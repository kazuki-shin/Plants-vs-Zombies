/**
 * Kazuki Shin
 * 1st Period
 * 5/24/16
 * FreezePlant is a plant that slows zombies down
 */

package Pvz;

/**
 * FreezePlant is a plant that slows zombies down
 */
public class FreezePlant extends NonAttackingPlant {

	/**
	 * Constructs a plant that slows zombies down while also subtracting the player's sun credits
	 */
	public FreezePlant()
	{
		super();
		Player.getWorld().getPlayer().plantIt("FreezePlant");
	}
}
