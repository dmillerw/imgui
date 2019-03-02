package imgui.impl

import gln.*
import org.lwjgl.opengl.*


val DEPTH_BUFFER_BIT_ = AttribMask(GL11.GL_DEPTH_BUFFER_BIT)
val STENCIL_BUFFER_BIT_ = AttribMask(GL11.GL_STENCIL_BUFFER_BIT)
val COLOR_BUFFER_BIT_ = AttribMask(GL11.GL_COLOR_BUFFER_BIT)


val COLOR_BUFFER_BIT = ClearBufferMask(GL11.GL_COLOR_BUFFER_BIT)
val STENCIL_BUFFER_BIT = ClearBufferMask(GL11.GL_STENCIL_BUFFER_BIT)
val DEPTH_BUFFER_BIT = ClearBufferMask(GL11.GL_DEPTH_BUFFER_BIT)
val COLOR_STENCIL_BUFFER_BIT = ClearBufferMask(GL11.GL_COLOR_BUFFER_BIT or GL11.GL_STENCIL_BUFFER_BIT)
val COLOR_DEPTH_BUFFER_BIT = ClearBufferMask(GL11.GL_COLOR_BUFFER_BIT or GL11.GL_DEPTH_BUFFER_BIT)
val DEPTH_STENCIL_BUFFER_BIT = ClearBufferMask(GL11.GL_DEPTH_BUFFER_BIT or GL11.GL_STENCIL_BUFFER_BIT)


val POINTS = DrawMode(GL11.GL_POINTS)
val LINES = DrawMode(GL11.GL_LINES)
val LINE_LOOP = DrawMode(GL11.GL_LINE_LOOP)
val LINE_STRIP = DrawMode(GL11.GL_LINE_STRIP)
val TRIANGLES = DrawMode(GL11.GL_TRIANGLES)
val TRIANGLE_STRIP = DrawMode(GL11.GL_TRIANGLE_STRIP)
val TRIANGLE_FAN = DrawMode(GL11.GL_TRIANGLE_FAN)
val QUADS = DrawMode(GL11.GL_QUADS)
val QUAD_STRIP = DrawMode(GL11.GL_QUAD_STRIP)
val POLYGON = DrawMode(GL11.GL_POLYGON)
val LINES_ADJACENCY = DrawMode(GL32.GL_LINES_ADJACENCY)
val LINE_STRIP_ADJACENCY = DrawMode(GL32.GL_LINE_STRIP_ADJACENCY)
val TRIANGLES_ADJACENCY = DrawMode(GL32.GL_TRIANGLES_ADJACENCY)
val TRIANGLE_STRIP_ADJACENCY = DrawMode(GL32.GL_TRIANGLE_STRIP_ADJACENCY)
val PATCHES = DrawMode(GL40.GL_PATCHES)


val ZERO = BlendingFactor(GL11.GL_ZERO)
val ONE = BlendingFactor(GL11.GL_ONE)
val SRC_COLOR = BlendingFactor(GL11.GL_SRC_COLOR)
val ONE_MINUS_SRC_COLOR = BlendingFactor(GL11.GL_ONE_MINUS_SRC_COLOR)
val DST_COLOR = BlendingFactor(GL11.GL_DST_COLOR)
val ONE_MINUS_DST_COLOR = BlendingFactor(GL11.GL_ONE_MINUS_DST_COLOR)
val SRC_ALPHA = BlendingFactor(GL11.GL_SRC_ALPHA)
val ONE_MINUS_SRC_ALPHA = BlendingFactor(GL11.GL_ONE_MINUS_SRC_ALPHA)
val DST_ALPHA = BlendingFactor(GL11.GL_DST_ALPHA)
val ONE_MINUS_DST_ALPHA = BlendingFactor(GL11.GL_ONE_MINUS_DST_ALPHA)
val CONSTANT_COLOR = BlendingFactor(GL14.GL_CONSTANT_COLOR)
val ONE_MINUS_CONSTANT_COLOR = BlendingFactor(GL14.GL_ONE_MINUS_CONSTANT_COLOR)
val CONSTANT_ALPHA = BlendingFactor(GL14.GL_CONSTANT_ALPHA)
val ONE_MINUS_CONSTANT_ALPHA = BlendingFactor(GL14.GL_ONE_MINUS_CONSTANT_ALPHA)
val SRC_ALPHA_SATURATE = BlendingFactor(GL14.GL_SRC_ALPHA_SATURATE)
val SRC1_COLOR = BlendingFactor(GL33.GL_SRC1_COLOR)
val ONE_MINUS_SRC1_COLOR = BlendingFactor(GL33.GL_ONE_MINUS_SRC1_COLOR)
val SRC1_ALPHA = BlendingFactor(GL15.GL_SRC1_ALPHA)
val ONE_MINUS_SRC1_ALPHA = BlendingFactor(GL33.GL_ONE_MINUS_SRC1_ALPHA)


val LOGIC_OP = BlendEquationMode(GL11.GL_LOGIC_OP)
val FUNC_ADD = BlendEquationMode(GL14.GL_FUNC_ADD)
val MIN = BlendEquationMode(GL14.GL_MIN)
val MAX = BlendEquationMode(GL14.GL_MAX)
val FUNC_SUBTRACT = BlendEquationMode(GL14.GL_FUNC_SUBTRACT)
val FUNC_REVERSE_SUBTRACT = BlendEquationMode(GL14.GL_FUNC_REVERSE_SUBTRACT)


val FRONT = FaceMode(GL11.GL_FRONT)
val BACK = FaceMode(GL11.GL_BACK)
val FRONT_AND_BACK = FaceMode(GL11.GL_FRONT_AND_BACK)


val DISABLED_ = CullFaceMode(GL11.GL_FALSE)
val FRONT__ = CullFaceMode(GL11.GL_FRONT)
val BACK__ = CullFaceMode(GL11.GL_BACK)
val FRONT_AND_BACK__ = CullFaceMode(GL11.GL_FRONT_AND_BACK)


val NEVER = CompareFunction(GL11.GL_NEVER)
val LESS = CompareFunction(GL11.GL_LESS)
val EQUAL = CompareFunction(GL11.GL_EQUAL)
val LEQUAL = CompareFunction(GL11.GL_LEQUAL)
val GREATER = CompareFunction(GL11.GL_GREATER)
val NOTEQUAL = CompareFunction(GL11.GL_NOTEQUAL)
val GEQUAL = CompareFunction(GL11.GL_GEQUAL)
val ALWAYS = CompareFunction(GL11.GL_ALWAYS)


