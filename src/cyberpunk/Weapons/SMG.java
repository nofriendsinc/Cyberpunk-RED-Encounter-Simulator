package cyberpunk.Weapons;

public class SMG extends SMGbase
{
	public SMG(int skill)
	{
		this.damageDice = 2;
		inMag = 30;
		this.maxMag = 30;
		this.skill = skill;
	}
}
