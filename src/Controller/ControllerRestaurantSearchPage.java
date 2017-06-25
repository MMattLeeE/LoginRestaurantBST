package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.fxml.Initializable;
import sun.rmi.runtime.Log;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Matt on 6/25/2017.
 */
public class ControllerRestaurantSearchPage implements Initializable {

    @FXML
    private Button UserInfoBtn;
    @FXML
    private Button LogOutBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

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