val NONE = BufferMode(GL11.GL_NONE)
val FRONT_LEFT = BufferMode(GL11.GL_FRONT_LEFT)
val FRONT_RIGHT = BufferMode(GL11.GL_FRONT_RIGHT)
val BACK_LEFT = BufferMode(GL11.GL_BACK_LEFT)
val BACK_RIGHT = BufferMode(GL11.GL_BACK_RIGHT)
val FRONT_ = BufferMode(GL11.GL_FRONT)
val BACK_ = BufferMode(GL11.GL_BACK)
val LEFT = BufferMode(GL11.GL_LEFT)
val RIGHT = BufferMode(GL11.GL_RIGHT)
val FRONT_AND_BACK_ = BufferMode(GL11.GL_FRONT_AND_BACK)
val AUX0 = BufferMode(GL11.GL_AUX0)
val AUX1 = BufferMode(GL11.GL_AUX1)
val AUX2 = BufferMode(GL11.GL_AUX2)
val AUX3 = BufferMode(GL11.GL_AUX3)


val NO_ERROR = ErrorCode(GL11.GL_NO_ERROR)
val INVALID_ENUM = ErrorCode(GL11.GL_INVALID_ENUM)
val INVALID_VALUE = ErrorCode(GL11.GL_INVALID_VALUE)
val INVALID_OPERATION = ErrorCode(GL11.GL_INVALID_OPERATION)
val STACK_OVERFLOW = ErrorCode(GL11.GL_STACK_OVERFLOW)
val STACK_UNDERFLOW = ErrorCode(GL11.GL_STACK_UNDERFLOW)
val OUT_OF_MEMORY = ErrorCode(GL11.GL_OUT_OF_MEMORY)
val TABLE_TOO_LARGE_EXT = ErrorCode(ARBImaging.GL_TABLE_TOO_LARGE)
val TEXTURE_TOO_LARGE = ErrorCode(0x8065)
//# Additional error codes
//# VERSION_3_0 enum:
//# ARB_framebuffer_object enum: (note: no ARB suffixes)
//# EXT_framebuffer_object enum:
val INVALID_FRAMEBUFFER_OPERATION = ErrorCode(GL30.GL_INVALID_FRAMEBUFFER_OPERATION)


val CW = FrontFaceDirection(GL11.GL_CW)
val CCW = FrontFaceDirection(GL11.GL_CCW)


val WIDTH = GetTexLevelParameter(GL11.GL_TEXTURE_WIDTH)
val HEIGHT = GetTexLevelParameter(GL11.GL_TEXTURE_HEIGHT)
val DEPTH = GetTexLevelParameter(GL12.GL_TEXTURE_DEPTH)
val INTERNAL_FORMAT = GetTexLevelParameter(GL11.GL_TEXTURE_INTERNAL_FORMAT)
val COMPONENTS = GetTexLevelParameter(GL11.GL_TEXTURE_COMPONENTS)
val RED_TYPE = GetTexLevelParameter(GL30.GL_TEXTURE_RED_TYPE)
val GREEN_TYPE = GetTexLevelParameter(GL30.GL_TEXTURE_GREEN_TYPE)
val BLUE_TYPE = GetTexLevelParameter(GL30.GL_TEXTURE_BLUE_TYPE)
val ALPHA_TYPE = GetTexLevelParameter(GL30.GL_TEXTURE_ALPHA_TYPE)
val DEPTH_TYPE = GetTexLevelParameter(GL30.GL_TEXTURE_DEPTH_TYPE)
val RED_SIZE = GetTexLevelParameter(GL11.GL_TEXTURE_RED_SIZE)
val GREEN_SIZE = GetTexLevelParameter(GL11.GL_TEXTURE_GREEN_SIZE)
val BLUE_SIZE = GetTexLevelParameter(GL11.GL_TEXTURE_BLUE_SIZE)
val ALPHA_SIZE = GetTexLevelParameter(GL11.GL_TEXTURE_ALPHA_SIZE)
val DEPTH_SIZE = GetTexLevelParameter(GL30.GL_TEXTURE_DEPTH_SIZE)
val COMPRESSED = GetTexLevelParameter(GL30.GL_TEXTURE_COMPRESSED)
val COMPRESSED_IMAGE_SIZE = GetTexLevelParameter(GL13.GL_TEXTURE_COMPRESSED_IMAGE_SIZE)
val BUFFER_OFFSET = GetTexLevelParameter(GL43.GL_TEXTURE_BUFFER_OFFSET)
val BUFFER_SIZE = GetTexLevelParameter(GL43.GL_TEXTURE_BUFFER_SIZE)


val DEPTH_STENCIL_MODE = TexParameter(GL43.GL_DEPTH_STENCIL_TEXTURE_MODE)
val IMAGE_FORMAT_COMPATIBILITY_TYPE = TexParameter(GL42.GL_IMAGE_FORMAT_COMPATIBILITY_TYPE)
val BASE_LEVEL = TexParameter(GL12.GL_TEXTURE_BASE_LEVEL)
val BORDER_COLOR = TexParameter(GL11.GL_TEXTURE_BORDER_COLOR)
val COMPARE_MODE = TexParameter(GL14.GL_TEXTURE_COMPARE_MODE)
val COMPARE_FUNC = TexParameter(GL14.GL_TEXTURE_COMPARE_FUNC)
val IMMUTABLE_FORMAT = TexParameter(GL42.GL_TEXTURE_IMMUTABLE_FORMAT)
val IMMUTABLE_LEVELS = TexParameter(GL43.GL_TEXTURE_IMMUTABLE_LEVELS)
val LOD_BIAS = TexParameter(GL14.GL_TEXTURE_LOD_BIAS)
val MAG_FILTER = TexParameter(GL11.GL_TEXTURE_MAG_FILTER)
val MAX_LEVEL = TexParameter(GL12.GL_TEXTURE_MAX_LEVEL)
val MAX_LOD = TexParameter(GL12.GL_TEXTURE_MAX_LOD)
val MIN_FILTER = TexParameter(GL11.GL_TEXTURE_MIN_FILTER)
val MIN_LOD = TexParameter(GL12.GL_TEXTURE_MIN_LOD)
val SWIZZLE_R_ = TexParameter(GL33.GL_TEXTURE_SWIZZLE_R)
val SWIZZLE_G_ = TexParameter(GL33.GL_TEXTURE_SWIZZLE_G)
val SWIZZLE_B_ = TexParameter(GL33.GL_TEXTURE_SWIZZLE_B)
val SWIZZLE_A_ = TexParameter(GL33.GL_TEXTURE_SWIZZLE_A)
val SWIZZLE_RGBA_ = TexParameter(GL33.GL_TEXTURE_SWIZZLE_RGBA)
val TARGET = TexParameter(GL45.GL_TEXTURE_TARGET)
val VIEW_MIN_LAYER = TexParameter(GL43.GL_TEXTURE_VIEW_MIN_LAYER)
val VIEW_MIN_LEVEL = TexParameter(GL43.GL_TEXTURE_VIEW_MIN_LEVEL)
val VIEW_NUM_LAYERS = TexParameter(GL43.GL_TEXTURE_VIEW_NUM_LAYERS)
val VIEW_NUM_LEVELS = TexParameter(GL43.GL_TEXTURE_VIEW_NUM_LEVELS)
val WRAP_S = TexParameter(GL11.GL_TEXTURE_WRAP_S)
val WRAP_T = TexParameter(GL11.GL_TEXTURE_WRAP_T)
val WRAP_R = TexParameter(GL12.GL_TEXTURE_WRAP_R)


