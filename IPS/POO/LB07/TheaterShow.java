

public class TheaterShow extends ShowTicket implements Exchangeable,Promotion {
    private String playName;
    private boolean balcony;;
    private float discountPorcentage;
    
    public TheaterShow() {
        this.playName = "";
        this.balcony = false;
        this.discountPorcentage = 0.0F;
    }

    public TheaterShow(String playName, boolean balcony, String place, String session, float price, String seatNumber) {
        super(place, session, price, seatNumber);
        this.playName = playName;
        this.balcony = balcony;
        this.discountPorcentage = discountPorcentage;
        getDiscountedPrice();
    }
    
    @Override
    public String getPlayName() {
        return playName;
    }

    public void setPlayName(String playName) {
        this.playName = playName;
    }

    public boolean isBalcony() {
        return balcony;
    }

    public void setBalcony(boolean balcony) {
        this.balcony = balcony;
    }

    public float getDiscountPorcentage() {
        return discountPorcentage;
    }

    public void setDiscountPorcentage(float discountPorcentage) {
        this.discountPorcentage = discountPorcentage;
    }
    
     @Override
     public float getFinalPrice() {
        if(isBalcony()) {
           this.setPrice(this.getPrice() + 10.0F);
        }
        return getPrice();
     }
     
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append(String.format("Play name: %s,Balcony: %b, Discount: %f ", playName, balcony,discountPorcentage));

        return sb.toString();
    }
    
     @Override
    public String getTicketType() {
      return "TheaterShow";
    }
    
    @Override
    public void toExchange(Ticket ticket) {
        if(this.getTicketType().equals(ticket.getTicketType()) && this.getPlayName().equals(ticket.getPlayName()) && this.getSession().equals(ticket.getSession())) {   
            this.setSeatNumber(ticket.getSeatNumber());
        }
    }

    @Override
    public void applyDiscount(float discount) {
       this.setDiscountPorcentage(discount);
    }

    @Override
    public float getDiscountedPrice() {
     float discount = (this.getDiscountPorcentage()/100) * this.getPrice();
     this.setPrice(this.getFinalPrice() - discount);
     return  this.getPrice();
    }
    
  
    
    
    
}
