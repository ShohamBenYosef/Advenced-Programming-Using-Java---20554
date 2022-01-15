package com.company;
import java.util.ArrayList;

public class QueueThread extends Thread{

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

    public synchronized boolean running() {
        if(queue.get(0)==null)
            try {
                wait();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        return queue.get(queue.size()-1) != null && queue.get(queue.size()-1).length < max;
    }


    public int[] pop(int index){
        int[] arr = queue.get(index);
        queue.remove(index);
        return arr;
    }




}