val DONT_CARE = HintMode(GL11.GL_DONT_CARE)
val FASTEST = HintMode(GL11.GL_FASTEST)
val NICEST = HintMode(GL11.GL_NICEST)


val PERSPECTIVE_CORRECTION_HINT = HintTarget(GL11.GL_PERSPECTIVE_CORRECTION_HINT)
val POINT_SMOOTH_HINT = HintTarget(GL11.GL_POINT_SMOOTH_HINT)
val LINE_SMOOTH_HINT = HintTarget(GL11.GL_LINE_SMOOTH_HINT)
val POLYGON_SMOOTH_HINT = HintTarget(GL11.GL_POLYGON_SMOOTH_HINT)
val FOG_HINT = HintTarget(GL11.GL_FOG_HINT)
val PACK_CMYK_HINT_EXT = HintTarget(0x800e)
val UNPACK_CMYK_HINT_EXT = HintTarget(0x800f)
val TEXTURE_COMPRESSION_HINT = HintTarget(GL13.GL_TEXTURE_COMPRESSION_HINT)
val FRAGMENT_SHADER_DERIVATIVE_HINT = HintTarget(GL20.GL_FRAGMENT_SHADER_DERIVATIVE_HINT)


val BYTE = DataType(GL11.GL_BYTE)
val UNSIGNED_BYTE = DataType(GL11.GL_UNSIGNED_BYTE)
val SHORT = DataType(GL11.GL_SHORT)
val UNSIGNED_SHORT = DataType(GL11.GL_UNSIGNED_SHORT)
val INT = DataType(GL11.GL_INT)
val UNSIGNED_INT = DataType(GL11.GL_UNSIGNED_INT)
val FLOAT = DataType(GL11.GL_FLOAT)
val `2_BYTES` = DataType(GL11.GL_2_BYTES)
val `3_BYTES` = DataType(GL11.GL_3_BYTES)
val `4_BYTES` = DataType(GL11.GL_4_BYTES)
val DOUBLE = DataType(GL11.GL_DOUBLE)
//# VERSION_3_0 enum:
//# ARB_half_float_vertex enum: (note: no ARB suffixes)
//# ARB_half_float_pixel enum:
//# NV_half_float enum:
val HALF_FLOAT = DataType(GL30.GL_HALF_FLOAT) //    # 3.0 / ARB_half_float_vertex
//#	HALF_FLOAT_ARB					= 0x140B
//#	HALF_FLOAT_NV					= 0x140B

//# OES_fixed_point enum:
//val FIXED_OES = DataType(0x140C)


val DISABLED = LogicOp(GL11.GL_FALSE)
val CLEAR = LogicOp(GL11.GL_CLEAR)
val AND = LogicOp(GL11.GL_AND)
val AND_REVERSE = LogicOp(GL11.GL_AND_REVERSE)
val COPY = LogicOp(GL11.GL_COPY)
val AND_INVERTED = LogicOp(GL11.GL_AND_INVERTED)
val NOOP = LogicOp(GL11.GL_NOOP)
val XOR = LogicOp(GL11.GL_XOR)
val OR = LogicOp(GL11.GL_OR)
val NOR = LogicOp(GL11.GL_NOR)
val EQUIV = LogicOp(GL11.GL_EQUIV)
val INVERT = LogicOp(GL11.GL_INVERT)
val OR_REVERSE = LogicOp(GL11.GL_OR_REVERSE)
val COPY_INVERTED = LogicOp(GL11.GL_COPY_INVERTED)
val OR_INVERTED = LogicOp(GL11.GL_OR_INVERTED)
val NAND = LogicOp(GL11.GL_NAND)
val SET = LogicOp(GL11.GL_SET)


val COLOR = PixelCopyType(GL11.GL_COLOR)
val DEPTH_ = PixelCopyType(GL11C.GL_DEPTH)
val STENCIL = PixelCopyType(GL11.GL_STENCIL)


val UNPACK_SWAP_BYTES = PixelStoreParameter(GL11.GL_UNPACK_SWAP_BYTES)
val UNPACK_LSB_FIRST = PixelStoreParameter(GL11.GL_UNPACK_LSB_FIRST)
val UNPACK_ROW_LENGTH = PixelStoreParameter(GL11.GL_UNPACK_ROW_LENGTH)
val UNPACK_SKIP_ROWS = PixelStoreParameter(GL11.GL_UNPACK_SKIP_ROWS)
val UNPACK_SKIP_PIXELS = PixelStoreParameter(GL11.GL_UNPACK_SKIP_PIXELS)
val UNPACK_ALIGNMENT = PixelStoreParameter(GL11.GL_UNPACK_ALIGNMENT)
val UNPACK_SKIP_IMAGES = PixelStoreParameter(GL12.GL_UNPACK_SKIP_IMAGES)
val UNPACK_IMAGE_HEIGHT = PixelStoreParameter(GL12.GL_UNPACK_IMAGE_HEIGHT)
val PACK_SWAP_BYTES = PixelStoreParameter(GL11.GL_PACK_SWAP_BYTES)
val PACK_LSB_FIRST = PixelStoreParameter(GL11.GL_PACK_LSB_FIRST)
val PACK_ROW_LENGTH = PixelStoreParameter(GL11.GL_PACK_ROW_LENGTH)
val PACK_SKIP_ROWS = PixelStoreParameter(GL11.GL_PACK_SKIP_ROWS)
val PACK_SKIP_PIXELS = PixelStoreParameter(GL11.GL_PACK_SKIP_PIXELS)
val PACK_ALIGNMENT = PixelStoreParameter(GL11.GL_PACK_ALIGNMENT)
val PACK_SKIP_IMAGES = PixelStoreParameter(GL12.GL_PACK_SKIP_IMAGES)
val PACK_IMAGE_HEIGHT = PixelStoreParameter(GL12.GL_PACK_IMAGE_HEIGHT)


