/**
 * Kazuki Shin
 * 1st Period
 * 5/24/16
 * MultiPeaShooter shoots multiple peas at zombies
 */

package Pvz;
/**
 * MultiPeaShooter shoots multiple peas at zombies
 */
public class MultiPeaShooter extends AttackingPlant {

	/**
	 * Constructs a plant that shoots multiple peas 
	 */
	public MultiPeaShooter()
	{
		super();
		Player.getWorld().getPlayer().plantIt("MultiPeaShooter");
	}

}
