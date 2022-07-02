package model;

import javax.swing.*;
import java.sql.*;

public class Database {
    public static boolean valido, valido2, valido3;
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

    public void updateDB2(String nick) {
        if (nick.equals("") || nick.equals(null)) {
            JOptionPane.showMessageDialog(null, "Nickname Obbligatorio");
            valido3 = false;
        } else {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jUno", "root", "AlessioFabio");
                try {
                    String query2 = "SELECT * FROM jUno.Profilo"
                                  + " WHERE nickname = '"+nick+"'";
                    Statement statement = connection.prepareStatement(query2);
                    ResultSet rs = statement.executeQuery(query2);
                    while (rs.next()) {
                        valido3 = true;
                    }
                    connection.close();
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "e1");
                    System.out.println(e1);
                }
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "e2: " + e2);
                System.out.println(e2);
            }
        }
    }
}