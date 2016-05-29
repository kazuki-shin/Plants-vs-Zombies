/**
 * Kazuki Shin
 * 1st Period
 * 5/24/16
 * Unit creates pieces for the game
 */

package Pvz;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

/**
 * Unit creates pieces for the game
 */
public class Unit extends Bug{
	private int hp;
	private int originalHp;

	/**
	 * Constructs a piece for the game
	 */
	public Unit()
	{
		setColor(null);
		originalHp = 10;
		hp = originalHp;
	}
	
	/**
	 * Dies if the unit hits 0 hp or less
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
	}
	
	/**
	 * Constructs a piece that can have its hp adjusted 
	 * @param originalHp1
	 */
	public Unit(int originalHp1)
	{
		setColor(null);
		originalHp = originalHp1;
		hp = originalHp;
	}
	
	/**
	 * Gets the hp for the unit
	 * @return
	 */
	public int getHp()
	{
		return hp;
	}
	
	/**
	 * Sets the hp to a given integer
	 * @param hp1 the number to change the hp to
	 */
	public void setHp(int hp1)
	{
		hp = hp1;
	}
	
	/**
	 * Gets the original hp of the game
	 * @return
	 */
	public int getOriginalHp() {
		return originalHp;
	}

	/**
	 * Changes the originalhp of the Unit
	 * @param originalHp how much hp the unit started with
	 */
	public void setOriginalHp(int originalHp) {
		this.originalHp = originalHp;
	}
	
	/**
	 * Checks to see if the unit is attacked
	 * @return if the unit was attacked or not
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
	 * Checks to see if the unit can move or nots
	 */
	public boolean canMove()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return false;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (!gr.isValid(next))
            return false;
        Actor neighbor = gr.get(next);
        
        return (neighbor == null) ;
        
    }
	
}
