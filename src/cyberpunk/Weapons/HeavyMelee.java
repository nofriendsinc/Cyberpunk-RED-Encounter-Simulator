package cyberpunk.Weapons;

public class HeavyMelee extends MeleeWeapon
{
	public HeavyMelee(int skill)
	{
		this.damageDice = 3;
		this.ROF = 2;
		this.skill = skill;
	}
}
