import java.time.LocalDate;
import java.util.*;

public class AgentAgency<K, V> {
    private LocalDate data_from;
    private LocalDate data_to;
    private Agent agent;
    private Agency agency;

    private Map<Class<K>, List<Class<V>>> association = new HashMap<>();


    public AgentAgency(LocalDate data_from, LocalDate data_to, Agent agent, Agency agency) {
        this.data_from = data_from;
        this.data_to = data_to;
        this.agent = agent;
        this.agency = agency;
    }

    public <K,V> void createAssociation(Class<K> class1, Class<V> class2) {
        if(association.containsKey(class1)) return;
        List<V> list = association.values();
        list.add((V) class2);
        association.put(class1, list);
    }

    @Override
    public String toString() {
        return "AgentAgency{" +
                "data_from=" + data_from +
                ", data_to=" + data_to +
                ", \n    agent=" + agent +
                "\n    agency=" + agency +
                '}';
    }
}
