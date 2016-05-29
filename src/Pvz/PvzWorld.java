/**
 * Kazuki Shin
 * 1st Period
 * 5/24/16
 * PvzWorld is the world in which the game is played
 */

package Pvz;

import javax.swing.JOptionPane;

import info.gridworld.Pvz.PlantSetUp;
import info.gridworld.Pvz.ZombieWave;
import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;
import info.gridworld.gui.GUIController;
import info.gridworld.world.World;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * PvzWorld is the world in which the game is played
 */
public class PvzWorld extends ActorWorld{
	
	private String worldType;
	private ZombieWave wave;
	private PlantSetUp setUp;
	private static Sound music;
	private Player player;
	
	/**
	 * Constructs a world
	 */
	public PvzWorld()
	{
		player = new Player();	
	}
	
	/**
	 * Constructs a world of the given type
	 * @param grid the grid to place the world
	 * @param worldType the type of the world
	 */
	public PvzWorld(BoundedGrid<Actor> grid, String worldType){
		super(grid, worldType,music);
		this.setType(worldType);
		player = super.getPlayer();
		wave = new ZombieWave(this);
		setUp = new PlantSetUp(this);
		player = new Player();
		music = new Sound();
		
		if(worldType.equals("Display"))
		{
			wave.display();
		}
		else if(worldType.equals("Day"))
		{
		setUp.blankSet();
		wave.wave2();
		}
		else
		{
			setUp.blankSet();
			wave.wave1();
		}
		show();
	}

	/**
	 * gets the player in the world
	 * @return the player in the world
	 */
	public Player getPlayer()
	{
		return player;
	}

	/**
	 * Gets the type of the world
	 * @return the type of the worlds
	 */
	public String getType() {
		return worldType;
	}

	/**
	 * Sets the type of world
	 * @param worldType the type of world
	 */
	public void setType(String worldType) {
		this.worldType = worldType;
	}
	
	/**
	 * Starts the game off with the default world
	 * @return the world to start with
	 */
	public static PvzWorld selectWorld()
	{
		
		//BoundedGrid<Actor> grid = new BoundedGrid<Actor>(7,18);
		JOptionPane.showMessageDialog(null, "WELCOME TO PLANTS VS ZOMBIES\nYou will be starting at Level 1: \"Day\"");
		return new PvzWorld(new BoundedGrid<Actor>(7,17), "Day");		
		
		/**
		String selectedWorld = "";
		selectedWorld = JOptionPane.showInputDialog(
				"WELCOME TO PLANTS VS ZOMBIES\nChoose a number for your World: \n(1) Day\n(2) Underwater\n(3) Haunted House\n(4) Castle\n(5) Volcano\n(6) Sky");
	
		TitleMaker.stopTitleMusic();
		Player.clearCredits();
		switch(selectedWorld)
		{
			//case "0": return new PvzWorld(new BoundedGrid<Actor>(10,10), "Display"); 
			case "1": return new PvzWorld(new BoundedGrid<Actor>(7,17), "Day");
			case "2": return new PvzWorld(grid, "Underwater");
			case "3": return new PvzWorld(grid, "Haunted House");
			case "4": return new PvzWorld(grid, "Castle");
			case "5": return new PvzWorld(grid, "Volcano");
			case "6": return new PvzWorld(grid, "Sky"); 
			default: JOptionPane.showMessageDialog(null,selectedWorld + " is not a valid world number \nTry Again" );
		
		}
		return new PvzWorld(new BoundedGrid<Actor>(5,11), "Display"); */
		
	}
	
	/**
	 * Shows a message showing your final score after ur death
	 */
	public static void gameOver()
	{
		JOptionPane.showMessageDialog(null, "THE ZOMBIES ATE YOUR BRAINSSS!\nYour final score was: "+Player.getDeaths() +" kills.\nGo play another game");
		
	}
	

}