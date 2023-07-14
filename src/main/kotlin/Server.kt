//  in Kotlin, there's no such keyword as `static`
//  Instead, methods that don't belong to an instance of a class can be declared
//  inside companion object
class Server (port: Long) {
    init {
        println("Server started on port $port")
    }
    companion object {
        fun withPort(port: Long) = Server(port)
    }
}