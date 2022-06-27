package com.erickandedwin;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

@SuppressWarnings({"DuplicatedCode", "unused", "unchecked"})
public class PairSort {

    public static void pairSort(int[] arr) {
        pairSort(arr, 0, arr.length - 1);
    }

    public static void pairSort(int @NotNull [] arr, int start, int end) {
        int length = (end - start) + 1;
        if (length < 2) {
            //it's already sorted
            return;
        }

        // [2, 4, 3, 56, 32]

        int i = start;

        while (i <= end) {
            // we either start from 0th index or the 1th index
            // int j = i++%2 +start;
            int j = start + (i++ % 2);//gives either 0 or 1 if start is 0
            while (j < end) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

                j += 2;
            }
        }
    }

    public static void pairSort(long @NotNull [] arr) {
        pairSort(arr, 0, arr.length - 1);
    }

    public static void pairSort(long[] arr, int start, int end) {
        int length = (end - start) + 1;
        if (length < 2) return;

        int i = start;
        //[2 , 4 ,5 , 4, 6

        while (i <= end) {
            int j = start + i++ % 2;

            while (j < end) {
                if (arr[j] > arr[j + 1]) {
                    var temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

                j += 2;
            }
        }

    }

    public static void pairSort(char[] arr) {
        pairSort(arr, 0, arr.length - 1);

    }

    public static void pairSort(char[] arr, int start, int end) {
        int length = (end - start) + 1;
        if (length < 2) return;

        int i = start;
        //[2 , 4 ,5 , 4, 6

        while (i <= end) {
            int j = start + i++ % 2;

            while (j < end) {
                if (arr[j] > arr[j + 1]) {
                    var temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

                j += 2;
            }
        }

    }

    public static void pairSort(float[] arr) {
        pairSort(arr, 0, arr.length - 1);
    }

    public static void pairSort(float[] arr, int start, int end) {
        int length = (end - start) + 1;
        if (length < 2) return;

        int i = start;

        while (i <= end) {
            int j = start + i++ % 2;

            while (j < end) {
                if (arr[j] > arr[j + 1]) {
                    var temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

                j += 2;
            }
        }
    }

    public static void pairSort(double[] arr) {
        pairSort(arr, 0, arr.length - 1);
    }

    public static void pairSort(double @NotNull [] arr, int start, int end) {
        int length = (end - start) + 1;
        if (length < 2) {
            return;
        }

        int i = start;

        while (i <= end) {
            int j = start + i++ % 2;

            while (j < end) {
                if (arr[j] > arr[j + 1]) {
                    var temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

                j += 2;
            }
        }
    }

    public static <T> void pairSort(T[] arr, Comparator<T> comparator) {
        pairSort(arr, comparator, 0, arr.length - 1);
    }

    public static <T> void pairSort(T[] arr, Comparator<T> comparator, int start, int end) {
        int length = (end - start) + 1;
        if (length < 2) return;

        int i = start;

        while (i <= end) {
            int j = start + i++ % 2;

            while (j < end) {
                if (comparator.compare(arr[j], arr[j + 1]) > 0) {
                    var temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                j += 2;
            }
        }
    }

    public static void pairSort(Object[] arr) {
        pairSort(arr, 0, arr.length - 1);
    }

    @SuppressWarnings("rawtypes")
    public static void pairSort(Object[] arr, int start, int end) {
        int length = end - start + 1;
        if (length < 2) return;

        int i = start;

        while (i <= end) {
            int j = start + (i++ % 2);
            while (j < end) {
                if (((Comparable) arr[j]).compareTo(arr[j + 1]) > 0) {
                    Object temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                j += 2;
            }
        }
    }
}
