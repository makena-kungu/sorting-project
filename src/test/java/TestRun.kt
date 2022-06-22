import com.erickandedwin.HybridMergeSort.hybridSort
import testing_reliability.Util.generateInts
import to_be_used.MergeSort.mergeSort
import java.util.Arrays.sort
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

private const val SIZE = 10000000

@OptIn(ExperimentalTime::class)
fun main() {

    val arr = generateInts(SIZE)
    val clone = arr.clone()
    val clone2 = arr.clone()
    //val clone3 = arr.clone()
    val clone4 = arr.clone()

    //val pairSort = measureTime { pairSort(clone3) }
    val timeMerge = measureTime { mergeSort(clone) }
    val de = measureTime { sort(clone2) }
    val timeHybrid = measureTime { hybridSort(clone4) }

    println("merge time = $timeMerge")
//    println("pair time  = $pairSort")
    println("de time    = $de")
    println("hybrid time = $timeHybrid")
}