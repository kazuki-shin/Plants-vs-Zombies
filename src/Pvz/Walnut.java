/**
 * Kazuki Shin
 * 1st Period
 * 5/24/16
 * Walnut has high hp
 */

package Pvz;

import javax.swing.ImageIcon;

/**
 * Walnut has high hp
 */
public class Walnut extends NonAttackingPlant {
	
	private String suffix;
	
	public Walnut()
	{
		setHp(10);
		setOriginalHp(8);
		Player.getWorld().getPlayer().plantIt("Walnut");
	}
	
	public void act()
	{
		super.act();
	}
	
	public String getImageSuffix()
	{
		return "_" + suffix;
	}
	
	public void setSuffix(String suffix)
	{
		this.suffix = suffix;
	}
}
