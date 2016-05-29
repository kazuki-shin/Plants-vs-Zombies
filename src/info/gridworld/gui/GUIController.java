/**
 * Kazuki Shin
 * 1st Period
 * 5/24/16
 * 
 */

package info.gridworld.gui;

import info.gridworld.Pvz.ZombieWave;
import info.gridworld.actor.Actor;
import info.gridworld.grid.*;
import info.gridworld.world.World;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Pvz.Cactus;
import Pvz.CatPlant;
import Pvz.DoubleFirePeaShooter;
import Pvz.DoublePeaShooter;
import Pvz.FirePeaShooter;
import Pvz.FreezePlant;
import Pvz.FutureWalnut;
import Pvz.Mine;
import Pvz.MultiPeaShooter;
import Pvz.Peashooter;
import Pvz.Player;
import Pvz.PvzWorld;
import Pvz.ScoreReader;
import Pvz.Shroom;
import Pvz.Sound;
import Pvz.Sunflower;
import Pvz.TitleMaker;
import Pvz.Unit;
import Pvz.Walnut;
import Pvz.Zombie;

import javax.imageio.ImageIO;
import javax.swing.*;


/**
 * The GUIController controls the behavior in a WorldFrame. <br />
 * This code is not tested on the AP CS A and AB exams. It contains GUI
 * implementation details that are not intended to be understood by AP CS
 * students.
 */

public class GUIController<T>
{
    public static final int INDEFINITE = 0, FIXED_STEPS = 1, PROMPT_STEPS = 2;

    private static final int MIN_DELAY_MSECS = 10, MAX_DELAY_MSECS = 1000;
    private static final int INITIAL_DELAY = MIN_DELAY_MSECS
            + (MAX_DELAY_MSECS - MIN_DELAY_MSECS) / 2;

    private Timer timer;
    private JButton stepButton, runButton, stopButton, newGameButton, quitButton,menuButton, nextLevel;
    private JComponent controlPanel;
    private GridPanel display;
    private WorldFrame<T> parentFrame;
    private int numStepsToRun, numStepsSoFar;
    private ResourceBundle resources;
    private DisplayMap displayMap;
    private boolean running;
    private Set<Class> occupantClasses;
    private String worldType;
    public static int time;
    //private Sound music;
    private int runCount;

    /**
     * Creates a new controller tied to the specified display and gui
     * frame.
     * @param parent the frame for the world window
     * @param disp the panel that displays the grid
     * @param displayMap the map for occupant displays
     * @param res the resource bundle for message display
     */
    public GUIController(WorldFrame<T> parent, GridPanel disp,
            DisplayMap displayMap, ResourceBundle res)
    {
        resources = res;
        display = disp;
        parentFrame = parent;
        this.displayMap = displayMap;
        this.worldType = parent.getWorldType();
        //this.music = parent.getWorld().getSound();
        runCount = 0;
        makeControls();

        occupantClasses = new TreeSet<Class>(new Comparator<Class>()
        {
            @Override
			public int compare(Class a, Class b)
            {
                return a.getName().compareTo(b.getName());
            }
        });

        World<T> world = parentFrame.getWorld();
        Grid<T> gr = world.getGrid();
        for (Location loc : gr.getOccupiedLocations())
            addOccupant(gr.get(loc));
        for (String name : world.getOccupantClasses())
            try
            {
                occupantClasses.add(Class.forName(name));
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }

        timer = new Timer(INITIAL_DELAY, new ActionListener()
        {
            @Override
			public void actionPerformed(ActionEvent evt)
            {
                step();
            }
        });

        display.addMouseListener(new MouseAdapter()
        {
            @Override
			public void mousePressed(MouseEvent evt)
            {
                Grid<T> gr = parentFrame.getWorld().getGrid();
                Location loc = display.locationForPoint(evt.getPoint());
                //if (loc != null && gr.isValid(loc) && !isRunning())
                if (loc != null && gr.isValid(loc))
                {
                    display.setCurrentLocation(loc);
                    locationClicked();
                }
            }
        });
        stop();
    }

