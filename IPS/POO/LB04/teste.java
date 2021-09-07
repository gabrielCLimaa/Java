import java.time.LocalDate;
import java.time.ZoneId;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class teste {
    public static void main(String[] args) {
        
        Set<Car> cars = new HashSet<>();
        
         cars.add(new Car("80-AA-AA", LocalDate.now(), "Renault", "Clio"));
         cars.add(new Car("81-AA-AA", LocalDate.now(), "Renault", "Clio"));
         cars.add(new Car("82-AA-AA", LocalDate.now(), "Renault", "Clio"));
         cars.add(new Car("83-AA-AA", LocalDate.now(), "Renault", "Clio"));
         cars.add(new Car("84-AA-AA", LocalDate.now(), "Renault", "Clio"));
         cars.add(new Car("85-AA-AA", LocalDate.now(), "Renault", "Clio"));
         cars.add(new Car("86-AA-AA", LocalDate.now(), "Renault", "Clio"));
         cars.add(new Car("87-AA-AA", LocalDate.now(), "Renault", "Clio")); 
        
         for(Car carros : cars) {
            System.out.println(">>"+carros.toString());
         }        
        

           PriceList.getInstance().addService(ServiceType.CARWASH, 25.0);
           PriceList.getInstance().addService(ServiceType.PARKING, 10.0);
           
           Service carro2 = new Service(new Car("99-Aa-BB", LocalDate.now(), "PORCHE", "BOXTER"),false);
           
           ServiceManagement AP = new ServiceManagement();
           
           AP.addService(carro2);
           
           AP.closeService(carro2);
                   
    }
    
}
