
public class AirplaneTicket extends Ticket implements Exchangeable {
    private String flightNumber;
    private float feeAmount;

    public AirplaneTicket(String flightNumber, float feeAmount, float price, String seatNumber) {
        super(price, seatNumber);
        this.flightNumber = flightNumber;
        this.feeAmount = feeAmount;
    }

    @Override
    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public float getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(float feeAmount) {
        this.feeAmount = feeAmount;
    }

    @Override
     public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(String.format("Flight number %s, Fee amount: %f ", flightNumber, feeAmount));
    
        return sb.toString();
    }        
    
    @Override
    public float getFinalPrice() {
        return 0;
    }

    @Override
    public String getTicketType() {
         return "AirplaneTicket";
    }

    @Override
    public void toExchange(Ticket ticket) {
      if(this.getTicketType().equals(ticket.getTicketType())&& this.getFlightNumber().equals(ticket.getFlightNumber())) {
          this.setSeatNumber(ticket.getSeatNumber());
      }
    }
}
