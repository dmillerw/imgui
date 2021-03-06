package imgui.imgui.widgets

import glm_.f
import glm_.func.common.max
import glm_.func.common.min
import glm_.glm
import glm_.i
import glm_.vec2.Vec2
import glm_.vec2.Vec2i
import glm_.vec3.Vec3
import glm_.vec3.Vec3i
import glm_.vec4.Vec4i
import imgui.*
import imgui.ImGui.beginGroup
import imgui.ImGui.calcItemWidth
import imgui.ImGui.calcTextSize
import imgui.ImGui.currentWindow
import imgui.ImGui.dragBehavior
import imgui.ImGui.endGroup
import imgui.ImGui.findRenderedTextEnd
import imgui.ImGui.focusableItemRegister
import imgui.ImGui.focusableItemUnregister
import imgui.ImGui.inputScalarAsWidgetReplacement
import imgui.ImGui.io
import imgui.ImGui.itemAdd
import imgui.ImGui.itemHoverable
import imgui.ImGui.itemSize
import imgui.ImGui.parseFormatFindEnd
import imgui.ImGui.parseFormatFindStart
import imgui.ImGui.popId
import imgui.ImGui.popItemWidth
import imgui.ImGui.pushId
import imgui.ImGui.pushMultiItemsWidths
import imgui.ImGui.renderFrame
import imgui.ImGui.renderNavHighlight
import imgui.ImGui.renderText
import imgui.ImGui.renderTextClipped
import imgui.ImGui.sameLine
import imgui.ImGui.setActiveId
import imgui.ImGui.setFocusId
import imgui.ImGui.style
import imgui.ImGui.textUnformatted
import imgui.internal.DragFlag
import imgui.internal.Rect
import imgui.internal.focus
import uno.kotlin.getValue
import kotlin.reflect.KMutableProperty0

/** Widgets: Drags
 *  - CTRL+Click on any drag box to turn them into an input box. Manually input values aren't clamped and can go off-bounds.
 *  - For all the Float2/Float3/Float4/Int2/Int3/Int4 versions of every functions, note that a 'float v[X]' function argument
 *      is the same as 'float* v', the array syntax is just a way to document the number of elements that are expected to be
 *      accessible. You can pass address of your first element out of a contiguous set, e.g. &myvector.x
 *  - Adjust format string to decorate the value with a prefix, a suffix, or adapt the editing and display precision
 *      e.g. "%.3f" -> 1.234; "%5.2f secs" -> 01.23 secs; "Biscuit: %.0f" -> Biscuit: 1; etc.
 *  - Speed are per-pixel of mouse movement (v_speed=0.2f: mouse needs to move by 5 pixels to increase value by 1).
 *      For gamepad/keyboard navigation, minimum speed is Max(v_speed, minimum_step_at_given_precision). */
interface drags {

    fun dragFloat(label: String, v: KMutableProperty0<Float>, vSpeed: Float = 1f, vMin: Float = 0f, vMax: Float = 0f,
                  format: String? = "%.3f", power: Float = 1f): Boolean =
            dragScalar(label, DataType.Float, v, vSpeed, vMin, vMax, format, power)

    fun dragFloat(label: String, v: FloatArray, ptr: Int, vSpeed: Float = 1f, vMin: Float = 0f, vMax: Float = 0f,
                  format: String = "%.3f", power: Float = 1f): Boolean = withFloat(v, ptr) {
        dragScalar(label, DataType.Float, it, vSpeed, vMin, vMax, format, power)
    }

    fun dragFloat2(label: String, v: FloatArray, vSpeed: Float = 1f, vMin: Float = 0f, vMax: Float = 0f, format: String = "%.3f", power: Float = 1f) =
            dragFloatN(label, v, 2, vSpeed, vMin, vMax, format, power)

    fun dragVec2(label: String, v: Vec2, vSpeed: Float = 1f, vMin: Float = 0f, vMax: Float = 0f, format: String = "%.3f", power: Float = 1f): Boolean {
        val floats = v to FloatArray(2)
        return dragFloatN(label, floats, 2, vSpeed, vMin, vMax, format, power).also {
            v put floats
        }
    }

