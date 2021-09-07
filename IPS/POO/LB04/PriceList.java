import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PriceList {
    
    private static PriceList instance;
    private Map<ServiceType, Double> Services = new HashMap<>();

    private PriceList() {
    }
    
    public void addService(ServiceType a, double b) {
        Services.put(a, b);
    }
    
    public double getPrice(ServiceType a) {
       
         return Services.get(a);
        
    }
    
    public static PriceList getInstance() {
      if(instance == null) {
          
          instance = new PriceList();
      }
      return instance;
        
    }
      
}
