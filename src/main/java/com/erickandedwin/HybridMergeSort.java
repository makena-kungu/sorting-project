package com.erickandedwin;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

import static com.erickandedwin.PairSort.pairSort;

@SuppressWarnings({"DuplicatedCode", "unused", "unchecked", "rawtypes"})
public class HybridMergeSort {

    private static final int PAIRING_THRESHOLD = 32;

    public static void hybridSort(int @NotNull [] arr) {
        hybridSort(arr, 0, arr.length - 1);
    }

    public static void hybridSort(int @NotNull [] arr, int fromIndex, int toIndex) {
        int length = toIndex - fromIndex + 1;
        if (length < 2) return;

        if (length <= PAIRING_THRESHOLD) {
            pairSort(arr, fromIndex, toIndex);
            return;
        }

        //say we have an array of size 10
        // midIndex = 4
        int midIndex = (fromIndex + toIndex) >>> 1;//(fromIndex + toIndex) / 2;
        hybridSort(arr, fromIndex, midIndex);
        hybridSort(arr, midIndex + 1, toIndex);

        hybridMerge(arr, fromIndex, midIndex, toIndex);
    }

    public static void hybridSortM(int @NotNull [] arr) {
        hybridSortM(arr, 0, arr.length - 1);
    }

    public static void hybridSortM(int @NotNull [] arr, int fromIndex, int toIndex) {
        int length = toIndex - fromIndex + 1;
        if (length < 2) return;

        if (length <= PAIRING_THRESHOLD) {
            pairSort(arr, fromIndex, toIndex);
            return;
        }

        // finding the middle index by finding sort of tne mean between the from and to indices.
        // i.e. total = fromIndex + toIndex
        //      middle index = total / 2
        // we'll use the bitshift operation as its more effective and reliable compared to raw division that may produce
        // unprecedented values for larger integers.
        int midIndex = (fromIndex + toIndex) >>> 1;//(fromIndex + toIndex) / 2;
        hybridSortM(arr, fromIndex, midIndex);
        hybridSortM(arr, midIndex + 1, toIndex);

        hybridMergeModified(arr, fromIndex, midIndex, toIndex);
    }

    private static void hybridMerge(int @NotNull [] arr, int fromIndex, int midIndex, int toIndex) {
        int sizeLeft = midIndex - fromIndex + 1;
        int sizeRight = toIndex - midIndex;

        // copying the data
        int[] left = new int[sizeLeft];
        int[] right = new int[sizeRight];

        System.arraycopy(arr, fromIndex, left, 0, sizeLeft);
        System.arraycopy(arr, midIndex + 1, right, 0, sizeRight);

        int i = 0, j = 0, k = fromIndex;

        while (i < sizeLeft && j < sizeRight) {
            int l = left[i];
            int r = right[j];
            if (l <= r) {
                arr[k++] = l;
                i++;
            } else {
                arr[k++] = r;
                j++;
            }
        }

        //copying remaining elements

        if (i < sizeLeft) System.arraycopy(left, i, arr, k, sizeLeft - i);
        if (j < sizeRight) System.arraycopy(right, j, arr, k, sizeRight - j);
    }

    private static void hybridMergeModified(int @NotNull [] arr, int fromIndex, int midIndex, int toIndex) {
        int sizeLeft = midIndex - fromIndex + 1;
        int sizeRight = toIndex - midIndex;

        // copying the data
        int[] right = new int[sizeRight];

        int i = fromIndex + sizeRight, j = 0, k = fromIndex;
        System.arraycopy(arr, midIndex + 1, right, 0, sizeRight);
        System.arraycopy(arr, fromIndex, arr, i, sizeLeft);

        while (i < toIndex && j < sizeRight) {
            int l = arr[i];
            int r = right[j];
            if (l <= r) {
                arr[k++] = l;
                i++;
            } else {
                arr[k++] = r;
                j++;
            }
        }
    }

    public static void hybridSort(long @NotNull [] arr) {
        hybridSort(arr, 0, arr.length - 1);
    }

    public static void hybridSort(long @NotNull [] arr, int fromIndex, int toIndex) {
        int length = toIndex - fromIndex + 1;
        if (length < 2) return;

        if (length <= PAIRING_THRESHOLD) {
            pairSort(arr, fromIndex, toIndex);
            return;
        }

        //say we have an array of size 10
        // midIndex = 4
        int midIndex = (fromIndex + toIndex) >>> 1;//(fromIndex + toIndex) / 2;
        hybridSort(arr, fromIndex, midIndex);
        hybridSort(arr, midIndex + 1, toIndex);

        hybridMerge(arr, fromIndex, midIndex, toIndex);
    }

