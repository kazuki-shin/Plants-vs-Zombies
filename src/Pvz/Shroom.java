/**
 * Kazuki Shin
 * 1st Period
 * 5/24/16
 * Shroom gives small amounts suncredits over time
 */

package Pvz;

/**
 * Shroom gives small amounts suncredits over time
 */
public class Shroom extends NonAttackingPlant{

	/**
	 * Constructs a plant that gives a small amount of sun credits over time
	 */
	public Shroom(){
		super();
		Player.getWorld().getPlayer().plantIt("Shroom");
	}
}
