import constants.EntityNames
import entities.BaseEntity

class Menu<T : BaseEntity>(
    val entityType: EntityNames,
    var content: MutableList<T>,
    val nextStep: (T) -> Unit,
    val createNewEntity: () -> T
) {

    fun render() {
        while (true) {
            println("\nСписок ${entityType.many}:\n0. Создать ${entityType.one}")
            content.forEachIndexed { index, entity -> println("${index + 1}. ${entity.name}") }
            println("${content.size + 1}. Выход")

            println("\nВыберите пункт меню:")
            when (val input = readLine()?.toIntOrNull()) {
                0 -> createAndAddEntityToArray()
                in 1..content.size -> if (input != null) {
                    nextStep(content[input - 1])
                }

                content.size + 1 -> return
                else -> println(
                    "\nОшибка, введено некорректное значение пункта меню."
                            + "\nВведите корректное значение...\n"
                )
            }
        }
    }

    private fun createAndAddEntityToArray() {
        val newEntity = createNewEntity()
        content.add(newEntity)
        println(entityType.creationMessage)
    }
}