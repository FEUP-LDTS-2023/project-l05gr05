package com.pacxon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.sound.sampled.Clip;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MusicSoundTest {

    private MusicSound musicSound;
    private Clip mockClip;

    @BeforeEach
    public void setUp() {
        mockClip = mock(Clip.class);
        musicSound = new MusicSound("src/test/resources/test_audio.wav");
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
}

