import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class Extenstion implements Serializable {
    private static long serialVersionUID;

    //https://edux.pjwstk.edu.pl/mat/205/lec/Wyklad-MAS-nr-03.html
    private static Map<Class, List<Extenstion>> allExtents = new Hashtable<>();

    public Extenstion() {
        List extent = null;
        Class theClass = this.getClass();

        if(allExtents.containsKey(theClass)) {
            // An extent of this class already exist
            extent = allExtents.get(theClass);
        }
        else {
            // An extent does not exist - create a new one
            extent = new ArrayList();
            allExtents.put(theClass, extent);
        }

        extent.add(this);
    }

//    private void add(Extenstion ex) {
//        extent.add(ex);
//    }
//
//    private void remove(Extenstion ex) {
//        extent.remove(ex);
//    }

    public static void writeExtents(ObjectOutputStream stream) throws IOException {
        stream.writeObject(allExtents);
    }

    public static void readExtents(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        allExtents = (Hashtable) stream.readObject();
    }

    public static void showExtent(Class theClass) throws Exception {
        List extent = null;

        if(allExtents.containsKey(theClass)) {
            // Extent of this class already exist
            extent = allExtents.get(theClass);
        }
        else {
            throw new Exception("Unknown class " + theClass);
        }
        System.out.println("Extenstion of the class: " + Extenstion.class.getName());
        for (Object ex : extent) {
            System.out.println(ex);
        }
    }
}