    fun dragFloat3(label: String, v: FloatArray, vSpeed: Float = 1f, vMin: Float = 0f, vMax: Float = 0f, format: String = "%.3f",
                   power: Float = 1f) = dragFloatN(label, v, 3, vSpeed, vMin, vMax, format, power)

    fun dragVec3(label: String, v: Vec3, vSpeed: Float = 1f, vMin: Float = 0f, vMax: Float = 0f, format: String = "%.3f",
                 power: Float = 1f): Boolean {
        val floats = v to FloatArray(3)
        return dragFloatN(label, floats, 3, vSpeed, vMin, vMax, format, power).also {
            v put floats
        }
    }

    fun dragFloat4(label: String, v: FloatArray, vSpeed: Float = 1f, vMin: Float = 0f, vMax: Float = 0f, format: String = "%.3f",
                   power: Float = 1f) = dragFloatN(label, v, 4, vSpeed, vMin, vMax, format, power)

    fun dragVec4(label: String, v: Vec2, vSpeed: Float = 1f, vMin: Float = 0f, vMax: Float = 0f, format: String = "%.3f",
                 power: Float = 1f): Boolean {
        val floats = v to FloatArray(4)
        return dragFloatN(label, floats, 4, vSpeed, vMin, vMax, format, power).also {
            v put floats
        }
    }

    fun dragFloatRange2(label: String, vCurrentMinPtr: KMutableProperty0<Float>, vCurrentMaxPtr: KMutableProperty0<Float>,
                        vSpeed: Float = 1f, vMin: Float = 0f, vMax: Float = 0f, format: String = "%.3f", formatMax: String = format,
                        power: Float = 1f): Boolean {

        val vCurrentMin by vCurrentMinPtr
        val vCurrentMax by vCurrentMaxPtr
        val window = currentWindow
        if (window.skipItems) return false

        pushId(label)
        beginGroup()
        pushMultiItemsWidths(2)

        var min = if (vMin >= vMax) -Float.MAX_VALUE else vMin
        var max = if (vMin >= vMax) vCurrentMax else vMax min vCurrentMax
        var valueChanged = dragFloat("##min", vCurrentMinPtr, vSpeed, min, max, format, power)
        popItemWidth()
        sameLine(0f, style.itemInnerSpacing.x)
        min = if (vMin >= vMax) vCurrentMin else vMin max vCurrentMin
        max = if (vMin >= vMax) Float.MAX_VALUE else vMax
        valueChanged = dragFloat("##max", vCurrentMaxPtr, vSpeed, min, max, formatMax, power) || valueChanged
        popItemWidth()
        sameLine(0f, style.itemInnerSpacing.x)

        textUnformatted(label, findRenderedTextEnd(label))
        endGroup()
        popId()
        return valueChanged
    }

    /** If v_min >= v_max we have no bound
     *  NB: vSpeed is float to allow adjusting the drag speed with more precision     */
    fun dragInt(label: String, v: IntArray, ptr: Int, vSpeed: Float = 1f, vMin: Int = 0, vMax: Int = 0, format: String = "%d") =
            withInt(v, ptr) { dragInt(label, it, vSpeed, vMin, vMax, format) }

    fun dragInt(label: String, v: KMutableProperty0<Int>, vSpeed: Float = 1f, vMin: Int = 0, vMax: Int = 0, format: String = "%d") =
            dragScalar(label, DataType.Int, v, vSpeed, vMin as Number, vMax as Number, format)

    fun dragInt2(label: String, v: IntArray, vSpeed: Float = 1f, vMin: Int = 0, vMax: Int = 0, format: String = "%d") =
            dragIntN(label, v, 2, vSpeed, vMin, vMax, format)

    fun dragVec2i(label: String, v: Vec2i, vSpeed: Float = 1f, vMin: Int = 0, vMax: Int = 0, format: String = "%d"): Boolean {
        val ints = v to IntArray(2)
        return dragIntN(label, ints, 2, vSpeed, vMin, vMax, format).also {
            v put ints
        }
    }

