public class Merchant {
    private String restaurantName;
    private String email;
    private String password;
    private String location;

    public Merchant() {
    }

    public Merchant(String restaurantName, String email, String password, String location) {
        this.restaurantName = restaurantName;
        this.email = email;
        this.password = password;
        this.location = location;
    }

    // Getters and setters

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // Display merchant profile
    public void displayProfile() {
        System.out.println();
        System.out.println("----------------------");
        System.out.println("MERCHANT PROFILE");
        System.out.println("----------------------");
        System.out.printf("Restaurant Name: %s%n", getRestaurantName());
        System.out.printf("Email Address: %s%n", getEmail());
        System.out.printf("Password: %s%n", getPassword());
        System.out.printf("Location: %s%n", getLocation());
        System.out.println("----------------------");
    }

    // Edit merchant profile
    public void editProfile() {
        System.out.println("Directing you to the edit profile page...");
    }

    // Refresh merchant profile
    public void refreshProfile() {
        System.out.println("Refreshing profile...");
    }

    @Override
    public String toString() {
        return String.format(
            "Merchant [restaurantName= %s, email= %s, password= %s, location= %s]",
            restaurantName, email, password, location);
    }

    public static void main(String[] args) {
        // Create instances of the Merchant class and test its methods here
        Merchant merchant1 = new Merchant("Delicious Pasta", "merchant@example.com", "securepassword", "Uptown");
        merchant1.displayProfile();
    }
}
