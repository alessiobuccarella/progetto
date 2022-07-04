package model;

import javax.swing.*;
import java.sql.*;

public class Database {
    public static boolean valido, valido2, valido3;
    public static String nomeProfilo, fotoProfilo, livello, partiteGiocate, partiteVinte, partitePerse;

    public void insertDB(String nick, String img) {
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
                            + " VALUES ('" + nick + "','" + img + "')";
                    statement.executeUpdate(query1);
                    connection.close();
                    valido = true;
                    valido2 = true;
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Nickname già in uso");
                }
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "" + e2);
            }
        }
    }
    public void selectDB(String nick) {
        if (nick.equals("") || nick.equals(null)) {
            JOptionPane.showMessageDialog(null, "Nickname Obbligatorio");
            valido3 = false;
        } else {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jUno", "root", "AlessioFabio");
                try {
                    String query2 = "SELECT * FROM jUno.Profilo"
                                  + " WHERE nickname = '" + nick + "'";
                    Statement statement = connection.prepareStatement(query2);
                    ResultSet rs = statement.executeQuery(query2);
                    while (rs.next()) {
                        valido3 = true;
                    }
                    connection.close();
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "" + e1);
                }
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "" + e2);
            }
        }
    }
    public void exportDB(String nickname) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jUno", "root", "AlessioFabio");
            try {
                String query4 = "SELECT * FROM jUno.Profilo"
                              + " WHERE nickname = '" + nickname + "'";
                Statement statement = connection.prepareStatement(query4);
                ResultSet rs = statement.executeQuery(query4);
                if (rs.next()) {
                    nomeProfilo = rs.getString(2);
                    System.out.println(nomeProfilo);
                    fotoProfilo = rs.getString(3);
                    System.out.println(fotoProfilo);
                    livello = rs.getString(4);
                    System.out.println(livello);
                    partiteGiocate = rs.getString(5);
                    System.out.println(partiteGiocate);
                    partiteVinte = rs.getString(6);
                    System.out.println(partiteVinte);
                    partitePerse = rs.getString(7);
                    System.out.println(partitePerse);
                }
                connection.close();
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "" + e1);
                System.out.println("e1: " + e1);
            }
        } catch (Exception e2) {
            JOptionPane.showMessageDialog(null, "" + e2);
            System.out.println("e2: " + e2);
        }
    }
    public void updateBD2(String nickname, boolean risultato) {
        if (risultato == true) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jUno", "root", "AlessioFabio");
                Statement statement = connection.createStatement();
                try {
                    String query3 = "UPDATE jUno.Profilo"
                                  + " SET partite_giocate = partite_giocate + 1, partite_vinte = partite_vinte + 1"
                                  + " WHERE nickname = '" + nickname + "'";
                    statement.executeUpdate(query3);
                    connection.close();
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "" + e1);
                }
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "" + e2);
            }
        } else {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jUno", "root", "AlessioFabio");
                Statement statement = connection.createStatement();
                try {
                    String query4 = "UPDATE jUno.Profilo"
                                  + " SET partite_giocate = partite_giocate + 1, partite_perse = partite_perse + 1"
                                  + " WHERE nickname = '" + nickname + "'";
                    statement.executeUpdate(query4);
                    connection.close();
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "" + e1);
                }
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "" + e2);
            }
        }
    }
}