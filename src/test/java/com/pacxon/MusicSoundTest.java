package com.pacxon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MusicSoundTest {

    private MusicSound musicSound;
    private Clip mockClip;

    @BeforeEach
    public void setUp() {
        mockClip = mock(Clip.class);
        musicSound = new MusicSound("src/main/resources/music/musicapacxon.wav");
    }

    @Test
    public void testInitialization() {
        assertNotNull(musicSound);
    }


    @Test
    public void testPlayWhenClipIsNull() {
        musicSound = new MusicSound("invalid_file_path.wav");

        musicSound.play();

        assertNull(musicSound.getClip());
    }


    @Test
    public void testStopWhenClipIsStopped() {
        when(mockClip.isRunning()).thenReturn(false);

        musicSound.stop();

        verify(mockClip, never()).stop();
    }

    @Test
    public void testStopWhenClipIsNull() {
        musicSound = new MusicSound("invalid_file_path.wav");
        musicSound.stop();
        assertNull(musicSound.getClip());
    }

    @Test
    public void testValidAudioFileLoading() throws Exception {
        String validFilePath = "src/main/resources/music/musicapacxon.wav";
        Clip testClip = AudioSystem.getClip();
        AudioInputStream testStream = AudioSystem.getAudioInputStream(new File(validFilePath));
        testClip.open(testStream);

        MusicSound validMusicSound = new MusicSound(validFilePath);

        assertNotNull(validMusicSound.getClip());
    }

    @Test
    public void testPlayWhenClipIsStopped() {
        when(mockClip.isRunning()).thenReturn(false);
        doNothing().when(mockClip).start();

        musicSound.play();

        verify(mockClip).start();
    }

    @Test
    public void testStopWhenClipIsRunning() {
        when(mockClip.isRunning()).thenReturn(true);
        doNothing().when(mockClip).stop();

        musicSound.stop();

        verify(mockClip).stop();
    }
}

