package cyberpunk.Weapons.forPlayer;
import cyberpunk.Weapons.Autofire;
import cyberpunk.Weapons.RangedWeapon;

public class AssaultRifle extends RangedWeapon
{
	protected int[] rangeDC = {17,16,15,13,15,20,25,30};
	private int[] rangeDCAuto = {22,20,17,20,25};
	private Autofire auto;

	public AssaultRifle(int skill)
	{
		this.damageDice = 5;
		this.ROF = 1;
		inMag = 25;
		this.maxMag = 25;
		auto = new Autofire(rangeDCAuto, 4);
		this.skill = skill;
	}
	
	public AssaultRifle()
	{
		// TODO Auto-generated constructor stub
	}

	public int autoFire(int range, int skill)
	{
		int toHit = this.auto.rollToHit(range, skill, checkMag());
		
		if(toHit == 0)
		{
			return 0;
		}
		else if(toHit >= 0)
		{
			removeInMag(10);
			return this.auto.rollDamage(toHit);
		}
		return 0;
	}
}
