package Model;

import MyDataStructures.Implementations.List.ListOrdered;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Matt on 7/2/2017.
 */
public class ExcelReaderTest {
    String filePath = "C:\\Users\\Matt\\Desktop\\restaurantList.xlsx";
    ExcelReader testReader = new ExcelReader();

    @Test
    public void readExcel() throws Exception {
        ListOrdered<Restaurant> testList = testReader.readExcel(filePath);
        System.out.println("List has " + testList.size() + " number of restaurants");
    }
}