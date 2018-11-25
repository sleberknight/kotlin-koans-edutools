import java.util.*

fun <K, V> buildMap(build: HashMap<K, V>.() -> Unit): Map<K, V> {
    val hashMap = HashMap<K, V>()
    hashMap.build()
    return hashMap
}

fun usage(): Map<Int, String> {
    return buildMap {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
}
