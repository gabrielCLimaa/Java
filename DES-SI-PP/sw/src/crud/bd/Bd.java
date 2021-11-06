/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gabri
 */
public class Bd {
    private final String url = "jdbc:mysql://localhost:3306/teste";
    private final String login =  "root";
    private final String senha = "12321";
    private Connection con = null;

    public Connection getCon() throws SQLException {
        System.out.println("Conexão aberta com sucesso");
        return this.con = DriverManager.getConnection(url,login,senha);
    }

   public void closeCon() throws SQLException {
       this.con.close();
       System.out.println("Conexão fechada com sucesso");
   }
    
}
