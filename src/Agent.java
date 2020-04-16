public class Agent extends Person {
    private double bonusForSelling = 0.12; // % month salary
    private double grossSalary;

    public Agent (String firstName, String lastName, String email, double grossSalary) {
        super(firstName, lastName, email);
        this.grossSalary = grossSalary;
    }

    public double getIncome(){
        return grossSalary * (1.0 + bonusForSelling);
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public double getBonusForSelling() {
        return bonusForSelling;
    }

    @Override
    public String toString() {
        return "[AGENT]" +
                "\nFirst name: "    + firstName     +
                "\nLast name: "     + lastName      +
                "\nEmail: "         + email         +
                "\nSalary "         + grossSalary;
    }

    public void setBonusForSelling(double newValue) {
        bonusForSelling = newValue;
    }
}
