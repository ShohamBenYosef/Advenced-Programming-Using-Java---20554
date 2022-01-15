package com.company;



public class MergeSort{

    private int threadsNum;
    private QueueThread queue;

    public MergeSort(int threadsNum, int[] arr){
        System.out.println("2");
        this.threadsNum = threadsNum;
        queue = new QueueThread(arr.length);

        if(arr != null) {
            for (int i = 0; i < arr.length; i++) {
                int[] temp = new int[1];
                temp[0] = arr[i];
                System.out.println("3");
                this.queue.push(temp);
            }
        }
    }

    public int[] runMerge(){
        System.out.println("4");
        while(queue.canContinue()){
            System.out.println("5");
            new MergeThread(this.queue.pop(), this.queue.pop(), this.queue).start();

        }
        return queue.pop();
    }








}
