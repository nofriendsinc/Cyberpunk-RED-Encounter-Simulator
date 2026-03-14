package cyberpunk.Weapons;

public class Shotgun extends RangedWeapon
{
	private Shellshot shell;

	public Shotgun(int skill)
	{
		this.shell = new Shellshot();
		this.damageDice = 5;
		this.ROF = 1;
		inMag = 4;
		this.maxMag = 4;
		this.skill = skill;
		rangeDC[0] = 13;
		rangeDC[1] = 15;
		rangeDC[2] = 20;
		rangeDC[3] = 25;
		rangeDC[4] = 30;
		rangeDC[5] = 35;
	}

	public Shotgun()
	{
		// TODO Auto-generated constructor stub
	}
}
