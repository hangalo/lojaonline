/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojaonline.bd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author praveen
 */
public class ConnectionFactory {

    public static Connection getConnection() {
        Connection con;
        String url = "jdbc:mysql://localhost:3306/bd_loja";
        String driver = "com.mysql.jdbc.Driver";
        String user = "root";
        String password = "root";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("Erro: Driver ou Bd nao encontrada" + ex);
            return null;
        }
        return con;

    }

}
