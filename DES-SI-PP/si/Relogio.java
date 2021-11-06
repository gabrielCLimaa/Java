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
public class Relogio implements Runnable {
    private RelogioData data;
    
    public Relogio(RelogioData data) {
        this.data = data;
    }
    
    @Override
    public void run() {
        System.out.println("THREAD RELOGIO ONLINE");
        while(true) {
            data.incrementSegundo();
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Relogio.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(data.getSegundo() == 60) {
                data.setSegundo(0);
                data.incrementMinuto();
            }
            if(data.getMinuto() == 60) {
                data.setMinuto(0);
                data.incrementHora();
            }          
            
            if(data.getHora() == 24) {
                data.setHora(0);
            }
            
        }
    }
    
}
