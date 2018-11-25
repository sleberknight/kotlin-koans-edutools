import java.util.*

fun getList(): List<Int> {
    val arrayList = arrayListOf(1, 5, 2)
    Collections.sort(arrayList, object: Comparator<Int> {
        override fun compare(num1: Int, num2: Int): Int = num2 - num1
    })
    return arrayList
}
