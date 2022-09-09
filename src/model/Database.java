package model;

import controller.AudioButtonManager;
import javax.swing.*;
import java.sql.*;

/**
 * Questa classe è utilizzata per la connessione con il database e utilizza il singleton pattern
 */
public class Database {

    /**
     * connessione del database
     */
    private Connection connection;
    /**
     *  unica istanza della classe
     */
    private static Database singleton;
    /**
     * oggetto audio
     */
    AudioButtonManager musicObjectButton = new AudioButtonManager();

    /**
     * Costruttore privato che nessuno può chiamare, tranne metodi (statici) della classe stessa, creo l'unica connessione al database
     */
    private Database() {
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jUno", "root", "AlessioFabio");
            Database.singleton = this;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * metodo punto di accesso per la costruzione
     * @return l'istanza
     */
    public static Database getInstance(){
        if (singleton == null){
            return new Database();
        }
        return singleton;
    }

    /**
     * metodo che tramite una query cerca il profilo nel database secondo il nickname del profilo in uso
     * @param nick del profilo in utilizzo
     * @return il profilo
     */
    public Profilo cercaProfilo(String nick) {
        try {
            String query = "SELECT * FROM jUno.Profilo WHERE nickname = '" + nick + "'";
            Statement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                Profilo profilo = new Profilo.ProfiloBuilder()
                        .setNickname(rs.getString(2))
                        .setAvatarImg(rs.getString(3))
                        .setLivello(rs.getInt(4))
                        .setPartiteGiocate(rs.getInt(5))
                        .setPartiteVinte(rs.getInt(6))
                        .setPartitePerse(rs.getInt(7)).build();
                return profilo;
            }
        } catch (Exception e1) {
            musicObjectButton.playButtonMusic("./src/audio/error_button_audio.wav");
            JOptionPane.showMessageDialog(null, "" + e1);

        }
        return null;
    }

    /**
     * metodo che tramite una query crea il profilo nel database secondo il nickname e l'avatar scelti del profilo in uso
     * @param nick del profilo
     * @param img avatar del profilo
     * @return il profilo
     */
    public Profilo creaProfilo(String nick, String img) {
        try {
            Statement statement = connection.createStatement();
            String query1 = "INSERT INTO jUno.Profilo"
                    + " (`nickname`, `avatar`)"
                    + " VALUES ('" + nick + "','" + img + "')";
            statement.executeUpdate(query1);

            Profilo profilo = new Profilo.ProfiloBuilder()
                    .setNickname(nick)
                    .setAvatarImg(img)
                    .setLivello(0)
                    .setPartiteGiocate(0)
                    .setPartitePerse(0)
                    .setPartiteVinte(0).build();
            return profilo;
        } catch (SQLException e2) {
            switch (e2.getSQLState()) {
                case "22001":
                    musicObjectButton.playButtonMusic("./src/audio/error_button_audio.wav");
                    JOptionPane.showMessageDialog(null, "Nickname deve essere lungo massimo 45 caratteri");
                    break;
                case "23000":
                    musicObjectButton.playButtonMusic("./src/audio/error_button_audio.wav");
                    JOptionPane.showMessageDialog(null, "Nickname già in uso");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "" + e2);
            }
        }
        return null;
    }
    /**
     * metodo che tramite una query aggiorna il profilo nel database secondo il nickname del profilo in uso e il risultato dopo una partita giocata
     * @param nickname del profilo in utilizzo
     * @param risultato della partita
     * @return il profilo
     */
    public void updateDatabase(String nickname, boolean risultato) {
        if (risultato == true) {
            try {
                Statement statement = connection.createStatement();
                try {
                    String query3 = "UPDATE jUno.Profilo"
                                  + " SET partite_giocate = partite_giocate + 1, partite_vinte = partite_vinte + 1, livello = livello + 2"
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
                                  + " SET partite_giocate = partite_giocate + 1, partite_perse = partite_perse + 1, livello = livello - 1"
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

    /**
     * metodo che chiude la connessione al database
     */
    public void close() {
        if (this.connection != null) {
            try {
                this.connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
