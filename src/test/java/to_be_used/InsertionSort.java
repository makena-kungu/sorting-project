package to_be_used;

import org.jetbrains.annotations.NotNull;

import static existing.GlobalKt.swap;

public class InsertionSort {

    public static void insertionSort(int[] arr) {
        insertionSort(arr, 0, arr.length - 1);
    }


    public static void insertionSort(int @NotNull [] arr, int start, int end) {
        if (arr.length < 2) return;

        int i = 0;
        int len = arr.length;
        while (i < len) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                swap(arr, j, j - 1);
                j--;
            }
            i++;
        }
    }
}
