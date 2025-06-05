package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import cyberpunk.Weapons.HeavyPistol;
import cyberpunk.Weapons.MediumPistol;

public class MediumPistolTest
{

	@Test
	public void test()
	{
		MediumPistol weapon = new MediumPistol(15);
		assertEquals(13, weapon.getRangeDC()[0]);
		assertEquals(15, weapon.getRangeDC()[1]);
		assertEquals(20, weapon.getRangeDC()[2]);
		assertEquals(25, weapon.getRangeDC()[3]);
		assertEquals(30, weapon.getRangeDC()[4]);
		assertEquals(30, weapon.getRangeDC()[5]);
		assertEquals(50, weapon.getRangeDC()[6]);
		assertEquals(50, weapon.getRangeDC()[7]);
		
		assertEquals(2, weapon.getDamageDice());
		assertEquals(2, weapon.getROF());
		assertEquals(15, weapon.getSkill());
		assertEquals(12, weapon.checkMag());
		assertTrue(weapon.rollDamage() > 0);
	}

}
