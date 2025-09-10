class ChecingToInput(){
    fun chec(input: String?): String? {
        return input?.takeIf { it.isNotBlank() } ?: run {
            inputError()
            null
        }
    }
    fun inputError(){
        println("Введено некорректное значение")
    }
}