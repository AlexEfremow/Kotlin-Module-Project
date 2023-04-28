import kotlin.system.exitProcess

fun main() {
    NotesController().mainScreen()
}

class NotesController {

    private val newStorage = Storage()

    fun mainScreen() {
        println("Список экранов: \n 0. Создать архив \n 1. Созданный архив \n 2. Выход \n")
        show(onClick0 = {
            println("Введите название Архива: ")
            newStorage.body.add(Archive(readLine() ?: ""))
            println("Архив был добавлен")
        }, onClick1 = {
            newStorage.showArchives()
            archiveChoose()
        }, onClick2 = { exitProcess(-1) })
    }

    fun show(onClick0: () -> Unit, onClick1: () -> Unit, onClick2: () -> Unit) {
        while (true) {
            println("Введите число: ")
            when (readLine()?.toIntOrNull()) {
                0 -> onClick0()
                1 -> onClick1()
                2 -> onClick2()
            }
        }
    }

    fun choose(onClick1: () -> Unit, onClick2: () -> Unit) {
        while (true) {
            println("Введите число: ")
            when (readLine()?.toIntOrNull()) {
                1 -> onClick1()
                2 -> onClick2()
                else -> println("Ошибка!")
            }
        }
    }


    fun archiveChoose() {
        println("1. Открыть Архив 2. Вернуться \n")
        choose(
            onClick1 = {
                println("Введите название Архива: ")
                val chosenArchive = newStorage.findArchive(readlnOrNull() ?: "")
                if (chosenArchive != null) {
                    showArchive(chosenArchive)
                } else {
                    println("Ошибка!\n")
                }
            },
            onClick2 = { mainScreen() })
    }

    fun showArchive(archive: Archive) {
        println("Список экранов: \n 0. Создать заметку \n 1. Созданные заметки \n 2. Вернуться \n")
        show(
            onClick0 = {
                println("Введите название Заметки: ")
                val name = readlnOrNull() ?: ""
                println("Введите тело Заметки: ")
                val body = readlnOrNull() ?: ""
                archive.addNote(Note(name, body))
            },
            onClick1 = {
                choiceNote(archive)
            },
            onClick2 = {
                archiveChoose()
            })
    }

    fun choiceNote(archive: Archive) {
        println("1. Открыть заметку 2. Вернуться \n")
        choose(onClick1 = {println("Введите название Заметки: ")
            val chosenNote = archive.findNote(readlnOrNull() ?: "")
            if (chosenNote != null) {
                println("Заметка: ${chosenNote.body} \n")
            } else {
                println("Ошибка!\n")
            }}, onClick2 = {showArchive(archive)})
            archive.showNotes()

            }
        }
