class Note( val name: String,  val body: String) {

    override fun toString(): String {
        return ("Заметка: ${this.name}")
    }
}

class Archive(val name: String) {
    private var body = emptyList<Note>().toMutableList()

    fun addNote(note: Note) {
        this.body.add(note)
        println("Заметка была добавлена")
    }

    override fun toString(): String {
        return name
    }
    fun findNote(noteName: String): Note? {
        return body.find { it.name.lowercase() == noteName.lowercase() }
    }

    fun showNotes() {
        println("Список заметок: $body")
    }
}

class Storage {
    var body = emptyList<Archive>().toMutableList()


    fun showArchives() {
        println("Архивы: $body")
    }

    fun findArchive(archiveName: String): Archive? {
        return body.find { it.name.lowercase() == archiveName.lowercase() }
    }

    override fun toString(): String {
        return body.toString()
    }
}
