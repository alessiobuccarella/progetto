package model;

import javax.swing.*;
import java.sql.*;

public class Database {
    public static boolean valido, valido2, valido3;
    public static String nomeProfilo, fotoProfilo, livello, partiteGiocate, partiteVinte, partitePerse;
    private Connection connection;
    private static Database singleton;
    private Database() {
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jUno", "app-user", "password");
            Database.singleton = this;
        }
        catch (SQLException e) {
        	e.printStackTrace();
        }
    }
    public static Database getInstance(){
        if (singleton == null){
            return new Database();
        }
        return singleton;
    }

    public void insertDB(String nick, String img) {
        if (nick.equals("") || nick.equals(null)) {
            JOptionPane.showMessageDialog(null, "Nickname Obbligatorio");
            valido = false;
            valido2 = false;
        } else {
            try {
                Statement statement = connection.createStatement();
                    String query1 = "INSERT INTO jUno.Profilo"
                            + " (`nickname`, `avatar`)"
                            + " VALUES ('" + nick + "','" + img + "')";
                    statement.executeUpdate(query1);
                    valido = true;
                    valido2 = true;
            } catch (SQLException e2) {
                switch (e2.getSQLState()) {
                    case "22001":
                        JOptionPane.showMessageDialog(null, "Nickname deve essere lungo massimo 45 caratteri");
                        break;
                    case "23000":
                        JOptionPane.showMessageDialog(null, "Nickname gi√† in uso");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "" + e2);
                }
            }
        }
    }

    public void selectDB(String nick) {
        if (nick.equals("") || nick.equals(null)) {
            JOptionPane.showMessageDialog(null, "Nickname Obbligatorio");
            valido3 = false;
        } else {
            try {
                try {
                    String query2 = "SELECT * FROM jUno.Profilo"
                                  + " WHERE nickname = '" + nick + "'";
                    Statement statement = connection.prepareStatement(query2);
                    ResultSet rs = statement.executeQuery(query2);
                    if (rs.next()) {
                        valido3 = true;
                    }
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
            try {
                String query4 = "SELECT * FROM jUno.Profilo"
                              + " WHERE nickname = '" + nickname + "'";
                Statement statement = connection.prepareStatement(query4);
                ResultSet rs = statement.executeQuery(query4);
                if (rs.next()) {
                    nomeProfilo = rs.getString(2);
                    fotoProfilo = rs.getString(3);
                    livello = rs.getString(4);
                    partiteGiocate = rs.getString(5);
                    partiteVinte = rs.getString(6);
                    partitePerse = rs.getString(7);
                }
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "" + e1);
            }
        } catch (Exception e2) {
            JOptionPane.showMessageDialog(null, "" + e2);
        }
    }

    public void updateBD2(String nickname, boolean risultato) {
        if (risultato == true) {
            try {
                Statement statement = connection.createStatement();
                try {
                    String query3 = "UPDATE jUno.Profilo"
                                  + " SET partite_giocate = partite_giocate + 1, partite_vinte = partite_vinte + 1"
                                  + " WHERE nickname = '" + nickname + "'";
                    statement.executeUpdate(query3);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "" + e1);
                }
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "" + e2);
            }
        } else {
            try {
                Statement statement = connection.createStatement();
                try {
                    String query4 = "UPDATE jUno.Profilo"
                                  + " SET partite_giocate = partite_giocate + 1, partite_perse = partite_perse + 1"
                                  + " WHERE nickname = '" + nickname + "'";
                    statement.executeUpdate(query4);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "" + e1);
                }
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "" + e2);
            }
        }
    }
    
    public Profilo cercaProfilo(String nick) {
        try {
            String query = "SELECT * FROM jUno.Profilo WHERE nickname = '" + nick + "'";
            Statement statement = connection.prepareStatement(query);
	        ResultSet rs = statement.executeQuery(query);
	        if (rs.next()) {
	        	Profilo profilo = new Profilo();
	        	profilo.setNickname(rs.getString(2));
	        	profilo.setAvatarImg(rs.getString(3));
	        	profilo.setLivello(rs.getInt(4));
	        	profilo.setPartiteGiocate(rs.getInt(5));
	        	profilo.setPartiteVinte(rs.getInt(6));
	        	profilo.setPartitePerse(rs.getInt(7));
	        	return profilo;
	        }
        } catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
    }
    
    public Profilo creaProfilo(String nick, String img) {
        try {
            Statement statement = connection.createStatement();
                String query1 = "INSERT INTO jUno.Profilo"
                        + " (`nickname`, `avatar`)"
                        + " VALUES ('" + nick + "','" + img + "')";
                statement.executeUpdate(query1);
                
            Profilo profilo = new Profilo();
            profilo.setNickname(nick);
            profilo.setAvatarImg(img);
            profilo.setLivello(0);
            profilo.setPartiteGiocate(0);
            profilo.setPartitePerse(0);
            profilo.setPartiteVinte(0);
            
            return profilo;
        } catch (SQLException e2) {
            switch (e2.getSQLState()) {
                case "22001":
                    JOptionPane.showMessageDialog(null, "Nickname deve essere lungo massimo 45 caratteri");
                    break;
                case "23000":
                    JOptionPane.showMessageDialog(null, "Nickname gi‡† in uso");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "" + e2);
            }
        }
        return null;
    }
}
