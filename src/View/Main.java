package View;

import Model.User;
import Model.UserDB;
import Model.UserIO;

import MyDataStructures.Implementations.List.ListOrdered;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;



/**
 * Created by Matt on 5/27/2017.
 */
public class Main extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        loadUserDB();

        Parent root = FXMLLoader.load(getClass().getResource("/View/loginPage.fxml"));

        Scene scene = new Scene(root, 600, 530);

        primaryStage.setTitle("Matt Login");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void loadUserDB() {
        try{
            UserDB.setUsersArrayList((ListOrdered<User>) UserIO.readUsers());
            UserDB.printOrderedList();

            System.out.println();
        } catch(IOException e) {
            System.err.print("Can't read/open users.dat file");
        } catch(ClassNotFoundException e) {
            System.err.print("Class not found...");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
