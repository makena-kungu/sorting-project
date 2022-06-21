package testing_reliability;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

import static com.erickandedwin.HybridMergeSort.hybridSort;
import static testing_reliability.Util.*;

public class Test {
    private static final int SIZE = 100;

    private boolean testInts() {
        var a = generateInts(SIZE);
        hybridSort(a);
        return isSorted(a);
    }

    private boolean testLongs() {
        var a = generateLongs(SIZE);
        hybridSort(a);
        return isSorted(a);
    }

    private boolean testFloats() {
        var a = generateFloats(SIZE);
        hybridSort(a);
        return isSorted(a);
    }

    private boolean testDoubles() {
        var a = generateDoubles(SIZE);
        hybridSort(a);
        return isSorted(a);
    }

    private boolean testChars() {
        var a = generateChars(SIZE);
        hybridSort(a);
        return isSorted(a);
    }

    private boolean testGeneral() {
        var a = generatePeople(SIZE);
        hybridSort(a);
        Arrays.sort(a);
        return isSorted(a);
    }

    public static void main(String[] args) {
        Test test = new Test();
        Assertions.assertTrue(test.testChars());
        Assertions.assertTrue(test.testInts());
        Assertions.assertTrue(test.testLongs());
        Assertions.assertTrue(test.testFloats());
        Assertions.assertTrue(test.testDoubles());
        Assertions.assertTrue(test.testGeneral());

        var a = generatePeople(5);
        print(a);
        hybridSort(a);
        Arrays.sort(a);
        System.out.println("After sorting");
        print(a);
    }

    private static <T> void print(T @NotNull [] a) {
        System.out.println("[");
        for (T object : a) {
            System.out.println("\t"+object);
        }
        System.out.println("]");
    }
}
