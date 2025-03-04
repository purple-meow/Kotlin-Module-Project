fun main(){
    println("Добро пожаловать в приложение для управления архивами и заметками!")
    val archives = mutableMapOf<String,MutableList<Note>>()
    ArchiveSelectionScreen(archives).start()
    println("Программа завершена.")
}