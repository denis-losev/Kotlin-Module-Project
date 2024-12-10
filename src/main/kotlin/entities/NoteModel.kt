package entities

data class NoteModel(
    override var name: String,
    var text: String
) : BaseEntity(name) {

    fun showContent() {
        println("\nНазвание заметки: $name\nСодержание заметки: $text\n")
    }
}
