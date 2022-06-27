package existing;

import org.jetbrains.annotations.NotNull;

import static com.erickandedwin.PairSort.pairSort;
import static java.util.Arrays.copyOfRange;

public class LegacyJava {
    public static void legacyMergeSort(Object[] a) {
        legacyMergeSort(a, 0, a.length);
    }

    public static void legacyMergeSort(Object[] a, int fromIndex, int toIndex) {
        Object[] aux = copyOfRange(a, fromIndex, toIndex);
        mergeSort(aux, a, fromIndex, toIndex, -fromIndex);
    }

    /**
     * Tuning parameter: list size at or below which insertion sort will be
     * used in preference to mergesort.
     * To be removed in a future release.
     */
    private static final int INSERTIONSORT_THRESHOLD = 32;

    /**
     * Src is the source array that starts at index 0
     * Dest is the (possibly larger) array destination with a possible offset
     * low is the index in dest to start sorting
     * high is the end index in dest to end sorting
     * off is the offset to generate corresponding low, high in src
     * To be removed in a future release.
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    private static void mergeSort(Object[] src,
                                  Object[] dest,
                                  int low,
                                  int high,
                                  int off) {
        int length = high - low;

        // Insertion sort on smallest arrays
        if (length <= INSERTIONSORT_THRESHOLD) {
            for (int i = low; i < high; i++)
                for (int j = i; j > low &&
                        ((Comparable) dest[j - 1]).compareTo(dest[j]) > 0; j--)
                    swap(dest, j, j - 1);
            return;
        }

        // Recursively sort halves of dest into src
        int destLow = low;
        int destHigh = high;
        low += off;
        high += off;
        int mid = (low + high) >>> 1;
        mergeSort(dest, src, low, mid, -off);
        mergeSort(dest, src, mid, high, -off);

        // If list is already sorted, just copy from src to dest.  This is an
        // optimization that results in faster sorts for nearly ordered lists.
        if (((Comparable) src[mid - 1]).compareTo(src[mid]) <= 0) {
            System.arraycopy(src, low, dest, destLow, length);
            return;
        }

        // Merge sorted halves (now in src) into dest
        for (int i = destLow, p = low, q = mid; i < destHigh; i++) {
            if (q >= high || p < mid && ((Comparable) src[p]).compareTo(src[q]) <= 0)
                dest[i] = src[p++];
            else
                dest[i] = src[q++];
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void pairSort(Object @NotNull [] arr, int start, int end) {
        if (arr.length < 2) return;

        int i = start;

        while (i <= end) {
            int j = start + (i++ % 2);
            while (j < end) {
                if (((Comparable) arr[j]).compareTo(arr[j + 1]) > 0) {
                    System.out.println("1st j = " + arr[j] + ", j+1 = " + arr[j + 1]);
                    Object temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    System.out.println("2nd j = " + arr[j] + ", j+1 = " + arr[j + 1]);
                }
                j += 2;
            }
        }
    }

    /**
     * Swaps x[a] with x[b].
     */
    private static void swap(Object @NotNull [] x, int a, int b) {
        Object t = x[a];
        x[a] = x[b];
        x[b] = t;
    }
}
