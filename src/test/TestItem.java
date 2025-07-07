package test;

import main.Item;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestItem{
    @Test
    public void getAllDependencies(){
        Item A = new Item( "A");
        Item B = new Item( "B");
        Item C = new Item( "C");
        Item E = new Item( "E");
        Item G = new Item( "G");
        A.addDependencies( B);
        A.addDependencies( C);
        B.addDependencies( C);
        B.addDependencies( E);
        C.addDependencies( G);

        assertEquals("B C E G", A.getAllDependencies());
        assertEquals("C E G", B.getAllDependencies());
        assertEquals("G", C.getAllDependencies());
        assertEquals("C B A", G.getAllDependencies());
        assertEquals("B A", E.getAllDependencies());
    }
}