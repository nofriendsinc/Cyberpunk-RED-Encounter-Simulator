package cyberpunk.Weapons;

public class Pistol extends RangedWeapon
{
	protected int[] rangeDC = {13,15,20,25,30,30};
	
	public Pistol()
	{
		
	}
	
	public Pistol(int skill)
	{
		this.skill = skill;
	}
}
