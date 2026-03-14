package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import cyberpunk.Weapons.AssaultRifle;
import cyberpunk.Weapons.RangedWeapon;

public class AssaultRifleTest
{

	@Test
	public void test()
	{
		AssaultRifle weapon = new AssaultRifle(15);
		
		assertEquals(5, weapon.getDamageDice());
		assertEquals(1, weapon.getROF());
		assertEquals(15, weapon.getSkill());
				
		assertEquals(true, weapon.removeInMag(10));
		assertEquals(15, weapon.checkMag());
		assertEquals(0, weapon.reload(2));
		assertEquals(17, weapon.checkMag());
		assertEquals(true, weapon.removeInMag(7));
		assertEquals(10, weapon.checkMag());
		assertEquals(0, weapon.reload(15));
		assertEquals(false, weapon.removeInMag(35));
		assertEquals(25, weapon.checkMag());
		assertEquals(true, weapon.removeInMag(10));
		assertEquals(15, weapon.checkMag());
		assertEquals(10, weapon.reload(20));
		assertNotNull(weapon.getRangeDC());
		assertEquals(true, weapon.rollToHit(27, 60));
		assertTrue(weapon.rollDamage() > 0);
	}

}
