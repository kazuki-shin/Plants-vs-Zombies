/**
 * Kazuki Shin
 * 1st Period
 * 5/24/16
 * DoubleFirePeaShooter shoots 2 fire peas at once
 */

package Pvz;

/**
 * DoubleFirePeaShooter shoots 2 fire peas at once
 */
public class DoubleFirePeaShooter extends AttackingPlant {
	
	/**
	 * Constructs a plant which shoots 2 fire peas at once
	 */
	public DoubleFirePeaShooter()
	{
		super();
		Player.getWorld().getPlayer().plantIt("DoubleFirePeaShooter");
	}
}
