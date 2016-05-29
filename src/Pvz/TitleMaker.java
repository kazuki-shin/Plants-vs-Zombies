/**
 * Kazuki Shin
 * 1st Period
 * 5/24/16
 * TitleMaker is the title for the game
 */

package Pvz;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.basic.BasicMenuBarUI;

import info.gridworld.actor.Actor;
import info.gridworld.grid.BoundedGrid;
import net.codejava.swing.jtable.HighScoreTable;

/**
 * TitleMaker is the title for the game
 */
public class TitleMaker {

	private static Sound music;
	
	/**
	 * Makes the title for the game
	 */
	public static void makeTitle()
	{
		music = new Sound();
		
		//frame
		JFrame frame = new JFrame("Game by Kazuki Shin");
		
		
		//panels
	    JPanel panel = new JPanel();
	    JPanel panel1 = new JPanel (new BorderLayout(2,2));
        JPanel panel2 = new JPanel (new BorderLayout(2,2));
        JPanel buttonPanel = new JPanel(new BorderLayout(2,2));
        panel.setLayout(new BorderLayout());
        
        
        ImageIcon titleImage = new ImageIcon("PvzTitle.png");
        Image img = titleImage.getImage();  
        Image newimg = img.getScaledInstance( 800, 400,  java.awt.Image.SCALE_SMOOTH ) ;  
        titleImage = new ImageIcon( newimg );
        //JLabel label1 = new JLabel(titleImage);
        JButton titleButton = new JButton(titleImage);
        titleButton.setBackground(Color.BLACK);
        titleButton.setOpaque(true);
        titleButton.setBorderPainted(false);
        titleButton.addActionListener(new ActionListener()
        {
            @Override
			public void actionPerformed(ActionEvent e)
            {
            	Instructions.show();
            }
        });
        
        JButton button0 = new JButton ("Encyclopedia");
        CustomButton.makeButton1(button0);
        button0.setFont(new Font("Serif", Font.PLAIN, 50));
        //button0.setForeground(Color.DARK_GRAY);
        button0.addActionListener(new ActionListener()
        {
            @Override
			public void actionPerformed(ActionEvent e)
            {
            	startEncyclopedia(frame);
            }
        });
        
        //start button
        JButton button1 = new JButton ("Start Game");
        CustomButton.makeButton1(button1);
        button1.setFont(new Font("Serif", Font.PLAIN, 50));
        //button1.setForeground(Color.DARK_GRAY);
        button1.addActionListener(new ActionListener()
        {
            @Override
			public void actionPerformed(ActionEvent e)
            {
            	startGame(frame);
            }
        });
        
        JButton button2 = new JButton ("Score Log");
        CustomButton.makeButton1(button2);
        button2.setFont(new Font("Serif", Font.PLAIN, 50));
        //button2.setForeground(Color.DARK_GRAY);
        button2.addActionListener(new ActionListener()
        {
            @Override
			public void actionPerformed(ActionEvent e)
            {
            	startHighScore(frame);
            }
        });
        
        JLabel label3 = new JLabel("Click Title for Instructions!", SwingConstants.CENTER);
        label3.setFont(new Font("MonoSpaced",Font.BOLD,30));
        label3.setForeground(Color.GREEN);
        
        panel1.add(label3,BorderLayout.NORTH);
        panel1.add(titleButton, BorderLayout.CENTER);
        panel1.setBackground(Color.BLACK);
        
        buttonPanel.add(button1, BorderLayout.CENTER);
        buttonPanel.add(button0, BorderLayout.EAST);
        buttonPanel.add(button2, BorderLayout.WEST);
        panel2.add(buttonPanel, BorderLayout.CENTER);

        panel.add(panel1, BorderLayout.CENTER);
        panel.add(panel2, BorderLayout.SOUTH);
		
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);

        frame.add(panel);
        frame.setBounds(120, 110, 0, 0);
        //Dimension d = new Dimension(1000,500);
        Dimension d = new Dimension(1200,600);
        frame.setPreferredSize(d);
        
        frame.pack();
        frame.setVisible(true);
        
        //music playing
        music = new Sound();
        int instance = ((int)(Math.random()*4))+1;
        switch(instance)
        {
        	case 1: music.playLoopSound("plants_vs_zombies.wav"); break;
        	case 2: music.playLoopSound("level1.wav"); break;
        	case 3: music.playLoopSound("level2.wav"); break;
        	case 4: music.playLoopSound("level3.wav"); break;
        }
		
	}
	
	/**
	 * Opens the starting world for the game
	 * @param frame past frames to dispose
	 */
	public static void startGame(JFrame frame)
	{
		frame.dispose();
		music.getClip().stop();
		PvzWorld.selectWorld();
	}
	
	/**
	 * shows an encyvlopedia of all the zombies and plants
	 * @param frame past frames to dispose
	 */
	public static void startEncyclopedia(JFrame frame)
	{
		music.getClip().stop();
		frame.dispose();
    	new PvzWorld(new BoundedGrid<Actor>(5,11), "Display"); 
	}
	
	/**
	 * A log of all the players that played the game
	 * @param frame past frames to dispose
	 */
	public static void startHighScore(JFrame frame)
	{
		//frame.dispose();
		HighScoreTable table = new HighScoreTable();
		table.setVisible(true);
				
	}
	
	/**
	 * Stops the music from the title page
	 */
	public static void stopTitleMusic()
	{
		music.getClip().close();
	}
	
}
