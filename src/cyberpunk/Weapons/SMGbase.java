package cyberpunk.Weapons;

public class SMGbase extends RangedWeapon
{
	public int[] rangeDCAuto = {22,20,17,20,25};
	public RangedWeapon weapon;
	public Autofire auto;
	
	public SMGbase()
	{
		this.ROF = 1;
		rangeDC[0] = 15;
		rangeDC[1] = 13;
		rangeDC[2] = 15;
		rangeDC[3] = 20;
		rangeDC[4] = 25;
		rangeDC[5] = 25;
		rangeDC[6] = 30;
	}

	public SMGbase(int skill)
	{
		this.ROF = 1;
		this.skill = skill;
		auto = new Autofire(rangeDCAuto, 3);
		rangeDC[0] = 15;
		rangeDC[1] = 13;
		rangeDC[2] = 15;
		rangeDC[3] = 20;
		rangeDC[4] = 25;
		rangeDC[5] = 25;
		rangeDC[6] = 30;
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
