import java.util.Scanner

class NoteViewScreen(private val note: Note) {
    private val scanner = Scanner(System.`in`)

    fun start() {
        println("Заголовок: ${note.title}")
        println("Текст заметки:")
        println(note.text)
        println("Нажмите Enter, чтобы вернуться.")
        scanner.nextLine()
    }
}