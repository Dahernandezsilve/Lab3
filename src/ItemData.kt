data class ItemData (
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
    inputList?.let { val finalList = ArrayList<ItemData>()
        val count: Int = inputList.size - 1
        for (item in 0.. count) {
            var type: String? = ""
            var info: String? = ""
            val element = inputList[item]
            when (element) { is Int -> { type = "entero"
                info = if ((element % 10) == 0) { "M10" } else if ((element % 5) == 0) { "M5" } else if ((element % 2) == 0) { "M2" } else { null } }
                is String -> { type = "cadena" ; info = "L" + element.length }
                is Boolean -> { type = "booleano" ; info = if (element == true) "Verdadero" else "Falso" }
            }
            element?.let { finalList.add(ItemData(item, element, type, info)) }
        }
        return finalList
    } ?: return null }