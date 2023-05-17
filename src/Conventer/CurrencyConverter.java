package Conventer;

import People.Client;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class CurrencyConverter {
    /** Цей клас містить методи та властивості для конвертації валют для клієнтів банку.
     *  Він надає можливість обмінювати гроші між різними валютами.
     * */

    private final Client client;
    private final Scanner scanner = new Scanner(System.in);
    private double USD_TO_UAH_RATE = 26.5;
    private double EUR_TO_UAH_RATE = 31.8;

    public CurrencyConverter(Client client) {
        this.client = client;
    }

    public void convert() {
        boolean isFinished = false;

        while (!isFinished) {
            System.out.println("Виберіть валюту для конвертації:");
            System.out.println("1. Гривня (UAH - USD/EUR).");
            System.out.println("2. Долар (USD - UAH).");
            System.out.println("3. Євро (EUR - UAH).");
            System.out.println("4. Назад.");

            int currencyOption = scanner.nextInt();

            if (currencyOption == 4) {
                isFinished = true;
                continue;
            }

            System.out.println("Введіть суму для конвертації:");
            double amount = scanner.nextDouble();

            switch (currencyOption) {
                case 1:
                    convertFromUAH(amount);
                    break;
                case 2:
                    convertToUSD(amount);
                    break;
                case 3:
                    convertToEUR(amount);
                    break;
                default:
                    System.out.println("Невірно вибрана валюта.");
                    break;
            }
        }
    }

    private void convertFromUAH(double amount) {
        System.out.println("Обмін з гривні:");
        System.out.println("Виберіть валюту для конвертації:");
        System.out.println("1. Долар (USD)");
        System.out.println("2. Євро (EUR)");

        Scanner scanner = new Scanner(System.in);
        int currencyOption = scanner.nextInt();

        if (amount <= client.getAmountInHryvnias()){
            switch (currencyOption) {
                case 1:
                    double resUSD = (double) Math.round((amount / USD_TO_UAH_RATE) * 100) / 100;
                    client.setAmountInDollars((client.getAmountInDollars() + resUSD));
                    client.setAmountInHryvnias((client.getAmountInHryvnias() - amount));
                    System.out.printf("Отримано %.2f$. Баланс готівкою: %.2f$. Баланс на картці: %.2f$.\n",
                            resUSD, client.getAmountInDollars(), client.getCardAmountInDollars());
                    break;
                case 2:
                    double resEUR = (double) Math.round((amount / EUR_TO_UAH_RATE) * 100) / 100;
                    client.setAmountInEuro((client.getAmountInEuro() + resEUR));
                    client.setAmountInHryvnias((client.getAmountInHryvnias() - amount));
                    System.out.printf("Отримано %.2f€. Баланс готівкою: %.2f€. Баланс на картці: %.2f€.\n",
                        resEUR, client.getAmountInEuro(), client.getCardAmountInEuro());
                    break;
                default:
                    System.out.println("Невірно вибрана валюта.");
                    break;
            }
        } else {
            System.out.println("Помилка! У Вас недостатньо коштів для обміну!");
        }
    }

    private void convertToUSD(double amount) {
        if (amount <= client.getAmountInDollars()){
            double res = (double) Math.round((amount * USD_TO_UAH_RATE) * 100) / 100;
            client.setAmountInHryvnias((client.getAmountInHryvnias() + res));
            System.out.printf("Отримано %.2f₴. Баланс готівкою: %.2f₴. Баланс на картці: %.2f₴.\n",
                  res, client.getAmountInHryvnias(), client.getCardAmountInHryvnias());
        } else {
            System.out.println("Помилка! У Вас недостатньо коштів для обміну!");
        }
    }

    private void convertToEUR(double amount) {
        if (amount <= client.getAmountInEuro()){
        double res = (double) Math.round((amount * EUR_TO_UAH_RATE) * 100) / 100;
        client.setAmountInHryvnias(client.getAmountInHryvnias() + res);
        System.out.printf("Отримано %.2f₴. Баланс готівкою: %.2f₴. Баланс на картці: %.2f₴.\n",
                res, client.getAmountInHryvnias(), client.getCardAmountInHryvnias());
        } else {
            System.out.println("Помилка! У Вас недостатньо коштів для обміну!");
        }
    }
}