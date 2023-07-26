package decorator

interface  StarTrekRepository {
    fun getCaptain(starshipName: String): String
    fun addCaptain(starshipName: String, captainName:String)
}

