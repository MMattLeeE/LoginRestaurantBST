package Test;

import Model.BinarySearchTree;
import Model.RestaurantExcelReader;
import Model.Restaurant;

import org.junit.Test;

/**
 * Created by Matt on 7/2/2017.
 */
public class RestaurantExcelReaderTest {
    String filePath = "C:\\Users\\Matt\\Desktop\\restaurantList.xlsx";

    @Test
    public void readExcel() throws Exception {
        BinarySearchTree<Restaurant> testBST = RestaurantExcelReader.readExcel(filePath);
        System.out.println("List has " + testBST.size() + " number of restaurants");

        System.out.println(testBST.toString());
        testBST.printTreeStructure();
    }
}