    /**
     * Advances the world one step.
     */
    public void step()
    {
        parentFrame.getWorld().step();
        parentFrame.repaint();
        if (++numStepsSoFar == numStepsToRun)
            stop();
        Grid<T> gr = parentFrame.getWorld().getGrid();

        for (Location loc : gr.getOccupiedLocations())
            addOccupant(gr.get(loc));
        if(Player.getTime()<80)
        	nextLevel.setEnabled(false);
        if(Player.getTime()>=80)
        {
        	nextLevel.setEnabled(true);
        	stop();
        }
        if(time%2==0)
        Player.addTime();
        time++;
    }
    
    public PvzWorld nextLevel()
    {
    	quit();
    	BoundedGrid<Actor> grid = new BoundedGrid<Actor>(7,18);
    	time = 0;
    	Player.clearTime();
    	switch(worldType)
    	{
    	case "Day": return new PvzWorld(grid, "Underwater"); 
    	case "Underwater": return new PvzWorld(grid, "Haunted House"); 
    	case "Haunted House": return new PvzWorld(grid, "Castle"); 
    	case "Castle": return new PvzWorld(grid, "Volcano"); 
    	case "Volcano": return new PvzWorld(grid, "Sky"); 
    	case "Sky": JOptionPane.showMessageDialog(null, "Good job, You finished the game!");
					try {
						ScoreReader.saveToFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.exit(0); break;
    	}
    	return new PvzWorld(grid, "Sky"); 
    }

    private void addOccupant(T occupant)
    {
    	/**
    	Class cl = occupant.getClass();
        do
        {
            if ((cl.getModifiers() & Modifier.ABSTRACT) == 0)
                occupantClasses.add(cl);
            cl = cl.getSuperclass();
        }
        while (cl != Object.class);
        */
    	
    	if(Player.getCredits()>=50)
    		occupantClasses.add(Sunflower.class);
    	if(Player.getCredits()<50)
    		occupantClasses.remove(Sunflower.class);
    	
    	if(Player.getCredits()>=100)
    		occupantClasses.add(Peashooter.class);
    	if(Player.getCredits()<100)
    		occupantClasses.remove(Peashooter.class);
    	
    	if(Player.getCredits()>=150)
    		occupantClasses.add(DoublePeaShooter.class);
    	if(Player.getCredits()<150)
    		occupantClasses.remove(DoublePeaShooter.class);
    	
    	if(Player.getCredits()>=150)
    		occupantClasses.add(MultiPeaShooter.class);
    	if(Player.getCredits()<150)
    		occupantClasses.remove(MultiPeaShooter.class);
    	
    	if(Player.getCredits()>=150)
    		occupantClasses.add(FirePeaShooter.class);
    	if(Player.getCredits()<150)
    		occupantClasses.remove(FirePeaShooter.class);
    	
    	if(Player.getCredits()>=200)
    		occupantClasses.add(DoubleFirePeaShooter.class);
    	if(Player.getCredits()<200)
    		occupantClasses.remove(DoubleFirePeaShooter.class);
    	
    	if(Player.getCredits()>=125)
    		occupantClasses.add(Cactus.class);
    	if(Player.getCredits()<125)
    		occupantClasses.remove(Cactus.class);
    	
    	if(Player.getCredits()>=100)
    		occupantClasses.add(CatPlant.class);
    	if(Player.getCredits()<100)
    		occupantClasses.remove(CatPlant.class);
    	
    	if(Player.getCredits()>=50)
    		occupantClasses.add(Walnut.class);
    	if(Player.getCredits()<50)
    		occupantClasses.remove(Walnut.class);
    	
    	if(Player.getCredits()>=100)
    		occupantClasses.add(FutureWalnut.class);
    	if(Player.getCredits()<100)
    		occupantClasses.remove(FutureWalnut.class);
    	
    	if(Player.getCredits()>=25)
    		occupantClasses.add(Shroom.class);
    	if(Player.getCredits()<25)
    		occupantClasses.remove(Shroom.class);
    	
    	if(Player.getCredits()>=25)
    		occupantClasses.add(Mine.class);
    	if(Player.getCredits()<25)
    		occupantClasses.remove(Mine.class);
    	
    	if(Player.getCredits()>=25)
    		occupantClasses.add(FreezePlant.class);
    	if(Player.getCredits()<25)
    		occupantClasses.remove(FreezePlant.class);
    }
    
    public void updateOccupant()
    {
    }
    
    public Set<Class> getOccClass()
    {
    	return occupantClasses;
    }

    /**
     * Starts a timer to repeatedly carry out steps at the speed currently
     * indicated by the speed slider up Depending on the run option, it will
     * either carry out steps for some fixed number or indefinitely
     * until stopped.
     */
    public void run()
    {
    	if(runCount==0)
    	{
    		Sound music = new Sound();
    		music.playSound("zombiesAreComing.wav");
    		runCount++;
    	}
        display.setToolTipsEnabled(false); // hide tool tips while running
        parentFrame.setRunMenuItemsEnabled(false);
        stopButton.setEnabled(true);
        stepButton.setEnabled(false);
        runButton.setEnabled(false);
        numStepsSoFar = 0;
        timer.start();
        running = true;
    }
    
    public void toMenu()
    {
    	TitleMaker.makeTitle();
    }
    
    public void quit()
    {
    	stop();
    	World<T> world = parentFrame.getWorld();
    	int numRows = world.getGrid().getNumRows();
    	int numCols = world.getGrid().getNumCols();
    	
    	for(int i =0; i<numRows; i++)
    	{
    		for(int j = 0; j < numCols; j++)
    		{
    			if( world.getGrid().get(new Location(i,j))instanceof Unit)
    			{
    				world.remove(new Location(i,j));
    			}
    		}
    		
    	}
    	world.getFrame().dispose();
    }
    
   
    /**
     * Stops any existing timer currently carrying out steps.
     */
    public void stop()
    {
        display.setToolTipsEnabled(true);
        parentFrame.setRunMenuItemsEnabled(true);
        timer.stop();
        stopButton.setEnabled(false);
        runButton.setEnabled(true);
        stepButton.setEnabled(true);
        running = false;
    }

    public boolean isRunning()
    {
        return running;
    }

    /**
     * Builds the panel with the various controls (buttons and
     * slider).
     */
    private void makeControls()
    {
        controlPanel = new JPanel();
        stepButton = new JButton(resources.getString("button.gui.step"));
        //runButton = new JButton(resources.getString("button.gui.run"));
        runButton = new JButton("Start Wave");
        stopButton = new JButton(resources.getString("button.gui.stop"));
        menuButton = new JButton("Back to Menu");
        quitButton = new JButton("Quit");
        nextLevel = new JButton("Next Level");
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.X_AXIS));
        controlPanel.setBorder(BorderFactory.createEtchedBorder());
        
