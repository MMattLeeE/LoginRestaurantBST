package Controller;

import Model.Restaurant;
import MyDataStructures.Implementations.List.ListIndexed;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sun.rmi.runtime.Log;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by Matt on 6/25/2017.
 */
public class ControllerRestaurantSearchPage implements Initializable {

    @FXML private Button UserInfoBtn;
    @FXML private Button LogOutBtn;
    @FXML private TableView<Restaurant> restaurantTable;
    @FXML private TableColumn<Restaurant, String> restaurantNameCol;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ArrayList<Restaurant> testList = new ArrayList<>();
        testList.add(new Restaurant());
        testList.add(new Restaurant());
        testList.add(new Restaurant());
        testList.add(new Restaurant());

        restaurantTable.getItems().setAll(testList);

        //When user info button is pressed
        UserInfoBtn.setOnAction(e -> {
            try {
                LoadPage.loadUserPage(e);
            } catch(IOException ex) {
                ex.printStackTrace();
            }
        });

        //When log out button is pressed
        LogOutBtn.setOnAction(e -> {
            try {
                LoadPage.loadLoginPage(e);
            } catch(IOException ex) {
                ex.printStackTrace();
            }
        });
    }

}
