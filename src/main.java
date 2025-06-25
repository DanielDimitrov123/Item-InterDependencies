import java.util.ArrayList;
import java.util.Scanner;

public class main {
    ArrayList<Item> ItemStack = new ArrayList<>();
    ArrayList<String> ItemNameStack = new ArrayList<>();
    ArrayList<Integer> ItemHeap = new ArrayList<>();
    public main() {
        Scanner input = new Scanner(System.in);
        while(true){
            String ItemList = input.nextLine();
            if( ItemList.equals("\n")){
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
        }
        ItemHeap.clear();
    }
}