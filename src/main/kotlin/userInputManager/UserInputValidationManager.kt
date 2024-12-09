package userInputManager

open class UserInputValidationManager {

    fun getTextInput(entityName: String): String {
        while (true) {
            println("Введите $entityName: ")
            var input = readlnOrNull()
            when (input) {
                null -> println("Ошибка, $entityName не может быть пустым...")
                else -> {
                    var inputLength = input.trim().length
                    if (inputLength == 0) {
                        println("Ошибка, $entityName не может быть пустым либо стостоять из пробелов...")
                    } else if (inputLength <= 1) {
                        println("Ошибка, $entityName не может состоять из одного символа...")
                    } else {
                        return input
                    }
                }
            }
        }
    }
}