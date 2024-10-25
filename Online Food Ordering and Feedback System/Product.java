public class Product {
    private String userIcon;
    private String title;
    private String description;
    private double price;
    private int quantity;
    private String category;

    public Product() {
    }

    public Product(String userIcon, String title, String description, double price, int quantity, String category) {
        this.userIcon = userIcon;
        this.title = title;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    // Getters and setters

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // Display product details
    public void displayProduct() {
        System.out.println();
        System.out.println("----------------------");
        System.out.println("PRODUCT DETAILS");
        System.out.println("----------------------");
        System.out.printf("User Icon: %s%n", getUserIcon());
        System.out.printf("Title: %s%n", getTitle());
        System.out.printf("Description: %s%n", getDescription());
        System.out.printf("Price: %.2f%n", getPrice());
        System.out.printf("Quantity: %d%n", getQuantity());
        System.out.printf("Category: %s%n", getCategory());
        System.out.println("----------------------");
    }

    public static void main(String[] args) {
        // Create instances of the Product class and test its methods here
        Product product1 = new Product("product-icon.png", "Pasta Mania",
                                      "Ham Carbonara & Pepsi", 5.00, 50, "Food");
        product1.displayProduct();
    }
}
