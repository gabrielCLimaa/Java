/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.group;

/**
 *
 * @author gabri
 */
public class RelogioData {
    private int hora;
    private int minuto;
    private int segundo;
    
    public RelogioData() {
        this.hora = 0;
        this.minuto = 0;
        this.segundo = 0;
    }
    
    public void showTime() {
        String hora = String.valueOf(this.hora);
        String minuto = String.valueOf(this.minuto);
        String segundo = String.valueOf(this.segundo);

        if(this.hora < 10) 
           hora = "0" + hora + ":";
        if(this.minuto < 10) 
            minuto = "0" + minuto + ":";
        if(this.segundo < 10)
            segundo = "0" + segundo + "\n";
        if(this.hora >= 10 ) 
             hora = hora + ":" ;
        if(this.minuto >= 10 ) 
            minuto = minuto + ":" ;
        if(this.segundo >= 10 ) 
            segundo = segundo + "\n";

        System.out.println(hora + minuto + segundo);
    }
    
    public String getTime() {
        return this.hora + ":" + this.minuto;
    }
    
    public void incrementSegundo() {
        this.segundo++;
    }
    
    public void incrementMinuto() {
        this.minuto++;
    }
    
    public void incrementHora() {
        this.hora++;
    }

    public int getHora() {
        return hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public int getSegundo() {
        return segundo;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public void setSegundo(int segundo) {
        this.segundo = segundo;
    }
    
}
