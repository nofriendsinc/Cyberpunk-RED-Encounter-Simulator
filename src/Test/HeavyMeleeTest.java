package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import cyberpunk.Weapons.HeavyMelee;
import cyberpunk.Weapons.MediumMelee;

public class HeavyMeleeTest
{

	@Test
	public void test()
	{
		HeavyMelee weapon = new HeavyMelee(50);
		assertEquals(50, weapon.getSkill());
		assertTrue(weapon.rollToHit(1));
		
		weapon = new HeavyMelee(15);
		assertEquals(15, weapon.getSkill());
		assertFalse(weapon.rollToHit(50));
		assertTrue(weapon.rollDamage() > 0);
		
		assertEquals(3, weapon.getDamageDice());
		assertEquals(2, weapon.getROF());
	}

}
