import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.stream.Stream;

public class Invoice {
    private int invoiceNumber;
    private Date invoiceDate;
    private static int number;

    public Invoice() {
        this.invoiceNumber = ++number;
        this.invoiceDate =  new Date();
    }

    ArrayList<InvoiceLine> line = new ArrayList();

    public InvoiceLine addLine(String produto,double precoU,double quantidade,boolean saldO) {
        InvoiceLine obj = new InvoiceLine(produto,precoU,quantidade,saldO);
        line.add(obj);
        return obj;
    }

    public void removeLine(int linha) {
        Iterator<InvoiceLine> it =line.iterator();

        while(it.hasNext()) {
            InvoiceLine record = it.next();
            if(record.getNumber() == linha) {
                it.remove();
            }
        }
    }

    @Override
    public String toString() {
        System.out.print("Invoice number: "+invoiceNumber +"\r\n");
        System.out.print(invoiceDate+"\r\n");
        System.out.print("---Invoice Lines---"+"\r\n");
        System.out.print("Number "+"|Product "+ "|Unit Price "+ "|Quantity "+ "|On Sales " + "|Total "+"\r\n");
        for(InvoiceLine record : line){
            System.out.println(record.toString()+"\r\n");
        }
        System.out.print("Valor Total Fatura:  "+getTotal() +"\r\n");
        System.out.print("Valor Total em Promoção:  "+getTotalOnSale() +"\r\n");
        return null;

    }

    public double getTotal() {
        double gastoTotal = 0;
        for(InvoiceLine record : line){
            double gasto = record.getTotal(record.getUnitPrice(), record.getQuantity());

            gastoTotal += gasto;
        }
        return gastoTotal;
    }

    public Stream<InvoiceLine> getProductOnSale() {
        return line.stream()
                .filter(record -> record.isOnSale());

    }

    public double getTotalOnSale() {
        double gastoPromo = 0;
        for(InvoiceLine record : line ) {
            if(record.isOnSale()){
                gastoPromo =  record.getTotal(record.getUnitPrice(),record.getQuantity());
            }
        }
        return gastoPromo;
    }

}
