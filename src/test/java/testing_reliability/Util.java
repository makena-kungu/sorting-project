package testing_reliability;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class Util {

    public static int @NotNull [] generateInts(int size) {
        return generateInts(size, false);
    }

    public static int @NotNull [] generateInts(int size, boolean seed) {
        int[] ints = new int[size];
        var rnd = seed ? new Random(98235) : new Random();
        for (int i = 0; i < size; i++) {
            ints[i] = rnd.nextInt(size);
        }
        return ints;
    }

    public static boolean isSorted(int @NotNull [] arr) {
        for (int i = 0, to = arr.length - 1; i < to; i++) {
            if (arr[i] > arr[i + 1]) return false;
        }
        return true;
    }

    public static long @NotNull [] generateLongs(int size) {
        long[] longs = new long[size];
        var rnd = new Random();
        for (int i = 0; i < size; i++) {
            longs[i] = rnd.nextLong(size);
        }
        return longs;
    }

    public static boolean isSorted(long @NotNull [] arr) {
        for (int i = 0, to = arr.length - 1; i < to; i++) {
            if (arr[i] > arr[i + 1]) return false;
        }
        return true;
    }

    public static float @NotNull [] generateFloats(int size) {
        var floats = new float[size];
        var rnd = new Random();
        for (int i = 0; i < size; i++) {
            floats[i] = rnd.nextFloat(size);
        }
        return floats;
    }

    public static boolean isSorted(float @NotNull [] arr) {
        for (int i = 0, to = arr.length - 1; i < to; i++) {
            if (arr[i] > arr[i + 1]) return false;
        }
        return true;
    }

    public static double @NotNull [] generateDoubles(int size) {
        double[] doubles = new double[size];
        var rnd = new Random();
        for (int i = 0; i < size; i++) {
            doubles[i] = rnd.nextDouble(size);
        }
        return doubles;
    }

    public static boolean isSorted(double @NotNull [] arr) {
        for (int i = 0, to = arr.length - 1; i < to; i++) {
            if (arr[i] > arr[i + 1]) return false;
        }
        return true;
    }

    public static char @NotNull [] generateChars(int size) {
        var chars = new char[size];
        var rnd = new Random();
        for (int i = 0; i < size; i++) {
            chars[i] = Character.highSurrogate(rnd.nextInt(65, 90));
        }
        return chars;
    }

    public static boolean isSorted(char @NotNull [] arr) {
        for (int i = 0, to = arr.length - 1; i < to; i++) {
            if (arr[i] > arr[i + 1]) return false;
        }
        return true;
    }

    public static Person @NotNull [] generatePeople(int size) {
        var people = new Person[size];
        var rnd = new Random();
        for (int i = 0; i < size; i++) {
            people[i] = new Person(
                    "Person " + rnd.nextInt(0, size >>> 1),
                    rnd.nextInt(0, 22),
                    rnd.nextFloat(0, 7.7F),
                    rnd.nextFloat(0, 150)
            );
        }
        return people;
    }

    @Contract(pure = true)
    public static <T extends Comparable<T>> boolean isSorted(T @NotNull [] arr) {
        for (int i = 0, to = arr.length - 1; i < to; i++) {

            if (arr[i].compareTo(arr[i + 1]) > 0) return false;
        }
        return true;
    }
}
