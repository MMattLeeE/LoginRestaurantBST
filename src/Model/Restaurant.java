package Model;

/**
 * Created by Matt on 6/25/2017.
 */
public class Restaurant {
    private String restaurantName;
    private String restaurantAddress;
    private float[] restaurantLocation;
    private String restaurantPhoneNumber;
    private String restaurantImage;
    private String restaurantGUI;

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    public float[] getRestaurantLocation() {
        return restaurantLocation;
    }

    public void setRestaurantLocation(float[] restaurantLocation) {
        this.restaurantLocation = restaurantLocation;
    }

    public String getRestaurantPhoneNumber() {
        return restaurantPhoneNumber;
    }

    public void setRestaurantPhoneNumber(String restaurantPhoneNumber) {
        this.restaurantPhoneNumber = restaurantPhoneNumber;
    }

    public String getRestaurantImage() {
        return restaurantImage;
    }

    public void setRestaurantImage(String restaurantImage) {
        this.restaurantImage = restaurantImage;
    }

    public String getRestaurantGUI() {
        return restaurantGUI;
    }

    public void setRestaurantGUI(String restaurantGUI) {
        this.restaurantGUI = restaurantGUI;
    }

}

