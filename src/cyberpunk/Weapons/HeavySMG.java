package cyberpunk.Weapons;

public class HeavySMG extends SMGbase
{
	public HeavySMG(int skill)
	{
		this.damageDice = 3;
		inMag = 40;
		this.maxMag = 40;
		this.skill = skill;
	}
}
