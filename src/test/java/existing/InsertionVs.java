package existing;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static testing_reliability.Util.generatePeople;

@SuppressWarnings({"unchecked", "rawtypes", "SameParameterValue"})
public class InsertionVs {

    private static void sort1(Object[] dest, int low, int high) {
        for (int i = low; i < high; i++)
            for (int j = i; j > low &&
                    ((Comparable) dest[j - 1]).compareTo(dest[j]) > 0; j--)
                swap(dest, j, j - 1);
    }

    private static void sort2(Object[] arr, int start, int end) {
        int i = 0;
        while (i <= end) {
            int j = start + (i++ % 2);
            while (j < end) {
                if (((Comparable<Object>) arr[j]).compareTo(arr[j + 1]) > 0)
                    swap(arr, j, j + 1);
                j += 2;
            }
        }
    }

    private static void swap(Object[] x, int a, int b) {
        Object t = x[a];
        x[a] = x[b];
        x[b] = t;
    }

    public static void main(String[] args) throws InterruptedException {
        var arr = generatePeople(10);
        var service = Executors.newFixedThreadPool(2);
        service.submit(() -> exec("insertion  ", arr.clone(), array -> {
            sort1(array, 0, array.length);
            return null;
        }));
        service.submit(() -> exec("pair       ", arr.clone(), array -> {
            sort2(array, 0, array.length - 1);
            return null;
        }));
        service.shutdown();
        var s = service.awaitTermination(5, TimeUnit.MINUTES);
        System.out.println(s ? "Terminated" : "Timeout");
        System.exit(0);
    }

    private static <T extends Comparable> void exec(String what, T[] arr, @NotNull Function<T[], Integer> function) {
        long start = System.nanoTime();
        function.apply(arr);
        long duration = System.nanoTime() - start;
        System.out.println("duration " + what + " = " + duration);
    }
}
