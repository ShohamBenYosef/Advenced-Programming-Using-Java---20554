import java.util.Iterator;
import java.util.TreeMap;

public class AssociationTable<E extends Comparable<E>, T> extends TreeMap<E,T>{


    private TreeMap<E, T> map;


    //Default Constructor
    public AssociationTable(){
        super(); // from TreeMap.
    }
    // Constructor
    public AssociationTable(E[] key, T[] val) throws IllegalArgumentException{
        super(); // from TreeMap.
        map = new TreeMap<E, T>();
        // edge case (too many keys or values):
        if(key.length != val.length)
            throw new IllegalArgumentException("Size arnt the same.");

        for(int i=0; i<key.length; i++){
            //System.out.println("put i = " + i);
            map.put(key[i], val[i]);
        }
    }
    //Add node to treeMap
    public void add(E key, T val) {
        if (this.containsKey(key)){ // check if alredy exist.
            this.replace(key, val);
        }
        System.out.println("3");
        this.put(key,val);
    }
    // return node with given key
    public T get(E key) {
        if (map.containsKey(key)){ //check if the treeMap contain the node
            System.out.println("*");
            return map.get(key);
        }
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

