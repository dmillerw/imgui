package imgui.imgui.demo

import glm_.glm
import glm_.vec2.Vec2
import glm_.vec4.Vec4
import imgui.*
import imgui.ImGui.beginMenu
import imgui.ImGui.beginMenuBar
import imgui.ImGui.beginPopupModal
import imgui.ImGui.button
import imgui.ImGui.checkbox
import imgui.ImGui.closeCurrentPopup
import imgui.ImGui.collapsingHeader
import imgui.ImGui.colorEdit4
import imgui.ImGui.combo
import imgui.ImGui.dragFloat
import imgui.ImGui.endMenu
import imgui.ImGui.endMenuBar
import imgui.ImGui.endPopup
import imgui.ImGui.inputText
import imgui.ImGui.isItemHovered
import imgui.ImGui.menuItem
import imgui.ImGui.openPopup
import imgui.ImGui.sameLine
import imgui.ImGui.selectable
import imgui.ImGui.separator
import imgui.ImGui.setItemDefaultFocus
import imgui.ImGui.setTooltip
import imgui.ImGui.text
import imgui.ImGui.textUnformatted
import imgui.ImGui.textWrapped
import imgui.functionalProgramming.button
import imgui.functionalProgramming.menu
import imgui.functionalProgramming.popup
import imgui.functionalProgramming.popupContextItem
import imgui.functionalProgramming.popupModal
import imgui.functionalProgramming.treeNode
import imgui.functionalProgramming.withId
import imgui.functionalProgramming.withItemWidth
import imgui.functionalProgramming.withStyleVar
import imgui.imgui.imgui_demoDebugInformations.Companion.showExampleMenuFile
import kotlin.reflect.KMutableProperty0
import imgui.ColorEditFlag as Cef
import imgui.InputTextFlag as Itf
import imgui.SelectableFlag as Sf
import imgui.TreeNodeFlag as Tnf
import imgui.WindowFlag as Wf

object showDemoWindowPopups {

    /* Popus */
    var selectedFish = -1
    val toggles = booleanArrayOf(true, false, false, false, false)

    /* Context Menu */
    var value = 0.5f
    var name = "Label1"

    var dontAskMeNextTime = false

    /* Modals */
    var dummyOpen = true
    var item = 1
    var color = Vec4(0.4f, 0.7f, 0f, 0.5f)

