package cyberpunk.Weapons;

public class MeleeWeapon extends Weapon
{
	protected int[] rangeDC = {0};
	
	public MeleeWeapon()
	{
		
	}
	
	public MeleeWeapon(int skill)
	{
		this.skill = skill;
	}
	
	public boolean rollToHit(int evasion)
	{
		int roll = dice.rollD10();
		if(this.skill + roll > evasion)
		{
			return true;
		}
		return false;
	}
}
