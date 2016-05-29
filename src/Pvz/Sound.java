/**
 * Kazuki Shin
 * 1st Period
 * 5/24/16
 * Sound allows for music to be played in the game
 */

package Pvz;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Sound allows for music to be played in the game
 */
public class Sound {
	private Clip clip;

	/**
	 * Constructs a object to play music
	 */
	public Sound()
	{
	}
	
	/**
	 * plays a given clip once
	 * @param music the clip to play
	 */
	public void playSound(String music)
	{
		try {
		    // Open an audio input stream.
		    java.net.URL url = this.getClass().getClassLoader().getResource(music);
		    AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
		    // Get a sound clip resource.
		    clip = AudioSystem.getClip();
		    // Open audio clip and load samples from the audio input stream.
		    clip.open(audioIn);
		    clip.start(); 
		    
		}catch(Exception e){
		    System.out.println(e);
		}
	}
	
	/**
	 * Plays the clip in a loop
	 * @param music the clip for the loop
	 */
	public void playLoopSound(String music)
	{
		try {
		    // Open an audio input stream.
		    java.net.URL url = this.getClass().getClassLoader().getResource(music);
		    AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
		    // Get a sound clip resource.
		    clip = AudioSystem.getClip();
		    // Open audio clip and load samples from the audio input stream.
		    clip.open(audioIn);
		    clip.start(); 
		    clip.loop(Clip.LOOP_CONTINUOUSLY);
		    
		}catch(Exception e){
		    System.out.println(e);
		}
	}
	
	/**
	 * Gets the clip of a Sound
	 * @return the clip of a Sound
	 */
	public Clip getClip()
	{
		return clip;
	}
	
	/**
	 * Stops the music for a loop
	 * @param clpClips the clips to stop looping
	 */
	public static void stopLoopingSounds(Clip... clpClips) {
		for (Clip clp : clpClips) {
			clp.stop();
		}
	}
	
}
