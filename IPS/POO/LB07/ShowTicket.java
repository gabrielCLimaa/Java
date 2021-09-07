

public class ShowTicket extends Ticket {

    private String place;
    private String session;

    public ShowTicket() {
        this.place = "";
        this.session = "";
    }
    public ShowTicket(String place, String session, float price, String seatNumber) {
        super(price, seatNumber);
        this.place = place;
        this.session = session;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append(String.format("Place: %s, Session: %s ", place, session));

        return sb.toString();
    }

    @Override
    public float getFinalPrice() {
       return 0;
    }

    @Override
    public String getTicketType() {
      return "";
    }

}
