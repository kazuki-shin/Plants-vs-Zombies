/**
 * Kazuki Shin
 * 1st Period
 * 5/24/16
 * Sunflower gives sun credits to the player over time
 */

package Pvz;

import java.io.IOException;

import info.gridworld.gui.ImageDisplay;

/**
 * Sunflower gives sun credits to the player over time
 */
public class Sunflower extends NonAttackingPlant {
	
	private int sunTime;
	private Sound music;
	
	/**
	 * Constructs a plant which gives sun credits over time
	 */
	public Sunflower()
	{
		super();
		Player.getWorld().getPlayer().plantIt("Sunflower");
		music = new Sound();
	}
	
	/**
	 * Hp goes down if is attacked
	 * Dies if the hp goes below zero
	 */
	public void act()
	{
		if(isAttacked())
		{
			setHp(getHp()-1);
		}
		if(getHp()<=0)
		{
			removeSelfFromGrid();
		}
		if(sunTime !=0 && sunTime%15==0)
		{
			Player.getWorld().getPlayer().addSunCredits();
			music.playSound("pacman_eatghost.wav");
		}
		sunTime++;
	}
	
}
