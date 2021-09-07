

public class Transport {
    private String id;
    private static int number = 000;
    private String origin;
    private String destination;
    private double price;
    private double fees;
    private boolean available;
    
    public Transport() {
        this.id = "T-00"+ ++number;
        this.origin = "";
        this.destination = "";
        this.fees = 0;
        this.price = 0;
        this.available = true;
    }

    public Transport(String origin, String destination, double price, double fees, boolean available) {
        this.origin = origin;
        this.destination = destination;
        this.price = price;
        this.fees = fees;
        this.available = available;
    }

    public double getPriceWithFees() {
        return this.getFees() + this.getPrice();
    }
    
    public String getTransportType() {
        return "";
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static int getNumber() {
        return number;
    }

    public static void setNumber(int number) {
        Transport.number = number;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() { 
        StringBuilder str = new StringBuilder();
        str.append("\nTRANSPORTATION-TYPE: " + this.getTransportType());
        str.append("\nID: " + this.id);
        str.append("\nORIGIN: " + this.origin );
        str.append("\nDESTINATION: "+ this.destination);
        str.append("\nPRICE: "+ this.price);
        str.append("\nFEES: "+ this.fees);
        str.append("\nAVAILABLE: "+ this.available);
        str.append("\nTOTAL-COST: " + this.getPriceWithFees());

        return str.toString();
        
    }
    
    
}
