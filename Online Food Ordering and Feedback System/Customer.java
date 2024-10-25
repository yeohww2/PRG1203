public class Customer {
    private String customerName;
    private String email;
    private String password;

    public Customer() {
    }

    public Customer(String customerName, String email, String password) {
        this.customerName = customerName;
        this.email = email;
        this.password = password;
    }

    // Getters and setters

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    // Display customer profile
    public void displayProfile() {
        System.out.println();
        System.out.println("----------------------");
        System.out.println("CUSTOMER PROFILE");
        System.out.println("----------------------");
        System.out.printf("Customer Name: %s%n", getCustomerName());
        System.out.printf("Email Address: %s%n", getEmail());
        System.out.printf("Password: %s%n", getPassword());
        System.out.println("----------------------");
    }

    // Edit customer profile
    public void editProfile() {
        System.out.println("Directing you to the edit profile page...");
    }

    // Refresh customer profile
    public void refreshProfile() {
        System.out.println("Refreshing profile...");
    }

    @Override
    public String toString() {
        return String.format(
            "Customer [customerName= %s, email= %s, password= %s]", customerName, email, password);
    }

    public static void main(String[] args) {
        //Create instances of the Customer class and test its methods here
        Customer customer1 = new Customer("Pauline Chan", "pauline@example.com", "securepassword");
        customer1.displayProfile();
    }
}
