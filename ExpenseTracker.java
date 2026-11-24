import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseTracker {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ArrayList<String> names = new ArrayList<>();
            ArrayList<Double> amounts = new ArrayList<>();
            
            boolean running = true;
            
            while (running) {
                System.out.println("\n===== PERSONAL EXPENSE TRACKER =====");
                System.out.println("1. Add expense");
                System.out.println("2. View expenses");
                System.out.println("3. View total spending");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                
                String choice = scanner.nextLine();
                
                switch (choice) {
                    case "1":
                        System.out.print("Enter expense name: ");
                        String name = scanner.nextLine().trim();
                        
                        if (name.isEmpty()) {
                            System.out.println("Expense name cannot be empty.");
                            break;
                        }
                        
                        System.out.print("Enter amount in rupees: ");
                        
                        try {
                            double amount =
                                    Double.parseDouble(scanner.nextLine());
                            
                            if (!Double.isFinite(amount) || amount <= 0) {
                                System.out.println("Enter a positive amount.");
                                break;
                            }
                            
                            names.add(name);
                            amounts.add(amount);
                            
                            System.out.println("Expense added successfully!");
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid amount. Enter a number.");
                        }
                        break;
                        
                    case "2":
                        if (names.isEmpty()) {
                            System.out.println("No expenses added yet.");
                        } else {
                            System.out.println("\n----- YOUR EXPENSES -----");
                            
                            for (int i = 0; i < names.size(); i++) {
                                System.out.printf(
                                        "%d. %s - Rs. %.2f%n",
                                        i + 1, names.get(i), amounts.get(i)
                                );
                            }
                        }
                        break;
                        
                    case "3":
                        double total = 0;
                        
                        for (double amount : amounts) {
                            total += amount;
                        }
                        
                        System.out.printf("Total spending: Rs. %.2f%n", total);
                        break;
                        
                    case "4":
                        running = false;
                        System.out.println("Goodbye!");
                        break;
                        
                    default:
                        System.out.println("Please choose 1, 2, 3, or 4.");
                }
            }
        }
    }
}