    operator fun invoke() {

        if (!collapsingHeader("Popups & Modal windows"))
            return

        /*  The properties of popups windows are:
            - They block normal mouse hovering detection outside them. (*)
            - Unless modal, they can be closed by clicking anywhere outside them, or by pressing ESCAPE.
            - Their visibility state (~bool) is held internally by imgui instead of being held by the programmer as we are used to with regular Begin() calls.
                User can manipulate the visibility state by calling OpenPopup().
            (*) One can use IsItemHovered(ImGuiHoveredFlags_AllowWhenBlockedByPopup) to bypass it and detect hovering even when normally blocked by a popup.
            Those three properties are connected. The library needs to hold their visibility state because it can close popups at any time.

            Typical use for regular windows:
            bool my_tool_is_active = false; if (ImGui::Button("Open")) my_tool_is_active = true; [...] if (my_tool_is_active) Begin("My Tool", &my_tool_is_active) { [...] } End();
            Typical use for popups:
            if (ImGui::Button("Open")) ImGui::OpenPopup("MyPopup"); if (ImGui::BeginPopup("MyPopup") { [...] EndPopup(); }
            With popups we have to go through a library call (here OpenPopup) to manipulate the visibility state.
            This may be a bit confusing at first but it should quickly make sense. Follow on the examples below.
         */
        treeNode("Popups") {

            textWrapped("When a popup is active, it inhibits interacting with windows that are behind the popup. Clicking outside the popup closes it.")

            val names = arrayOf("Bream", "Haddock", "Mackerel", "Pollock", "Tilefish")

            /*  Simple selection popup
                (If you want to show the current selection inside the Button itself, you may want to build a string
                using the "###" operator to preserve a constant ID with a variable label)                 */
            if (button("Select..")) openPopup("my_select_popup")
            sameLine()
            textUnformatted(names.getOrElse(selectedFish) { "<None>" })
            popup("my_select_popup") {
                text("Aquarium")
                separator()
                names.forEachIndexed { i, n -> if (selectable(n)) selectedFish = i }
            }

            // Showing a menu with toggles
            if (button("Toggle..")) openPopup("my_toggle_popup")
            popup("my_toggle_popup") {
                names.forEachIndexed { i, n -> withBool(toggles, i) { b -> menuItem(n, "", b) } }

                menu("Sub-menu") { menuItem("Click me") }

                separator()
                text("Tooltip here")
                if (isItemHovered()) setTooltip("I am a tooltip over a popup")

                if (button("Stacked Popup")) openPopup("another popup")
                popup("another popup") {
                    names.forEachIndexed { i, n -> withBool(toggles, i) { b -> menuItem(n, "", b) } }
                    menu("Sub-menu") { menuItem("Click me") }
                }
            }

            // Call the more complete ShowExampleMenuFile which we use in various places of this demo
            if (button("File Menu..")) openPopup("my_file_popup")
            popup("my_file_popup") { showExampleMenuFile() }
        }

        treeNode("Context menus") {

            // BeginPopupContextItem() is a helper to provide common/simple popup behavior of essentially doing:
            //    if (IsItemHovered() && IsMouseReleased(0))
            //       OpenPopup(id);
            //    return BeginPopup(id);
            // For more advanced uses you may want to replicate and cuztomize this code. This the comments inside BeginPopupContextItem() implementation.
            text("Value = %.3f (<-- right-click here)", value)
            popupContextItem("item context menu") {
                if (selectable("Set to zero")) value = 0f
                if (selectable("Set to PI")) value = glm.PIf
                withItemWidth(-1) {
                    dragFloat("##Value", ::value, 0.1f, 0f, 0f)
                }
            }

            /*
                We can also use OpenPopupOnItemClick() which is the same as BeginPopupContextItem() but without the Begin call.
                So here we will make it that clicking on the text field with the right mouse button (1) will toggle the visibility of the popup above.
                ImGui::Text("(You can also right-click me to the same popup as above.)");
                ImGui::OpenPopupOnItemClick("item context menu", 1);
                When used after an item that has an ID (here the Button), we can skip providing an ID to BeginPopupContextItem().
                BeginPopupContextItem() will use the last item ID as the popup ID.
                In addition here, we want to include your editable label inside the button label. We use the ### operator to override the ID (read FAQ about ID for details)
             */
            val text = "Button: $name###Button" // ### operator override id ignoring the preceding label
            button(text)
            popupContextItem {
                text("Edit name")
                inputText("##edit", name.toCharArray())
                if (button("Close")) closeCurrentPopup()
            }
            sameLine(); text("(<-- right-click here)")
        }

        treeNode("Modals") {

            textWrapped("Modal windows are like popups but the user cannot close them by clicking outside the window.")

            if (button("Delete.."))
                openPopup("Delete?")

            popupModal("Delete?", null, Wf.AlwaysAutoResize.i) {

                text("All those beautiful files will be deleted.\nThis operation cannot be undone!\n\n")
                separator()

                //static int dummy_i = 0;
                //ImGui::Combo("Combo", &dummy_i, "Delete\0Delete harder\0");

                withStyleVar(StyleVar.FramePadding, Vec2()) { checkbox("Don't ask me next time", ::dontAskMeNextTime) }

                button("OK", Vec2(120, 0)) { closeCurrentPopup() }
                setItemDefaultFocus()
                sameLine()
                button("Cancel", Vec2(120, 0)) { closeCurrentPopup() }
            }

            button("Stacked modals..") { openPopup("Stacked 1") }
            popupModal("Stacked 1", null, Wf.MenuBar.i) {

                if (beginMenuBar()) {
                    if (beginMenu("File")) {
                        if (menuItem("Dummy menu item")) {
                        }
                        endMenu()
                    }
                    endMenuBar()
                }

                text("Hello from Stacked The First\nUsing style.Colors[Col.ModalWindowDimBg] behind it.")

                // Testing behavior of widgets stacking their own regular popups over the modal.
                combo("Combo", ::item, listOf("aaaa", "bbbb", "cccc", "dddd", "eeee"))
                colorEdit4("color", color)

                button("Add another modal..") { openPopup("Stacked 2") }
                // Also demonstrate passing a bool* to BeginPopupModal(), this will create a regular close button which will close the popup.
                // Note that the visibility state of popups is owned by imgui, so the input value of the bool actually doesn't matter here.
                if (beginPopupModal("Stacked 2", ::dummyOpen)) {
                    text("Hello from Stacked The Second!")
                    button("Close") { closeCurrentPopup() }
                    endPopup()
                }
                button("Close") { closeCurrentPopup() }
            }
        }

        treeNode("Menus inside a regular window") {
            textWrapped("Below we are testing adding menu items to a regular window. It's rather unusual but should work!")
            separator()
            /*  NB: As a quirk in this very specific example, we want to differentiate the parent of this menu from
                the parent of the various popup menus above.
                To do so we are encloding the items in a pushID()/popID() block to make them two different menusets.
                If we don't, opening any popup above and hovering our menu here would open it. This is because once
                a menu is active, we allow to switch to a sibling menu by just hovering on it, which is the desired
                behavior for regular menus. */
            withId("foo") {
                menuItem("Menu item", "CTRL+M")
                menu("Menu inside a regular window") { showExampleMenuFile() }
            }
            separator()
        }
    }
}

private inline fun <R> withBool(bools: BooleanArray, index: Int, block: (KMutableProperty0<Boolean>) -> R): R {
    Ref.bPtr++
    val b = Ref::bool
    b.set(bools[index])
    val res = block(b)
    bools[index] = b()
    Ref.bPtr--
    return res
}