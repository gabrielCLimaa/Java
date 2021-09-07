

public class Lorry extends GroundTransportation {
    private int numberOfPallets;
    private int trailers;
    
    public Lorry(int numberOfPallets, int trailers, String licensePlate) {
        super(licensePlate);
        this.numberOfPallets = numberOfPallets;
        this.trailers = trailers;
    }

    public Lorry(int numberOfPallets, int trailers, String licensePlate, String origin, String destination, double price, double fees, boolean available) {
        super(licensePlate, origin, destination, price, fees, available);
        this.numberOfPallets = numberOfPallets;
        this.trailers = trailers;
    }

    public int getNumberOfPallets() {
        return numberOfPallets;
    }

    public void setNumberOfPallets(int numberOfPallets) {
        this.numberOfPallets = numberOfPallets;
    }

    public int getTrailers() {
        return trailers;
    }

    public void setTrailers(int trailers) {
        this.trailers = trailers;
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
        str.append("\nPALLETS: "+ this.numberOfPallets);
        str.append("\nTrailers: "+ this.trailers);
        str.append("\nTOTAL-COST: " + this.getPriceWithFees());
        
        return str.toString();
        
    }
      
}
