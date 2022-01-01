package com.company;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.ArrayList;


public class AssociationTable<E extends Comparable<E>, T> extends TreeMap<E,T>{


    private TreeMap<E, T> map;


    // Constructor:
    public AssociationTable(){
        super();
    }

    public AssociationTable(ArrayList<E> key, ArrayList<E> val) {
        try {

        }catch (Exception e){

        }

    }

    public void add(E key, T val){
        if(this.containsKey(key))
            this.replace(key, val);
        this.put(key, val);
    }

    public T get(E key){
        if (map.containsKey(key))
            return (T) map.get(key);
        return null;
    }

    public Boolean contains(E key){
        if(map.containsKey(key))
            return true;
        return false;
    }


    public boolean remove(E key) {
        if (map.containsKey(key)){
            map.remove(key);
            return true;
        }
        return false;
    }

    public int size(){
        return super.size();
    }

    /*public Iterator keyIterator() {
        AssociationTable<E, T> map = new AssociationTable<>();
        for (Iterator<E> it = map.iterato)
    }*/
}

