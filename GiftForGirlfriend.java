import java.util.Scanner;

public class GiftForGirlfriend {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Array of gifts to choose from
        String[] gifts = {"Flowers", "Chocolates", "Jewelry", "Perfume", "Handwritten Letter"};
        
        System.out.println("Choose a gift for your girlfriend:");
        for (int i = 0; i < gifts.length; i++) {
            System.out.println((i + 1) + ". " + gifts[i]);
        }
        
        // User selects a gift
        System.out.print("Enter the number of the gift you want to give: ");
        int choice = scanner.nextInt();
        
        if (choice >= 1 && choice <= gifts.length) {
            System.out.println("You chose to give your girlfriend " + gifts[choice - 1] + "!");
        } else {
            System.out.println("Invalid choice. Please run the program again and select a valid gift.");
        }
        
        // Closing the scanner object
        scanner.close();
    }
}
