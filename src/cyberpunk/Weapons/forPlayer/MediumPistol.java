package cyberpunk.Weapons.forPlayer;

import cyberpunk.Weapons.Pistol;

public class MediumPistol extends Pistol
{	
	public MediumPistol(int skill)
	{
		this.damageDice = 2;
		this.ROF = 2;
		inMag = 12;
		this.maxMag = 12;
		this.skill = skill;
	}
}
