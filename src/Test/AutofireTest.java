package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import cyberpunk.Weapons.Autofire;

public class AutofireTest
{

	@Test
	public void test()
	{
		int[] rangeDCAuto = {22,20,17,20,25};
		Autofire auto = new Autofire(rangeDCAuto, 4);
		
		assertTrue(auto.rollToHit(20, 50, 25) != 0);
		assertTrue(auto.rollToHit(20, 50, 9) == 0);
		assertTrue(auto.rollDamage(5) >= 0);
		assertTrue(auto.rollDamage(0) == 0);
	}

}
