package com.company;


import java.util.concurrent.ExecutorService;

public class MergeSort extends Thread{

    private int threadsNum;
    private QueueThread queue;

    public MergeSort(int threadsNum, int[] arr){
        this.threadsNum = threadsNum;

        if(arr != null) {
            for (int i = 0; i < arr.length; i++) {
                int[] temp = new int[1];
                temp[0] = arr[i];
                queue.push(temp);
            }
        }
    }


    public int[] applay(){

        int i = 0, j = i+1;
        while (queue.notEmpty())
            //MergeThread mergeThread = new MergeThread(queue.pop(i), queue.pop(j), queue);
    }





}
