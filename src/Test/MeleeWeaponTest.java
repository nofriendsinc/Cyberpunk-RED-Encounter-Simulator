package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import cyberpunk.Weapons.MeleeWeapon;

public class MeleeWeaponTest
{

	@Test
	public void test()
	{
		MeleeWeapon weapon = new MeleeWeapon(50);
		assertEquals(50, weapon.getSkill());
		assertTrue(weapon.rollToHit(1));
		
		weapon = new MeleeWeapon(15);
		assertEquals(15, weapon.getSkill());
		assertFalse(weapon.rollToHit(50));
		weapon.setDamageDice(5);
		assertTrue(weapon.rollDamage() > 0);
	}

}
