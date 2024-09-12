import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicketMachine machine = new TicketMachine(50);

        while(true) {
            System.out.println("\n--- Ticket Machine Menu ---");
            System.out.println("1. Get Ticket Price");
            System.out.println("2. Get Current Balance");
            System.out.println("3. Insert Money");
            System.out.println("4. Print Ticket");
            System.out.println("5. Refund Balance");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch(choice) {
                case 1:
                    System.out.println("Ticket price: " + machine.getPrice() + " cents.");
                    break;
                case 2:
                    System.out.println("Current balance: " + machine.getBalance() + " cents.");
                    break;
                case 3:
                    System.out.print("Enter amount to insert: ");
                    int amount = scanner.nextInt();
                    machine.insertMoney(amount);
                    break;
                case 4:
                    machine.printTicket();
                    break;
                case 5:
                    if(machine.canRefund()) {
                        machine.refundBalance();
                    }
                    else {
                        System.out.println("No balance to refund.");
                    }
                    break;
                case 6:
                    System.out.println("Exiting the ticket machine...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }
    }
}
