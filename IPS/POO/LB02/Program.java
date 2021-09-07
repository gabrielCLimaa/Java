public class Program {
    public static void main(String[] args) {
        Invoice G1 = new Invoice();
        G1.addLine( "MEMORIA", 200.0, 2.0, false);
        G1.addLine( "PC", 199.0, 1.0, true);
        G1.toString();
    }
}
