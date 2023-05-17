package CardOperations;

import People.Client;

import java.util.Scanner;

public class WithdrawFunds {
    /** Цей клас використовується для знаття коштів з картки */

    private final Client client;
    private final Scanner scanner = new Scanner(System.in);

    public WithdrawFunds(Client client) {
    this.client = client;
  }

    public void withdrawUAH() {
        System.out.println("Виберіть суму яку хочете зняти з картки.");
        double sum = scanner.nextDouble();
        if (sum <= client.getCardAmountInHryvnias()){
            client.setCardAmountInHryvnias(client.getCardAmountInHryvnias() - sum);
            client.setAmountInHryvnias(client.getAmountInHryvnias() + sum);
            System.out.printf("З вашого рахунку знято %.2f₴!\nБаланс на картці: %.2f₴. Баланс готівкою: %.2f₴.\n",
                sum, client.getCardAmountInHryvnias(), client.getAmountInHryvnias());
        } else {
            System.out.println("Помилка! У Вас недостатньо гривень на картці для зняття!");
        }
    }

    public void withdrawUSD() {
        System.out.println("Виберіть суму яку хочете зняти з картки.");
        double sum = scanner.nextDouble();
        if (sum <= client.getCardAmountInDollars()){
            client.setCardAmountInDollars(client.getCardAmountInDollars() - sum);
            client.setAmountInDollars(client.getAmountInDollars() + sum);
            System.out.printf("З вашого рахунку знято %.2f$!\nБаланс на картці: %.2f$. Баланс готівкою: %.2f$.\n",
                sum, client.getCardAmountInDollars(), client.getAmountInDollars());
        } else {
            System.out.println("Помилка! У Вас недостатньо доларів на картці для зняття!");
        }
    }

    public void withdrawEURO(){
        System.out.println("Виберіть суму яку хочете зняти з картки.");
        double sum = scanner.nextDouble();
        if (sum <= client.getCardAmountInEuro()){
            client.setCardAmountInEuro(client.getCardAmountInEuro() - sum);
            client.setAmountInEuro(client.getAmountInEuro() + sum);
            System.out.printf("Ваш рахунок поповнено на %.2f€!\nБаланс на картці: %.2f€. Баланс готівкою: %.2f€.\n",
                sum, client.getCardAmountInEuro(), client.getAmountInEuro());
        } else {
            System.out.println("Помилка! У Вас недостатньо євро на картці для зняття!");
        }
    }

    public void withdraw() {
        boolean isFinished = false;

        while (!isFinished) {
            System.out.println("Оберіть операцію:");
            System.out.println("1. Зняти гроші з гривневої картки.");
            System.out.println("2. Зняти гроші з доларової картки.");
            System.out.println("3. Зняти гроші з євро картки.");
            System.out.println("4. Назад.");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    withdrawUAH();
                    break;
                case 2:
                    withdrawUSD();
                    break;
                case 3:
                    withdrawEURO();
                    break;
                case 4:
                    isFinished = true;
                    break;
                default:
                    System.out.println("Невірний вибір!");
                    break;
            }
        }
    }
}