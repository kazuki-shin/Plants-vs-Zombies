/**
 * Kazuki Shin
 * 1st Period
 * 5/24/16
 * A PlantSetUp creates a basic setup for plants to appear in the world
 */

package info.gridworld.Pvz;

import Pvz.Blank;
import Pvz.DoublePeaShooter;
import Pvz.Mine;
import Pvz.Peashooter;
import Pvz.Plant;
import Pvz.PvzWorld;
import Pvz.Sunflower;
import Pvz.Unit;
import Pvz.Walnut;
import Pvz.Zombie;
import info.gridworld.grid.Location;

/**
 * A PlantSetUp creates a basic setup for plants to appear in the world
 */
public class PlantSetUp {

	private PvzWorld world;
	
	/**
	 * Creates a object to setup plants
	 * @param world sets the world for this class
	 */
	public PlantSetUp(PvzWorld world)
	{
		this.world = world;
	}
	
	/**
	 * Adds a plant set up of type 1
	 */
	public void setUp1()
	{
		for(int i = 1; i <= 5; i++)
		{
			world.add(new Location(i,4),new Sunflower());
			if(i%2==0)
			world.add(new Location(i,5), new DoublePeaShooter());
			if(i%2==1)
			{
			world.add(new Location(i,5), new Walnut());
			world.add(new Location(i,6), new Mine());
			}
		}
	}
	
	/**
	 * Adds a blank object in the world
	 */
	public void blankSet()
	{
		world.add(new Location(0,0), new Blank());
	}
	
	/**
	 * Adds a plant set up of type 2
	 */
	public void setUp2()
	{
		for(int i = 0; i <= 5; i++)
		{
			world.add(new Location(i,3),new Sunflower());
			if(i%2==0)
			world.add(new Location(i,4), new Peashooter());
			if(i%2==1)
			world.add(new Location(i,4), new Walnut());
		}
	}
	
}