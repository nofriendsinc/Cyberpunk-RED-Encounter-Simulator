package Test;

import static org.junit.Assert.*;
import org.junit.Test;
import cyberpunk.Weapons.*;

public class WeaponTest
{

	@Test
	public void test()
	{
		Weapon weapon = new Weapon(15);
		
		assertEquals(0, weapon.getDamageDice());
		assertEquals(0, weapon.getROF());
		assertEquals(15, weapon.getSkill());
		weapon.setDamageDice(1);
		weapon.setROF(1);
		weapon.setSkill(1);
		assertEquals(1, weapon.getDamageDice());
		assertEquals(1, weapon.getROF());
		assertEquals(1, weapon.getSkill());
		assertTrue(weapon.rollDamage() > 0);
	}

}
