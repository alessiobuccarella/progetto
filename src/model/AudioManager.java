package model;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;


public class AudioManager {

    public void playMusic(String musicLocation) {
        File musicPath = new File(musicLocation);
        try {
            if(musicPath.exists()) {
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(musicPath));
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                if(){
                    clip.stop();
                }
            } else {
                System.out.println("Non trovo il file audio");
            }
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "" + ex);
        }

    }
}

