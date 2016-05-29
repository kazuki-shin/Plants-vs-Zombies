/**
 * Kazuki Shin
 * 1st Period
 * 5/24/16
 * Instructions show the user instructions for the game
 */

package Pvz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Instructions show the user instructions for the game
 */
public class Instructions {

	/**
	 * Displays the user instructions in a GUI
	 */
	public static void show()
	{
	JFrame frame = new JFrame("User Instructions");
	String message = "<html>The main objective of Plants Vs Zombies is to protect the house from the waves of "
			+ "<br>zombies trying to attack it. To do this, the user must place different plants strategically to "
			+ "kill the <br>zombies as the difficulty level increases. The user has an itinerary of plants, and "
			+ "the plants that <br>cause higher damage or have higher capabilities are worth more sun credit. "
			+ "<br><br>The user begins with 400 sun credits, and can place more sunflowers to get more sun "
			+ "credit. Sun credit is gained automatically over time once the Sunflower is planted, and 100 "
			+ "credits are needed to plant a basic shooter. From there, plants become worth higher credit "
			+ "proportionally to how high their capabilities are. <br><br>To plant a plant, click on the "
			+ "square where you want to plant, and a menu will <br>pop up with the choices of which plants are "
			+ "available with their given sun credit. Once the user <br>survives a zombie wave, and all the"
			+ " zombies are gone, the user can click “Next Level”. This will <br>cause more zombies to spawn, this "
			+ "time at a higher difficulty, and the user must place down <br>more plants or replace old plants "
			+ "with higher level plants to survive. If a zombie reaches a plant <br>without being killed, the "
			+ "zombie can eat the plant; how fast the zombie eats the plant depends <br>on the difficulty level"
			+ " of the zombie. <br><br>The user can tell how close a plant is to dying according to <br>their "
			+ "color. If the plant has high health, it stays it’s original color; if the plant becomes yellow,"
			+ " it <br>has medium health; if the plant turns read, then the plant is close to dying; from there,"
			+ " the plant <br>disappears, and the zombie can continue walking until it is killed, or it reaches "
			+ "the house. The <br>more zombies are killed, the higher the score (also, the user’s brains don’t "
			+ "get eaten).</html>"; 

	JLabel label = new JLabel(message);
	label.setForeground(Color.BLACK);
	label.setBackground(Color.BLACK);
	
	
     frame.setLocationByPlatform(true);

     frame.add(label,BorderLayout.NORTH);
     frame.setBounds(400, 250, 0, 0);
     Dimension d = new Dimension(630,400);
     frame.setPreferredSize(d);
     
     frame.pack();
     frame.setVisible(true);
	}

}
