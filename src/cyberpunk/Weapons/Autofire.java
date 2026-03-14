package cyberpunk.Weapons;

import cyberpunk.Dice;

public class Autofire
{
	private static final int range0To6 = 0;
	private static final int range7To12 = 1;
	private static final int range13To25 = 2;
	private static final int range26To50 = 3;
	private static final int range51To100 = 4;
	
	private int[] rangeDC;
	private int maxMultiple;
	private Dice dice = new Dice();

	public Autofire(int[] rangeDC, int max)
	{
		this.rangeDC = rangeDC;
		this.maxMultiple = max;
	}

	public int rollToHit(int range, int skill, int inMag)
	{
		//if weapon has 10 bullets in mag, try to beat DC at range
		//returns amount DC was beaten by
		if(inMag >= 10)
		{
			int DC = 0;
			int roll = dice.rollD10();
			
			if(range > 0 && range <= 6) DC = range0To6;
			if(range > 6 && range <= 12) DC = range7To12;
			if(range > 12 && range <= 25) DC = range13To25;
			if(range > 25 && range <= 50) DC = range26To50;
			if(range > 50 && range <= 100) DC = range51To100;
			
			try
			{
				int i = rangeDC[DC];
			}
			catch(Exception e)
			{
				return 0;
			}
			
			if(roll + skill > rangeDC[DC])
			{
				return (roll + skill) - rangeDC[DC];
			}
		}
		return 0;
	}
	
	public int rollDamage(int beatDC)
	{
		//roll damage and multiplies by amount player beat the DC by, up to max for chosen weapon
		int temp = dice.rollD6() + dice.rollD6();
		if(beatDC > this.maxMultiple) beatDC = this.maxMultiple;
		temp *= beatDC;
		return temp;
	}
}
