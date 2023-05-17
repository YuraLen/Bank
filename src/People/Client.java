package People;

public class Client {
    /** Цей клас представляє клієнта в системі банку.
     * Він містить різні властивості та методи для управління інформацією про клієнта та його фінансовий стан.*/
    private String name;
    private String surname;
    private String patronymic;
    private String dateOfBirthString;
    private int age;
    private String cardNumber;
    // ↓ Баланс готівкою і на картках
    private double amountInHryvnias;
    private double amountInDollars;
    private double amountInEuro;
    private double cardAmountInHryvnias;
    private double cardAmountInDollars;
    private double cardAmountInEuro;
    // ↓ Про кредит
    private int loanTerminInYears;
    private double amountLoan;
    private double monthlyPayment;
    private double totalInterest;
    // ↓ Про депозит
    private double depositAmount;
    private double depositInterestRate;
    private double depositTermInMonths;
    private double depositAmountOfInterest;
    private double totalAmountOfDeposit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getDateOfBirthString() {
        return dateOfBirthString;
    }

    public void setDateOfBirthString(String dateOfBirthString) {
        this.dateOfBirthString = dateOfBirthString;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getAmountInHryvnias() {
        return amountInHryvnias;
    }

    public void setAmountInHryvnias(double amountInHryvnias) {
        this.amountInHryvnias = amountInHryvnias;
    }

    public double getAmountInDollars() {
        return amountInDollars;
    }

    public void setAmountInDollars(double amountInDollars) {
        this.amountInDollars = amountInDollars;
    }

    public double getAmountInEuro() {
        return amountInEuro;
    }

    public void setAmountInEuro(double amountInEuro) {
        this.amountInEuro = amountInEuro;
    }

    public double getCardAmountInHryvnias() {
        return cardAmountInHryvnias;
    }

    public void setCardAmountInHryvnias(double cardAmountInHryvnias) {
        this.cardAmountInHryvnias = cardAmountInHryvnias;
    }

    public double getCardAmountInDollars() {
        return cardAmountInDollars;
    }

    public void setCardAmountInDollars(double cardAmountInDollars) {
        this.cardAmountInDollars = cardAmountInDollars;
    }

    public double getCardAmountInEuro() {
        return cardAmountInEuro;
    }

    public void setCardAmountInEuro(double cardAmountInEuro) {
        this.cardAmountInEuro = cardAmountInEuro;
    }

    public double getAmountLoan() {
        return amountLoan;
    }

    public void setAmountLoan(double amountLoan) {
        this.amountLoan = amountLoan;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public double getTotalInterest() {
        return totalInterest;
    }

    public void setTotalInterest(double totalInterest) {
        this.totalInterest = totalInterest;
    }

    public int getLoanTerminInYears() {
        return loanTerminInYears;
    }

    public void setLoanTerminInYears(int loanTerminInYears) {
        this.loanTerminInYears = loanTerminInYears;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public double getDepositInterestRate() {
        return depositInterestRate;
    }

    public void setDepositInterestRate(double depositInterestRate) {
        this.depositInterestRate = depositInterestRate;
    }

    public double getDepositTermInMonths() {
        return depositTermInMonths;
    }

    public void setDepositTermInMonths(double depositTermInMonths) {
        this.depositTermInMonths = depositTermInMonths;
    }

    public double getDepositAmountOfInterest() {
        return depositAmountOfInterest;
    }

    public void setDepositAmountOfInterest(double depositAmountOfInterest) {
        this.depositAmountOfInterest = depositAmountOfInterest;
    }

    public double getTotalAmountOfDeposit() {
        return totalAmountOfDeposit;
    }

    public void setTotalAmountOfDeposit(double totalAmountOfDeposit) {
        this.totalAmountOfDeposit = totalAmountOfDeposit;
    }
}