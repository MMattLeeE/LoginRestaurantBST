package Test;

import org.junit.Test;
import Controller.ControllerRestaurantSearchPage;
import static org.junit.Assert.*;

/**
 * Created by Matt on 7/5/2017.
 */
public class ControllerRestaurantSearchPageTest {
    ControllerRestaurantSearchPage test = new ControllerRestaurantSearchPage();

    @Test
    public void orderContainStringTest() throws Exception {
        String query = "-37";
        String checked = "-37.1234";
        String test3 = "-27.1234";

        assertEquals(true,test.orderContainString(query,checked));
        assertEquals(false,test.orderContainString(query,test3));
    }

}