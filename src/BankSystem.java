import People.Cashier1;
import People.Cashier2;
import People.Client;
import People.Specialist;

import java.util.Scanner;

public class BankSystem {
    /** У цьокму класі відбувається збірка проекту. Підтягування осонвних класів та ініціалізація певних данних  */

    public void start(){
        Scanner scanner = new Scanner(System.in);
        Client client = new Client();
        Specialist specialist = new Specialist("Іван", "Спеціаліст відділення", client);
        Cashier1 cashier1 = new Cashier1("Сергій", "Касир", client);
        Cashier2 cashier2 = new Cashier2("Олександ", "Касир", client);

        System.out.println("Адміністратор: Добрий день. Вітаємо Вас в нашому відділені ПриватБанку!");
        System.out.println();

        boolean isInsideBank = true;
        while (isInsideBank) {
            System.out.println("-------------- Виберіть подальшу дію: --------------");
            System.out.println("1. Звернутися до Спеціаліста відділення (відкриття рахунку / отримати виписку з банку);");
            System.out.println("2. Звернутися до Каси 1 (перекази / обмін валюти);");
            System.out.println("3. Звернутися до Каси 2 (кредит / депозит);");
            System.out.println("4. Вийти з банку.");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    specialist.work();
                    break;
                case 2:
                    cashier1.work(client);
                    break;
                case 3:
                    cashier2.work(client);
                    break;
                case 4:
                    System.out.println("Дякуємо, що обрали наш банк. Заходьте ще!");
                    isInsideBank = false;
                    break;
                default:
                    System.out.println("Неправильна команда.");
                    break;
            }
        }
    }
}