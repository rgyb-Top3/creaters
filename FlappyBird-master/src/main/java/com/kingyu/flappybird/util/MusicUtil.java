package com.kingyu.flappybird.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import javax.sound.sampled.*;  
import java.io.File;  
import java.io.IOException;

/**
 * 音乐工具类
 *
 * @author Kingyu
 * wav音频：JDK提供的类可直接解码 mp3音频：JDK没有提供支持，需要使用第三方的工具包
 */
public class MusicUtil {

    private static AudioStream fly;
    private static AudioStream crash;
    private static AudioStream score;

    // wav播放
    public static void playFly() {
        loadClip("resources/wav/fly.wav", fly);  
        if (fly != null) {  
            fly.start();  
        }
    }

    public static void playCrash() {
        loadClip("resources/wav/crash.wav", crash);  
        if (crash != null) {  
            crash.start();  
        }
    }

    public static void playScore() {
        loadClip("resources/wav/score.wav", score);  
        if (score != null) {  
            score.start();  
        }
        private static void loadClip(String filePath, Clip clip) {  
        try {  
            File audioFile = new File(filePath);  
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);  
            AudioFormat format = audioStream.getFormat();  
            DataLine.Info info = new DataLine.Info(Clip.class, format);  
 
            if (!AudioSystem.isLineSupported(info)) {  
                System.out.println("Line not supported");  
                System.exit(0);  
            }  
 
            clip = (Clip) AudioSystem.getLine(info);  
            clip.open(audioStream);  
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {  
            e.printStackTrace();  
        }
    }

}
