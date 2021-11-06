/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.group;

/**
 *
 * @author gabri
 */
public class Alarme implements Runnable {
    
    private RelogioData data;
    private AlarmeData alarmeData;
   
    public Alarme(RelogioData data, AlarmeData alarmeData) {
        this.data = data;
        this.alarmeData = alarmeData;
    }
   
    @Override
    public void run() {
        System.out.println("THREAD ALARME ONLINE");
        this.alarmeData.setIsActive(true);
        while(true) {
             if(data.getTime().equalsIgnoreCase(this.alarmeData.getHora() + ":"
                     + this.alarmeData.getMinuto())) {
                 System.out.println("ALARME ALARME ALARME ALARME");
                 System.out.println("ALARME ALARME ALARME ALARME");
                 System.out.println("ALARME ALARME ALARME ALARME");
                 System.out.println("");
                 this.alarmeData.setIsActive(false);
                 break;
             }
        }
    }
}
