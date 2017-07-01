package Controller;

import Model.Restaurant;
import MyDataStructures.Implementations.List.ListIndexed;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sun.rmi.runtime.Log;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by Matt on 6/25/2017.
 */
public class ControllerRestaurantSearchPage implements Initializable {

    @FXML private Label restaurantNameOutput;
    @FXML private Label restaurantAddressOutput;
    @FXML private Label restaurantLatitudeOutput;
    @FXML private Label restaurantLongitudeOutput;
    @FXML private Label restaurantPhoneNumberOutput;
    @FXML private ImageView restaurantImageView;

    @FXML private TextField searchTextField;
    @FXML private Button searchBtn;

    @FXML private Button UserInfoBtn;
    @FXML private Button LogOutBtn;

    @FXML private TableView<Restaurant> restaurantTable;
    @FXML private TableColumn<Restaurant, String> restaurantNameCol;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ArrayList<Restaurant> testList = new ArrayList<>();
        testList.add(new Restaurant());
        testList.add(new Restaurant("Someplace","222 someplace ct test test 221122",new double[]{-1.111, 1.222},"4324443322","testImg"));
        testList.add(new Restaurant());
        testList.add(new Restaurant());

        restaurantTable.getItems().setAll(testList);

        //change listener for when a restaurant is selected on list...
        restaurantTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (restaurantTable.getSelectionModel().getSelectedItem() != null) {
                displayRestaurantData(newSelection);
            }
        });

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

    public void displayRestaurantData(Restaurant currentSelected) {
        restaurantNameOutput.setText(currentSelected.getRestaurantName());
        restaurantAddressOutput.setText(currentSelected.getRestaurantAddress());

        double[] temp = currentSelected.getRestaurantLocation();
        restaurantLatitudeOutput.setText(Double.toString(temp[0]));
        restaurantLongitudeOutput.setText(Double.toString(temp[1]));

        restaurantPhoneNumberOutput.setText(currentSelected.getRestaurantPhoneNumber());

        Image image = new Image("file:" + currentSelected.getRestaurantImage(),583,322,true,false);
        restaurantImageView.setImage(image);

        restaurantNameOutput.setVisible(true);
        restaurantAddressOutput.setVisible(true);
        restaurantLatitudeOutput.setVisible(true);
        restaurantLongitudeOutput.setVisible(true);
        restaurantPhoneNumberOutput.setVisible(true);
        restaurantImageView.setVisible(true);
    }

}