    fun dragInt3(label: String, v: IntArray, vSpeed: Float = 1f, vMin: Int = 0, vMax: Int = 0, format: String = "%d") =
            dragIntN(label, v, 3, vSpeed, vMin, vMax, format)

    fun dragVec3i(label: String, v: Vec3i, vSpeed: Float = 1f, vMin: Int = 0, vMax: Int = 0, format: String = "%d"): Boolean {
        val ints = v to IntArray(3)
        return dragIntN(label, ints, 3, vSpeed, vMin, vMax, format).also {
            v put ints
        }
    }

    fun dragInt4(label: String, v: IntArray, vSpeed: Float = 1f, vMin: Int = 0, vMax: Int = 0, format: String = "%d") =
            dragIntN(label, v, 4, vSpeed, vMin, vMax, format)

    fun dragVec4i(label: String, v: Vec4i, vSpeed: Float = 1f, vMin: Int = 0, vMax: Int = 0, format: String = "%d"): Boolean {
        val ints = v to IntArray(4)
        return dragIntN(label, ints, 4, vSpeed, vMin, vMax, format).also {
            v put ints
        }
    }

    fun dragIntRange2(label: String, vCurrentMinPtr: KMutableProperty0<Int>, vCurrentMaxPtr: KMutableProperty0<Int>, vSpeed: Float = 1f,
                      vMin: Int = 0, vMax: Int = 0, format: String = "%d", formatMax: String = format): Boolean {

        val vCurrentMin by vCurrentMinPtr
        val vCurrentMax by vCurrentMaxPtr
        val window = currentWindow
        if (window.skipItems) return false

        pushId(label)
        beginGroup()
        pushMultiItemsWidths(2)

        var min = if (vMin >= vMax) Int.MIN_VALUE else vMin
        var max = if (vMin >= vMax) vCurrentMax else vMax min vCurrentMax
        var valueChanged = dragInt("##min", vCurrentMinPtr, vSpeed, min, max, format)
        popItemWidth()
        sameLine(0f, style.itemInnerSpacing.x)
        min = if (vMin >= vMax) vCurrentMin else vMin max vCurrentMin
        max = if (vMin >= vMax) Int.MAX_VALUE else vMax
        valueChanged = dragInt("##max", vCurrentMaxPtr, vSpeed, min, max, formatMax) || valueChanged
        popItemWidth()
        sameLine(0f, style.itemInnerSpacing.x)

        textUnformatted(label, findRenderedTextEnd(label))
        endGroup()
        popId()
        return valueChanged
    }

    /** For all the Float2/Float3/Float4/Int2/Int3/Int4 versions of every functions, note that a 'float v[X]' function
     *  argument is the same as 'float* v', the array syntax is just a way to document the number of elements that are
     *  expected to be accessible. You can pass address of your first element out of a contiguous set, e.g. &myvector.x
     *  Adjust format string to decorate the value with a prefix, a suffix, or adapt the editing and display precision
     *  e.g. "%.3f" -> 1.234; "%5.2f secs" -> 01.23 secs; "Biscuit: %.0f" -> Biscuit: 1; etc.
     *  Speed are per-pixel of mouse movement (vSpeed = 0.2f: mouse needs to move by 5 pixels to increase value by 1).
     *  For gamepad/keyboard navigation, minimum speed is Max(vSpeed, minimumStepAtGivenPrecision). */
    fun dragScalar(label: String, v: FloatArray, vSpeed: Float, vMin: Float? = null, vMax: Float? = null, format: String? = null,
                   power: Float = 1f): Boolean = dragScalar(label, v, 0, vSpeed, vMin, vMax, format, power)

    /** If vMin >= vMax we have no bound  */
    fun dragScalar(label: String, v: FloatArray, ptr: Int = 0, vSpeed: Float, vMin: Float? = null, vMax: Float? = null,
                   format: String? = null, power: Float = 1f): Boolean = withFloat(v, ptr) {
        dragScalar(label, DataType.Float, it, vSpeed, vMin, vMax, format, power)
    }

