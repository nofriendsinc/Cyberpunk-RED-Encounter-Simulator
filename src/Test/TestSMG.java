package Test;

import static org.junit.Assert.*;

import cyberpunk.Weapons.forPlayer.*;

public class TestSMG
{

	@org.junit.Test
	public void test()
	{
		SMG gun = new SMG(10);
		assertEquals(30, gun.checkMag());
		assertEquals(15, gun.rangeDC[0]);
		//fail("Not yet implemented");
	}

}
