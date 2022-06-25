@file:OptIn(ExperimentalTime::class)
@file:Suppress("SameParameterValue", "unused")

import com.erickandedwin.HybridMergeSort.hybridSort
import testing_reliability.Util.generateInts
import to_be_used.MergeSort.mergeSort
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

private const val SIZE = 1_000_000
private const val DEFAULT_SEED = 0
private const val SEED = 34645

fun main() {

    val arr = generateInts(SIZE, true)
    System.gc()
    print("hybrid time           =", arr.clone()) { hybridSort(it) }
    System.gc()
    print("merge time            =", arr.clone()) { mergeSort(it) }
//    print("pair time             =") { if (it.size <= 10000) pairSort(it) }
//    print("default time          =") { sort(it) }
//    print("hybrid time  modified =") { hybridSortM(it) }
}

private inline fun print(what: String, array: IntArray, func: (IntArray) -> Unit) {
    println("$what ${measureTime { func(array) }}")
}