val POINT = PolygonMode(GL11.GL_POINT)
val LINE = PolygonMode(GL11.GL_LINE)
val FILL = PolygonMode(GL11.GL_FILL)


val ZERO__ = StencilOp(GL11.GL_ZERO)
val KEEP = StencilOp(GL11.GL_KEEP)
val REPLACE = StencilOp(GL11.GL_REPLACE)
val INCR = StencilOp(GL11.GL_INCR)
val INCR_WRAP = StencilOp(GL14.GL_INCR_WRAP)
val DECR = StencilOp(GL11.GL_DECR)
val DECR_WRAP = StencilOp(GL14.GL_DECR_WRAP)
val INVERT_ = StencilOp(GL11.GL_INVERT)


val NEAREST_ = TextureMagFilter(GL11.GL_NEAREST)
val LINEAR_ = TextureMagFilter(GL11.GL_LINEAR)


val NEAREST = TextureMinFilter(GL11.GL_NEAREST)
val LINEAR = TextureMinFilter(GL11.GL_LINEAR)
val NEAREST_MIPMAP_NEAREST = TextureMinFilter(GL11.GL_NEAREST_MIPMAP_NEAREST)
val LINEAR_MIPMAP_NEAREST = TextureMinFilter(GL11.GL_LINEAR_MIPMAP_NEAREST)
val NEAREST_MIPMAP_LINEAR = TextureMinFilter(GL11.GL_NEAREST_MIPMAP_LINEAR)
val LINEAR_MIPMAP_LINEAR = TextureMinFilter(GL11.GL_LINEAR_MIPMAP_LINEAR)


val `1D` = TextureTarget(GL11.GL_TEXTURE_1D)
val `2D` = TextureTarget(GL11.GL_TEXTURE_2D)
val `3D` = TextureTarget(GL12.GL_TEXTURE_3D)
val `1D_ARRAY` = TextureTarget(GL30.GL_TEXTURE_1D_ARRAY)
val `2D_ARRAY` = TextureTarget(GL30.GL_TEXTURE_2D_ARRAY)
val RECTANGLE = TextureTarget(GL31.GL_TEXTURE_RECTANGLE)
val `2D_MULTISAMPLE` = TextureTarget(GL32C.GL_TEXTURE_2D_MULTISAMPLE)
val `2D_MULTISAMPLE_ARRAY` = TextureTarget(GL32.GL_TEXTURE_2D_MULTISAMPLE_ARRAY)
val CUBE_MAP = TextureTarget(GL13.GL_TEXTURE_CUBE_MAP)
val CUBE_MAP_POSITIVE_X = TextureTarget(GL13.GL_TEXTURE_CUBE_MAP_POSITIVE_X)
val CUBE_MAP_MEGATIVE_X = TextureTarget(GL13.GL_TEXTURE_CUBE_MAP_NEGATIVE_X)
val CUBE_MAP_POSITIVE_Y = TextureTarget(GL13.GL_TEXTURE_CUBE_MAP_POSITIVE_Y)
val CUBE_MAP_MEGATIVE_Y = TextureTarget(GL13.GL_TEXTURE_CUBE_MAP_NEGATIVE_Y)
val CUBE_MAP_POSITIVE_Z = TextureTarget(GL13.GL_TEXTURE_CUBE_MAP_POSITIVE_Z)
val CUBE_MAP_MEGATIVE_Z = TextureTarget(GL13.GL_TEXTURE_CUBE_MAP_NEGATIVE_Z)
val PROXY_1D = TextureTarget(GL11.GL_PROXY_TEXTURE_1D)
val PROXY_2D = TextureTarget(GL11.GL_PROXY_TEXTURE_2D)
val PROXY_3D = TextureTarget(GL12.GL_PROXY_TEXTURE_3D)
val PROXY_1D_ARRAY = TextureTarget(GL30.GL_PROXY_TEXTURE_1D_ARRAY)
val PROXY_2D_ARRAY = TextureTarget(GL30.GL_PROXY_TEXTURE_2D_ARRAY)
val PROXY_RECTANGLE = TextureTarget(GL31.GL_PROXY_TEXTURE_RECTANGLE)
val PROXY_2D_MULTISAMPLE = TextureTarget(GL32.GL_PROXY_TEXTURE_2D_MULTISAMPLE)
val PROXY_2D_MULTISAMPLE_ARRAY = TextureTarget(GL32.GL_PROXY_TEXTURE_2D_MULTISAMPLE_ARRAY)
val PROXY_CUBE_MAP = TextureTarget(GL32.GL_PROXY_TEXTURE_CUBE_MAP)
val BUFFER = TextureTarget(GL32.GL_TEXTURE_BUFFER)


val CLAMP = TextureWrapMode(GL11.GL_CLAMP)
val REPEAT = TextureWrapMode(GL11.GL_REPEAT)


val ARRAY_BUFFER = BufferTarget(GL15.GL_ARRAY_BUFFER)
val ATOMIC_COUNTER_BUFFER = BufferTarget(GL42.GL_ATOMIC_COUNTER_BUFFER)
val COPY_READ_BUFFER = BufferTarget(GL31.GL_COPY_READ_BUFFER)
val COPY_WRITE_BUFFER = BufferTarget(GL31.GL_COPY_WRITE_BUFFER)
val DISPATCH_INDIRECT_BUFFER = BufferTarget(GL43.GL_DISPATCH_INDIRECT_BUFFER)
val DRAW_INDIRECT_BUFFER = BufferTarget(GL40.GL_DRAW_INDIRECT_BUFFER)
val ELEMENT_ARRAY_BUFFER = BufferTarget(GL15.GL_ELEMENT_ARRAY_BUFFER)
val PIXEL_PACK_BUFFER = BufferTarget(GL21.GL_PIXEL_PACK_BUFFER)
val PIXEL_UNPACK_BUFFER = BufferTarget(GL21.GL_PIXEL_UNPACK_BUFFER)
val SHADER_STORAGE_BUFFER = BufferTarget(GL43.GL_SHADER_STORAGE_BUFFER)
val TEXTURE_BUFFER = BufferTarget(GL31.GL_TEXTURE_BUFFER)
val TRANSFORM_FEEDBACK_BUFFER = BufferTarget(GL30.GL_TRANSFORM_FEEDBACK_BUFFER)
val UNIFORM_BUFFER = BufferTarget(GL31.GL_UNIFORM_BUFFER)


val READ_ONLY = BufferAccess(GL15.GL_READ_ONLY)
//#	READ_ONLY_ARB					= 0x88B8
val WRITE_ONLY = BufferAccess(GL15.GL_WRITE_ONLY)
//#	WRITE_ONLY_ARB					= 0x88B9
val READ_WRITE = BufferAccess(GL15.GL_READ_WRITE)


