package cyberpunk.Weapons;

public class MeleeWeapon extends Weapon
{
	public MeleeWeapon()
	{
		
	}
	
	public MeleeWeapon(int skill)
	{
		this.skill = skill;
	}
	
	public boolean rollToHit(int skill, int evasion)
	{
		int roll = dice.rollD10();
		if(skill + roll > evasion)
		{
			return true;
		}
		return false;
	}
}
