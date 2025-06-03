package cyberpunk.Weapons.forPlayer;
import cyberpunk.Weapons.SMGbase;

public class SMG extends SMGbase
{
	public SMG(int skill)
	{
		this.damageDice = 2;
		inMag = 30;
		this.maxMag = 30;
		this.skill = skill;
	}

	public SMG()
	{
		// TODO Auto-generated constructor stub
	}
}
