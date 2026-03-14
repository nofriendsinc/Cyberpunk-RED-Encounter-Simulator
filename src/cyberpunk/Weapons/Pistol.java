package cyberpunk.Weapons;

public class Pistol extends RangedWeapon
{
	public Pistol()
	{
		rangeDC[0] = 13;
		rangeDC[1] = 15;
		rangeDC[2] = 20;
		rangeDC[3] = 25;
		rangeDC[4] = 30;
		rangeDC[5] = 30;
	}
	
	public Pistol(int skill)
	{
		this.skill = skill;
		rangeDC[0] = 13;
		rangeDC[1] = 15;
		rangeDC[2] = 20;
		rangeDC[3] = 25;
		rangeDC[4] = 30;
		rangeDC[5] = 30;
	}
	
	public int[] getRangeDC()
	{
		return this.rangeDC;
	}
}
