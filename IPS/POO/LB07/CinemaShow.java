

public class CinemaShow extends ShowTicket implements Exchangeable, Promotion {
    private String movieName;
    private String cinemaRoom;
    private boolean glasses3D;
    private float discountPorcentage;

    public CinemaShow() {
        super();
        this.movieName = "";
        this.cinemaRoom = "";
        this.glasses3D = false;
        this.discountPorcentage = 0.0F;
    }

    public CinemaShow(String movieName, String cinemaRoom, boolean glasses3D, String place, String session, float price, String seatNumber) {
        super(place, session, price, seatNumber);
        this.movieName = movieName;
        this.cinemaRoom = cinemaRoom;
        this.glasses3D = glasses3D;
        getDiscountedPrice();
    }
    
    @Override
    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    @Override
    public String getCinemaRoom() {
        return cinemaRoom;
    }

    public void setCinemaRoom(String cinemaRoom) {
        this.cinemaRoom = cinemaRoom;
    }

    public boolean isGlasses3D() {
        return glasses3D;
    }

    public void setGlasses3D(boolean glasses3D) {
        this.glasses3D = glasses3D;
    }

    public float getDiscountPorcentage() {
        return discountPorcentage;
    }

    public void setDiscountPorcentage(float discountPorcentage) {
        this.discountPorcentage = discountPorcentage;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append(String.format("Cinem room: %s, Movie name: %s, 3D glasses: %b, Discount: %f ", cinemaRoom, movieName, glasses3D,discountPorcentage));

        return sb.toString();
    }
    
     @Override
     public float getFinalPrice() {
        if(isGlasses3D()) {
           this.setPrice(this.getPrice() + 1.50F);
        }
        return getPrice();
     }

    @Override
    public void toExchange(Ticket ticket) {
        if(this.getTicketType().equals(ticket.getTicketType()) && this.getMovieName().equals(ticket.getMovieName()) && this.getCinemaRoom().equals(ticket.getCinemaRoom()) && this.getSession().equals(ticket.getSession())) {
            this.setSeatNumber(ticket.getSeatNumber());
        }
    }
    
    @Override
    public String getTicketType() {
      return "CinemaShow";
    }

    @Override
    public void applyDiscount(float discount) {
        this.setDiscountPorcentage(discount);
    }

    @Override
    public float getDiscountedPrice() {
     float discount = this.getDiscountPorcentage()/100 * this.getPrice();
     this.setPrice(this.getFinalPrice() - discount);
     return  this.getPrice();
    }
    
    
}
