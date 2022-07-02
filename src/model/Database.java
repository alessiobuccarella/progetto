package model;

import model.Profilo;

import javax.swing.*;
import java.sql.*;

public class Database {
    public static boolean valido, valido2;
    Profilo profilo = new Profilo();
    public void updateDB(String nick, String img) {
        if (nick.equals("") || nick.equals(null)) {
            JOptionPane.showMessageDialog(null, "Nickname Obbligatorio");
            valido = false;
            valido2 = false;
        } else {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jUno", "root", "AlessioFabio");
                Statement statement = connection.createStatement();
                try {
                    String query1 = "INSERT INTO jUno.Profilo"
                                  + " (`nickname`, `avatar`)"
                                  + " VALUES ('"+nick+"','"+img+"')";
                    statement.executeUpdate(query1);
                    connection.close();
                    valido = true;
                    valido2 = true;

                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Nickname già in uso");
                    System.out.println(e1);
                }
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "e2: " + e2);
                System.out.println(e2);
            }
        }
    }
}