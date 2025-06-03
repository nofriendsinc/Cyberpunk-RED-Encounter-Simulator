package cyberpunk.Weapons.forPlayer;

import cyberpunk.Weapons.Pistol;

public class VeryHeavyPistol extends Pistol
{
	public VeryHeavyPistol(int skill)
	{
		this.damageDice = 4;
		this.ROF = 1;
		inMag = 8;
		this.maxMag = 8;
		this.skill = skill;
	}
}
