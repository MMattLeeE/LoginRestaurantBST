package Model;

import java.io.Serializable;

/**
 * Created by Matt on 6/25/2017.
 */
public class Restaurant implements Serializable, Comparable<Restaurant> {
    private String restaurantName;
    private String restaurantAddress;
    private double[] restaurantLocation;
    private String restaurantPhoneNumber;
    private String restaurantImage;

    public Restaurant() {
        setRestaurantName("testRestaurant");
        setRestaurantAddress("111 test adress rd testCity VA 22221");
        setRestaurantLocation(new double[]{38.833596, -77.234517});
        setRestaurantPhoneNumber("7039123434");
        setRestaurantImage("testImg");
    }
    public Restaurant(String name, String address, double[] location, String number, String image) {
        setRestaurantName(name);
        setRestaurantAddress(address);
        setRestaurantLocation(location);
        setRestaurantPhoneNumber(number);
        setRestaurantImage(image);
    }
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

    public double[] getRestaurantLocation() {
        return restaurantLocation;
    }

    public void setRestaurantLocation(double[] restaurantLocation) {
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

    @Override
    public int compareTo(Restaurant o) {
        return this.restaurantName.compareTo(o.restaurantName);
    }
}

