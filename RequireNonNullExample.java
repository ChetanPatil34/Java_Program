import java.util.Objects;

public class RequireNonNullExample {
    public static void main(String[] args) {
        try {
            setMessage(null);  // Passing null intentionally
        } catch (NullPointerException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void setMessage(String message) {
        // Throw NPE with a custom message if 'message' is null
        Objects.requireNonNull(message, "Message cannot be null");
        System.out.println("Message set to: " + message);
    }
}