val STREAM_DRAW = Usage(GL15.GL_STREAM_DRAW)
val STREAM_READ = Usage(GL15.GL_STREAM_READ)
val STREAM_COPY = Usage(GL15.GL_STREAM_COPY)
val STATIC_DRAW = Usage(GL15.GL_STATIC_DRAW)
val STATIC_READ = Usage(GL15.GL_STATIC_READ)
val STATIC_COPY = Usage(GL15.GL_STATIC_COPY)
val DYNAMIC_DRAW = Usage(GL15.GL_DYNAMIC_DRAW)
val DYNAMIC_READ = Usage(GL15.GL_DYNAMIC_READ)
val DYNAMIC_COPY = Usage(GL15.GL_DYNAMIC_COPY)


val LOWER_LEFT = PointSpriteCoordOrigin(GL20.GL_LOWER_LEFT)
val UPPER_LEFT = PointSpriteCoordOrigin(GL20.GL_UPPER_LEFT)


val SWIZZLE_R = TextureSwizzle(GL33.GL_TEXTURE_SWIZZLE_R)
val SWIZZLE_G = TextureSwizzle(GL33.GL_TEXTURE_SWIZZLE_G)
val SWIZZLE_B = TextureSwizzle(GL33.GL_TEXTURE_SWIZZLE_B)
val SWIZZLE_A = TextureSwizzle(GL33.GL_TEXTURE_SWIZZLE_A)
val SWIZZLE_RGBA = TextureSwizzle(GL33.GL_TEXTURE_SWIZZLE_RGBA)


val FIRST_VERTEX_CONVENTION = ProvokeMode(GL32.GL_FIRST_VERTEX_CONVENTION)
val LAST_VERTEX_CONVENTION = ProvokeMode(GL32.GL_LAST_VERTEX_CONVENTION)


val DEPTH_COMPONENT = ProvokeMode(GL32.GL_DEPTH_COMPONENT)
val STENCIL_COMPONENT = ProvokeMode(GL43.GL_STENCIL_COMPONENTS)


val COMPARE_R_TO_TEXTURE = TextureCompareMode(GL14.GL_COMPARE_R_TO_TEXTURE)
val NONE_ = TextureCompareMode(GL11.GL_NONE)


val IMAGE_FORMAT_COMPATIBILITY_BY_SIZE = ImageFormatCompatibilityType(GL42.GL_IMAGE_FORMAT_COMPATIBILITY_BY_SIZE)
val IMAGE_FORMAT_COMPATIBILITY_BY_CLASS = ImageFormatCompatibilityType(GL42.GL_IMAGE_FORMAT_COMPATIBILITY_BY_CLASS)
val NONE__ = ImageFormatCompatibilityType(GL11.GL_NONE)


val ACCESS = BufferParameter(GL15.GL_BUFFER_ACCESS)
val ACCESS_FLAGS = BufferParameter(GL30.GL_BUFFER_ACCESS_FLAGS)
val IMMUTABLE_STORAGE = BufferParameter(GL44.GL_BUFFER_IMMUTABLE_STORAGE)
val MAPPED = BufferParameter(GL15.GL_BUFFER_MAPPED)
val MAP_LENGTH = BufferParameter(GL30.GL_BUFFER_MAP_LENGTH)
val MAP_OFFSET = BufferParameter(GL30.GL_BUFFER_MAP_OFFSET)
val SIZE = BufferParameter(GL15C.GL_BUFFER_SIZE)
val STORAGE_FLAGS = BufferParameter(GL44.GL_BUFFER_STORAGE_FLAGS)
val USAGE = BufferParameter(GL15.GL_BUFFER_USAGE)


val SAMPLES_PASSED = QueryTarget(GL15.GL_SAMPLES_PASSED)
val ANY_SAMPLES_PASSED = QueryTarget(GL33.GL_ANY_SAMPLES_PASSED)
val ANY_SAMPLES_PASSED_CONSERVATIVE = QueryTarget(GL43.GL_ANY_SAMPLES_PASSED_CONSERVATIVE)
val PRIMITIVES_GENERATED = QueryTarget(GL30.GL_PRIMITIVES_GENERATED)
val TRANSFORM_FEEDBACK_PRIMITIVES_WRITTEN = QueryTarget(GL30.GL_TRANSFORM_FEEDBACK_PRIMITIVES_WRITTEN)
val TIME_ELAPSED = QueryTarget(GL33.GL_TIME_ELAPSED)
val TIMESTAMP = QueryTarget(GL33.GL_TIMESTAMP)


val CURRENT_QUERY = GetQuery(GL15.GL_CURRENT_QUERY)
val COUNTER_BITS = GetQuery(GL15.GL_QUERY_COUNTER_BITS)


val RESULT = GetQueryObject(GL15.GL_QUERY_RESULT)
val RESULT_NO_WAIT = GetQueryObject(GL44.GL_QUERY_RESULT_NO_WAIT)
val RESULT_AVAILABLE = GetQueryObject(GL15.GL_QUERY_RESULT_AVAILABLE)


val COMPUTE_SHADER = ShaderType(GL43.GL_COMPUTE_SHADER)
val VERTEX_SHADER = ShaderType(GL20.GL_VERTEX_SHADER)
val TESS_CONTROL_SHADER = ShaderType(GL40.GL_TESS_CONTROL_SHADER)
val TESS_EVALUATION_SHADER = ShaderType(GL40.GL_TESS_EVALUATION_SHADER)
val GEOMETRY_SHADER = ShaderType(GL32.GL_GEOMETRY_SHADER)
val FRAGMENT_SHADER = ShaderType(GL20.GL_FRAGMENT_SHADER)


val SHADER_TYPE = GetShader(GL20.GL_SHADER_TYPE)
val DELETE_STATUS = GetShader(GL20.GL_DELETE_STATUS)
val COMPILE_STATUS = GetShader(GL20.GL_COMPILE_STATUS)
val INFO_LOG_LENGTH = GetShader(GL20.GL_INFO_LOG_LENGTH)
val SHADER_SOURCE_LENGTH = GetShader(GL20.GL_SHADER_SOURCE_LENGTH)


