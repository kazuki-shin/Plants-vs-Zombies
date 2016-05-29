/**
 * Kazuki Shin
 * 1st Period
 * 5/24/16
 * DoublePeaShooter shoots 2 peas at once
 */

package Pvz;

/**
 * DoublePeaShooter shoots 2 peas at once
 */
public class DoublePeaShooter extends AttackingPlant {
	
	/**
	 * Constructs a plant that shoots 2 peas at once
	 */
	public DoublePeaShooter()
	{
		super();
		Player.getWorld().getPlayer().plantIt("DoublePeaShooter");
	}
}
