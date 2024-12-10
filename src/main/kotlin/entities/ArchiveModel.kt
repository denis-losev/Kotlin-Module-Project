package entities

data class ArchiveModel(
    override var name: String,
    var notes: MutableList<NoteModel> = mutableListOf()
) : BaseEntity(name)
