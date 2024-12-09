import constants.EntityNames
import entities.ArchiveModel
import entities.NoteModel
import userInputManager.UserInputValidationManager

class NotesApp {

    var noteArrays: MutableList<ArchiveModel> = mutableListOf()

    fun start() {
        println("Добро пожаловать в 'Архив заметок'")
        val screen = Menu(
            EntityNames.ARCHIVE,
            noteArrays,
            { archive -> openNoteArray(archive) },
            { createNewArchive() }
        )
        screen.render()
    }

    private fun openNoteArray(archive: ArchiveModel) {
        val screen = Menu(
            EntityNames.NOTE,
            archive.notes,
            { note -> openNote(note) },
            { createNewNote() }
        )
        screen.render()
    }

    private fun createNewArchive(): ArchiveModel {
        val archiveName = UserInputValidationManager().getTextInput("название архива")
        return ArchiveModel(archiveName)
    }

    private fun createNewNote(): NoteModel {
        val noteName = UserInputValidationManager().getTextInput("название заметки")
        val noteText = UserInputValidationManager().getTextInput("текст заметки")
        return NoteModel(noteName, noteText)
    }

    private fun openNote(note: NoteModel) {
        note.showContent()
    }
}