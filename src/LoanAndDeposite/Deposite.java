package LoanAndDeposite;

import People.Client;

import java.util.Scanner;

public class Deposite {
    /** Цей клас створений для того щоб клієнт міг покласти гроші на депозит */

    private final Client client;

    public Deposite(Client client) {
        this.client = client;
    }

    public void getDeposite(Scanner scanner){
        System.out.println("Касир: В нашому банку процент річної ставки сягає 12%");
        client.setDepositInterestRate(12);
        System.out.println("Введіть суму депозиту: ");
        client.setDepositAmount(scanner.nextDouble());
        System.out.println("Введіть строк депозиту в місяцях: ");
        client.setDepositTermInMonths(scanner.nextInt());

        if (client.getDepositAmount() <= client.getAmountInHryvnias()){
            client.setDepositAmountOfInterest(client.getDepositAmount() * client.getDepositInterestRate() / 100 / 12
                    * client.getDepositTermInMonths());
            client.setTotalAmountOfDeposit(client.getDepositAmount() + client.getDepositAmountOfInterest());
            client.setAmountInHryvnias(client.getAmountInHryvnias() - client.getDepositAmount());

            System.out.println("Сума депозиту: " + client.getDepositAmount() + "₴.");
            System.out.println("Відсоткова ставка: " + client.getDepositInterestRate() + "%");
            System.out.println("Термін депозиту: " + client.getDepositTermInMonths() + " місяців");
            System.out.println("Сума відсотків: " + client.getDepositAmountOfInterest() + "₴.");
            System.out.println("Загальна сума: " + client.getTotalAmountOfDeposit() + "₴.");
        } else {
            System.out.println("Помилка! У Вас недостатньо гривень для того, щоб положити їх на депозит");
            client.setDepositAmount(0);
            client.setDepositTermInMonths(0);
        }
    }
}