    private static void hybridMerge(long @NotNull [] arr, int fromIndex, int midIndex, int toIndex) {
        int sizeLeft = midIndex - fromIndex + 1;
        int sizeRight = toIndex - midIndex;

        // copying the data
        long[] left = new long[sizeLeft];
        long[] right = new long[sizeRight];

        System.arraycopy(arr, fromIndex, left, 0, sizeLeft);
        System.arraycopy(arr, midIndex + 1, right, 0, sizeRight);

        int i = 0, j = 0, k = fromIndex;

        while (i < sizeLeft && j < sizeRight) {
            long l = left[i];
            long r = right[j];
            if (l <= r) {
                arr[k++] = l;
                i++;
            } else {
                arr[k++] = r;
                j++;
            }
        }

        //copying remaining elements

        if (i < sizeLeft) System.arraycopy(left, i, arr, k, sizeLeft - i);
        if (j < sizeRight) System.arraycopy(right, j, arr, k, sizeRight - j);
    }


    public static void hybridSort(float @NotNull [] arr) {
        hybridSort(arr, 0, arr.length - 1);
    }

    public static void hybridSort(float @NotNull [] arr, int fromIndex, int toIndex) {
        int length = toIndex - fromIndex + 1;
        if (length < 2) return;

        if (length <= PAIRING_THRESHOLD) {
            pairSort(arr, fromIndex, toIndex);
            return;
        }

        int midIndex = (fromIndex + toIndex) >>> 1;
        hybridSort(arr, fromIndex, midIndex);
        hybridSort(arr, midIndex + 1, toIndex);

        hybridMerge(arr, fromIndex, midIndex, toIndex);
    }

    private static void hybridMerge(float @NotNull [] arr, int fromIndex, int midIndex, int toIndex) {
        int sizeLeft = (midIndex + 1) - fromIndex;
        int sizeRight = toIndex - midIndex;

        //copying the data from array
        float[] left = new float[sizeLeft];
        float[] right = new float[sizeRight];


        System.arraycopy(arr, fromIndex, left, 0, sizeLeft);
        System.arraycopy(arr, midIndex + 1, right, 0, sizeRight);

        int i = 0, j = 0, k = fromIndex;

        while (i < sizeLeft && j < sizeRight) {
            float l = left[i];
            float r = right[j];
            if (l <= r) {
                arr[k++] = l;
                i++;
            } else {
                arr[k++] = r;
                j++;
            }
        }

        if (i < sizeLeft) System.arraycopy(left, i, arr, k, sizeLeft - i);
        if (j < sizeRight) System.arraycopy(right, j, arr, k, sizeRight - j);
    }

    public static void hybridSort(double @NotNull [] arr) {
        hybridSort(arr, 0, arr.length - 1);
    }

    public static void hybridSort(double @NotNull [] arr, int fromIndex, int toIndex) {
        int length = toIndex - fromIndex + 1;
        if (length < 2) return;

        if (length <= PAIRING_THRESHOLD) {
            pairSort(arr, fromIndex, toIndex);
            return;
        }

        int midIndex = (fromIndex + toIndex) >>> 1;
        hybridSort(arr, fromIndex, midIndex);
        hybridSort(arr, midIndex + 1, toIndex);

        hybridMerge(arr, fromIndex, midIndex, toIndex);
    }

    private static void hybridMerge(double @NotNull [] arr, int fromIndex, int midIndex, int toIndex) {
        int sizeLeft = (midIndex + 1) - fromIndex;
        int sizeRight = toIndex - midIndex;

        //copying the data from array
        double[] left = new double[sizeLeft];
        double[] right = new double[sizeRight];


        System.arraycopy(arr, fromIndex, left, 0, sizeLeft);
        System.arraycopy(arr, midIndex + 1, right, 0, sizeRight);

        int i = 0, j = 0, k = fromIndex;

        while (i < sizeLeft && j < sizeRight) {
            double l = left[i];
            double r = right[j];
            if (l <= r) {
                arr[k++] = l;
                i++;
            } else {
                arr[k++] = r;
                j++;
            }
        }

        if (i < sizeLeft) System.arraycopy(left, i, arr, k, sizeLeft - i);
        if (j < sizeRight) System.arraycopy(right, j, arr, k, sizeRight - j);
    }

    public static void hybridSort(char @NotNull [] arr) {
        hybridSort(arr, 0, arr.length - 1);
    }

    public static void hybridSort(char @NotNull [] arr, int fromIndex, int toIndex) {
        int length = toIndex - fromIndex + 1;
        if (length < 2) return;

        if (length <= PAIRING_THRESHOLD) {
            pairSort(arr, fromIndex, toIndex);
            return;
        }

        int midIndex = (fromIndex + toIndex) >>> 1;
        hybridSort(arr, fromIndex, midIndex);
        hybridSort(arr, midIndex + 1, toIndex);

        hybridMerge(arr, fromIndex, midIndex, toIndex);
    }

    private static void hybridMerge(char @NotNull [] arr, int fromIndex, int midIndex, int toIndex) {
        int sizeLeft = (midIndex + 1) - fromIndex;
        int sizeRight = toIndex - midIndex;

        //copying the data from array  and saving for later use
        char[] left = new char[sizeLeft];
        char[] right = new char[sizeRight];

        System.arraycopy(arr, fromIndex, left, 0, sizeLeft);
        System.arraycopy(arr, midIndex + 1, right, 0, sizeRight);

        int i = 0, j = 0, k = fromIndex;

        while (i < sizeLeft && j < sizeRight) {
            char l = left[i];
            char r = right[j];
            if (l <= r) {
                arr[k++] = l;
                i++;
            } else {
                arr[k++] = r;
                j++;
            }
        }

        if (i < sizeLeft) System.arraycopy(left, i, arr, k, sizeLeft - i);
        if (j < sizeRight) System.arraycopy(right, j, arr, k, sizeRight - j);
    }

