package to_be_used;

import org.jetbrains.annotations.NotNull;

public class GlobalResources {
    public static void swap(int @NotNull [] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
