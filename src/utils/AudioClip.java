package utils;

import java.io.File;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

public class AudioClip {
	
	private File file;
	public String path;
	
	
	public AudioClip(String path) {
//<<<<<<< HEAD
//		path = "C:/Users/ACER/eclipse-workspace/2DGame/res/audio/" + path;
//
//		file = new File(path);
//=======
		this.path = path;
		Path path1 = FileSystems.getDefault().getPath("").toAbsolutePath();
		file = new File(path1 + "/res/audio/" + path);


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
