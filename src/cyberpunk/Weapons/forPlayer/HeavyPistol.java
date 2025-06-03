package cyberpunk.Weapons.forPlayer;

import cyberpunk.Weapons.Pistol;

public class HeavyPistol extends Pistol
{
	public HeavyPistol(int skill)
	{
		this.damageDice = 2;
		this.ROF = 2;
		inMag = 8;
		this.maxMag = 8;
		this.skill = skill;
	}
}
