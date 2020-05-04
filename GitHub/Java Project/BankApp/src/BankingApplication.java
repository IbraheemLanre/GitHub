import java.util.Scanner;

public class BankingApplication {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Ade", "CME100");
        account.showTransactionMenu();
    }
}

class BankAccount {
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    BankAccount(String cname, String cid){
        customerName = cname;
        customerId = cid;
    }

    void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount) {
        if(amount !=0){
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("You deposited: " + previousTransaction);
        }
        else if (previousTransaction < 0) {
            System.out.println("You withdrew: " + Math.abs(previousTransaction));
        }
        else {
            System.out.println("You have not performed any transactions");
        }
    }

    void showTransactionMenu() {
        char transactionOption = '\0';
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome " + customerName);
        System.out.println("Your ID is " + customerId);
        System.out.println("\nA. Check Balance");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous Transaction");
        System.out.println("E. Exit");

        do{
            System.out.println("=======================================================================");
            System.out.println("Enter an option from the transaction menu above");
            System.out.println("=======================================================================");
            transactionOption = scanner.next().charAt(0);
            System.out.println("\n");

            switch (transactionOption) {
                case 'A':
                    System.out.println("------------------------------");
                    System.out.println("Balance = " + balance);
                    System.out.println("------------------------------");
                    System.out.println("\n");
                    break;

                case 'B':
                    System.out.println("------------------------------");
                    System.out.println("Enter an amount to deposit:");
                    System.out.println("------------------------------");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                    break;

                case 'C':
                    System.out.println("------------------------------");
                    System.out.println("Enter an amount to withdraw:");
                    System.out.println("------------------------------");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println("\n");

                case 'D':
                    System.out.println("------------------------------");
                    getPreviousTransaction();
                    System.out.println("------------------------------");
                    System.out.println("\n");
                    break;

                case 'E':
                    System.out.println("************************************");
                    break;

                default:
                    System.out.println("You made an invalid selection!. Please make a new selection");
                    break;
            }
        }while (transactionOption != 'E');

        System.out.println("Thank you for your patronage");
    }
}
