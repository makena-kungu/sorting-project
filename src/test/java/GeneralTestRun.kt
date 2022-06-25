@file:OptIn(ExperimentalTime::class, ExperimentalTime::class)

import com.erickandedwin.HybridMergeSort.hybridSort
import existing.LegacyJava.legacyMergeSort
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking
import testing_reliability.Person
import testing_reliability.Util.generatePeople
import to_be_used.MergeSort.mergeSort
import java.util.*
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

private const val SIZE = 1__000_000

fun main() {
    val arr: Array<Person> = generatePeople(SIZE)
    runBlocking {
        awaitAll(async {
            print("merge time            =", arr.clone()) { mergeSort(it) }
        }, async {
            print("hybrid time           =", arr.clone()) { hybridSort(it) }
        }, async {
            print("default time          =", arr.clone()) { Arrays.sort(it) }
        }, async {
            print("legacy time           =", arr.clone()) { legacyMergeSort(it) }
        })
    }
}

private inline fun <T : Comparable<T>> print(what: String, array: Array<T>, func: (Array<T>) -> Unit) {
    println("$what ${measureTime { func(array) }}")
}