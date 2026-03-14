package Test;
import cyberpunk.*;
import cyberpunk.Weapons.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class RangeFinderTest
{
	private int handgun = 8;
	private int shoulderarms = 8;
	private MediumPistol weapon = new MediumPistol(handgun);
	
	protected int[] rangeDC = {13,15,20,25,30,30};
	private int[] ranges = {2,9,22,37,85,154,314,721};
	
	private RangeFinder range = new RangeFinder();

	@Test
	public void test()
	{
		//Test getRangeDC
		assertEquals(0, cycleRanges(0, 6, range));
		assertEquals(1, cycleRanges(7, 12, range));
		assertEquals(2, cycleRanges(13, 25, range));
		assertEquals(3, cycleRanges(26, 50, range));
		assertEquals(4, cycleRanges(51, 100, range));
		assertEquals(5, cycleRanges(101, 200, range));
		assertEquals(6, cycleRanges(201, 400, range));
		assertEquals(7, cycleRanges(401, 800, range));
		
		//Test DCs for pistol at all ranges
		assertEquals(13, range.getRangeDCVal(5, weapon.getRangeDC()));
		assertEquals(15, range.getRangeDCVal(11, weapon.getRangeDC()));
		assertEquals(20, range.getRangeDCVal(20, weapon.getRangeDC()));
		assertEquals(25, range.getRangeDCVal(35, weapon.getRangeDC()));
		assertEquals(30, range.getRangeDCVal(75, weapon.getRangeDC()));
		assertEquals(30, range.getRangeDCVal(150, weapon.getRangeDC()));
		assertEquals(50, range.getRangeDCVal(300, weapon.getRangeDC()));
		assertEquals(50, range.getRangeDCVal(600, weapon.getRangeDC()));
	}
	
	public static int cycleRanges(int start, int end, RangeFinder range)
	{
		int sum = 0;
		int amt = 0;
		
		for(int i = start; i <= end; i++)
		{
			sum += range.getRangeDC(i);
			amt++;
		}
		
		return (sum / amt);
	}

}
