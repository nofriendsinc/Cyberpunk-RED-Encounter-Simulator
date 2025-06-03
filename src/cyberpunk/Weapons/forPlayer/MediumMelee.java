package cyberpunk.Weapons.forPlayer;
import cyberpunk.Weapons.MeleeWeapon;

public class MediumMelee extends MeleeWeapon
{
	public MediumMelee(int skill)
	{
		this.damageDice = 2;
		this.ROF = 2;
		this.skill = skill;
	}
}
