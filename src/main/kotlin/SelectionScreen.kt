import java.util.Scanner

open class SelectionScreen(private val title: String) {
    protected val options = mutableListOf<MenuOption>()
    protected val scanner = Scanner(System.`in`)

    protected fun addOption(label: String, action: () -> Unit) {
        options.add(MenuOption(label, action))
    }

    fun start() {
        while (true) {
            println(title)
            options.forEachIndexed { index, option ->
             println("$index. ${option.label}")
            }
            println("${options.size}. Выход")

            println("Выберите пункт меню:")
            val input = scanner.nextLine().trim()

            try {
                val choice = input.toInt()
                when{
                    choice == options.size -> return
                    choice in options.indices -> options[choice].action()
                    else -> println("Неверный номер пункта меню")
                }
            } catch (e: NumberFormatException) {
                println("Пожалуйста, введите число.")
            }
        }
    }
}

data class MenuOption(val label: String, val action: () -> Unit)