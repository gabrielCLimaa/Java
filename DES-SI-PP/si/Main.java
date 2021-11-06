/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.group;

import java.util.Scanner;

/**
 *
 * @author gabri
 */
public class Main {
    public static void main(String[] args){
        System.out.println("THREAD PRINCIPAL ONLINE");
        RelogioData data = new RelogioData();
        AlarmeData alarmeData = new AlarmeData();
        CronometroData cronometroData = new CronometroData();
        
        Thread time = new Thread(new Relogio(data));
        Thread alarme = new Thread(new Alarme(data,alarmeData));
        
        time.start();
        
        Scanner in = new Scanner(System.in);
        
        int option;
        boolean firstTimeCronometro = true;
        boolean firstTimeAlarme = true;
        
        while(true) {
            System.out.println("0) Sair");
            System.out.println("1) Ver horario");
            System.out.println("2) Iniciar cronometro");
            System.out.println("3) Parar cronometro");
            System.out.println("4) Zerar cronometro");
            System.out.println("5) Definir alarme");
            System.out.println("6) Ajustar horario");
            option = in.nextInt();
            
            switch(option) {
                case 0 : System.exit(0);
                    break;
                    
                case 1: data.showTime();
                    break;
                    
                case 2: 
                    if(firstTimeCronometro) {
                        Thread cronometro = new Thread(new Cronometro(cronometroData));
                        cronometro.start();
                        firstTimeCronometro = false;
                    }
                    cronometroData.resetFirstTime();
                    break;
                    
                case 3: cronometroData.stopTime();
                        cronometroData.show();
                    break;
                    
                case 4: cronometroData.reset();
                    break;
                    
                case 5: in.nextLine();
                        System.out.println("Informe o alarme em formato Hh:Mm");
                        String[] vetorAlarme = in.nextLine().split("\\:");
                        alarmeData.setHora(Integer.valueOf(vetorAlarme[0]));
                        alarmeData.setMinuto(Integer.valueOf(vetorAlarme[1]));
                        if(firstTimeAlarme) {
                            alarme.start();
                            firstTimeAlarme = false;
                        } else if(!alarmeData.isIsActive()) {
                            alarme.interrupt();
                            alarme = new Thread(new Alarme(data,alarmeData));
                            alarme.start();
                        }
                    break;
                 
                case 6: in.nextLine();
                        System.out.println("Informe o novo horario em formato Hh:Mm:Ss");
                        String[] vetorHorario = in.nextLine().split("\\:");
                        data.setHora(Integer.valueOf(vetorHorario[0]));
                        data.setMinuto(Integer.valueOf(vetorHorario[1]));
                        data.setSegundo(Integer.valueOf(vetorHorario[2]));
                    break;
            }
        }
    }
}
