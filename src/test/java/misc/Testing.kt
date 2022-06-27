@file:OptIn(ExperimentalTime::class)

package misc

import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking
import misc.Main.lSort
import misc.Main.sort
import testing_reliability.Person
import testing_reliability.Util.generatePeople
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

fun main() {

    val people = generatePeople(32)
    runBlocking {
        awaitAll(
            async {
                outputTime("legacy",people) { lSort(it) }
            },
            async {
                outputTime("pair  ",people) { sort(it) }
            }
        )
    }
}

fun outputTime(what: String, people: Array<Person>, block: (Array<Person>) -> Unit) {
    val arr = people.clone()
    val time = measureTime { block(arr) }
    println("$what = $time")
    //println(arr.joinToString("\n"))
}