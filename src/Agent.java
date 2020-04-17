public class Agent extends Worker {
    private double bonusForSelling = 0.12; // % month salary
    private double grossSalary;

    public Agent (String firstName, String lastName, String email, int age, double grossSalary) {
        super(firstName, lastName, email, age);
        this.grossSalary = grossSalary;
    }

    @Override
    public String toString() {
        return  "\tFirst name: "    + firstName     +
                "\n\tLast name: "     + lastName      +
                "\n\tEmail: "         + email         +
                "\n\tSalary "         + grossSalary;
    }

//  Getters
    public double getIncome(){
        return grossSalary * (1.0 + bonusForSelling);
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public double getBonusForSelling() {
        return bonusForSelling;
    }

//  Setters
    public void setBonusForSelling(double newValue) {
        bonusForSelling = newValue;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public static double findTheHighestPaidAgent() throws ClassNotFoundException {
        Iterable<Agent> agents = Extenstion.getExtent(Agent.class);
        double theBiggestSalary = 0.00;
        for(Agent agent: agents) {
            theBiggestSalary = theBiggestSalary > agent.getGrossSalary() ? theBiggestSalary : agent.getGrossSalary();
        }
        return theBiggestSalary;
    }
}
