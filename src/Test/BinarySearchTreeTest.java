package Test;

import Model.BinarySearchTree;
import Model.Restaurant;
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
        System.out.println(testBST.getInOrderQueue());
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

    @Test
    public void compareToTest() throws Exception {
        Restaurant test1 = new Restaurant("test","testaddress",new double[]{38.7517314,-77.4727505},"testphone","testimage");
        Restaurant test2 = new Restaurant("test2","testaddress2",new double[]{39.052466,-77.453372},"testphone2","testimage2");
        Restaurant test3 = new Restaurant("test2","testaddress2",new double[]{39.052466,-77.453372},"testphone2","testimage2");

        System.out.println(test1.compareTo(test2));
        System.out.println(test2.compareTo(test1));
        System.out.println(test2.compareTo(test3));

        System.out.println(Double.toString(test2.getRestaurantLocation()[0]));
    }
}