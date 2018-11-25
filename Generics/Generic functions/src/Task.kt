import java.util.*

fun <T, C : MutableCollection<in T>> Collection<T>.partitionTo(
        dest1: C,
        dest2: C,
        predicate: (T) -> Boolean): Pair<C, C> {

    for (element in this) {
        when (predicate(element)) {
            true -> dest1.add(element)
            false -> dest2.add(element)
        }
    }

    return Pair(dest1, dest2)
}

fun partitionWordsAndLines() {
    val (words, lines) = listOf("a", "a b", "c", "d e")
            .partitionTo(ArrayList(), ArrayList()) { s -> !s.contains(" ") }

    println(words == listOf("a", "c"))
    println(lines == listOf("a b", "d e"))
}

fun partitionLettersAndOtherSymbols() {
    val (letters, other) = setOf('a', '%', 'r', '}')
            .partitionTo(HashSet(), HashSet()) { c -> c in 'a'..'z' || c in 'A'..'Z' }

    println(letters == setOf('a', 'r'))
    println(other == setOf('%', '}'))
}

fun main() {
    println("starting...")
    partitionWordsAndLines()
    partitionLettersAndOtherSymbols()
}
