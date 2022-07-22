// Lab3. Diego Alexander Hernández Silvestre | Carné: 21270
data class ItemData (
    var originalPos: Int,
    var originalValue: Any,
    var type: String? = null,
    var info: String? = null
)
fun main() {
    val result = processList(listOf(20, 25, 2, 7,"hola","", true, false, null, 2.0))
    println(result)
}
fun processList(inputList: List<Any?>?): List<ItemData>? {
    inputList?.let { val finalList = ArrayList<ItemData>() //Filtrar valores nulos
        val count = inputList.size - 1 // Tamaño de la lista
        for (item in 0.. count) { var type: String? = "" // Recorrer todos los elementos de la lista
            var info: String? = ""
            val element = inputList[item]
            when (element) { is Int -> { type = "entero" //Filtrar cada elemento dependiendo el tipo.
                info = when {(element % 10) == 0 -> "M10" ; (element % 5) == 0 -> "M5" ; (element % 2) == 0 -> "M2" else -> null }}
                is String -> { type = "cadena" ; info = "L" + element.length }
                is Boolean -> { type = "booleano" ; info = when (element) { true -> "Verdadero" else -> "Falso" } }
                else -> {type = null ; info = null } }
            element?.let { finalList.add(ItemData(item, element, type, info)) } } //Añadir todos los valores a la lista final
        return finalList
    } ?: return null }