package com.erickandedwin.usecase;

import com.erickandedwin.HybridMergeSort;
import com.erickandedwin.PairSort;

import java.util.Arrays;
import java.util.Random;

public class TestKit {
    public static Bursary[] generateList(int size) {
        var grades = new String[]{"A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "E"};
        var bursary = new Bursary[size];
        var rnd = new Random();
        for (int i = 0; i < size; i++) {
            bursary[i] = new Bursary("Name" + rnd.nextInt((2*size)/3), "School" + rnd.nextInt((2*size)/3), grades[rnd.nextInt(0, 11)], rnd.nextDouble(0, 40000), rnd.nextBoolean()?"Orphan":"Not Orphan");

        }
        return bursary;

    }

    public static void main(String[] args) {
        var bursaries = generateList(50);
        System.out.println(Arrays.toString(bursaries));
        HybridMergeSort.hybridSort(bursaries);
        for (Bursary bursary : bursaries) {
            System.out.println(bursary+ " " + bursary.weightedMean());

        }



    }
}
