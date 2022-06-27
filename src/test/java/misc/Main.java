package misc;

import org.jetbrains.annotations.NotNull;

import static testing_reliability.Util.generatePeople;

public class Main {
    public static void lSort(Object[] dest) {

        for (int i = 0, high = dest.length; i < high; i++)
            for (int j = i; j > 0 &&
                    ((Comparable) dest[j - 1]).compareTo(dest[j]) > 0; j--)
                swap(dest, j, j - 1);
    }

    public static void sort(Object[] dest) {
        int low = 0;
        int high = dest.length;
        for (int i = low; i < high; i++) {
            for (int j = low + (i % 2); j < high - 1; j++) {
                Comparable temp = ((Comparable) dest[j]);
                if (temp.compareTo(dest[j + 1]) > 0) {
                    dest[j] = dest[j + 1];
                    dest[j + 1] = temp;
                }
            }
        }
    }

    private static void swap(Object @NotNull [] x, int a, int b) {
        Object t = x[a];
        x[a] = x[b];
        x[b] = t;
    }
}
