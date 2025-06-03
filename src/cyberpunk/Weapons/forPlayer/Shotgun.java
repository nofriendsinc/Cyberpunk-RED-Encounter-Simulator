package cyberpunk.Weapons.forPlayer;

import cyberpunk.Weapons.RangedWeapon;
import cyberpunk.Weapons.Shellshot;

public class Shotgun extends RangedWeapon
{
	private int[] rangeDC = {13,15,20,25,30,35};
	private Shellshot shell;

	public Shotgun(int skill)
	{
		this.shell = new Shellshot();
		this.damageDice = 5;
		this.ROF = 1;
		inMag = 4;
		this.maxMag = 4;
		this.skill = skill;
	}

	public Shotgun()
	{
		// TODO Auto-generated constructor stub
	}
}
