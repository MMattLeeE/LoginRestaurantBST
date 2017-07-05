package Controller;

import Model.BinarySearchTree;
import Model.Restaurant;
import Model.RestaurantDB;
import MyDataStructures.Exceptions.QueueUnderFlowException;
import MyDataStructures.Implementations.List.ListIndexed;
import MyDataStructures.Implementations.NodeIndexed;
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

    public Label Name;
    public Label Address;
    public Label Lat;
    public Label Long;
    public Label Phone;

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

    private ArrayList<Restaurant> searchArray;
    private ArrayList<Restaurant> tempList;
    private BinarySearchTree<Restaurant> bst;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bst = RestaurantDB.getRestaurantsDB();
        tempList = new ArrayList<>();
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

        searchBtn.setOnAction(e -> {
            searchRestaurants();
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

        restaurantLatitudeOutput.setText(Double.toString(currentSelected.getRestaurantLocation()[0]));
        restaurantLongitudeOutput.setText(Double.toString(currentSelected.getRestaurantLocation()[1]));

        restaurantPhoneNumberOutput.setText(currentSelected.getRestaurantPhoneNumber());

        Image image = new Image(currentSelected.getRestaurantImage(),583,322,true,false);
        restaurantImageView.setImage(image);

        restaurantNameOutput.setVisible(true);
        restaurantAddressOutput.setVisible(true);
        restaurantLatitudeOutput.setVisible(true);
        restaurantLongitudeOutput.setVisible(true);
        restaurantPhoneNumberOutput.setVisible(true);
        restaurantImageView.setVisible(true);

        Name.setVisible(true);
        Address.setVisible(true);
        Lat.setVisible(true);
        Long.setVisible(true);
        Phone.setVisible(true);
    }

    private void searchRestaurants() {
        String searchQuery = searchTextField.getText().toLowerCase();

        searchArray = new ArrayList<>();

        String currentName;
        String currentAddress;
        String currentLat;
        String currentLong;
        String currentPhone;

        for (int i =0; i < tempList.size(); i++) {
            currentName = tempList.get(i).getRestaurantName().toLowerCase();
            currentAddress = tempList.get(i).getRestaurantAddress().toLowerCase();
            currentLat = Double.toString(tempList.get(i).getRestaurantLocation()[0]);
            currentLong = Double.toString(tempList.get(i).getRestaurantLocation()[1]);
            currentPhone = tempList.get(i).getRestaurantPhoneNumber().toLowerCase();

            if (currentName.contains(searchQuery) ||
                    currentAddress.contains(searchQuery) ||
                    orderContainString(searchQuery,currentLat) ||
                    orderContainString(searchQuery,currentLong) ||
                    orderContainString(searchQuery,currentPhone)) {
                searchArray.add(tempList.get(i));
            }

        }

        restaurantTable.getItems().setAll(searchArray);

        searchTextField.clear();

        restaurantNameOutput.setVisible(false);
        restaurantAddressOutput.setVisible(false);
        restaurantLatitudeOutput.setVisible(false);
        restaurantLongitudeOutput.setVisible(false);
        restaurantPhoneNumberOutput.setVisible(false);
        restaurantImageView.setVisible(false);

        Name.setVisible(false);
        Address.setVisible(false);
        Lat.setVisible(false);
        Long.setVisible(false);
        Phone.setVisible(false);

    }

    public boolean orderContainString(String query, String checked) {//check the strings in order from the beginning.
        boolean output = false;
        if(query.length() > checked.length()) { //if the substring that is being looked for is larger than the string it is being looked for in it
            output = false;
        } else {
            boolean end = false;
            int index = 0;

            while (!end) {//ends if there is a mismatch for a character or if the last query character has been compared.
                if (checked.charAt(index)==query.charAt(index)){//if the character is a match
                    index++;

                    if (index == query.length()) {//if the last character of the query is checked and matches
                        output = true;
                        end = true;
                    }

                } else {
                    end = true;
                    output = false;
                }
            }
        }
        return output;
    }
}