    @Suppress("UNCHECKED_CAST")
    fun dragScalar(label: String, dataType: DataType, v: KMutableProperty0<*>, vSpeed: Float, vMin: Number? = null, vMax: Number? = null,
                   format_: String? = null, power: Float = 1f): Boolean {

        v as KMutableProperty0<Number>
        val window = currentWindow
        if (window.skipItems) return false

        if (power != 1f)
            assert(vMin != null && vMax != null) // When using a power curve the drag needs to have known bounds

        val id = window.getId(label)
        val w = calcItemWidth()

        val labelSize = calcTextSize(label, 0, true)
        val frameBb = Rect(window.dc.cursorPos, window.dc.cursorPos + Vec2(w, labelSize.y + style.framePadding.y * 2f))
        val totalBb = Rect(frameBb.min, frameBb.max + Vec2(if (labelSize.x > 0f) style.itemInnerSpacing.x + labelSize.x else 0f, 0f))

        itemSize(totalBb, style.framePadding.y)
        if (!itemAdd(totalBb, id, frameBb))
            return false

        val hovered = itemHoverable(frameBb, id)

        // Default format string when passing NULL
        // Patch old "%.0f" format string to use "%d", read function comments for more details.
        val format = when {
            format_ == null -> when (dataType) {
                DataType.Float, DataType.Double -> "%f"
                else -> "%d"
            }
            dataType == DataType.Int && format_ != "%d" -> patchFormatStringFloatToInt(format_)
            else -> format_
        }

        // Tabbing or CTRL-clicking on Drag turns it into an input box
        var startTextInput = false
        val tabFocusRequested = focusableItemRegister(window, id)
        if (tabFocusRequested || (hovered && (io.mouseClicked[0] || io.mouseDoubleClicked[0]) || g.navActivateId == id || (g.navInputId == id && g.scalarAsInputTextId != id))) {
            setActiveId(id, window)
            setFocusId(id, window)
            window.focus()
            g.activeIdAllowNavDirFlags = (1 shl Dir.Up) or (1 shl Dir.Down)
            if (tabFocusRequested || io.keyCtrl || io.mouseDoubleClicked[0] || g.navInputId == id) {
                startTextInput = true
                g.scalarAsInputTextId = 0
            }
        }
        if (startTextInput || (g.activeId == id && g.scalarAsInputTextId == id)) {
            window.dc.cursorPos put frameBb.min
            focusableItemUnregister(window)
            return inputScalarAsWidgetReplacement(frameBb, id, label, dataType, v, format)
        }

        // Actual drag behavior
        val valueChanged = dragBehavior(id, dataType, v, vSpeed, vMin, vMax, format, power, DragFlag.None.i)

        // Draw frame
        val frameCol = when (g.activeId) {
            id -> Col.FrameBgActive
            else -> when (g.hoveredId) {
                id -> Col.FrameBgHovered
                else -> Col.FrameBg
            }
        }
        renderNavHighlight(frameBb, id)
        renderFrame(frameBb.min, frameBb.max, frameCol.u32, true, style.frameRounding)

        // Display value using user-provided display format so user can add prefix/suffix/decorations to the value.
        val value = String(v.format(dataType, format))
        renderTextClipped(frameBb.min, frameBb.max, value, value.length, null, Vec2(0.5f))

        if (labelSize.x > 0f)
            renderText(Vec2(frameBb.max.x + style.itemInnerSpacing.x, frameBb.min.y + style.framePadding.y), label)

        ImGuiTestEngineHook_ItemInfo(id, label, window.dc.itemFlags)
        return valueChanged
    }

    fun dragFloatN(label: String, v: FloatArray, components: Int, vSpeed: Float, vMin: Float, vMax: Float, format: String? = null,
                   power: Float = 1f): Boolean {

        val window = currentWindow
        if (window.skipItems) return false

        var valueChanged = false
        beginGroup()
        pushId(label)
        pushMultiItemsWidths(components)
        for (i in 0 until components) {
            pushId(i)
            withFloat(v, i) {
                valueChanged = dragScalar("", DataType.Float, it, vSpeed, vMin, vMax, format, power) || valueChanged
            }
            sameLine(0f, style.itemInnerSpacing.x)
            popId()
            popItemWidth()
        }
        popId()

        textUnformatted(label, findRenderedTextEnd(label))
        endGroup()
        return valueChanged
    }

