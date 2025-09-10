class NoteAdd {
    val archiv = mutableListOf<Archive>()

    fun addArchive(name: String) {
        archiv.add(Archive(name, mutableListOf()))
    }

    fun getArсhives(): List<String> {
        return archiv.map { it.archive }
    }

    fun addNoteArchive(numberArchive: Int, nameNote: String, textNote: String) {
        archiv[numberArchive].notes.add(Note(nameNote, textNote))
    }

    fun getTextNote(numberArchive: Int, numberNote: Int): String {
        return archiv[numberArchive].notes[numberNote].textNote
    }

    fun getNote(numberArchive: Int): List<String> {
        return archiv[numberArchive].notes.map { it.titleNote }
    }


}