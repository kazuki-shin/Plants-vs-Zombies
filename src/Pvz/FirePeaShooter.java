/**
 * Kazuki Shin
 * 1st Period
 * 5/24/16
 * FirePeaShooter shoots fire peas at zombies
 */

package Pvz;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

/**
 * FirePeaShooter shoots fire peas at zombies
 */
public class FirePeaShooter extends AttackingPlant{
	
	/**
	 * Constructs a plant that shoots fire peas
	 */
	public FirePeaShooter(){
		super();
		Player.getWorld().getPlayer().plantIt("FirePeaShooter");
	}
	
	/**
	 * Shoots a fire pea
	 */
	public void shoot()
	{ 	
		Grid<Actor> gr = getGrid();
    	Location loc = getLocation();
    	Location check = new Location(loc.getRow(),loc.getCol()+1);
    	
    		
    		if(((gr.get(check)==null) || !(gr.get(check) instanceof Zombie)) && getTurn()%getShootPace()==0)
			{
    			FirePea pea;
    			pea = new FirePea();
    		if(gr.get(check) instanceof Plant)
    		{
    			pea.putSelfInGrid(gr, new Location(loc.getRow(),loc.getCol()+2));
    			
    		}
    		else
    			pea.putSelfInGrid(gr, new Location(loc.getRow(),loc.getCol()+1));
    		Sound music = new Sound();
			music.playSound("select.wav");
			}	
	}
}
