package org.givou.badapple;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Main extends JFrame {
	

	private static Listener listener = new Listener();
	private static Timer timer;
	
	
	public static Thread getThread() {
		return Thread.currentThread();
	}
	
	public Main() {
		setSize(650, 485);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		setTitle("BadApple by Thiemoo lol");
		
		getContentPane().add(listener);
		
		timer = new Timer(30, listener);
	}
	
	public static void main(String[] args) {
		new Main();
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		
		try {			
			URL audiourl = classloader.getResource("data/BadApple.wav");
			AudioInputStream audioInput = AudioSystem.getAudioInputStream(audiourl);
			Clip audioclip = AudioSystem.getClip();
			
			audioclip.open(audioInput);
			audioclip.loop(0);
				
		} catch (Exception e) {
			System.out.println("An error ocurred!");
			e.printStackTrace();
			Runtime.getRuntime().exit(0);
		}
		
		timer.start();
	}
}
