public class Agent extends Worker {
//    private double bonusForSelling = 0.12; // % month salary
    private String agentNo;
//    private double grossSalary;

    public Agent(String firstName, String lastName, String email, int age, String agentNo) {
        super(firstName, lastName, email, age);
        this.agentNo = agentNo;
//        this.grossSalary = grossSalary;
    }



    @Override
    public String toString() {
        return "Agent{" +
                "agentNo='" + agentNo + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                "}\n";
    }
//    public static double findTheHighestSalary() throws ClassNotFoundException {
//        double theBiggestSalary = 0.00;
//        try {
//            Iterable<Agent> agents = Extenstion.getExtent(Agent.class);
//            for(Agent agent: agents) {
//                theBiggestSalary = theBiggestSalary > agent.getGrossSalary() ? theBiggestSalary : agent.getGrossSalary();
//            }
//        } catch(ClassNotFoundException e) {
//
//        }
//        return theBiggestSalary;
//    }
}
