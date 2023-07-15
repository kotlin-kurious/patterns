class MailBuilder {
    //specify default values for constructor and function parameters
    data class Mail_V3(
        val to: List<String>,
        val cc: List<String> = listOf(),
        val title: String = "",
        val message: String = "",
        val important: Boolean = false
    )

    val mail = Mail_V3(listOf("manager@company.com"), listOf(), "Ping")

    // Not having to specify order with fluent setters was very handy. Kotlin has named arguments for that
    val mail2 = Mail_V3(title = "Hello", message = "There", to = listOf("my@dear.cat"))

}