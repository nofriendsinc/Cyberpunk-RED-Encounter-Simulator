package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import cyberpunk.Weapons.HeavyMelee;
import cyberpunk.Weapons.VeryHeavyMelee;

public class VeryHeavyMeleeTest
{
	
	@Test
	public void test()
	{
		VeryHeavyMelee weapon = new VeryHeavyMelee(50);
		assertEquals(50, weapon.getSkill());
		assertTrue(weapon.rollToHit(1));
		
		weapon = new VeryHeavyMelee(15);
		assertEquals(15, weapon.getSkill());
		assertFalse(weapon.rollToHit(50));
		assertTrue(weapon.rollDamage() > 0);
		
		assertEquals(4, weapon.getDamageDice());
		assertEquals(1, weapon.getROF());
	}

}
