package Model;

import org.junit.Test;

import static Model.BinarySearchTree.INORDER;
import static org.junit.Assert.*;

/**
 * Created by Matt on 6/28/2017.
 */
public class BinarySearchTreeTest {
    BinarySearchTree<String> testBST = new BinarySearchTree<>();
    String[] testStrings = {"f","b","k","d","e","a","g","h","i","j","c","l","m"};

    public void addTestValues() {
        for (int i=0; i<testStrings.length; i++) {
            testBST.add(testStrings[i]);
        }
    }

    @Test
    public void addTest() throws Exception {
        addTestValues();
        testBST.printTreeStructure();
        assertEquals(13,testBST.size());
    }

    @Test
    public void getTest() throws Exception {
        addTestValues();
        assertEquals("l",testBST.get("l"));
    }

    @Test
    public void containsTest() throws Exception {
        addTestValues();
        assertEquals(true,testBST.contains("a"));
        assertEquals(true,testBST.contains("b"));
        assertEquals(true,testBST.contains("c"));

    }

    @Test
    public void isEmptyTest() throws Exception {
        assertEquals(true,testBST.isEmpty());
        addTestValues();
        assertEquals(false,testBST.isEmpty());
    }

    @Test
    public void sizeTest() throws Exception {

    }

    @Test
    public void removeTest() throws Exception {
        addTestValues();
        testBST.printTreeStructure();
        testBST.remove("f");
        testBST.printTreeStructure();
        assertEquals(false,testBST.contains("f"));
    }

    @Test
    public void resetTest() throws Exception {
        addTestValues();
        assertEquals(13,testBST.reset(INORDER));
        System.out.println(testBST.inOrderQueue);
    }

    @Test
    public void getNextTest() throws Exception {

    }

    @Test
    public void balanceTreeTest() throws Exception {
        addTestValues();
        testBST.printTreeStructure();

        testBST.balanceTree();
        testBST.printTreeStructure();
    }

    @Test
    public void toStringTest() throws Exception {
        addTestValues();
        System.out.println(testBST.toString());
    }
}