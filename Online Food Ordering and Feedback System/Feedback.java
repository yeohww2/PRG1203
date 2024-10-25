public class Feedback {
    private Order order;
    private String comment;

    public Feedback() {
    }

    public Feedback(Order order, String comment) {
        this.order = order;
        this.comment = comment;
    }

    // Getters and setters

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    // Display feedback details
    public void displayFeedback() {
        System.out.println();
        System.out.println("----------------------");
        System.out.println("FEEDBACK DETAILS");
        System.out.println("----------------------");
        System.out.println("Order:");
        System.out.printf("Order Number: %d%n", getOrder().getOrderNumber());
        System.out.printf("Customer Name: %s%n", getOrder().getCustomerDetails().getCustomerName());
        System.out.printf("Total Amount: %.2f%n", getOrder().getTotalAmount());
        System.out.println("Comment: " + getComment());
        System.out.println("----------------------");
    }

    public static void main(String[] args) {
        // Create instances of the Feedback class and test its methods here
        Customer customer1 = new Customer("Pauline Chan", "pauline@example.com", "securepassword");
        Order order1 = new Order(1, customer1);

        Feedback feedback1 = new Feedback(order1, "Great experience and well prapared!");
        feedback1.displayFeedback();
    }
}
