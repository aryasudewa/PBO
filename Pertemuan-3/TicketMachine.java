public class TicketMachine {
    private int price;
    private int balance;

    public TicketMachine(int ticketCost) {
        if(ticketCost <= 0) {
            throw new IllegalArgumentException("Ticket cost must be greater than zero.");
        }
        this.price = ticketCost;
        this.balance = 0;
    }

    public int getPrice() {
        return price;
    }

    public int getBalance() {
        return balance;
    }

    public void insertMoney(int amount) {
        if(amount > 0) {
            balance += amount;
            System.out.println("Inserted " + amount + " cents. Current balance: " + balance);
        }
        else {
            System.out.println(amount + " is not a valid amount to insert.");
        }
    }

    public void printTicket() {
        if(balance >= price) {
            System.out.println("------------------");
            System.out.println("## Ticket");
            System.out.println("## " + price + " cents");
            System.out.println("------------------");
            
            balance -= price;
            System.out.println("Ticket printed. Remaining balance: " + balance + " cents.");
        }
        else {
            System.out.println("You must insert at least " + (price - balance) + " more cents.");
        }
    }

    public void refundBalance() {
        if(balance > 0) {
            System.out.println("Refunded: " + balance + " cents.");
            balance = 0;
        }
        else {
            System.out.println("No balance to refund.");
        }
    }

    public boolean canRefund() {
        return balance > 0;
    }
}
