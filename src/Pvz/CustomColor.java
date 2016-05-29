/**
 * Kazuki Shin
 * 1st Period
 * 5/24/16
 * CustomColor creates colors which are not apart of the Color class
 */

package Pvz;
import java.awt.Color;

/**
 * CustomColor creates colors which are not apart of the Color class
 */
public class CustomColor {

	/**
	 * Creates a custom made green color
	 * @return the custom made green color
	 */
	public static Color green()
	{
		int red = 50;
        int blue = 50;
        int green = 205;
        return new Color(red,green,blue);
	}
	
	
}
