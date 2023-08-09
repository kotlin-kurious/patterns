
fun main() {

    // using an inner class
    // note the Kotlin api usage of `restore`
    // learned:
    // using special characters in function names wrapped in backticks
    // using the `with` standard function to avoid repeating myMemento.think()

    val myMemento = Memento()
    myMemento.think("First Thought")
    myMemento.think("On Second thought")
    val memento = myMemento.saveThatThought()
    with(myMemento) {
        think("Three-peat")

    }
    myMemento.printThoughts()
    myMemento.`my thoughts back then?`(memento)
    myMemento.printThoughts()
}

class Memento {

    private var thoughts = mutableListOf<String>()

    fun printThoughts() {
        println(thoughts)
    }

    inner class Memory(private val mindState: List<String>) {
        fun restore() {
            thoughts = mindState.toMutableList()
        }
    }

    fun saveThatThought(): Memory {
        return Memory(thoughts.toList())
    }

    fun `my thoughts back then?`(memory: Memory) {
        memory.restore()
    }

    fun think(thought: String) {
        thoughts.add(thought)
        if (thoughts.size > 2) {
            thoughts.removeFirst()
        }
    }
}