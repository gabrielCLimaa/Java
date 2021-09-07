public class AppTest {
    
    public static void main(String[] args) {
       
        ShippingCompany cp = new ShippingCompany("ALWAYS-MOVING");
        
        GroundTransportation g1 = new GroundTransportation("AAA-978");
        
        ShipTrasnportation s1 = new ShipTrasnportation("Nemo", 800);
        
        ShipTrasnportation s2 = new ShipTrasnportation("Everred",2000);
        
        Lorry l1 = new Lorry(200,1000,"BBB-111");
        
        Van v1 = new Van(200,"CCC-999");
        
        cp.add(g1);
        cp.add(s1);
        cp.add(s2);
        cp.add(l1);
        cp.add(v1);
        
        cp.toString();
        
    }
    
}
