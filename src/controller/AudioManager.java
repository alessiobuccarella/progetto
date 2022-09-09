package controller;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

/**
 * classe che permette la riproduzione di audio sample nella navigazione del menu e utilizza il singleton pattern
 */
public class AudioManager {
    /**
     *  unica istanza della classe
     */
    private static AudioManager istanza;
    /**
     * clip audio
     */
    private Clip clip;

    /**
     * Costruttore privato che nessuno può chiamare, tranne metodi (statici) della classe stessa, inizializza l'unica istanza
     */
    private AudioManager() {
        AudioManager.istanza = this;
    }

    /**
     * metodo punto di accesso per la costruzione
     * @return l'istanza
     */
    public static AudioManager getInstance() {
        if (istanza == null){
            return new AudioManager();
        }
        return istanza;
    }

    /**
     * metodo che permette l'ascolto del sample audio durante la navigazione nel menu
     * @param musicLocation path del file audio da riprodurre
     */
    public void playMusic(String musicLocation) {
        File musicPath = new File(musicLocation);
        try {
            if(musicPath.exists()) {
                if(clip == null) {
                    clip = AudioSystem.getClip();
                    clip.open(AudioSystem.getAudioInputStream(musicPath));
                    clip.start();
                    clip.loop(Clip.LOOP_CONTINUOUSLY);
                } else {
                    clip.stop();
                    clip = null;
                }
            } else {
                System.out.println("Non trovo il file audio");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "" + ex);
        }
    }
}

