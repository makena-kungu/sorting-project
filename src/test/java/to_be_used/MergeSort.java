package to_be_used;

@SuppressWarnings("unused")
public class MergeSort {

    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int mid = (low + high) >> 1;

        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);

        merge(arr, low, mid, high);
    }

    public static void merge(int[] arr, int low, int m, int high) {
        int size1 = m - low + 1;
        int size2 = high - m;

        // copying the data
        int[] lower = new int[size1];
        int[] higher = new int[size2];

        System.arraycopy(arr, low, lower, 0, size1);
        System.arraycopy(arr, m + 1, higher, 0, size2);

        int i = 0, j = 0;

        int k = low;

        while (i < size1 && j < size2) {
            int l = lower[i];
            int r = higher[j];
            if (l <= r) {
                arr[k++] = l;
                i++;
            } else {
                arr[k++] = r;
                j++;
            }
        }

        //copying remaining elements

        if (i < k) System.arraycopy(lower, i, arr, k, size1 - i);
        if (j < k) System.arraycopy(higher, j, arr, k, size2 - j);
    }

}