    fun dragIntN(label: String, v: IntArray, components: Int, vSpeed: Float, vMin: Int, vMax: Int, format: String = "%d"): Boolean {
        val window = currentWindow
        if (window.skipItems) return false

        var valueChanged = false
        beginGroup()
        pushId(label)
        pushMultiItemsWidths(components)
        for (i in 0 until components) {
            pushId(i)
            withInt(v, i) { valueChanged = dragInt("", it, vSpeed, vMin, vMax, format) || valueChanged }
            sameLine(0f, style.itemInnerSpacing.x)
            popId()
            popItemWidth()
        }
        popId()

        textUnformatted(label, findRenderedTextEnd(label))
        endGroup()
        return valueChanged
    }

    companion object {

        // TODO delete and use them in just one single place
        private inline fun <R> withFloat(block: (KMutableProperty0<Float>) -> R): R {
            Ref.fPtr++
            return block(Ref::float).also { Ref.fPtr-- }
        }

        private inline fun <R> withInt(block: (KMutableProperty0<Int>) -> R): R {
            Ref.iPtr++
            return block(Ref::int).also { Ref.iPtr-- }
        }

        private inline fun <R> withFloatAsInt(value: KMutableProperty0<Float>, block: (KMutableProperty0<Int>) -> R): R {
            Ref.iPtr++
            val i = Ref::int
            i.set(glm.floatBitsToInt(value()))
            val res = block(i)
            value.set(glm.intBitsToFloat(i()))
            Ref.iPtr--
            return res
        }

        private inline fun <R> withInt(ints: IntArray, ptr: Int, block: (KMutableProperty0<Int>) -> R): R {
            Ref.iPtr++
            val i = Ref::int
            i.set(ints[ptr])
            val res = block(i)
            ints[ptr] = i()
            Ref.iPtr--
            return res
        }

        private inline fun <R> withFloat(floats: FloatArray, ptr: Int, block: (KMutableProperty0<Float>) -> R): R {
            Ref.fPtr++
            val f = Ref::float
            f.set(floats[ptr])
            val res = block(f)
            floats[ptr] = f()
            Ref.fPtr--
            return res
        }

        private inline fun <R> withFloat(value: KMutableProperty0<Int>, block: (KMutableProperty0<Float>) -> R): R {
            Ref.fPtr++
            val f = Ref::float
            f.set(value().f)
            val res = block(f)
            value.set(f().i)
            Ref.fPtr--
            return res
        }

        /** FIXME-LEGACY: Prior to 1.61 our DragInt() function internally used floats and because of this the compile-time default value
         *  for format was "%.0f".
         *  Even though we changed the compile-time default, we expect users to have carried %f around, which would break
         *  the display of DragInt() calls.
         *  To honor backward compatibility we are rewriting the format string, unless IMGUI_DISABLE_OBSOLETE_FUNCTIONS is enabled.
         *  What could possibly go wrong?! */
        fun patchFormatStringFloatToInt(fmt: String): String {
            if (fmt == "%.0f") // Fast legacy path for "%.0f" which is expected to be the most common case.
                return "%d"
            val fmtStart = parseFormatFindStart(fmt)    // Find % (if any, and ignore %%)
            // Find end of format specifier, which itself is an exercise of confidence/recklessness (because snprintf is dependent on libc or user).
            val fmtEnd = parseFormatFindEnd(fmt, fmtStart)
            if (fmtEnd > fmtStart && fmt[fmtEnd - 1] == 'f') {
                if (fmtStart == 0 && fmtEnd == fmt.length)
                    return "%d"
                return fmt.substring(0, fmtStart) + "%d" + fmt.substring(fmtEnd, fmt.length)
            }
            return fmt
        }
    }
}