/**
 * Kazuki Shin
 * 1st Period
 * 5/24/16
 * 
 */

package Pvz;
import java.io.IOException;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import net.codejava.swing.jtable.HighScoreTable;

/**
 * Zombie is the basic enemy object
 */
public class Zombie extends Unit{
	
	private int turn;
	private Sound hit;
	private int startTime =5;
	private PvzWorld world;
	
	/**
	 * Constructs a basic enemy 
	 */
	public Zombie()
	{
		setHp(3);
		setDirection(270);
		turn = 0;
		hit = new Sound();
	}
	
	/**
	 * Constructs a basic enemy with a set start times
	 * @param startTime the time to start the zomies moving
	 */
	public Zombie(int startTime, PvzWorld world)
	{
		this.world = world;
		this.startTime = startTime;
		setHp(3);
		setDirection(270);
		turn = 0;
		hit = new Sound();
	}
	
	/**
	 * Checks to see if the zombie can move or is taking damage
	 */
	public void act()
	{
		if ((canMove() && (turn%4==0 || lookTwo())) && turn >= startTime)
            move();
		if(isHit())
		{
			hit.playSound("woodchopping.wav");
			setHp(getHp()-1);
		}
		else if(isAttacked() && turn%AttackingPlant.getShootPace()==0)
		{
			hit.playSound("woodchopping.wav");
			setHp(getHp()-1);
		}
		if(getHp()<=0)
		{
			Player.addKills();
			randomZombie().putSelfInGrid(this.getGrid(), new Location(this.getLocation().getRow(),15));
			removeSelfFromGrid();
			
		}
		if(this.getLocation() !=null)
		if(this.getLocation().getCol()<2)
		{
			PvzWorld.gameOver();
			try {
				ScoreReader.saveToFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.exit(0);
			//CustomMessage.gameOver();
		}
		turn++;
	}
	
	/**
	 * Zombie moves if possible
	 */
	public void move()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (gr.isValid(next))
            moveTo(next);
        else
            removeSelfFromGrid();
    }
	
	/**
	 * gets the time for the zombie
	 */
	public int getStartTime() {
		return startTime;
	}

	/**
	 * Changes the start time for each zombie
	 * @param startTime
	 */
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	/**
	 * Checks to see if the zombie was attacked or not
	 */
	//if zombie is next to an attacking plant
	public boolean isAttacked()
	{
	        Grid<Actor> gr = getGrid();
	        if (gr == null)
	            return false;
	        Location loc = getLocation();
	        Location next = loc.getAdjacentLocation(270);
	        if (!gr.isValid(next))
	            return false;
	        Actor neighbor = gr.get(next);
	        return(neighbor instanceof AttackingPlant);
	        //return (neighbor instanceof Pea) || (neighbor instanceof AttackingPlant);
	}
	
	/**
	 * Checks to see if anyone is hit or not
	 * @return if anyone has hit it or not
	 */
	public boolean isHit()
	{
	        Grid<Actor> gr = getGrid();
	        if (gr == null)
	            return false;
	        Location loc = getLocation();
	        Location next = loc.getAdjacentLocation(270);
	        if (!gr.isValid(next))
	            return false;
	        Actor neighbor = gr.get(next);
	        return(neighbor instanceof Pea);
	        //return (neighbor instanceof Pea) || (neighbor instanceof AttackingPlant);
	}
	
	/**
	 * looks two spots over to see if there is a zombie near by
	 * @return if there is a zombie near bys
	 */
	//if zombie is 2 away from zombie
	public boolean lookTwo()
	{
		Grid<Actor> gr = getGrid();
        if (gr == null)
            return false;
        Location loc = getLocation();
        Location next = new Location(loc.getRow(),loc.getCol()-2);
        if (!gr.isValid(next))
            return false;
        Actor neighbor = gr.get(next);
        return(neighbor instanceof Pea);
	}	
	
	public static Zombie randomZombie()
	{
		int chooser = (int) (Math.random()*11);
		switch(chooser)
		{
		case 0: return new Zombie();
		case 1: return new BucketZombie();
		case 2: return new ConeZombie();
		case 3: return new DancerZombie();
		case 4: return new FootballZombie();
		case 5: return new MummyZombie();
		case 6: return new PirateZombie();
		case 7: return new RabbitZombie();
		case 8: return new SnorkelZombie();
		case 9: return new ElfZombie();
		case 10: return new CaveZombie();
		case 11: return new SnailZombie();
		default: return new Zombie();
		}

	}
	
	
	
}