val DELETE_STATUS_ = GetProgram(GL20.GL_DELETE_STATUS)
val LINK_STATUS = GetProgram(GL20.GL_LINK_STATUS)
val VALIDATE_STATUS = GetProgram(GL20.GL_VALIDATE_STATUS)
val INFO_LOG_LENGTH_ = GetProgram(GL20.GL_INFO_LOG_LENGTH)
val ATTACHED_SHADERS = GetProgram(GL20.GL_ATTACHED_SHADERS)
val ACTIVE_ATOMIC_COUNTER_BUFFERS = GetProgram(GL42.GL_ACTIVE_ATOMIC_COUNTER_BUFFERS)
val ACTIVE_ATTRIBUTES = GetProgram(GL20.GL_ACTIVE_ATTRIBUTES)
val ACTIVE_ATTRIBUTE_MAX_LENGTH = GetProgram(GL20.GL_ACTIVE_ATTRIBUTE_MAX_LENGTH)
val ACTIVE_UNIFORMS = GetProgram(GL20.GL_ACTIVE_UNIFORMS)
val ACTIVE_UNIFORM_BLOCKS = GetProgram(GL31.GL_ACTIVE_UNIFORM_BLOCKS)
val ACTIVE_UNIFORM_BLOCK_MAX_NAME_LENGTH = GetProgram(GL31.GL_ACTIVE_UNIFORM_BLOCK_MAX_NAME_LENGTH)
val ACTIVE_UNIFORM_MAX_LENGTH = GetProgram(GL20.GL_ACTIVE_UNIFORM_MAX_LENGTH)
//val COMPUTE_WORK_GROUP_SIZE = GetProgram(GL43.GL_COMPUTE_WORK_GROUP_SIZE) Vec3i
val PROGRAM_BINARY_LENGTH = GetProgram(GL41.GL_PROGRAM_BINARY_LENGTH)
val TRANSFORM_FEEDBACK_BUFFER_MODE = GetProgram(GL30.GL_TRANSFORM_FEEDBACK_BUFFER_MODE)
val TRANSFORM_FEEDBACK_VARYINGS = GetProgram(GL30.GL_TRANSFORM_FEEDBACK_VARYINGS)
val TRANSFORM_FEEDBACK_VARYING_MAX_LENGTH = GetProgram(GL30.GL_TRANSFORM_FEEDBACK_VARYING_MAX_LENGTH)
val GEOMETRY_VERTICES_OUT = GetProgram(GL32.GL_GEOMETRY_VERTICES_OUT)
val GEOMETRY_INPUT_TYPE = GetProgram(GL32.GL_GEOMETRY_INPUT_TYPE)
val GEOMETRY_OUTPUT_TYPE = GetProgram(GL32.GL_GEOMETRY_OUTPUT_TYPE)


