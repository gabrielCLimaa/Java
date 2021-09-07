
import java.util.ArrayList;

public class AppTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CinemaShow c1= new CinemaShow("batman","e.4",true,"a23","sessio 1",45F,"46"); 
        CinemaShow c2= new CinemaShow("batman","e.4",false,"a24","sessio 1",45F,"46"); 
        
        TheaterShow t1= new TheaterShow("gg",true,"43D","500",30F,"23");
        TheaterShow t2= new TheaterShow("gg",false,"44D","500",30F,"23");
        
        AirplaneTicket a1 = new AirplaneTicket("123",200F,1500F,"35");
        AirplaneTicket a2 = new AirplaneTicket("444",450F,2500F,"01");
        
        ArrayList<Ticket> lista = new ArrayList();
        lista.add(c1);
        lista.add(c2);
        lista.add(t1);
        lista.add(t2);
        lista.add(a1);
        lista.add(a2);
        
        for(Ticket obj : lista) {
            System.out.println(obj.toString());
        }
        
        System.out.println("depois");
        
        lista.add(c1);
        lista.set(0, lista.get(1));
        lista.set(1, lista.get(6));
        lista.remove(6);
        
        for(Ticket obj : lista) {
            System.out.println(obj.toString());
        }
        
        System.out.println("------------------------");
        
        Product p1 = new Product(5000F,"Ps5");
        Product p2 = new Product(12.000F,"Iphone");
       
        ArrayList<Promotion> lista2 = new ArrayList();
        lista2.add(c1);
        lista2.add(c2);
        lista2.add(t1);
        lista2.add(t2);
        lista2.add(p1);
        lista2.add(p2);
        
        for(Promotion obj : lista2) {
            System.out.println(obj.getDiscountedPrice());
        }
        
        System.out.println("Apos desconto");
        
        for(Promotion obj : lista2) {
            obj.applyDiscount(10);
            System.out.println(obj.getDiscountedPrice());
        }
        
        
    }
    
}
