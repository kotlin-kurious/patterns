package decorator

class LoggingGetCaptain (private val repository:
                         StarTrekRepository): StarTrekRepository by repository {
    override fun getCaptain(starshipName: String): String {
        println("Getting captain for $starshipName")
        return repository.getCaptain(starshipName)
    }
}