val FLOAT_ = UniformType(GL11.GL_FLOAT)
val FLOAT_VEC2 = UniformType(GL20.GL_FLOAT_VEC2)
val FLOAT_VEC3 = UniformType(GL20.GL_FLOAT_VEC3)
val FLOAT_VEC4 = UniformType(GL20.GL_FLOAT_VEC4)
val DOUBLE_ = UniformType(GL11.GL_DOUBLE)
val DOUBLE_VEC2 = UniformType(GL40.GL_DOUBLE_VEC2)
val DOUBLE_VEC3 = UniformType(GL40.GL_DOUBLE_VEC3)
val DOUBLE_VEC4 = UniformType(GL40.GL_DOUBLE_VEC4)
val INT_ = UniformType(GL11.GL_INT)
val INT_VEC2 = UniformType(GL20.GL_INT_VEC2)
val INT_VEC3 = UniformType(GL20.GL_INT_VEC3)
val INT_VEC4 = UniformType(GL20.GL_INT_VEC4)
val UNSIGNED_INT_ = UniformType(GL11.GL_UNSIGNED_INT)
val UNSIGNED_INT_VEC2 = UniformType(GL30.GL_UNSIGNED_INT_VEC2)
val UNSIGNED_INT_VEC3 = UniformType(GL30.GL_UNSIGNED_INT_VEC3)
val UNSIGNED_INT_VEC4 = UniformType(GL30.GL_UNSIGNED_INT_VEC4)
val BOOL = UniformType(GL20.GL_BOOL)
val BOOL_VEC2 = UniformType(GL20.GL_BOOL_VEC2)
val BOOL_VEC3 = UniformType(GL20.GL_BOOL_VEC3)
val BOOL_VEC4 = UniformType(GL20.GL_BOOL_VEC4)
val FLOAT_MAT2 = UniformType(GL20.GL_FLOAT_MAT2)
val FLOAT_MAT3 = UniformType(GL20.GL_FLOAT_MAT3)
val FLOAT_MAT4 = UniformType(GL20.GL_FLOAT_MAT4)
val FLOAT_MAT2x3 = UniformType(GL21.GL_FLOAT_MAT2x3)
val FLOAT_MAT2x4 = UniformType(GL21.GL_FLOAT_MAT2x4)
val FLOAT_MAT3x2 = UniformType(GL21.GL_FLOAT_MAT3x2)
val FLOAT_MAT3x4 = UniformType(GL21.GL_FLOAT_MAT3x4)
val FLOAT_MAT4x2 = UniformType(GL21.GL_FLOAT_MAT4x2)
val FLOAT_MAT4x3 = UniformType(GL21.GL_FLOAT_MAT4x3)
val DOUBLE_MAT2 = UniformType(GL40.GL_DOUBLE_MAT2)
val DOUBLE_MAT3 = UniformType(GL40.GL_DOUBLE_MAT3)
val DOUBLE_MAT4 = UniformType(GL40.GL_DOUBLE_MAT4)
val DOUBLE_MAT2x3 = UniformType(GL40.GL_DOUBLE_MAT2x3)
val DOUBLE_MAT2x4 = UniformType(GL40.GL_DOUBLE_MAT2x4)
val DOUBLE_MAT3x2 = UniformType(GL40.GL_DOUBLE_MAT3x2)
val DOUBLE_MAT3x4 = UniformType(GL40.GL_DOUBLE_MAT3x4)
val DOUBLE_MAT4x2 = UniformType(GL40.GL_DOUBLE_MAT4x2)
val DOUBLE_MAT4x3 = UniformType(GL40.GL_DOUBLE_MAT4x3)
val SAMPLER_1D = UniformType(GL20.GL_SAMPLER_1D)
val SAMPLER_2D = UniformType(GL20.GL_SAMPLER_2D)
val SAMPLER_3D = UniformType(GL20.GL_SAMPLER_3D)
val SAMPLER_CUBE = UniformType(GL20.GL_SAMPLER_CUBE)
val SAMPLER_1D_SHADOW = UniformType(GL20.GL_SAMPLER_1D_SHADOW)
val SAMPLER_2D_SHADOW = UniformType(GL20.GL_SAMPLER_2D_SHADOW)
val SAMPLER_1D_ARRAY_SHADOW = UniformType(GL30.GL_SAMPLER_1D_ARRAY_SHADOW)
val SAMPLER_2D_ARRAY_SHADOW = UniformType(GL30.GL_SAMPLER_2D_ARRAY_SHADOW)
val SAMPLER_2D_MULTISAMPLE = UniformType(GL32.GL_SAMPLER_2D_MULTISAMPLE)
val SAMPLER_2D_MULTISAMPLE_ARRAY = UniformType(GL32.GL_SAMPLER_2D_MULTISAMPLE_ARRAY)
val SAMPLER_CUBE_SHADOW = UniformType(GL30.GL_SAMPLER_CUBE_SHADOW)
val SAMPLER_BUFFER = UniformType(GL31.GL_SAMPLER_BUFFER)
val SAMPLER_2D_RECT = UniformType(GL31.GL_SAMPLER_2D_RECT)
val SAMPLER_2D_RECT_SHADOW = UniformType(GL31.GL_SAMPLER_2D_RECT_SHADOW)
val INT_SAMPLER_1D = UniformType(GL30.GL_INT_SAMPLER_1D)
val INT_SAMPLER_2D = UniformType(GL30.GL_INT_SAMPLER_2D)
val INT_SAMPLER_3D = UniformType(GL30.GL_INT_SAMPLER_3D)
val INT_SAMPLER_CUBE = UniformType(GL30.GL_INT_SAMPLER_CUBE)
val INT_SAMPLER_1D_ARRAY = UniformType(GL30.GL_INT_SAMPLER_1D_ARRAY)
val INT_SAMPLER_2D_ARRAY = UniformType(GL30.GL_INT_SAMPLER_2D_ARRAY)
val INT_SAMPLER_2D_MULTISAMPLE = UniformType(GL32.GL_INT_SAMPLER_2D_MULTISAMPLE)
val INT_SAMPLER_2D_MULTISAMPLE_ARRAY = UniformType(GL32.GL_INT_SAMPLER_2D_MULTISAMPLE_ARRAY)
val INT_SAMPLER_BUFFER = UniformType(GL31.GL_INT_SAMPLER_BUFFER)
val INT_SAMPLER_2D_RECT = UniformType(GL31.GL_INT_SAMPLER_2D_RECT)
val UNSIGNED_INT_SAMPLER_1D = UniformType(GL30.GL_UNSIGNED_INT_SAMPLER_1D)
val UNSIGNED_INT_SAMPLER_2D = UniformType(GL30.GL_UNSIGNED_INT_SAMPLER_2D)
val UNSIGNED_INT_SAMPLER_3D = UniformType(GL30.GL_UNSIGNED_INT_SAMPLER_3D)
val UNSIGNED_INT_SAMPLER_CUBE = UniformType(GL30.GL_UNSIGNED_INT_SAMPLER_CUBE)
val UNSIGNED_INT_SAMPLER_1D_ARRAY = UniformType(GL31.GL_UNSIGNED_INT_SAMPLER_1D_ARRAY)
val UNSIGNED_INT_SAMPLER_2D_ARRAY = UniformType(GL31.GL_UNSIGNED_INT_SAMPLER_2D_ARRAY)
val UNSIGNED_INT_SAMPLER_2D_MULTISAMPLE = UniformType(GL32.GL_UNSIGNED_INT_SAMPLER_2D_MULTISAMPLE)
val UNSIGNED_INT_SAMPLER_2D_MULTISAMPLE_ARRAY = UniformType(GL32.GL_UNSIGNED_INT_SAMPLER_2D_MULTISAMPLE_ARRAY)
val UNSIGNED_INT_SAMPLER_BUFFER = UniformType(GL31.GL_UNSIGNED_INT_SAMPLER_BUFFER)
val UNSIGNED_INT_SAMPLER_2D_RECT = UniformType(GL31.GL_UNSIGNED_INT_SAMPLER_2D_RECT)
val IMAGE_1D = UniformType(GL42.GL_IMAGE_1D)
val IMAGE_2D = UniformType(GL42.GL_IMAGE_2D)
val IMAGE_3D = UniformType(GL42.GL_IMAGE_3D)
val IMAGE_2D_RECT = UniformType(GL42.GL_IMAGE_2D_RECT)
val IMAGE_CUBE = UniformType(GL42.GL_IMAGE_CUBE)
val IMAGE_BUFFER = UniformType(GL42.GL_IMAGE_BUFFER)
val IMAGE_1D_ARRAY = UniformType(GL42.GL_IMAGE_1D_ARRAY)
val IMAGE_2D_ARRAY = UniformType(GL42.GL_IMAGE_2D_ARRAY)
val IMAGE_2D_MULTISAMPLE = UniformType(GL42.GL_IMAGE_2D_MULTISAMPLE)
val IMAGE_2D_MULTISAMPLE_ARRAY = UniformType(GL42.GL_IMAGE_2D_MULTISAMPLE_ARRAY)
val INT_IMAGE_1D = UniformType(GL42.GL_INT_IMAGE_1D)
val INT_IMAGE_2D = UniformType(GL42.GL_INT_IMAGE_2D)
val INT_IMAGE_3D = UniformType(GL42.GL_INT_IMAGE_3D)
val INT_IMAGE_2D_RECT = UniformType(GL42.GL_INT_IMAGE_2D_RECT)
val INT_IMAGE_CUBE = UniformType(GL42.GL_INT_IMAGE_CUBE)
val INT_IMAGE_BUFFER = UniformType(GL42.GL_INT_IMAGE_BUFFER)
val INT_IMAGE_1D_ARRAY = UniformType(GL42.GL_INT_IMAGE_1D_ARRAY)
val INT_IMAGE_2D_ARRAY = UniformType(GL42.GL_INT_IMAGE_2D_ARRAY)
val INT_IMAGE_2D_MULTISAMPLE = UniformType(GL42.GL_INT_IMAGE_2D_MULTISAMPLE)
val INT_IMAGE_2D_MULTISAMPLE_ARRAY = UniformType(GL42.GL_INT_IMAGE_2D_MULTISAMPLE_ARRAY)
val UNSIGNED_INT_IMAGE_1D = UniformType(GL42.GL_UNSIGNED_INT_IMAGE_1D)
val UNSIGNED_INT_IMAGE_2D = UniformType(GL42.GL_UNSIGNED_INT_IMAGE_2D)
val UNSIGNED_INT_IMAGE_3D = UniformType(GL42.GL_UNSIGNED_INT_IMAGE_3D)
val UNSIGNED_INT_IMAGE_2D_RECT = UniformType(GL42.GL_UNSIGNED_INT_IMAGE_2D_RECT)
val UNSIGNED_INT_IMAGE_CUBE = UniformType(GL42.GL_UNSIGNED_INT_IMAGE_CUBE)
val UNSIGNED_INT_IMAGE_BUFFER = UniformType(GL42.GL_UNSIGNED_INT_IMAGE_BUFFER)
val UNSIGNED_INT_IMAGE_1D_ARRAY = UniformType(GL42.GL_UNSIGNED_INT_IMAGE_1D_ARRAY)
val UNSIGNED_INT_IMAGE_2D_ARRAY = UniformType(GL42.GL_UNSIGNED_INT_IMAGE_2D_ARRAY)
val UNSIGNED_INT_IMAGE_2D_MULTISAMPLE = UniformType(GL42.GL_UNSIGNED_INT_IMAGE_2D_MULTISAMPLE)
val UNSIGNED_INT_IMAGE_2D_MULTISAMPLE_ARRAY = UniformType(GL42.GL_UNSIGNED_INT_IMAGE_2D_MULTISAMPLE_ARRAY)
val UNSIGNED_INT_ATOMIC_COUNTER = UniformType(GL42.GL_UNSIGNED_INT_ATOMIC_COUNTER)


