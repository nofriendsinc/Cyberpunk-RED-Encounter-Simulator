package cyberpunk.Weapons;
import cyberpunk.Dice;
import cyberpunk.RangeFinder;

public class RangedWeapon extends Weapon
{
	private static final int range0To6 = 0;
	private static final int range7To12 = 1;
	private static final int range13To25 = 2;
	private static final int range26To50 = 3;
	private static final int range51To100 = 4;
	private static final int range101To200 = 5;
	private static final int range201To400 = 6;
	private static final int range401To800 = 7;
	
	
	public int[] rangeDC;
	public int damageDice;
	public int ROF;
	public Dice dice = new Dice();
	public int skill;
	public static int inMag;
	public int maxMag;
	
	public RangedWeapon()
	{
		
	}
	
	public RangedWeapon(int skill)
	{
		this.skill = skill;
	}
	
	public static void removeInMag(int shots)
	{
		inMag -= shots;
	}
	
	public boolean rollToHit(int range, int skill)
	{
		if(inMag > 0)
		{
			int DC = 0;
			int roll = dice.rollD10();
			
			DC = new RangeFinder().getRangeDC(range);
			
			try
			{
				int i = rangeDC[DC];
			}
			catch(Exception e)
			{
				return false;
			}
			
			inMag--;

			if(roll + skill > rangeDC[DC])
			{
				return true;
			}
		}
		else
		{
			return false;
		}
		
		return false;
	}
	
	public static int checkMag()
	{
		return inMag;
	}
	
	public int reload(int ammo)
	{
		if(ammo >= this.maxMag)
		{
			inMag = this.maxMag;
			return ammo - (maxMag - inMag);
		}
		else
		{
			inMag += ammo;
			return 0;
		}
	}
	
	public int[] getRangeDC()
	{
		return this.rangeDC;
	}
}
