import java.util.Scanner

class CreateArchiveScreen(private val archives: MutableMap<String, MutableList<Note>>) {
    private val scanner = Scanner(System.`in`)

    fun start() {
        while (true) {
            println("Введите название архива (не может быть пустым):")
            val name = scanner.nextLine().trim()

            when {
                name.isEmpty() -> println("Название архива не может быть пустым.")
                archives.containsKey(name) -> println("Архив с таким именем уже существует.")
                else -> {
                    archives[name] = mutableListOf()
                    println("Архив '$name' успешно создан.")
                        return
                }
            }
        }
    }
}
