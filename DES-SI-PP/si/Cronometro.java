/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.group;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabri
 */
public class Cronometro implements Runnable {
    private CronometroData cronometroData;

    public Cronometro(CronometroData cronometroData) {
        this.cronometroData = cronometroData;
    }

    @Override
    public void run() {
        System.out.println("THREAD CRONOMETRO ONLINE");
        while(true){
            try {
                   Thread.sleep(1000);
               } catch (InterruptedException ex) {
                   Logger.getLogger(Relogio.class.getName()).log(Level.SEVERE, null, ex);
               }
            if(this.cronometroData.getStopOption() == false) {
               cronometroData.incrementSegundo();
               if(cronometroData.getSegundo() == 60) {
                   cronometroData.setSegundo(0);
                   cronometroData.incrementMinuto();
               }
               if(cronometroData.getMinuto() == 60) {
                   cronometroData.setMinuto(0);
                   cronometroData.incrementHora();
               }          
            }  
        }
    }
}
