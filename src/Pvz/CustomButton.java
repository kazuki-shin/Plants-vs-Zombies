/**
 * Kazuki Shin
 * 1st Period
 * 5/24/16
 * A CustomButton edits buttons to various types for GUIs
 */

package Pvz;

import java.awt.Color;
import javax.swing.JButton;

/**
 * A CustomButton edits buttons to various types for GUIs
 */
public class CustomButton {
	
	/**
	 * Edits a button as type 1
	 * @param button the button to edit
	 */
	public static void makeButton1(JButton button)
	{
		button.setBackground(Color.BLACK);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setForeground(Color.GREEN);
	}
	
	/**
	 * Edits a button as type 2
	 * @param button
	 */
	public static void makeButton2(JButton button)
	{
		button.setBackground(Color.BLACK);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setForeground(Color.GREEN);
	}
	
}
