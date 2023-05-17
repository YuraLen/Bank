package People;

import CardOperations.CardTop;
import CardOperations.WithdrawFunds;
import Conventer.CurrencyConverter;

import java.util.Scanner;

public class Cashier1 extends Personal {
    /** Клас Cashier1 є підкласом класу Personal і представляє касира в банку.
     *  У цьому класі описані методи та атрибути, які дозволяють касиру взаємодіяти з клієнтами
     *  щодо операцій з банківськими рахунками та валютою.
     * */

    private Client client;
    private CardTop cardTop;
    private WithdrawFunds withdrawFunds;
    private CurrencyConverter currencyConverter;

    public Cashier1(String name, String position, Client client) {
        super(name, position);
        this.client = client;
        this.cardTop = new CardTop(client);
        this.withdrawFunds = new WithdrawFunds(client);
        this.currencyConverter = new CurrencyConverter(client);
    }
    Scanner scanner = new Scanner(System.in);

    public void work(Client client) {
        boolean isFinished = false;

        greeting();
        while (!isFinished) {
            System.out.println("1. Поповнити банківський рахунок.");
            System.out.println("2. Зняти кошти з банківського рахунку.");
            System.out.println("3. Обміняти валюту.");
            System.out.println("4. Назад.");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (client.getCardNumber() != null){
                        cardTop.topUp();
                    } else {
                        System.out.printf("%s %s: У Вас немає відкритого рахунку. Відкрити його можна у спеціаліста відділення.\n",
                                getPosition(), getName());
                    }
                    break;
                case 2:
                    if (client.getCardNumber() != null){
                        withdrawFunds.withdraw();
                    } else {
                        System.out.printf("%s %s: У Вас немає відкритого рахунку. Відкрити його можна у спеціаліста відділення.\n",
                                getPosition(), getName());
                    }
                    break;
                case 3:
                    currencyConverter.convert();
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