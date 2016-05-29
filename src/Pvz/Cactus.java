/**
 * Kazuki Shin
 * 1st Period
 * 5/24/16
 * A Cactus shoots thorns at zombies
 */

package Pvz;

/**
 * A Cactus shoots thorns at zombies
 */
public class Cactus extends AttackingPlant {
	
	/**
	 * Creates a cactus while subtracting the player's sunCredits
	 */
	public Cactus()
	{
		super();
		Player.getWorld().getPlayer().plantIt("Cactus");
	}

}
