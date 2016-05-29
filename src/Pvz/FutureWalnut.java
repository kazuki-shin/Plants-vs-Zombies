/**
 * Kazuki Shin
 * 1st Period
 * 5/24/16
 * Future Walnut is a futuristic upgrade of a normal walnut.
 */

package Pvz;

/**
 * Future Walnut is a futuristic upgrade of a normal walnut.
 */
public class FutureWalnut extends NonAttackingPlant {
	
	/**
	 * Constructs a futurisic walnut plant
	 */
	public FutureWalnut()
	{
		super();
		Player.getWorld().getPlayer().plantIt("FutureWalnut");
	}

}
