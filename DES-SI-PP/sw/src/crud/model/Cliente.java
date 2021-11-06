/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud.model;

import java.util.Date;

/**
 *
 * @author gabri
 */
public class Cliente {
    private int id;
    private String clientNome;
    private String address;
    private Date date;
    private int status;

    public Cliente(int id, String clientNome, String address, Date date, int status) {
        this.id = id;
        this.clientNome = clientNome;
        this.address = address;
        this.date = date;
        this.status = status;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClientNome() {
        return clientNome;
    }

    public void setClientNome(String clientNome) {
        this.clientNome = clientNome;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date.toString();
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return this.id + "-" + this.clientNome + "-" + this.address + "-" + this.date + "-" + this.status; 
    }
    
}
