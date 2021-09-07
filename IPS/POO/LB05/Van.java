

public class Van extends GroundTransportation {
    private int packages;
   
    public Van(int packages, String licensePlate) {
        super(licensePlate);
        this.packages = packages;
    }

    public Van(int packages, String licensePlate, String origin, String destination, double price, double fees, boolean available) {
        super(licensePlate, origin, destination, price, fees, available);
        this.packages = packages;
    }

    public int getPackages() {
        return packages;
    }

    public void setPackages(int packages) {
        this.packages = packages;
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
        str.append("\nLICENSE PLATE: "+ super.getLicensePlate());
        str.append("\nPACKAGES: "+ this.packages);
        str.append("\nTOTAL-COST: " + this.getPriceWithFees());
        
        return  str.toString();
        
    }
    
     
    
}
