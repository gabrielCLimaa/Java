
public class Product implements Promotion {
    private float price;
    private String name;
    private float discountPorcentage;

    public Product(float price, String name) {
        this.price = price;
        this.name = name;
        this.discountPorcentage = 0.0F;
        getDiscountedPrice();
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        sb.append(String.format("Price %f, Name: %s,Discount: %f ", price,name,discountPorcentage));
    
        return sb.toString();
    }

    @Override
    public void applyDiscount(float discount) {
         this.setDiscountPorcentage(discount);
    }

    @Override
    public float getDiscountedPrice() {
     this.setPrice(this.getPrice() - (this.getDiscountPorcentage()/100 * this.getPrice()));
     return  this.getPrice();
    }
    
    
    
}
