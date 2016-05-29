/**
 * Kazuki Shin
 * 1st Period
 * 5/24/16
 * Player holds the information for the user playing the game
 */

package Pvz;

import javax.swing.JOptionPane;

/**
 * Player holds the information for the user playing the game
 */
public class Player {

	private static int sunCredits;
	private static int zombiesKilled;
	private static int time;
	private static PvzWorld world = new PvzWorld();
	private static int messageCount;
	
	/**
	 * Creates a profile that holds kills and sun credits for the user
	 */
	public Player()
	{
		sunCredits = 50;
		time = 0;
		messageCount = 0;
	}
	
	/**
	 * Gets the amount of time the player has played the game
	 * @return the amount of time the player has played the game
	 */
	public static int getTime()
	{
		return time;
	}
	
	/**
	 * increments the time
	 */
	public static void addTime()
	{
		time++;
		if(time>79 && messageCount==0)
		{
			
			JOptionPane.showMessageDialog(null, "You beat this level! Click \"Next Level\" to continue.");
			messageCount++;
		}
	}
	
	/**
	 * Resets the time back to zero
	 */
	public static void clearTime()
	{
		time = 0;
	}
	
	/**
	 * Adds 50 sun credits to your existing account
	 */
	public void addSunCredits()
	{
		sunCredits+=50;	
	}
	
	/**
	 * Resets your credits to zero
	 */
	public static void clearCredits()
	{
		sunCredits = 0;
	}
	
	/**
	 * Changes the amount of suncredits a player has
	 * @param credits the amount to change to 
	 */
	public static void setCredit(int credits)
	{
		sunCredits = credits;
	}
	
	/**
	 * Gets the amount of sun credits the player has
	 * @return the amount of sun credits the player has
	 */
	public static int getCredits()
	{
		return sunCredits;
	}
	
	/**
	 * Gets the amount of kills the player has
	 * @return the amount of kills the player has
	 */
	public static int getDeaths()
	{
		return zombiesKilled;
	}
	
	/**
	 * Increments the players kills by one
	 */
	public static void addKills()
	{
		zombiesKilled++;
	}
	
	/**
	 * Gets the world in which the player is in
	 * @return the world in which the player is in
	 */
	public static PvzWorld getWorld(){
		return world;
	}
	
	/**
	 * Subtracts the amount of sun credits it takes to plant
	 * @param plantType the type of plant planted
	 */
	public void plantIt(String plantType)
	{
		switch(plantType)
		{
			case "Cactus": sunCredits-=125; break;
			case "Peashooter": sunCredits-=100; break;
			case "CatPlant": sunCredits-=100; break;
			case "DoubleFirePeaShooter": sunCredits-=200; break;
			case "DoublePeaShooter": sunCredits-=150; break;
			case "FirePeaShooter": sunCredits-=150; break;
			case "FutureWalnut": sunCredits-=100; break;
			case "Mine": sunCredits-=25; break;
			case "Shroom": sunCredits-=25; break;
			case "Walnut": sunCredits-=50; break;
			case "MultiPeaShooter": sunCredits-=150; break;
			case "Sunflower": sunCredits-=50; break;
			case "FreezePlant": sunCredits-=25;break;
			default: sunCredits -=1000;
		}
	}
	
}