        Dimension spacer = new Dimension(5, stepButton.getPreferredSize().height + 10);
        
        controlPanel.add(Box.createRigidArea(spacer));
        
        //controlPanel.add(stepButton);
        //controlPanel.add(Box.createRigidArea(spacer));
        controlPanel.add(runButton);
        controlPanel.add(Box.createRigidArea(spacer));
        //controlPanel.add(stopButton);
        //controlPanel.add(Box.createRigidArea(spacer));
        controlPanel.add(nextLevel);
        controlPanel.add(Box.createRigidArea(spacer));
        controlPanel.add(menuButton);
        controlPanel.add(Box.createRigidArea(spacer));
        controlPanel.add(quitButton);
        controlPanel.add(Box.createRigidArea(spacer));
        
        runButton.setEnabled(false);
        stepButton.setEnabled(false);
        stopButton.setEnabled(false);
        quitButton.setEnabled(true);
        nextLevel.setEnabled(false);
        
        controlPanel.add(Box.createRigidArea(spacer));
        controlPanel.add(new JLabel(resources.getString("slider.gui.slow")));
        JSlider speedSlider = new JSlider(MIN_DELAY_MSECS, MAX_DELAY_MSECS,
                INITIAL_DELAY);
        speedSlider.setInverted(true);
        speedSlider.setPreferredSize(new Dimension(100, speedSlider
                .getPreferredSize().height));
        speedSlider.setMaximumSize(speedSlider.getPreferredSize());

