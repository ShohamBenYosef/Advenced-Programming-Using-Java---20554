package com.company;

public class MergeThread extends Thread{

    private int[] arr1;
    private int[] arr2;
    private int[] sortedArr;

    private QueueThread queue;

    public MergeThread(int[] arr1, int[] arr2, QueueThread q){
        System.out.println("6");
        this.arr1 = arr1;
        this.arr2 = arr2;
        this.queue = q;

        sortedArr = new int[arr1.length+arr2.length];
    }

    @Override
    public void run() {
        super.run();

        while (queue.canContinue()) {
            System.out.println("7 ");
            int i = 0, j = 0, s = 0;
            // i -> arr1, j -> arr2, s for sorted arr
            while (i < arr1.length && j < arr2.length) {
                if (arr1[i] < arr2[j])
                    sortedArr[s++] = arr1[i++];
                else
                    sortedArr[s++] = arr2[i++];
            }
            while (i < arr1.length) {
                sortedArr[s++] = arr1[i++];
            }
            while (j < arr2.length) {
                sortedArr[s++] = arr2[j++];
            }
            queue.push(sortedArr);
        }
    }
}
