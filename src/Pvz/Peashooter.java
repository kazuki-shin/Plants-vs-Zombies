/**
 * Kazuki Shin
 * 1st Period
 * 5/24/16
 * Peashooter shoots peas at zombies
 */

package Pvz;

/**
 * Peashooter shoots peas at zombies
 */
public class Peashooter extends AttackingPlant{
	
	
	/**
	 * Constructs a plant that shoots peas at zombies
	 */
	public Peashooter()
	{
		super();
		Player.getWorld().getPlayer().plantIt("Peashooter");
	}
	
}
