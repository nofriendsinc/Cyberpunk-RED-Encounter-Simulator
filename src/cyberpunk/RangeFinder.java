package cyberpunk;

public class RangeFinder
{
	private static final int range0To6 = 0;
	private static final int range7To12 = 1;
	private static final int range13To25 = 2;
	private static final int range26To50 = 3;
	private static final int range51To100 = 4;
	private static final int range101To200 = 5;
	private static final int range201To400 = 6;
	private static final int range401To800 = 7;
	
	public RangeFinder()
	{
		// TODO Auto-generated constructor stub
	}
	
	public int getRangeDC(int range)
	{
		int DC = 50;
		if(range > 0 && range <= 6) DC = range0To6;
		if(range > 6 && range <= 12) DC = range7To12;
		if(range > 12 && range <= 25) DC = range13To25;
		if(range > 25 && range <= 50) DC = range26To50;
		if(range > 50 && range <= 100) DC = range51To100;
		if(range > 100 && range <= 200) DC = range101To200;
		if(range > 200 && range <= 400) DC = range201To400;
		if(range > 400 && range <= 800) DC = range401To800;
		
		return DC;
	}
	
	public int getRangeDCVal(int range, int[] rangeDC)
	{
		int DC = new RangeFinder().getRangeDC(range);
		
		try
		{
			int i = rangeDC[DC];
		}
		catch(Exception e)
		{
			return 50;
		}
		
		return rangeDC[DC];
	}

}
