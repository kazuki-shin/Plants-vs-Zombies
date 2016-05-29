/**
 * Kazuki Shin
 * 1st Period
 * 5/24/16
 * A CatPlant is a plant which everyone loves.
 * It shoots normal peas at zombies
 */

package Pvz;

/**
 * A CatPlant is a plant which everyone loves.
 * It shoots normal peas at zombies
 */
public class CatPlant extends AttackingPlant {

	/**
	 * Constructs a CatPlant while subtracting the player's sun credits
	 */
	public CatPlant()
	{
		super();
		Player.getWorld().getPlayer().plantIt("CatPlant");
	}
}
