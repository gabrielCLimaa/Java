import java.util.HashSet;
import java.util.Set;

public class CarWashServices {
    private Set<Car> washes = new HashSet<>();

    public CarWashServices() {
    }
    
    public boolean addCar(Car car) {
        if(!washes.contains(car)) { 
            washes.add(car);
            return true;
        } else {
            return false;
        }
    }
    
     public boolean removeCar(Car car) {
        if(washes.contains(car)) { 
            washes.remove(car);
            return true;
     } else {
        return false;
      }
    }
    
}
