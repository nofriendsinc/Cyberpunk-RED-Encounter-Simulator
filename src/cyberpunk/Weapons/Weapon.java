package cyberpunk.Weapons;

import cyberpunk.Dice;

public class Weapon
{
	protected int[] rangeDC;
	protected int damageDice;
	protected int ROF;
	protected Dice dice = new Dice();
	protected int skill;
	
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

	public int[] getRangeDC()
	{
		return this.rangeDC;
	}
	
	public void setSkill(int skill)
	{
		this.skill = skill;
	}
}
