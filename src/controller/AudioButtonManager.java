package controller;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;

public class AudioButtonManager {

    public void playButtonMusic(String musicLocation) {
        File musicPath = new File(musicLocation);
        try {
            if(musicPath.exists()) {
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(musicPath));
                clip.start();
            } else {
                System.out.println("Non trovo il file audio");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "" + ex);
        }
    }
}
