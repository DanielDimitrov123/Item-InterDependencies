import java.util.ArrayList;

public class Item {
    String name;
    ArrayList<Item> dependencies;
    ArrayList<Item> supports;

    public Item(String newName) {
        this.name = newName;
        this.dependencies = new ArrayList<Item>();
        this.supports = new ArrayList<Item>();
    }
    public Item(String newName, ArrayList<Item> newDependencies, ArrayList<Item> newSupports) {
        this.name = newName;
        assert newDependencies != null;
        this.dependencies.addAll(newDependencies);
        assert newSupports != null;
        this.supports.addAll(newSupports);
    }
}