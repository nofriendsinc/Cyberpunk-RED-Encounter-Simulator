package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import cyberpunk.Weapons.RangedWeapon;

public class RangedWeaponTest
{

	@Test
	public void test()
	{
		RangedWeapon weapon = new RangedWeapon(15, 15);
		
		assertEquals(0, weapon.getDamageDice());
		assertEquals(0, weapon.getROF());
		assertEquals(0, weapon.getSkill());
		weapon.setDamageDice(1);
		weapon.setROF(1);
		weapon.setSkill(1);
		assertEquals(1, weapon.getDamageDice());
		assertEquals(1, weapon.getROF());
		assertEquals(1, weapon.getSkill());
		
		assertEquals(true, weapon.removeInMag(10));
		assertEquals(5, weapon.checkMag());
		assertEquals(0, weapon.reload(2));
		assertEquals(7, weapon.checkMag());
		assertEquals(true, weapon.removeInMag(7));
		assertEquals(0, weapon.checkMag());
		assertEquals(0, weapon.reload(15));
		assertEquals(false, weapon.removeInMag(35));
		assertEquals(15, weapon.checkMag());
		assertEquals(true, weapon.removeInMag(10));
		assertEquals(5, weapon.checkMag());
		assertEquals(10, weapon.reload(20));
		assertNotNull(weapon.getRangeDC());
		assertEquals(false, weapon.rollToHit(0, 12));
		assertTrue(weapon.rollDamage() > 0);
	}

}
