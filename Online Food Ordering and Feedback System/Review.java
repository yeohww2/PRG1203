import java.util.ArrayList;
import java.util.List;

public class Review {
    private List<Feedback> feedbackList;

    public Review() {
        feedbackList = new ArrayList<>();
    }

    public Review(List<Feedback> feedbackList) {
        this.feedbackList = feedbackList;
    }

    // Getters and setters

    public List<Feedback> getFeedbackList() {
        return feedbackList;
    }

    public void addFeedback(Feedback feedback) {
        feedbackList.add(feedback);
    }

    // Display reviews
    public void displayReviews() {
        System.out.println();
        System.out.println("----------------------");
        System.out.println("REVIEWS");
        System.out.println("----------------------");
        for (Feedback feedback : feedbackList) {
            feedback.displayFeedback();
        }
        System.out.println("----------------------");
    }

    public static void main(String[] args) {
        // Create instances of the Review class and test its methods here
        Customer customer1 = new Customer("Pauline Chan", "pauline@example.com", "securepassword");
        Order order1 = new Order(1, customer1);
        Feedback feedback1 = new Feedback(order1, "Great food and well service!");

        Customer customer2 = new Customer("Sylvia Leong", "Sylvia@example.com", "strongpassword");
        Order order2 = new Order(2, customer2);
        Feedback feedback2 = new Feedback(order2, "My favourite pasta place! Bought from them many times and the taste is the same everytime.");

        Review review = new Review();
        review.addFeedback(feedback1);
        review.addFeedback(feedback2);

        review.displayReviews();
    }
}
