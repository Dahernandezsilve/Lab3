data class ItemData (
    // No tocar esta clase ---

        var originalPos: Int,
        var originalValue: Any,
        var type: String? = null,
        var info: String? = null
)
    fun main() {
        val result = processList(listOf(20, 25, 2, 7, "hola", "", true, false, null, 2.0))
        println(result)
    }
    fun processList(inputList: List<Any?>?): List<ItemData>? {
        if (inputList==null){
            return null
        }
        var listaFinal = ArrayList<ItemData>()
        var contar:Int = inputList!!.size-1
        for (item in 0..contar) {
            var originalPos:Int = item
            var type:String?=""
            var info:String?=""
            val element = inputList[item]
            when (element) {
                is Int -> {
                    var value:Int = element
                    type = "entero"
                    if ((value % 10) == 0){
                        info = "M10"
                    } else if ((value % 5) == 0){
                        info = "M5"
                    } else if ((value % 2) == 0){
                        info = "M2"
                    } else {
                        info = null
                    }
                }
                is String -> {
                    type = "cadena"
                    info = "L" + element.length
                }
                is Boolean -> {
                    type = "booleano"
                    if (element == true){
                        info = "Verdadero"
                    } else {
                        info = "Falso"
                    }
                }
                else -> {
                    type = null
                    info = null
                }
            }
            if (element != null) {
                listaFinal.add(ItemData(originalPos, (element ?: "null"), type, info))
            }
        }
        return listaFinal
    }