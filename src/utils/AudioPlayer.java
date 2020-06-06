package utils;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioPlayer {
	
	static Clip clip;
	static AudioInputStream stream;
	
	public static synchronized void playSound(AudioClip sound) {
		Thread thread = new Thread() {
			public void run() {
				try {
					stream = sound.getAudioStream();
					clip = AudioSystem.getClip();
					clip.open(stream);
					clip.start();
					if(sound.path == "C:/Users/ACER/eclipse-workspace/2DGame/res/audio/Map1Music.wav" ||
					   sound.path == "C:/Users/ACER/eclipse-workspace/2DGame/res/audio/Map2Music.wav" ||
					   sound.path == "C:/Users/ACER/eclipse-workspace/2DGame/res/audio/MenuMusic.wav") {
					clip.loop(Clip.LOOP_CONTINUOUSLY);
					}

					
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}; thread.start();
	}
	
	public static void stopSound(AudioClip sound) {
			clip.close();
	}
	
}