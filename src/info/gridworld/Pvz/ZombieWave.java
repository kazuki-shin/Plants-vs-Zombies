/**
 * Kazuki Shin
 * 1st Period
 * 5/24/16
 * A ZombieWave creates waves of zombies to generate in the world
 */

package info.gridworld.Pvz;

import Pvz.Blank;
import Pvz.BucketZombie;
import Pvz.BucketZombieInfo;
import Pvz.Cactus;
import Pvz.CactusInfo;
import Pvz.CatPlant;
import Pvz.CatPlantInfo;
import Pvz.CaveZombie;
import Pvz.CaveZombieInfo;
import Pvz.ConeZombie;
import Pvz.ConeZombieInfo;
import Pvz.DancerZombie;
import Pvz.DancerZombieInfo;
import Pvz.DoubleFirePeaShooter;
import Pvz.DoubleFirePeaShooterInfo;
import Pvz.DoublePeaShooter;
import Pvz.DoublePeaShooterInfo;
import Pvz.ElfZombie;
import Pvz.ElfZombieInfo;
import Pvz.FirePeaShooter;
import Pvz.FirePeaShooterInfo;
import Pvz.FootballZombie;
import Pvz.FootballZombieInfo;
import Pvz.FrankenShooter;
import Pvz.FreezePlant;
import Pvz.FreezePlantInfo;
import Pvz.FutureWalnut;
import Pvz.FutureWalnutInfo;
import Pvz.LetterPBottom;
import Pvz.LetterPTop;
import Pvz.LetterV;
import Pvz.LetterZBottom;
import Pvz.LetterZTop;
import Pvz.Mine;
import Pvz.MineInfo;
import Pvz.MultiPeaShooter;
import Pvz.MultiPeaShooterInfo;
import Pvz.MummyZombie;
import Pvz.MummyZombieInfo;
import Pvz.Peashooter;
import Pvz.PeashooterInfo;
import Pvz.PirateZombie;
import Pvz.PirateZombieInfo;
import Pvz.PvzWorld;
import Pvz.RabbitZombie;
import Pvz.RabbitZombieInfo;
import Pvz.Shroom;
import Pvz.ShroomInfo;
import Pvz.SnailZombie;
import Pvz.SnailZombieInfo;
import Pvz.SnorkelZombie;
import Pvz.SnorkelZombieInfo;
import Pvz.Sunflower;
import Pvz.SunflowerInfo;
import Pvz.Unit;
import Pvz.Walnut;
import Pvz.WalnutInfo;
import Pvz.Zombie;
import Pvz.ZombieInfo;
import info.gridworld.grid.Location;
/**
 * A ZombieWave creates waves of zombies to generate in the world
 */
public class ZombieWave {
	
	private PvzWorld world;
	
	/**
	 * Creates waves of zombies and adds them in the world
	 * @param world sets the world for this class
	 */
	public ZombieWave(PvzWorld world)
	{
		this.world = world;
	}
	
	/**
	 * Creates a wave of zombies of type 1
	 */
	public void wave1()
	{
		world.add(new Location(1,17),new Zombie(51,world));
		world.add(new Location(2,17),new Zombie(100,world));
		world.add(new Location(3,17),new Zombie(90,world));
		world.add(new Location(4,17),new Zombie(74,world));
		world.add(new Location(5,17),new Zombie(110,world));
	}
	
	/**
	 * Creates a wave of zombies type 2
	 */
	public void wave2()
	{
	
		world.add(new Location(1,15),new Zombie(51,world));
		world.add(new Location(2,15),new Zombie(100,world));
		world.add(new Location(3,15),new Zombie(90,world));
		world.add(new Location(4,15),new Zombie(74,world));
		world.add(new Location(5,15),new Zombie(110,world));
	}
	
	/**
	 * Creates a wave of zombies type 3
	 */
	public void wave3()
	{
		for(int i = 0; i <= 5; i++)
		{
			world.add(new Location(i,17),new RabbitZombie());
			if(i%2==1)
			world.add(new Location(i,16),new FootballZombie());
			if(i%2==0)
			world.add(new Location(i,16),new DancerZombie());
		}
	}

	/**
	 * Sets up various objects for the encyclopedia
	 */
	public void display()
	{
		int count = 1;
		Unit figure = null;
		int rows = world.getGrid().getNumRows();
		int cols = world.getGrid().getNumCols();
		for(int i = 0; i< rows; i++)
		{
			for(int j = 0; j < cols; j++)
			{  
				
					switch(count)
					{
						case 1: figure = new Zombie(); break;
						case 2: figure = new ZombieInfo(); break;
						case 3: figure = new BucketZombie(); break;
						case 4: figure = new BucketZombieInfo(); break;
						case 5: figure = new ConeZombie(); break;
						case 6: figure = new ConeZombieInfo(); break;
						case 7: figure = new DancerZombie(); break;
						case 8: figure = new DancerZombieInfo(); break;
						case 9: figure = new FootballZombie(); break;
						case 10: figure = new FootballZombieInfo(); break;
						case 11: figure = new LetterPTop(); break;
						case 12: figure = new MummyZombie(); break;
						case 13: figure = new MummyZombieInfo(); break;
						case 14: figure = new PirateZombie(); break;
						case 15: figure = new PirateZombieInfo(); break;
						case 16: figure = new RabbitZombie(); break;
						case 17: figure = new RabbitZombieInfo(); break;
						case 18: figure = new SnorkelZombie(); break;
						case 19: figure = new SnorkelZombieInfo(); break;
						case 20: figure = new ElfZombie(); break;
						case 21: figure = new ElfZombieInfo(); break;
						case 22: figure = new LetterPBottom(); break;
						case 23: figure = new CaveZombie(); break;
						case 24: figure = new CaveZombieInfo(); break;
						case 25: figure = new SnailZombie(); break;
						case 26: figure = new SnailZombieInfo(); break;
						case 27: figure = new Sunflower(); break;
						case 28: figure = new SunflowerInfo(); break;
						case 29: figure = new Shroom(); break;
						case 30: figure = new ShroomInfo(); break;
						case 31: figure = new Mine(); break;
						case 32: figure = new MineInfo(); break;
						case 33: figure = new LetterV(); break;
						case 34: figure = new Peashooter(); break;
						case 35: figure = new PeashooterInfo(); break;
						case 36: figure = new DoublePeaShooter(); break;
						case 37: figure = new DoublePeaShooterInfo(); break;
						case 38: figure = new MultiPeaShooter(); break;
						case 39: figure = new MultiPeaShooterInfo(); break;
						case 40: figure = new FirePeaShooter(); break;
						case 41: figure = new FirePeaShooterInfo(); break;
						case 42: figure = new DoubleFirePeaShooter(); break;
						case 43: figure = new DoubleFirePeaShooterInfo(); break;
						case 44: figure = new LetterZTop(); break;
						case 45: figure = new Walnut(); break;
						case 46: figure = new WalnutInfo(); break;
						case 47: figure = new Cactus(); break;
						case 48: figure = new CactusInfo(); break;
						case 49: figure = new FreezePlant(); break;
						case 50: figure = new FreezePlantInfo(); break;
						case 51: figure = new FutureWalnut(); break;
						case 52: figure = new FutureWalnutInfo(); break;
						case 53: figure = new CatPlant(); break;
						case 54: figure = new CatPlantInfo(); break;
						case 55: figure = new LetterZBottom(); break;
						default: figure = new Blank(); break;
					}
					world.add(new Location(i,j),figure);
				count++;
			}
		} 
	}

	
}
