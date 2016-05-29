/**
 * Kazuki Shin
 * 1st Period
 * 5/24/16
 * An AttackingPlant is a plant which can shoot projectiles at zombies
 */

package Pvz;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

/**
 * An AttackingPlant is a plant which can shoot projectiles at zombies
 */
public class AttackingPlant extends Plant{

	private int turn;
	private Sound music;
	private static int defShootPace;
	
	/**
	 * Constructs a plant which can attack zombies
	 */
	public AttackingPlant()
	{
		super();
		turn = 0;
		music = new Sound();
		defShootPace = 6;
	}
	
	/**
	 * Shoots a projectile if possible and plant dies if hp is 0 or less
	 */
	public void act()
	{
		super.act();
		if(getHp()>=1 && aim())
		{
			shoot();
		}
		turn++;
	}
	
	/**
	 * Shoots a projectile
	 */
	public void shoot()
	{ 	
		Grid<Actor> gr = getGrid();
    	Location loc = getLocation();
    	Location check = new Location(loc.getRow(),loc.getCol()+1);
    		if(((gr.get(check)==null) || !(gr.get(check) instanceof Zombie)) && turn%defShootPace==0)
			{
    			Pea pea;
    			pea = new Pea();
    		if(gr.get(check) instanceof Plant)
    		{
    			pea.putSelfInGrid(gr, new Location(loc.getRow(),loc.getCol()+2));
    			
    		}
    		else
    			pea.putSelfInGrid(gr, new Location(loc.getRow(),loc.getCol()+1));
			music.playSound("select.wav");
			}	
    		/**
    		else if(((gr.get(check)==null) || !(gr.get(check) instanceof Zombie)) && turn%defShootPace!=0)
			{
    		if(gr.get(check) instanceof Plant)
    			((Walnut)(gr.get(check))).setSuffix("");
			} */
	}
	
	/**
	 * Gets the speed at which the plant shoots
	 * @return pace at which the plant shoots
	 */
	public static int getShootPace()
	{
		return defShootPace;
	}
	
	/**
	 * Gets the amount of turns the plant has existed for
	 * @return the amount of turns the plant has existed for
	 */
	public int getTurn()
	{
		return turn;
	}
	
	/**
	 * Sets the amount of turns the plant has existed for
	 * @param turn1 the amount of turns the plant has existed for
	 */
	public void setTurn(int turn1)
	{
		turn = turn1;
	}
	
	public boolean aim(){
		
		int row = this.getLocation().getRow();
		for(int i = 4; i<15;i++)
		{
			if(this.getGrid().get(new Location(row,i))!=null)
			{
				if(this.getGrid().get(new Location(row,i)) instanceof Zombie)
			    	 return true;
			}
		}
	    return false;		
	}
	
}
