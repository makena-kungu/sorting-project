package existing

fun quickSort(array: IntArray) {
    //println("array = [${array.joinToString()}]")
    quickSort(array, 0, array.lastIndex)
}

fun quickSort(array: IntArray, low: Int, high: Int) {
    //println("array = [${array.joinToString()}], low = [${low}], high = [${high}]")

    if (low < high) {
        val pi = partition(array, low, high)
        quickSort(array, low, pi - 1)
        quickSort(array, pi + 1, high)
    }
}

/*
* We'll take the highest element in this partition as the pivot an sort it, then sort other elements
* relative to it
* */
private fun partition(array: IntArray, low: Int, high: Int): Int {
    val pivot = array[high]
    var i = low - 1
    for (j in low until high) {
        if (array[j] < pivot) {
            swap(array, ++i, j)
        }
    }
    val k = i + 1
    swap(array, k, high)
    //println("array = [${array.joinToString()}], low = [${low}], high = [${high}]")
    return k
}