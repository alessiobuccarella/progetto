package controller;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class AudioManager {
    private static AudioManager istanza;
    private AudioManager() {
        AudioManager.istanza = this;
    }

    public static AudioManager getInstance() {
        if (istanza == null){
            return new AudioManager();
        }
        return istanza;
    }

    public void playMusic(String musicLocation) {
        File musicPath = new File(musicLocation);
        try {
            if(musicPath.exists()) {
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(musicPath));
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                System.out.println("Non trovo il file audio");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "" + ex);
        }
    }
}