    /**
     * @see HybridMergeSort#hybridSort(Object[], Object[], int, int)
     */
    public static void hybridSort(Object[] arr) {
        Object[] aux = Arrays.copyOfRange(arr, 0, arr.length);
        hybridSort(aux, arr, 0, arr.length, -0);
    }

    /**
     * Sorts the specified range of the specified array in ascending order using {@linkplain Comparable natural ordering}
     * of its elements. The range to be sorted is specified by {@code fromIndex}, inclusive to {@code endIndex},
     * exclusive. All elements in this range must implement the {@linkplain Comparable} interface, otherwise a
     * {@linkplain ClassCastException} will be thrown. The sort is stable meaning the order of equal elements does not
     * change.
     *
     * @param src       a copy of the array that will be used in holding the items temporarily before insertion into the
     *                  {@code dest}.
     * @param dest      the array to be sorted
     * @param fromIndex the index of the first element (inclusive) to be sorted.
     * @param toIndex   the index of the last element (inclusive) to be sorted.
     * @throws ClassCastException             if the array contains elements that cannot be compared.
     * @throws ArrayIndexOutOfBoundsException if {@code fromIndex < 0 or toIndex >= dest.length}
     */
    public static void hybridSort(Object[] src, Object @NotNull [] dest, int fromIndex, int toIndex) {
        int length = toIndex - fromIndex + 1;
        if (length < 2) return;

        if (length <= PAIRING_THRESHOLD) {
            pairSort(dest, fromIndex, toIndex);
            return;
        }

        int midIndex = (fromIndex + toIndex) >>> 1;
        hybridSort(src, dest, fromIndex, midIndex);
        hybridSort(src, dest, midIndex + 1, toIndex);

        // if the list is already sorted, just insert the two
        if (((Comparable) src[midIndex]).compareTo(src[midIndex + 1]) <= 0) {
            System.arraycopy(src, fromIndex, dest, fromIndex, length);
            return;
        }

        // Merge sorted halves (now in src) into dest
        int i = fromIndex, j = fromIndex, k = midIndex, high = toIndex + 1;
        for (; i < high; i++) {
            if (k >= high || j < midIndex && ((Comparable) src[j]).compareTo(src[k]) <= 0)
                dest[i] = src[j++];
            else
                dest[i] = src[k++];
        }
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static void hybridSort(Object[] src,
                                  Object[] dest,
                                  int low,
                                  int high,
                                  int off) {
        int length = high - low;

        // Insertion sort on smallest arrays
        if (length <= PAIRING_THRESHOLD) {
            for (int i = low; i < high; i++) {
                for (int j = low + (i % 2); j < high - 1; j++) {
                    Comparable temp = ((Comparable) dest[j]);
                    if (temp.compareTo(dest[j + 1]) > 0) {
                        swap(dest, j, j + 1);
                    }
                }
            }
            return;
        }

        // Recursively sort halves of dest into src
        int destLow = low;
        int destHigh = high;
        low += off;
        high += off;
        int mid = (low + high) >>> 1;
        hybridSort(dest, src, low, mid, -off);
        hybridSort(dest, src, mid, high, -off);

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

    private static void swap(Object @NotNull [] x, int a, int b) {
        Object t = x[a];
        x[a] = x[b];
        x[b] = t;
    }

    @Contract(pure = true)
    private static boolean sorted(Object @NotNull [] arr) {
        for (int i = 0, length = arr.length - 1; i < length; i++) {
            //noinspection rawtypes
            Comparable obj = ((Comparable) arr[i]);
            if (obj.compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    private static void hybridMerge(Object @NotNull [] arr, int fromIndex, int midIndex, int toIndex) {
        int sizeLeft = (midIndex + 1) - fromIndex;
        int sizeRight = toIndex - midIndex;

        //copying the data from array  and saving for later use
        Object[] left = new Object[sizeLeft];
        Object[] right = new Object[sizeRight];

        System.arraycopy(arr, fromIndex, left, 0, sizeLeft);
        System.arraycopy(arr, midIndex + 1, right, 0, sizeRight);

        int i = 0, j = 0, k = fromIndex;

        while (i < sizeLeft && j < sizeRight) {
            var l = ((Comparable) left[i]);
            var r = ((Comparable) right[j]);
            if (l.compareTo(r) <= 0) {
                arr[k++] = l;
                i++;
            } else {
                arr[k++] = r;
                j++;
            }
        }

        if (i < sizeLeft) System.arraycopy(left, i, arr, k, sizeLeft - i);
        if (j < sizeRight) System.arraycopy(right, j, arr, k, sizeRight - j);
    }
}
