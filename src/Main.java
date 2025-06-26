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
            if( Iterator.dependencies.isEmpty() == false){
                ArrayList<Item> Dependencies = Iterator.getAllDependencies();
                System.out.print( Iterator.name);
                for( Item IteratorDependencies : Dependencies){
                    System.out.print( " " + IteratorDependencies.name );
                }
                System.out.println();
            }
        }

        System.out.println();

        for( Item Iterator : ItemStack){
            if( Iterator.supports.isEmpty() == false){
                ArrayList<Item> Supports = Iterator.getAllSupports();
                System.out.print( Iterator.name);
                for( Item IteratorSupports : Supports){
                    System.out.print( " " + IteratorSupports.name );
                }
                System.out.println();
            }
        }
    }
}