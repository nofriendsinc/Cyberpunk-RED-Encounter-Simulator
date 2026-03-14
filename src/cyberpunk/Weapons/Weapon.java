package cyberpunk.Weapons;

import cyberpunk.Dice;

public class Weapon
{
	protected int damageDice = 0;
	protected int ROF = 0;
	protected Dice dice = new Dice();
	protected int skill = 0;
	
	public Weapon()
	{
		
	}

	public Weapon(int skill)
	{
		this.skill = skill;
	}
	
	public int rollDamage()
	{
		return dice.rollD6(this.damageDice);
	}
	
	public int getROF()
	{
		return this.ROF;
	}
	
	public void setSkill(int skill)
	{
		this.skill = skill;
	}

	public int getDamageDice()
	{
		return damageDice;
	}

	public void setDamageDice(int damageDice)
	{
		this.damageDice = damageDice;
	}

	public int getSkill()
	{
		return skill;
	}

	public void setROF(int rOF)
	{
		ROF = rOF;
	}

	public int[] getRangeDC()
	{
		return null;
	}
}
