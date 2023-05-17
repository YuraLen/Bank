package People;

import java.time.LocalDate;
import java.time.Period;
import java.util.Random;
import java.util.Scanner;

public class Specialist extends Personal {
    /** Клас Specialist є підкласом класу Personal і представляє спеціаліста, який працює в банку.
     *  У цьому класі описані методи та атрибути, які дозволяють спеціалісту працювати з клієнтами.
     * */

    private final Client client;

    public Specialist(String name, String position, Client client) {
        super(name, position);
        this.client = client;
    }

    Scanner scanner = new Scanner(System.in);

    public void work() {
        boolean isFinished = false;

        greeting();
        while (!isFinished) {
            System.out.println("1. Відкрити банківський рахунок.");
            System.out.println("2. Отримати виписку з детальною інформацією.");
            System.out.println("3. Назад.");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (client.getCardNumber() == null){
                        registerCard();
                    } else {
                        System.out.printf("%s %s: У Вас вже є відкритий рахунок!\n", getPosition(), getName());
                    }
                    break;
                case 2:
                    if (client.getCardNumber() != null){
                        showInfo();
                    } else {
                        System.out.printf("%s %s: У Вас немає відкритого рахунку!\n", getPosition(), getName());
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

    public void registerCard(){
        System.out.println("Спеціаліст: Давайте відкриємо Вам банківський рахунок.");
        System.out.print("✎ Ім'я: ");
        client.setName(scanner.next());
        System.out.print("✎ Прізвище: ");
        client.setSurname(scanner.next());
        System.out.print("✎ По батькові: ");
        client.setPatronymic(scanner.next());
        System.out.print("Введіть дату народження (у форматі рррр-мм-дд): ");
        client.setDateOfBirthString(scanner.next());
        System.out.print("\uD83D\uDCB8 Сума грошей у гривнях: ");
        client.setAmountInHryvnias(scanner.nextDouble());
        calculateAge();

        if (client.getAge() < 18) {
            System.out.println("Спеціаліст: Ви не можете зареєструвати рахунок, так як вам менше 18 років.");
            client.setName(null);
            client.setSurname(null);
            client.setPatronymic(null);
            client.setDateOfBirthString(null);
            client.setAmountInHryvnias(0);
        } else {
            client.setCardNumber(generateMastercardNumber());
        }
    }

    public static String generateMastercardNumber() {
        Random random = new Random();

        // Генеруємо першу частину номеру карточки (6 цифр)
        StringBuilder sb = new StringBuilder();
        sb.append("5"); // Перший символ для Mastercard завжди 5
        for (int i = 0; i < 5; i++) {
            int digit = random.nextInt(10);
            sb.append(digit);
        }

        // Генеруємо другу частину номеру карточки (14 цифр)
        for (int i = 0; i < 14; i++) {
            int digit = random.nextInt(10);
            sb.append(digit);
        }
        return sb.toString();
    }

    private void calculateAge() {
        LocalDate dateOfBirth = LocalDate.parse(client.getDateOfBirthString());
        LocalDate currentDate = LocalDate.now();
        Period ageUp = Period.between(dateOfBirth, currentDate);
        client.setAge(ageUp.getYears());
    }

    public String showInfo() {
        System.out.println("~~~~~~~~~~~~~ Інформація про клієнта ~~~~~~~~~~~~~");
        System.out.println("Ім'я: " + client.getName());
        System.out.println("Прізвище: " + client.getSurname());
        System.out.println("По батькові: " + client.getPatronymic());
        System.out.println("Кількість повних років: " + client.getAge());
        System.out.println("Номер карточки: " + client.getCardNumber());
        System.out.println("―――――――― Інформація по рахунках ――――――――");
        System.out.println("Гривнева карта: " + client.getCardAmountInHryvnias() + "₴.");
        System.out.println("Доларова картка: " + client.getCardAmountInDollars() + "$.");
        System.out.println("Євро картка: " + client.getCardAmountInDollars() + "€.\n");
        System.out.println("Сума гривень готівкою: " + client.getAmountInHryvnias() + "₴.");
        System.out.println("Сума доларів готівкою: " + client.getAmountInDollars() + "$.");
        System.out.println("Сума євро готівкою: " + client.getAmountInEuro() + "€.");
        System.out.println("―――――――― Інформація по кредиту ――――――――");
        System.out.println("Термін дії в роках: " + client.getLoanTerminInYears() + ".");
        System.out.println("Щомісячний платіж: " + client.getMonthlyPayment() + "₴.");
        System.out.println("Загальна сума платежів: " + client.getAmountLoan() + "₴.");
        System.out.println("Загальні відсотки: " + client.getTotalInterest() + "₴.");
        System.out.println("―――――――― Інформація по депозиту ――――――――");
        System.out.println("Сума депозиту: " + client.getDepositAmount() + "₴.");
        System.out.println("Відсоткова ставка: " + client.getDepositInterestRate() + "%");
        System.out.println("Термін депозиту: " + client.getDepositTermInMonths() + " місяців");
        System.out.println("Сума відсотків: " + client.getDepositAmountOfInterest() + "₴.");
        System.out.println("Загальна сума: " + client.getTotalAmountOfDeposit() + "₴.");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        return null;
    }
}