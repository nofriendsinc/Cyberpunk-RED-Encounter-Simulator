package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import cyberpunk.Weapons.Pistol;
import cyberpunk.Weapons.VeryHeavyPistol;

public class VeryHeavyPistolTest
{

	@Test
	public void test()
	{
		VeryHeavyPistol weapon = new VeryHeavyPistol(15);
		assertEquals(13, weapon.getRangeDC()[0]);
		assertEquals(15, weapon.getRangeDC()[1]);
		assertEquals(20, weapon.getRangeDC()[2]);
		assertEquals(25, weapon.getRangeDC()[3]);
		assertEquals(30, weapon.getRangeDC()[4]);
		assertEquals(30, weapon.getRangeDC()[5]);
		assertEquals(50, weapon.getRangeDC()[6]);
		assertEquals(50, weapon.getRangeDC()[7]);
		
		assertEquals(4, weapon.getDamageDice());
		assertEquals(1, weapon.getROF());
		assertEquals(15, weapon.getSkill());
		assertEquals(8, weapon.checkMag());
		assertTrue(weapon.rollDamage() > 0);
	}

}
