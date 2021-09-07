

public class GroundTransportation extends Transport {
    private String licensePlate;
    
    public GroundTransportation(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public GroundTransportation(String licensePlate, String origin, String destination, double price, double fees, boolean available) {
        super(origin, destination, price, fees, available);
        this.licensePlate = licensePlate;
    }
    
    @Override
    public void setFees(double fees) {
        super.setFees(this.getPrice() * 0.03);
    }
    
    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    
    @Override
    public String getTransportType() {
        return "GroundTransportation";
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
        str.append("\nLICENSE PLATE: "+ this.licensePlate);
        str.append("\nTOTAL-COST: " + this.getPriceWithFees());
        
        return str.toString();
        
    }
    
}
