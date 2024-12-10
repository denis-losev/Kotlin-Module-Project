package constants

enum class EntityNames(
    val one: String,
    val many: String,
    val creationMessage: String
) {

    ARCHIVE(
        "архив",
        "архивов",
        "Архив успешно создан!"
    ),
    NOTE(
        "заметку",
        "заметок",
        "Заметка успешно добавлена в архив!"
    )
}