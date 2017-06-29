package Model;

import org.junit.Test;

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
    }

    @Test
    public void containsTest() throws Exception {
    }

    @Test
    public void isEmptyTest() throws Exception {
    }

    @Test
    public void sizeTest() throws Exception {
    }

    @Test
    public void removeTest() throws Exception {
    }

    @Test
    public void resetTest() throws Exception {
    }

    @Test
    public void getNextTest() throws Exception {
    }

}