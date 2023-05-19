package LoanAndDeposite;

import People.Client;

import java.util.Scanner;

public class Loan {
    /** Цей клас містить методи та властивості для обробки запитів на отримання кредиту в банку. */

    private final Client client;

    public Loan(Client client) {
        this.client = client;
    }

    public void getLoan(Scanner scanner){
        System.out.println("Касир: В нашому банку процент річної ставки сягає 25%");
        double interestRate = 25;
        System.out.print("Введіть суму кредиту в гривнях яку хочете отримати: ");
        double loanAmount = scanner.nextDouble();
        System.out.print("Введіть термін кредиту (у роках): ");
        int loanTermYears = scanner.nextInt();

        double monthlyInterestRate = interestRate / 100 / 12;
        int loanTermMonths = loanTermYears * 12;

        client.setLoanTerminInYears(loanTermYears);
        client.setMonthlyPayment((double) Math.round(calculateMonthlyPayment(loanAmount, monthlyInterestRate,
                loanTermMonths) * 100) / 100);
        client.setAmountLoan(client.getMonthlyPayment() * loanTermMonths);
        client.setTotalInterest((double) Math.round((client.getAmountLoan() - loanAmount) * 100) / 100);
        client.setAmountInHryvnias(client.getAmountInHryvnias() + loanAmount);

        System.out.println("Щомісячний платіж: " + client.getMonthlyPayment());
        System.out.println("Загальна сума платежів: " + client.getAmountLoan());
        System.out.println("Загальні відсотки: " + client.getTotalInterest());
    }

    public static double calculateMonthlyPayment(double loanAmount, double monthlyInterestRate, int loanTermMonths) {
        double denominator = Math.pow(1 + monthlyInterestRate, loanTermMonths) - 1;
        return loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, loanTermMonths) / denominator;
    }
}