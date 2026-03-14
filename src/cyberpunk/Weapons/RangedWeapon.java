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
	
	
	protected int[] rangeDC = {50,50,50,50,50,50,50,50};
	protected static int inMag;
	protected int maxMag;
	
	public RangedWeapon()
	{
		
	}
	
	public RangedWeapon(int inmag, int maxmag)
	{
		inMag = inmag;
		maxMag = maxmag;
	}
	
	public RangedWeapon(int skill)
	{
		this.skill = skill;
	}
	
	public static boolean removeInMag(int shots)
	{
		if(shots <= inMag)
		{
			inMag -= shots;
			return true;
		}
		else return false;
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
				int i = this.rangeDC[DC];
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
		int diff = maxMag - inMag;
		if(ammo >= diff)
		{
			inMag = maxMag;
			return (ammo - diff);
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
