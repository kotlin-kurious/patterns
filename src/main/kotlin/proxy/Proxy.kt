package proxy

import java.net.URL

class Proxy {

    fun main() {
        val lyrics = BandLyric(
            "https://private-anon-670eceec03-lyricsovh.apiary-mock.com/v1/u2/one",
            "https://private-anon-670eceec03-lyricsovh.apiary-mock.com/v1/u2/one"
        )

        println(lyrics)
        println(lyrics)
    }

    data class BandInfo(
        val url: String
    ) {
        val image: ByteArray by lazy { // this time, using the `by` keyword to delegate the initialization
            println("Fetching records, please wait")
            URL(url).readBytes()
        }
    }

}