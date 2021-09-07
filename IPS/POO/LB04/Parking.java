import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Parking {
    private int place;
    private Car car;
    public Map<Integer,Car> parking = new HashMap<>();

    public Parking() {
    }

    public void addCar(int place, Car car) {
        if (!parking.containsValue(car)) {
            parking.put(place, car);
        }
    }

    public void removerCar(Car car) {
        if(parking.containsValue(car)) {
            parking.remove(car);
        }
    }

    public void show() {

        Iterator it = parking.keySet().iterator();
        while(it.hasNext()){
            System.out.println(">"+ it.next());
        }

        it = parking.values().iterator();
        while(it.hasNext()) {
            System.out.println(">"+ it.next());

        }

    }

}
