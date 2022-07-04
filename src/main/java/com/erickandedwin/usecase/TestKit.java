package com.erickandedwin.usecase;

import com.erickandedwin.PairSort;

import java.util.Random;

public class TestKit {
    public static Bursary[] generateList(int size){
        var bursary= new Bursary[size];
        var rnd= new Random();
        for (int i =0; i<size; i++ ){
            bursary[i]= new Bursary("Name" + i%3,"School"+ i%3,"Grade", rnd.nextDouble(0, 40000),"ParentStatus", );

        }
        return bursary;

    }
    public static void main(String[] args) {
        var Bursary = generateList(10);
        PairSort.pairSort(bursary);

        for (Bursary person:bursary){
            System.out.println(bursary);
        }

    }
}
