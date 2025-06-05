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
		//Roll D10, if 1 roll again and subtract, if 10 roll again and add
		int temp = rand.nextInt(10) + 1;
		int temp2 = 0;
		if(temp == 1)
		{
			temp2 = rand.nextInt(10) + 1;
			temp -= temp2;
		}
		if(temp == 10)
		{
			temp2 = rand.nextInt(10) + 1;
			temp += temp2;
		}
		return temp;
	}
	
	public int rollD6(int num)
	{
		//Roll num of D6s, if 2 of more are 6, add 5 to total
		int temp = 0;
		int count = 0;
		for(int i = 0; i < num; i++)
		{
			int temp2 = rand.nextInt(6) + 1;
			if(temp2 == 6) 
			{
				count++;
			}
			temp += temp2;
		}
		if(count >= 2)	temp += 5;
		return temp;
	}
	
	public int rollD6()
	{
		return rand.nextInt(6) + 1;
	}

}