        // remove control PAGE_UP, PAGE_DOWN from slider--they should be used
        // for zoom
        InputMap map = speedSlider.getInputMap();
        while (map != null)
        {
            map.remove(KeyStroke.getKeyStroke("control PAGE_UP"));
            map.remove(KeyStroke.getKeyStroke("control PAGE_DOWN"));
            map = map.getParent();
        }

        controlPanel.add(speedSlider);
        controlPanel.add(new JLabel(resources.getString("slider.gui.fast")));
        controlPanel.add(Box.createRigidArea(new Dimension(5, 0)));

        stepButton.addActionListener(new ActionListener()
        {
            @Override
			public void actionPerformed(ActionEvent e)
            {
                step();
            }
        });
        menuButton.addActionListener(new ActionListener()
        {
            @Override
			public void actionPerformed(ActionEvent e)
            {
                quit();
                toMenu();
            }
        });
        nextLevel.addActionListener(new ActionListener()
        {
            @Override
			public void actionPerformed(ActionEvent e)
            {
                nextLevel();
            }
        });
        runButton.addActionListener(new ActionListener()
        {
            @Override
			public void actionPerformed(ActionEvent e)
            {
                run();
            }
        });
        quitButton.addActionListener(new ActionListener()
        {
            @Override
			public void actionPerformed(ActionEvent e)
            {
                quit();
            }
        });
        //
        stopButton.addActionListener(new ActionListener()
        {
            @Override
			public void actionPerformed(ActionEvent e)
            {
                stop();
            }
        });
        speedSlider.addChangeListener(new ChangeListener()
        {
            @Override
			public void stateChanged(ChangeEvent evt)
            {
                timer.setDelay(((JSlider) evt.getSource()).getValue());
            }
        });
    }

    /**
     * Returns the panel containing the controls.
     * @return the control panel
     */
    public JComponent controlPanel()
    {
        return controlPanel;
    }

    /**
     * Callback on mousePressed when editing a grid.
     */
    private void locationClicked()
    {
        World<T> world = parentFrame.getWorld();
        Location loc = display.getCurrentLocation();
        if (loc != null && !world.locationClicked(loc))
            editLocation();
        parentFrame.repaint();
    }

    /**
     * Edits the contents of the current location, by displaying the constructor
     * or method menu.
     */
    public void editLocation()
    {
        World<T> world = parentFrame.getWorld();

        Location loc = display.getCurrentLocation();
        if (loc != null)
        {
            T occupant = world.getGrid().get(loc);
            if (occupant == null)
            {
                MenuMaker<T> maker = new MenuMaker<T>(parentFrame, resources,
                        displayMap);
                JPopupMenu popup = maker.makeConstructorMenu(occupantClasses,
                        loc);
                Point p = display.pointForLocation(loc);
                popup.show(display, p.x, p.y);
            }
            else
            {
                MenuMaker<T> maker = new MenuMaker<T>(parentFrame, resources,
                        displayMap);
                JPopupMenu popup = maker.makeMethodMenu(occupant, loc);
                Point p = display.pointForLocation(loc);
                popup.show(display, p.x, p.y);
            }
        }
        parentFrame.repaint();
    }

    /**
     * Edits the contents of the current location, by displaying the constructor
     * or method menu.
     */
    public void deleteLocation()
    {
        World<T> world = parentFrame.getWorld();
        Location loc = display.getCurrentLocation();
        if (loc != null)
        {
            world.remove(loc);
            parentFrame.repaint();
        }
    }
}
