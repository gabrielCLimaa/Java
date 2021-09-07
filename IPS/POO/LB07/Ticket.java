

public abstract class Ticket {
    
    private float price;
    private String seatNumber;

    public Ticket() {
        this.price = 0.0F;
        this.seatNumber = "";
    }
    
    public Ticket(float price, String seatNumber) {
        this.price = price;
        this.seatNumber = seatNumber;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }
    
    public abstract float getFinalPrice();
    public abstract String getTicketType();
    
    public String getPlayName() {
        return "";
    }

     public String getSession() {
        return "";
    }
    
    public String getMovieName() {
        return "";
    } 
    
    public String getCinemaRoom() {
        return "";
    } 
    
    public String getFlightNumber() {
        return "";
    }
            
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        
        sb.append(String.format("(%s)-Price: %8.2f€, Seat Number: %s ",getTicketType(), price, seatNumber));
    
        return sb.toString();
    }        
    
}
