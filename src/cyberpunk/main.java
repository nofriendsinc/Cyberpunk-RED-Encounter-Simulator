package cyberpunk;
import java.util.Random;
import Test.*;
import cyberpunk.Weapons.forPlayer.MediumPistol;


public class main 
{

	public static void main(String[] args) 
	{
		new TestSMG();
		new TestPlayer();
		
		System.out.println("Testing");
		int cycles = 50;
		MediumPistol pistol = new MediumPistol(10);
		Random rand = new Random();
		Dice dice = new Dice();
		
		
		for(int i = 1; i <= cycles; i++)
		{
			//pistol.rollToHit(15);
			
			percentage(cycles, i);
		}

	}
	
	public static void percentage(int cycles, int i)
	{
		if(cycles > 1000)
		{
			if(i % (cycles / 100) == 0)
			{
				System.out.println(i / (cycles / 100) + "%");
			}
		}
	}

}
