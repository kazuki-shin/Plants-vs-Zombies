/**
 * Kazuki Shin
 * 1st Period
 * 5/24/16
 * Mine is a plant that self destructs and kills the zombie which tried to eat it
 */

package Pvz;

/**
 * Mine is a plant that self destructs and kills the zombie which tried to eat it
 */
public class Mine extends NonAttackingPlant {

	/**
	 * Constructs a plant which explodes
	 */
	public Mine()
	{
		super();
		Player.getWorld().getPlayer().plantIt("Mine");
	}

}
