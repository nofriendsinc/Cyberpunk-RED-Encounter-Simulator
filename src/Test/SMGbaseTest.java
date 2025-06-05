package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import cyberpunk.Weapons.SMGbase;

public class SMGbaseTest
{
	//15,13,15,20,25,25,30}

	@Test
	public void test()
	{
		SMGbase weapon = new SMGbase(15);
		
		assertEquals(15, weapon.getRangeDC()[0]);
		assertEquals(13, weapon.getRangeDC()[1]);
		assertEquals(15, weapon.getRangeDC()[2]);
		assertEquals(20, weapon.getRangeDC()[3]);
		assertEquals(25, weapon.getRangeDC()[4]);
		assertEquals(25, weapon.getRangeDC()[5]);
		assertEquals(30, weapon.getRangeDC()[6]);
		assertEquals(50, weapon.getRangeDC()[7]);
		
		assertEquals(0, weapon.getDamageDice());
		assertEquals(1, weapon.getROF());
		assertEquals(15, weapon.getSkill());
	}

}
