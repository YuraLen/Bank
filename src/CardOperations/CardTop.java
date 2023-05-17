package CardOperations;

import People.Client;

import java.util.Scanner;

public class CardTop {
    /** Цей клас використовується для поповнення коштів на картку */

    private Client client;
    private Scanner scanner = new Scanner(System.in);

    public CardTop(Client client) {
        this.client = client;
    }

    public void topUpUAH() {
        System.out.println("Виберіть суму яку хочете поповнити на картку.");
        double sum = scanner.nextDouble();
        if (sum <= client.getAmountInHryvnias()){
            client.setCardAmountInHryvnias(client.getCardAmountInHryvnias() + sum);
            client.setAmountInHryvnias(client.getAmountInHryvnias() - sum);
            System.out.printf("Ваш рахунок поповнено на %.2f₴!\nБаланс на картці: %.2f₴. Баланс готівкою: %.2f₴.\n",
                sum, client.getCardAmountInHryvnias(), client.getAmountInHryvnias());
        } else {
            System.out.println("Помилка! У Вас недостатньо гривень для поповнення!");
        }
    }

    public void topUpUSD() {
        System.out.println("Виберіть суму яку хочете поповнити на картку.");
        double sum = scanner.nextDouble();
        if (sum <= client.getAmountInDollars()){
            client.setCardAmountInDollars(client.getCardAmountInDollars() + sum);
            client.setAmountInDollars(client.getAmountInDollars() - sum);
            System.out.printf("Ваш рахунок поповнено на %.2f$!\nБаланс на картці: %.2f$. Баланс готівкою: %.2f$.\n",
                sum, client.getCardAmountInDollars(), client.getAmountInDollars());
        } else {
            System.out.println("Помилка! У Вас недостатньо доларів для поповнення!");
        }
    }

    public void topUpEURO(){
        System.out.println("Виберіть суму яку хочете поповнити на картку.");
        double sum = scanner.nextDouble();
        if (sum <= client.getAmountInEuro()){
            client.setCardAmountInEuro(client.getCardAmountInEuro() + sum);
            client.setAmountInEuro(client.getAmountInEuro() - sum);
            System.out.printf("Ваш рахунок поповнено на %.2f€!\nБаланс на картці: %.2f€. Баланс готівкою: %.2f€.\n",
                sum, client.getCardAmountInEuro(), client.getAmountInEuro());
        } else {
            System.out.println("Помилка! У Вас недостатньо євро для поповнення!");
        }
    }

    public void topUp() {
        boolean isFinished = false;

        while (!isFinished) {
            System.out.println("1. Поповнити гривневу картку.");
            System.out.println("2. Поповнити доларову картку.");
            System.out.println("3. Поповнити євро картку.");
            System.out.println("4. Назад.");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    topUpUAH();
                    break;
                case 2:
                    topUpUSD();
                    break;
                case 3:
                    topUpEURO();
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