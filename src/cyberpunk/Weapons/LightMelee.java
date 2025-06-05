package cyberpunk.Weapons;

public class LightMelee extends MeleeWeapon
{
	public LightMelee(int skill)
	{
		this.damageDice = 1;
		this.ROF = 2;
		this.skill = skill;
	}
}
