import java.util.ArrayList;

public class Item {
    String name;
    ArrayList<Item> dependencies;
    ArrayList<Item> supports;

    public Item(String newName) {
        addName( newName);
        this.dependencies = new ArrayList<>();
        this.supports = new ArrayList<>();
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
        this.dependencies.addLast(newDependencies);
    }

    public void addDependencies( ArrayList<Item> newDependencies){
        this.dependencies.addAll(newDependencies);
    }

    public void addSupports( Item newSupports){
        this.supports.addLast(newSupports);
    }

    public void addSupports( ArrayList<Item> newSupports){
        this.supports.addAll(newSupports);
    }

    public ArrayList<Item> getAllDependencies(){
        ArrayList<Item> Heap = new ArrayList<>(this.dependencies);
        for( Item heapIterator : Heap){
            for( Item dependencyIterator : heapIterator.dependencies) {
                if( Heap.contains( dependencyIterator) == false){
                    Heap.add( dependencyIterator);
                }
            }
        }
        return Heap;
    }
}