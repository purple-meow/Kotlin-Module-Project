import java.util.Scanner

class NoteSelectionScreen(
    private val archives: MutableMap<String, MutableList<Note>>,
    private val archiveName: String
) : SelectionScreen("Управление заметками в архиве '$archiveName'"){
    init {
        addOption("Создать заметку") {
            CreateNoteScreen(archives, archiveName).start()
            updateOptions()
        }
        updateOptions()
    }

    private fun updateOptions(){
        while (options.size > 1){
            options.removeAt(1)
        }

        val notes = archives[archiveName] ?: emptyList()
        if (notes.isNotEmpty()) {
            notes.forEach { note ->
                addOption(note.title) {
                    NoteViewScreen(note).start()
                }
            }
        } else {
            addOption("Заметок нет") {}
        }
    }
}