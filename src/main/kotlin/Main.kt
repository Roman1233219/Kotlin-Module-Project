fun main() {

    val addNotes = NoteAdd()
    val errorMessage = ChecingToInput()
    while (true) {
        println("1. Создать архив\n2. Список архивов\n3. Выход")

        when (try {
            readln().toInt()
        } catch (e: Exception) {
        }) {

            1 -> {
                var nameArch: String? = null
                while (nameArch == null) {
                    println("Введите название архива:")
                    var input = readlnOrNull()
                    nameArch = errorMessage.chec(input)

                }
                addNotes.addArchive(nameArch)
            }

            2 -> {
                while (true) {
                    println("Список архивов:")
                    val archives = addNotes.getArсhives()
                    for (i in archives.indices) {
                        println("$i. ${archives[i]}")
                    }
                    println("${archives.size}. Назад")

                    val archiveChoice: Int = try {
                        readln().toInt()
                    } catch (e: Exception) {
                        archives.size + 2
                    }

                    when {
                        archiveChoice < archives.size -> {
                            val archiveName = archives[archiveChoice]
                            while (true) {
                                println("Список заметок в архиве: $archiveName")
                                val notes = addNotes.getNote(archiveChoice)
                                for (i in notes.indices) {
                                    println("$i. ${notes[i]}")
                                }
                                println("${notes.size}. Создать заметку\n${notes.size + 1}. Назад")



                                val сhoice: Int = try {
                                    readln().toInt()
                                } catch (e: Exception) {
                                    archives.size + 2
                                }

                                when {
                                    сhoice == notes.size -> {
                                        var nameNote: String? = null
                                        while (nameNote == null) {
                                            println("Введите название заметки:")
                                            var input = readlnOrNull()
                                            nameNote = ChecingToInput().chec(input)

                                        }

                                        var textNote: String? = null
                                        while(textNote==null){
                                            println("Введите текст заметки:")
                                            var input = readlnOrNull()
                                            textNote = ChecingToInput().chec(input)
                                        }
                                        addNotes.addNoteArchive(archiveChoice, nameNote, textNote)
                                    }

                                    сhoice == notes.size + 1 -> {
                                        break
                                    }

                                    сhoice < notes.size -> {
                                        val nameNote = notes[сhoice]
                                        val textNote =
                                            addNotes.getTextNote(archiveChoice, сhoice)
                                        println("Заметка '$nameNote'. Текст заметки: $textNote")
                                    }

                                    else -> errorMessage.inputError()
                                }
                            }
                        }

                        archiveChoice == archives.size -> {
                            break
                        }

                        else -> errorMessage.inputError()

                    }
                }
            }

            3 -> break

            else -> errorMessage.inputError()

        }
    }
}