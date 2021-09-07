import java.util.HashSet;
import java.util.Set;

public final class Service {
    private Set<ServiceType> services = new HashSet<>();
    private Car car;
    private boolean prk;
    
    public Service(Car car, boolean prk) {
        this.car = car;
        this.prk = prk;
        if(prk){
            addServicePrk();
            addServiceWas();
        } else {
            addServiceWas();
        }
    }

    public boolean isPrk() {
        return prk;
    }
  
    public Car getCar() {
        return car;
    }
    
    private void addServicePrk() {
        services.add(ServiceType.PARKING);
    }
    
    private void addServiceWas() {
        services.add(ServiceType.CARWASH);
    }
    
    public double getPrice() {
    double valor = 0;
        for(ServiceType servicos : services) {
            valor =  PriceList.getInstance().getPrice(servicos.CARWASH);
            if(prk) {
                valor +=  PriceList.getInstance().getPrice(servicos.PARKING);
            }
        }
        
        return valor;
    }
}
