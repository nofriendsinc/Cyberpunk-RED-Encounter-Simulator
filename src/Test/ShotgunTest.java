package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import cyberpunk.Weapons.HeavyPistol;
import cyberpunk.Weapons.Shotgun;

public class ShotgunTest
{

	@Test
	public void test()
	{
		Shotgun weapon = new Shotgun(15);
		assertEquals(13, weapon.getRangeDC()[0]);
		assertEquals(15, weapon.getRangeDC()[1]);
		assertEquals(20, weapon.getRangeDC()[2]);
		assertEquals(25, weapon.getRangeDC()[3]);
		assertEquals(30, weapon.getRangeDC()[4]);
		assertEquals(35, weapon.getRangeDC()[5]);
		assertEquals(50, weapon.getRangeDC()[6]);
		assertEquals(50, weapon.getRangeDC()[7]);
		
		assertEquals(5, weapon.getDamageDice());
		assertEquals(1, weapon.getROF());
		assertEquals(15, weapon.getSkill());
		assertEquals(4, weapon.checkMag());
		assertTrue(weapon.rollDamage() > 0);
	}

}