val BYTE_ = VertexAttribType(GL11.GL_BYTE)
val UNSIGNED_BYTE_ = VertexAttribType(GL20.GL_UNSIGNED_BYTE)
val SHORT_ = VertexAttribType(GL20.GL_SHORT)
val UNSIGNED_SHORT_ = VertexAttribType(GL20.GL_UNSIGNED_SHORT)
val INT__ = VertexAttribType(GL11.GL_INT)
val UNSIGNED_INT__ = VertexAttribType(GL40.GL_UNSIGNED_INT)
val HALF_FLOAT_ = VertexAttribType(GL40.GL_HALF_FLOAT)
val FLOAT__ = VertexAttribType(GL40.GL_FLOAT)
val DOUBLE__ = VertexAttribType(GL11.GL_DOUBLE)
val FIXED = VertexAttribType(GL41.GL_FIXED)
val INT_2_10_10_10_REV = VertexAttribType(GL33.GL_INT_2_10_10_10_REV)
val UNSIGNED_INT_2_10_10_10_REV = VertexAttribType(GL12.GL_UNSIGNED_INT_2_10_10_10_REV)
val UNSIGNED_INT_10F_11F_11F_REV = VertexAttribType(GL30.GL_UNSIGNED_INT_10F_11F_11F_REV)


val FLOAT___ = AttributeType(GL11.GL_FLOAT)
val FLOAT_VEC2_ = AttributeType(GL20.GL_FLOAT_VEC2)
val FLOAT_VEC3_ = AttributeType(GL20.GL_FLOAT_VEC3)
val FLOAT_VEC4_ = AttributeType(GL20.GL_FLOAT_VEC4)
val FLOAT_MAT2_ = AttributeType(GL20.GL_FLOAT_MAT2)
val FLOAT_MAT3_ = AttributeType(GL20.GL_FLOAT_MAT3)
val FLOAT_MAT4_ = AttributeType(GL20.GL_FLOAT_MAT4)
val FLOAT_MAT2x3_ = AttributeType(GL21.GL_FLOAT_MAT2x3)
val FLOAT_MAT2x4_ = AttributeType(GL21.GL_FLOAT_MAT2x4)
val FLOAT_MAT3x2_ = AttributeType(GL21.GL_FLOAT_MAT3x2)
val FLOAT_MAT3x4_ = AttributeType(GL21.GL_FLOAT_MAT3x4)
val FLOAT_MAT4x2_ = AttributeType(GL21.GL_FLOAT_MAT4x2)
val FLOAT_MAT4x3_ = AttributeType(GL21.GL_FLOAT_MAT4x3)
val INT_VEC2_ = AttributeType(GL20.GL_INT_VEC2)
val INT_VEC3_ = AttributeType(GL20.GL_INT_VEC3)
val INT_VEC4_ = AttributeType(GL20.GL_INT_VEC4)
val UNSIGNED_INT___ = AttributeType(GL11.GL_UNSIGNED_INT)
val UNSIGNED_INT_VEC2_ = AttributeType(GL30.GL_UNSIGNED_INT_VEC2)
val UNSIGNED_INT_VEC3_ = AttributeType(GL30.GL_UNSIGNED_INT_VEC3)
val UNSIGNED_INT_VEC4_ = AttributeType(GL30.GL_UNSIGNED_INT_VEC4)
val DOUBLE___ = AttributeType(GL11.GL_DOUBLE)
val DOUBLE_VEC2_ = AttributeType(GL40.GL_DOUBLE_VEC2)
val DOUBLE_VEC3_ = AttributeType(GL40.GL_DOUBLE_VEC3)
val DOUBLE_VEC4_ = AttributeType(GL40.GL_DOUBLE_VEC4)
val DOUBLE_MAT2_ = AttributeType(GL40.GL_DOUBLE_MAT2)
val DOUBLE_MAT3_ = AttributeType(GL40.GL_DOUBLE_MAT3)
val DOUBLE_MAT4_ = AttributeType(GL40.GL_DOUBLE_MAT4)
val GL_DOUBLE_MAT2x3 = AttributeType(GL40.GL_DOUBLE_MAT2x3)
val GL_DOUBLE_MAT2x4 = AttributeType(GL40.GL_DOUBLE_MAT2x4)
val GL_DOUBLE_MAT3x2 = AttributeType(GL40.GL_DOUBLE_MAT3x2)
val GL_DOUBLE_MAT3x4 = AttributeType(GL40.GL_DOUBLE_MAT3x4)
val GL_DOUBLE_MAT4x2 = AttributeType(GL40.GL_DOUBLE_MAT4x2)
val GL_DOUBLE_MAT4x3 = AttributeType(GL40.GL_DOUBLE_MAT4x3)


val BUFFER_BINDING = GetVertexAttrib(GL15.GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING)
val ENABLED = GetVertexAttrib(GL20.GL_VERTEX_ATTRIB_ARRAY_ENABLED)
val SIZE_ = GetVertexAttrib(GL20.GL_VERTEX_ATTRIB_ARRAY_SIZE)
val STRIDE = GetVertexAttrib(GL20.GL_VERTEX_ATTRIB_ARRAY_STRIDE)
val TYPE = GetVertexAttrib(GL20.GL_VERTEX_ATTRIB_ARRAY_TYPE)
val NORMALIZED = GetVertexAttrib(GL20.GL_VERTEX_ATTRIB_ARRAY_NORMALIZED)
val INTEGER = GetVertexAttrib(GL30.GL_VERTEX_ATTRIB_ARRAY_INTEGER)
val DIVISOR = GetVertexAttrib(GL33.GL_VERTEX_ATTRIB_ARRAY_DIVISOR)
val CURRENT = GetVertexAttrib(GL20.GL_CURRENT_VERTEX_ATTRIB)