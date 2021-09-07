public class InvoiceLine {
    private static int n;
    private int number;
    private String product;
    private double unitPrice;
    private double quantity;
    private boolean onSale;

    public InvoiceLine(String product, double unitPrice, double quantity, boolean onSale) {
        this.product = product;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.onSale = onSale;
        this.number = ++n;
    }

    @Override
    public String toString() {
        return getNumber() + "  |  "  + getProduct() + "  |  " + getUnitPrice() + "  |  "+ getQuantity() + "  |  " + isOnSale() + "  |  " + getTotal(getUnitPrice(),getQuantity());
    }

    public double getTotal(double unitPrice, double quantity) {

        double total = unitPrice * quantity;
        return total;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

}
