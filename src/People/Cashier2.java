package People;

import LoanAndDeposite.Deposite;
import LoanAndDeposite.Loan;
import java.util.Scanner;

public class Cashier2 extends Personal {
    /** Клас Cashier2 є підкласом класу Personal і представляє касира в банку.
     *  У цьому класі описані методи та атрибути, які дозволяють касиру взаємодіяти з клієнтами
     *  щодо оформлення кредитів та депозитів.
     * */
    private Client client;
    private final Loan loan;
    private final Deposite deposite;
    private final Scanner scanner;

    public Cashier2(String name, String position, Client client) {
        super(name, position);
        this.client = client;
        this.loan = new Loan(client);
        this.deposite = new Deposite(client);
        this.scanner = new Scanner(System.in);
    }

    public void work(Client client){
        boolean isFinished = false;

        greeting();
        while (!isFinished) {
            System.out.println("Оберіть дію:");
            System.out.println("1. Оформити кредит;");
            System.out.println("2. Оформити депозит;");
            System.out.println("3. Назад.");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (client.getCardNumber() != null){
                        if (client.getAmountLoan() == 0){
                            loan.getLoan(scanner);
                        } else {
                            System.out.printf("%s %S: У Вас вже відкритий кредит. Ви не можете відкрити новий.", getPosition(), getName());
                        }
                    } else {
                        System.out.printf("%s %s: У Вас немає відкритого рахунку. Відкрити його можна у спеціаліста відділення.\n",
                            getPosition(), getName());
                    }
                    break;
                case 2:
                    if (client.getCardNumber() != null){
                        if (client.getDepositAmount() == 0){
                            deposite.getDeposite(scanner);
                        } else {
                            System.out.printf("%s %S: У Вас вже відкритий депозит. Ви не можете відкрити новий.\n", getPosition(), getName());
                        }
                    } else {
                        System.out.printf("%s %s: У Вас немає відкритого рахунку. Відкрити його можна у спеціаліста відділення.\n",
                            getPosition(), getName());
                    }
                    break;
                case 3:
                    isFinished = true;
                    break;
                default:
                    System.out.println("Невірний вибір!");
                    break;
            }
        }
    }
}
