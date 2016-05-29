/**
 * Kazuki Shin
 * 1st Period
 * 5/24/16
 * Pea is what is shot from an attacking plant. Deals damage to zombies
 */

package Pvz;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

/**
 * Pea is what is shot from an attacking plant. Deals damage to zombies
 */
public class Pea extends Unit{

	private int turn;
	private int count;
	
	
	/**
	 * Contructs a projectile that deals damage to zombies
	 */
	public Pea()
	{
		setDirection(90);
		setHp(1);
		turn = 0;
		count = 0;
	}	
	
	/**
	 * Moves the pea from the shooting plant towards a zombie in that lane if possible
	 */
	public void act()
	{
		if(canMove() && turn%2==1)
		{
			move();
		}
		if(lookOne())
		{
			setHp(getHp()-1);
			count++;
		}
		if((getHp()<=0 || peaBehind())|| stuck())
			removeSelfFromGrid();
		if(exists() && count>0){
			removeSelfFromGrid();
		}
		turn++;
	}
	
	/**
	 * Checks to see whether the pea exits in the grid or not
	 */
	public boolean exists()
	{
		Grid<Actor> gr = getGrid();
        Location loc = getLocation();
        if(loc!=null)
        return gr.isValid(loc);
        return false;
	}
	
	/**
	 * Moves the pea
	 */
	public void move()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (gr.isValid(next))
            moveTo(next);
        else
            removeSelfFromGrid();
    }
	
	/**
	 * Checks to see if there is a zombie near the pea
	 * @return whether the pea is attacked or not
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
	 * Checks to see if there is another pea behind it
	 * @return whether there is a pea behind or not
	 */
	public boolean peaBehind()
	{
		Grid<Actor> gr = getGrid();
        if (gr == null)
            return false;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(270);
        if (!gr.isValid(next))
            return false;
        Actor neighbor = gr.get(next);
        return (neighbor instanceof Pea);	
	}
	
	/**
	 * Checks to see if the pea is stuck between 2 objects
	 * @return if the pea is stuck between two objects
	 */
	public boolean stuck()
	{
		Grid<Actor> gr = getGrid();
        if (gr == null)
            return false;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(270);
        Location next1 = loc.getAdjacentLocation(90);
        if (!gr.isValid(next)|| !gr.isValid(next1))
            return false;
        Actor neighbor = gr.get(next);
        Actor neighbor1 = gr.get(next1);
        return (neighbor instanceof Plant) && (neighbor1 instanceof Zombie);
	}
	
		/**
		 * Checks to see if there is a zombie 2 spots away from where it exists
		 * @return if there is a zombie 2 spots away
		 */
		public boolean lookTwo()
		{
			Grid<Actor> gr = getGrid();
	        if (gr == null)
	            return false;
	        Location loc = getLocation();
	        Location next = new Location(loc.getRow(),loc.getCol()+2);
	        if (!gr.isValid(next))
	            return false;
	        Actor neighbor = gr.get(next);
	        return(neighbor instanceof Zombie);
		}
		
		/**
		 * Checks to see if there is a zombie 1 spot away from where it exists
		 * @return if there is a zombie 1 spot away
		 */
		public boolean lookOne()
		{
			Grid<Actor> gr = getGrid();
	        if (gr == null)
	            return false;
	        Location loc = getLocation();
	        Location next = new Location(loc.getRow(),loc.getCol()+1);
	        if (!gr.isValid(next))
	            return false;
	        Actor neighbor = gr.get(next);
	        return(neighbor instanceof Zombie);
		}
	

}
