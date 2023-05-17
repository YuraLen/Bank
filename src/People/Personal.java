package People;

public class Personal {
    /** Цей клас вважаєтся батьківским класом класів Specialist, Cashier1, Cashier2.
     * У цьому класі визначені загальні атрибути та методи, які можуть бути використані в цих підкласах.
     * */

    private String name;
    private String position;

    public Personal(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public void greeting() {
        System.out.printf("%s %s: Добрий день. Чим можу допомогти?\n", getPosition(), getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}