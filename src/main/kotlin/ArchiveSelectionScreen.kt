import java.util.Scanner

class ArchiveSelectionScreen(private val archives: MutableMap<String, MutableList<Note>>) : SelectionScreen("Управление архивами"){
    init {
        addOption("Создать архив"){
            CreateArchiveScreen(archives).start()
            updateOptions()
        }
        updateOptions()
    }

    private fun updateOptions(){
        while(options.size > 1){
            options.removeAt(1)
        }

        if (archives.isNotEmpty()){
            archives.keys.forEach { archiveName ->
                addOption(archiveName){
                    NoteSelectionScreen(archives, archiveName).start()
                }
            }
        } else {
            addOption("Архивов нет") {}
        }
    }
}