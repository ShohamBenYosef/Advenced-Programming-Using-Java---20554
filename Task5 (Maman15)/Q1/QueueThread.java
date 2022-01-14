package com.company;
import java.util.ArrayList;

public class QueueThread {

    private ArrayList<int[]> queue;
    private int max;


    public QueueThread(int max){
        queue = new ArrayList<>();
    }

    public synchronized void push(int[] arr){
        queue.add(arr);
        notifyAll();
    }

    public synchronized int[] pop(){
        while (!queue.isEmpty()){
            try {
                wait();
            }catch (InterruptedException exception){
                exception.printStackTrace();
            }
        }
        return queue.get(1);
    }

    public synchronized boolean notEmpty(){
        while (!queue.isEmpty()){
            try {
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        if (!queue.isEmpty())
            return true;
        return false;
    }


    public int[] pop(int index){
        int[] arr = queue.get(index);
        queue.remove(index);
        return arr;
    }




}
