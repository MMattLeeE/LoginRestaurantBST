package Controller;

import Model.BinarySearchTree;
import Model.Restaurant;
import Model.RestaurantDB;
import MyDataStructures.Exceptions.QueueUnderFlowException;
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
        BinarySearchTree<Restaurant> bst = RestaurantDB.getRestaurantsDB();
        ArrayList<Restaurant> tempList = new ArrayList<>();
        bst.reset(BinarySearchTree.INORDER);

        for (int i=0; i<bst.size(); i++) {
            try {
                tempList.add(bst.getNext(BinarySearchTree.INORDER));
            } catch (QueueUnderFlowException e) {
                e.printStackTrace();
                System.err.println("Binary Search Tree inorder queue is empty...");
            }
        }

        restaurantTable.getItems().setAll(tempList);

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

    private void displayRestaurantData(Restaurant currentSelected) {
        restaurantNameOutput.setText(currentSelected.getRestaurantName());
        restaurantAddressOutput.setText(currentSelected.getRestaurantAddress());

        double[] temp = currentSelected.getRestaurantLocation();
        restaurantLatitudeOutput.setText(Double.toString(temp[0]));
        restaurantLongitudeOutput.setText(Double.toString(temp[1]));

        restaurantPhoneNumberOutput.setText(currentSelected.getRestaurantPhoneNumber());

        Image image = new Image(currentSelected.getRestaurantImage(),583,322,true,false);
        restaurantImageView.setImage(image);

        restaurantNameOutput.setVisible(true);
        restaurantAddressOutput.setVisible(true);
        restaurantLatitudeOutput.setVisible(true);
        restaurantLongitudeOutput.setVisible(true);
        restaurantPhoneNumberOutput.setVisible(true);
        restaurantImageView.setVisible(true);
    }

}
