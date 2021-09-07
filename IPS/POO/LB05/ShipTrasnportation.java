
public class ShipTrasnportation extends Transport{
    private String name;
    private int numberOfContainers;

    public ShipTrasnportation(String name, int numberOfContainers) {
        this.name = name;
        this.numberOfContainers = numberOfContainers;
    }

    public ShipTrasnportation(String name, int numberOfContainers, String origin, String destination, double price, double fees, boolean available) {
        super(origin, destination, price, fees, available);
        this.numberOfContainers = numberOfContainers;
        this.name = name;
    }
     
    @Override
    public void setFees(double fees) {
        super.setFees(this.getPrice() * 0.025);
    }
    
    @Override
    public String getTransportType() {
        return "ShipTransportation";
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfContainers() {
        return numberOfContainers;
    }

    public void setNumberOfContainers(int numberOfContainers) {
        this.numberOfContainers = numberOfContainers;
    }
    
    @Override
    public String toString() { 
        StringBuilder str = new StringBuilder();
        str.append("\nTRANSPORTATION-TYPE: " + this.getTransportType());
        str.append("\nID: " + super.getId());
        str.append("\nORIGIN: " + super.getOrigin() );
        str.append("\nDESTINATION: "+ super.getDestination());
        str.append("\nPRICE: "+ super.getPrice());
        str.append("\nFEES: "+ super.getFees());
        str.append("\nAVAILABLE: "+ super.isAvailable());
        str.append("\nNAME: "+ this.name);
        str.append("\nNUMBEROFCONTAINERS "+ this.numberOfContainers);
        str.append("\nTOTAL-COST: " + this.getPriceWithFees());
        
        return str.toString();
        
    }
    
    
}
