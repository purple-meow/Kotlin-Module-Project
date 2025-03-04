import java.util.Scanner

class CreateNoteScreen(private val archives: MutableMap<String, MutableList<Note>>,
    private val archiveName: String) {
    private val scanner = Scanner(System.`in`)
    fun start() {
        while (true) {
            println("Введите название заметки (не может быть пустым):")
            val title = scanner.nextLine().trim()

            when {
                title.isEmpty() -> println("Название заметки не может быть пустым.")
                archives[archiveName]?.any { it.title == title } == true -> println("Заметка с таким именем уже существует.")
                else -> {
                    println("Введите текст заметки (не может быть пустым):")
                    val text = scanner.nextLine().trim()

                    if (text.isEmpty()) {
                        println("Текст заметки не может быть пустым.")
                    } else {
                    archives[archiveName]?.add(Note(title, text))
                    println("Заметка '$title' успешно создана.")
                    return
                }
            }
        }
    }
}
}