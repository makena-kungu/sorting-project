package com.erickandedwin;

import org.jetbrains.annotations.NotNull;

public class ModifiedInsertionSort {

    public static void modifiedInsertionSort(int[] arr) {
        modifiedInsertionSort(arr, 0, arr.length - 1);
    }

    public static void modifiedInsertionSort(int @NotNull [] arr, int start, int end) {
        int len = end - start + 1;
        if (len < 2) return; // an array of length less than two is already sorted

        var temp = arr.clone();
        int i = start + 1;
        while (i < len) {
            insert(arr, temp[i], i - 1);
            i++;
        }
    }

    private static int index(int @NotNull [] arr, int element, int first, int last) {

        int max = arr[last];
        if (element >= max) {
            return -1;
        }

        int min = arr[first];
        if (element <= min) {

            if (element == min) {
                return first + 1;
            }
            return first;
        }

        int pivot = (first + last) >> 1;
        int mid = arr[pivot];

        int len = last - first + 1;
        if (len <= 2) {
            return last;
        }

        if (element < mid) {
            return index(arr, element, first, pivot);
        } else if (element > mid) {
            return index(arr, element, pivot, last);
        } else {
            return pivot;
        }
    }

    private static void insert(int[] arr, int element, int lastInserted) {
        int i = index(arr, element, 0, lastInserted);
        if (i < 0) return;

        while (i <= lastInserted + 1) {
            int temp = arr[i];
            arr[i] = element;
            element = temp;
            i++;
        }
    }

}
