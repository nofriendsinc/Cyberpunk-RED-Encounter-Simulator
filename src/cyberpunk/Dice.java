package cyberpunk;
import java.util.Random;

public class Dice
{
	Random rand = new Random();
	
	public Dice()
	{
		// TODO Auto-generated constructor stub
	}
	
	public int rollD10()
	{
		int temp = rand.nextInt(10) + 1;
		int temp2 = 0;
		//System.out.print(temp + " +/- ");
		if(temp == 1)
		{
			temp2 = rand.nextInt(10) + 1;
			temp -= temp2;
			//System.out.print(temp2 + " = ");
		}
		if(temp == 10)
		{
			temp2 = rand.nextInt(10) + 1;
			temp += temp2;
			//System.out.print(temp2 + " = ");
		}
		//System.out.println(temp);
		return temp;
	}
	
	public int rollD6(int num)
	{
		//return rand.nextInt(6) + 1;
		int temp = 0;
		int count = 0;
		for(int i = 0; i < num; i++)
		{
			int temp2 = rand.nextInt(6) + 1;
			if(temp2 == 6) 
			{
				count++;
				//System.out.println("Crit!");
			}
			temp += temp2;
		}
		return temp;
	}
	
	public int rollD6()
	{
		return rand.nextInt(6) + 1;
	}

}
