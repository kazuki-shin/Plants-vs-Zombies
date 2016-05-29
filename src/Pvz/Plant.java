/**
 * Kazuki Shin
 * 1st Period
 * 5/24/16
 * Plant allows for the player to defend their house from the zombies
 */

package Pvz;
import java.awt.Color;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

/**
 * Plant allows for the player to defend their house from the zombies
 */
public class Plant extends Unit{
	
	private Sound music;
	
	/**
	 * Constructs objects which allow for the player to protect their house from the zombies
	 */
	public Plant()
	{
		setOriginalHp(5);
		setHp(getOriginalHp());
		music = new Sound();
		music.playSound("woodchopping.wav");
		
	}
	
	/**
	 * changes color if hp is decreased. Attacks zombies based on their abilities
	 */
	public void act()
	{
		hpColor();
		super.act();
		if(getHp()<=0)
		{
			Sound music = new Sound();
			music.playSound("icebreaking.wav");
		}
	}
	
	/**
	 * Checks to see if the plant is attacked or not
	 * @return if the plant is attacked or not
	 */
	public boolean isAttacked()
	{
	        Grid<Actor> gr = getGrid();
	        if (gr == null)
	            return false;
	        Location loc = getLocation();
	        Location next = loc.getAdjacentLocation(90);
	        if (!gr.isValid(next))
	            return false;
	        Actor neighbor = gr.get(next);
	        return (neighbor instanceof Zombie);
	    
	}
	
	/**
	 * changes the color of a plant based on how much damage the plant has taken
	 */
	public void hpColor()
	{
		if(getHp()>=(getOriginalHp()*0.8))
			setColor(null);
		else if(getHp()>=(getOriginalHp()*0.5))
			setColor(Color.YELLOW);
		else
			setColor(Color.RED);
	}
	
}
