package cyberpunk.Weapons;

public class VeryHeavyMelee extends MeleeWeapon
{
	public VeryHeavyMelee(int skill)
	{
		this.damageDice = 4;
		this.ROF = 1;
		this.skill = skill;
	}
}
