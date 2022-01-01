package com.company;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.ArrayList;


public class AssociationTable<E extends Comparable<E>, T> extends TreeMap<E,T>{


    private TreeMap<E, T> map;


    //Default Constructor
    public AssociationTable(){
        super();
    }
    // Constructor
    public AssociationTable(ArrayList<E> key, ArrayList<T> val) throws IllegalArgumentException{
        map = new TreeMap<E, T>();

        // edge case (too many keys or values):
        if(key.size() != val.size())
            throw new IllegalArgumentException("Size arnt the same.");

        for(int i=0; i<key.size(); i++){
            map.put(key.get(i), val.get(i));
        }
    }

    //Add node to treeMap
    public void add(E key, T val){
        if(this.containsKey(key)) // check if alredy exist.
            this.replace(key, val);
        this.put(key, val);
    }
    // return node with given key
    public T get(E key){
        if (map.containsKey(key)) //check if the treeMap contain the node
            return (T) map.get(key);
        return null;
    }
    // //check if the treeMap contain the node with 'key' key
    public Boolean contains(E key){
        if(map.containsKey(key))
            return true;
        return false;
    }

    // remove given node from the treeMap
    public boolean remove(E key) {
        if (map.containsKey(key)){
            map.remove(key);
            return true;
        }
        return false;
    }

    // return the size of the treeMap (int)
    public int size(){
        return super.size();
    }

    // iterator
    public Iterator keyIterator() {
        return this.map.keySet().iterator();
    }
}

