@file:OptIn(ExperimentalTime::class)

package time_analysis

import com.erickandedwin.HybridMergeSort.hybridSort
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.xssf.usermodel.XSSFFont
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import testing_reliability.Util.generateInts
import to_be_used.MergeSort.mergeSort
import java.io.FileOutputStream
import kotlin.math.pow
import kotlin.math.roundToLong
import kotlin.system.measureNanoTime
import kotlin.time.Duration.Companion.nanoseconds
import kotlin.time.ExperimentalTime


fun main() {
    createWorkBook {
        val dataSet = (2..6).map { 10.0.pow(it).toInt() }
        dataSet.forEach { sampleSize ->
            val sheet = createSheet(sampleSize.toString())
            val headers = arrayOf("Run", "Merge", "Hybrid")
            val headerRow = sheet.createRow(0)
            headers.forEachIndexed { index, s ->
                headerRow.createCell(index).run {
                    setCellValue(s)
                    val style = cellStyle
                    val font = XSSFFont()
                    font.bold = true
                    style.setFont(font)
                    cellStyle = style
                }
            }

            val merge = mutableListOf<Long>()
            val hybrid = mutableListOf<Long>()
            (1..10).forEach {
                val row = sheet.createRow(it)
                val arr = generateInts(sampleSize)

                row.createCell(0).setCellValue(it.toString())
                runBlocking {
                    awaitAll(
                        async {
                            row.createCell(1).run {
                                val time = measureNanoTime { mergeSort(arr) }
                                merge += time
                                setCellValue(time.nanoseconds.toString())
                            }
                        },async {
                            row.createCell(2).run {
                                val time = measureNanoTime { hybridSort(arr) }
                                hybrid += time
                                setCellValue(time.nanoseconds.toString())
                            }
                        }
                    )
                }
            }

            val averageRow = sheet.createRow(11)
            averageRow.createCell(0).run {
                setCellValue("Average")
            }
            averageRow.createCell(1).run {
                val average = merge.average().roundToLong().nanoseconds
                setCellValue(average.toString())
            }
            averageRow.createCell(2).run {
                val average = hybrid.average().roundToLong().nanoseconds
                setCellValue(average.toString())
            }
        }
    }
}

fun createWorkBook(block: Workbook.() -> Unit) {
    val workbook = XSSFWorkbook()

    workbook.block()
    FileOutputStream("analysis.xlsx").use { fileOut -> workbook.write(fileOut) }
}