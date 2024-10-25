public class MainApplication {
    public static void main(String[] args) {
        // Create a customer
        Customer customer = new Customer("John Doe", "john@example.com", "securepassword");

        // Create an order
        Order order = new Order(1, customer);

        // Create items using the Order.Item constructor
        Order.Item item1 = order.createItem("Burger", 5.99);
        Order.Item item2 = order.createItem("Fries", 2.49);

        // Add items to the order
        order.addItem(item1);
        order.addItem(item2);

        // Display order details
        System.out.println("----------------------");
        System.out.println("ORDER DETAILS");
        System.out.println("----------------------");
        System.out.printf("Order Number: %d%n", order.getOrderNumber());
        
        if (order.getCustomerDetails() != null) {
            System.out.printf("Customer Name: %s%n", order.getCustomerDetails().getCustomerName());
        } else {
            System.out.println("Customer details not available");
        }

        System.out.println("Items:");
        for (Order.Item item : order.getItems()) {
            System.out.printf("- %s (%d) - %.2f%n", item.getName(), item.getQuantity(), item.getPrice());
        }

        System.out.printf("Total Amount Paid: %.2f%n", order.getTotalAmount());
        System.out.println("----------------------");
    }
}
