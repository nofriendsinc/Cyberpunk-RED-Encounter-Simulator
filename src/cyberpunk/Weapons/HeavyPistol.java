package cyberpunk.Weapons;

public class HeavyPistol extends Pistol
{	
	public HeavyPistol(int skill)
	{
		this.damageDice = 3;
		this.ROF = 2;
		inMag = 8;
		this.maxMag = 8;
		this.skill = skill;
		
	}
}
