package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import cyberpunk.Weapons.MediumMelee;
import cyberpunk.Weapons.MeleeWeapon;

public class MediumMeleeTest
{

	@Test
	public void test()
	{
		MediumMelee weapon = new MediumMelee(50);
		assertEquals(50, weapon.getSkill());
		assertTrue(weapon.rollToHit(1));
		
		weapon = new MediumMelee(15);
		assertEquals(15, weapon.getSkill());
		assertFalse(weapon.rollToHit(50));
		assertTrue(weapon.rollDamage() > 0);
		
		assertEquals(2, weapon.getDamageDice());
		assertEquals(2, weapon.getROF());
	}

}
