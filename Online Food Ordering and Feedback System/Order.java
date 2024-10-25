import java.util.ArrayList;
import java.util.List;

public class Order extends Customer{
    private List<Item> items;
    private int orderNumber;
    private Customer customerDetails;
    private double totalAmount;

    public Order() {
        items = new ArrayList<>();
    }

    public Order(int orderNumber, Customer customerDetails) {
        this.orderNumber = orderNumber;
        this.customerDetails = customerDetails;
        items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
        calculateTotalAmount();
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Customer getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(Customer customerDetails) {
        this.customerDetails = customerDetails;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    private void calculateTotalAmount() {
        totalAmount = 0;
        for (Item item : items) {
            totalAmount += item.getPrice();
        }
    }

    public void displayOrder() {
        System.out.println();
        System.out.println("----------------------");
        System.out.println("ORDER DETAILS");
        System.out.println("----------------------");
        System.out.printf("Order Number: %d%n", getOrderNumber());

        if (getCustomerDetails() != null) {
            System.out.printf("Customer Name: %s%n", getCustomerDetails().getCustomerName());
        } else {
            System.out.println("Customer details not available");
        }

        System.out.println("Items:");
        for (Item item : items) {
            System.out.printf("- %s (%d) - %.2f%n", item.getName(), item.getQuantity(), item.getPrice());
        }

        System.out.printf("Total Amount Paid: %.2f%n", getTotalAmount());
        System.out.println("----------------------");
    }

    public class Item {
        private String name;
        private double price;
        private int quantity;

        public Item(String name, double price) {
            this.name = name;
            this.price = price;
            this.quantity = 1; // Default quantity
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }
    }

    public Item createItem(String name, double price) {
        return new Item(name, price);
    }

    public static void main(String[] args) {
        Customer customer1 = new Customer("John Doe", "john@example.com", "securepassword");
        Order order1 = new Order(1, customer1);

        Order.Item item1 = order1.createItem("Burger", 5.99);
        Order.Item item2 = order1.createItem("Fries", 2.49);

        order1.addItem(item1);
        order1.addItem(item2);

        order1.displayOrder();
    }
}
