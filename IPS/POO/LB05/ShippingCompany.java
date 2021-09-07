
import java.util.ArrayList;
import java.util.HashSet;

public class ShippingCompany extends  HashSet<Transport> {
    private String name;
    private ArrayList<Transport> inService = new ArrayList<Transport>();

    public ShippingCompany(String name) {
        this.name = name;
    }
    
    public void makeTrasportation(String id,String origin,String destination,double price) {
        for(Transport obj : this) {
            if(obj.getId()== id && obj.isAvailable()) {
                obj.setDestination(destination);
                obj.setOrigin(origin);
                obj.setAvailable(false);
                inService.add(obj);
                this.remove(obj);
            }
        }
        
    }
    
    public void finalizeTransportation(String id) {
        for(Transport obj : inService) {
            if(obj.getId()== id) {
                obj.setDestination("");
                obj.setOrigin("");
                obj.setAvailable(true);
                obj.setPrice(0);
                this.add(obj);
                inService.remove(obj);
            }
        }      
    }
        
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Transport> getInService() {
        return inService;
    }

    public void setInService(ArrayList<Transport> inService) {
        this.inService = inService;
    }

    @Override
    public String toString() {
        for(Transport obj : this) {
            System.out.println(obj.toString());
        }
        return "";
    }

}
