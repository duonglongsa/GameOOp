package utils;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

public class AudioClip {
	
	private File file;
	public String path;
	
	
	public AudioClip(String path) {
		path = "C:/Users/ACER/eclipse-workspace/2DGame/res/audio/" + path;
		file = new File(path);
	}
	
	public AudioInputStream getAudioStream() {
		try {
			
			return AudioSystem.getAudioInputStream(file);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
