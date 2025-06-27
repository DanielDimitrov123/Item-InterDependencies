package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main( String[] args) {
        ArrayList<Item> ItemStack = new ArrayList<>();
        ArrayList<String> ItemNameStack = new ArrayList<>();
        ArrayList<Integer> ItemHeap = new ArrayList<>();

        Scanner input = new Scanner(System.in);
        while(true){
            String ItemList = input.nextLine();
            if( ItemList.isBlank()){
                break;
            }
            String[] ItemNames = ItemList.split(" ");

            for (String itemName : ItemNames) {
                if( ItemNameStack.contains(itemName) == false){
                    Item newItem = new Item(itemName);
                    ItemStack.addLast( newItem);
                    ItemNameStack.addLast( itemName);
                }
                ItemHeap.addLast( ItemNameStack.indexOf( itemName));
            }

            Item leadingItem = ItemStack.get(ItemHeap.getFirst());
            for (Integer itemOrder : ItemHeap){
                Item Iterator = ItemStack.get( itemOrder);
                if( leadingItem.name.equals( Iterator.name) == false){
                    leadingItem.addDependencies( Iterator);
                    Iterator.addSupports( leadingItem);
                }
            }

            ItemHeap.clear();
        }

        for( Item Iterator : ItemStack){
            if( Iterator.dependencies.isTableEmpty() == false){
                ArrayList<Item> Dependencies = Iterator.getAllDependencies();
                printItemTree( Iterator, Dependencies);
            }
        }

        System.out.println();

        for( Item Iterator : ItemStack){
            if( Iterator.supports.isTableEmpty() == false){
                ArrayList<Item> Supports = Iterator.getAllSupports();
                printItemTree( Iterator, Supports);
            }
        }
    }

    public static void printItemTree( Item rootItem, ArrayList<Item> ItemTree){
        System.out.print( rootItem.name);
        for( Item Iterator : ItemTree){
            System.out.print( " " + Iterator.name );
        }
        System.out.println();
    }
}