package main;

import main.ItemStack;

import java.util.ArrayList;

public class Item {
    String name;
    ItemStack dependencies;
    ItemStack supports;

    public Item(String newName) {
        addName( newName);
        this.dependencies = new ItemStack();
        this.supports = new ItemStack();
    }

    public Item(String newName, ArrayList<Item> newDependencies, ArrayList<Item> newSupports) {
        addName( newName);
        addDependencies( newDependencies);
        addSupports( newSupports);
    }

    public void addName( String newName){
        this.name = newName;
    }

    public void addDependencies( Item newDependencies){
        this.dependencies.addNoRepeating( newDependencies);
    }

    public void addDependencies( ArrayList<Item> newDependencies){
        this.dependencies.addNoRepeatingArrayList(newDependencies);
    }

    public void addSupports( Item newSupports){
        this.supports.addNoRepeating(newSupports);
    }

    public void addSupports( ArrayList<Item> newSupports){
        this.supports.addNoRepeatingArrayList(newSupports);
    }

    public ArrayList<Item> getAllDependencies(){
        ItemStack Heap = new ItemStack();
        Heap.addNoRepeatingItemStack(this.dependencies);
        int num = 0;
        Item heapIterator;
        while( num < Heap.getTableSize()){
            heapIterator = Heap.getItem(num);
            if( heapIterator.equals( this) == false) {
                Heap.addNoRepeatingItemStack(heapIterator.dependencies);
            }
            num++;
        }
        return Heap.Table;
    }

    public ArrayList<Item> getAllSupports(){
        ItemStack Heap = new ItemStack();
        Heap.addNoRepeatingItemStack( this.supports);
        int num = 0;
        Item heapIterator;
        while( num < Heap.getTableSize()){
            heapIterator = Heap.getItem(num);
            if( heapIterator.equals( this) == false){
                Heap.addNoRepeatingItemStack( heapIterator.supports);
            }
            num++;
        }
        return Heap.Table;
    }
}