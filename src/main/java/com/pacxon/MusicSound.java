package com.pacxon;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusicSound {
    private Clip clip;

    public MusicSound(String filePath) {
        try {
            File audioFile = new File(filePath);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(100);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void play() {
        if (clip != null && !clip.isRunning()) {
            clip.setFramePosition(0);
            clip.start();
        }
    }

    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

}
