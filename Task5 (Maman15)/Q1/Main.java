package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final int MAX_VAL = 100;
        final int MIN_VAL = 1;

        Random random = new Random();
        Scanner scan = new Scanner(System.in);

        // get info from user
        System.out.println("Please enter size of array: ");
        int size = scan.nextInt();
        System.out.println("Please Enter num of threads: ");
        int num = scan.nextInt();

        System.out.println("size: " + size + " num: " + num);

        // initiate.
        int[] arr = new int[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(MAX_VAL) + MIN_VAL;
            System.out.print(arr[i]+"\t");
        }
        System.out.println("\n\n 1");
        // send array to mergeSort
        MergeSort mergeSort = new MergeSort(num, arr);
        mergeSort.runMerge();

        // print sorted arr
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"\t");
        }

    }

}
