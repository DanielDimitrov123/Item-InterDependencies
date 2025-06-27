import java.util.ArrayList;

public class ItemStack {
  ArrayList<Item> Table;

  public ItemStack(){
    this.Table = new ArrayList<>();
  }

  public ItemStack( ArrayList<Item> newTable){
    new ItemStack();
    for( Item Iterator : newTable){
      addNoRepeating( Iterator);
    }
  }

  public ItemStack( ItemStack newTable){
    ArrayList<Item> newStackToArray = newTable.Table;
    new ItemStack( newStackToArray);
  }

  public void addNoRepeatingArrayList( ArrayList<Item> newStack){
    for( Item Iterator : newStack) {
      addNoRepeating(Iterator);
    }
  }

  public void addNoRepeatingItemStack( ItemStack newStack){
    ArrayList<Item> newStackToArray = newStack.Table;
    addNoRepeatingArrayList( newStackToArray);
  }

  public void addNoRepeating( Item newItem){
    if( this.Table.contains( newItem) == false){
      this.Table.addLast( newItem);
    }
  }

  public boolean isTableEmpty(){
    return this.Table.isEmpty();
  }

  public int getTableSize(){
    return this.Table.size();
  }

  public Item getItem( int index){
    return this.Table.get( index);
  }
}
