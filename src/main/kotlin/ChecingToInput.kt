class ChecingToInput(){
    fun chec(input: String?): String? {
        return input?.takeIf { it.isNotEmpty() } ?: run {
            inputError()
            null
        }
    }
    fun inputError(){
        println("Введено некорректное значение")
    }
}