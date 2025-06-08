package cyberpunk;

import java.util.ArrayList;
import java.util.Random;

import cyberpunk.Weapons.MeleeWeapon;
import cyberpunk.Weapons.RangedWeapon;
import cyberpunk.Weapons.Weapon;

public class PlayerBrain
{
	Random rand = new Random();
	//Randomly pick starting position between x = [-30,30) and y = [-30,30)
	int xPos = rand.nextInt(60) - 30;
	int yPos = rand.nextInt(60) - 30;
	
	public PlayerBrain()
	{
		
	}
	
	public Player getTargetPlayer(ArrayList<Player> enemy)
	{
		double tempMin = 100000;
		double temp = 0;
		Player tempTarget = enemy.get(rand.nextInt(enemy.size()));
		
		//Chose closest target
		for(int i = 0; i < enemy.size(); i++)
		{
			temp = getDistance(enemy.get(i).getYPos(), enemy.get(i).getYPos());
			if(temp < tempMin && enemy.get(i).getHP() > 0) 
			{
				tempMin = temp;
				tempTarget = enemy.get(i);
			}
		}
		
		return tempTarget;
		
		/*if(tempMin == 0)
		{
			this.distanceToTarget = temp;
			return tempTarget;
		}
		else
		{
			Random rand = new Random();
			this.distanceToTarget = temp;
			return enemy.get(rand.nextInt(enemy.size()));
		}*/
	}
	
	public void movePlayer(ArrayList<Player> enemy, int move)
	{
		//TODO FIGURE OUT MOVEMENT LOGIC
		
		/*
		//find average distance to all enemies
		int sumDist = 0;
		int sumEnemy = 0;
		for(int i = 0; i < enemy.size(); i++)
		{
			sumDist = Math.abs(this.distanceFromCenter) + Math.abs(enemy.get(i).getDistanceFromCenter());
			sumEnemy = Math.abs(enemy.get(i).getDistanceFromCenter());
		}
		
		//sumDist /= enemy.size();
		//sumEnemy /= enemy.size();
		
		//find weapon with most damage
		Weapon temp = null;
		int dmg = 0;
		for(int i = 0; i < weapons.size(); i++)
		{
			if(weapons.get(i).getDamageDice() > dmg)	temp = weapons.get(i);
		}
		
		//find best range for weapon
		int dc = 50;
		int index = 0;
		int distPref = 0;
		for(int i = 0; i < temp.getRangeDC().length; i++)
		{
			if(temp.getRangeDC()[i] < dc)
			{
				dc = temp.getRangeDC()[i];
				index = i;
			}
		}
		
		if(index == 0)	distPref = 3;
		if(index == 1)	distPref = 10;
		if(index == 2)	distPref = 20;
		if(index == 3)	distPref = 40;
		if(index == 4)	distPref = 75;
		if(index == 5)	distPref = 150;
		if(index == 6)	distPref = 300;
		if(index == 7)	distPref = 500;
		*/
		
		//compare preferred dist to average to enemies
		
		//if(sumDist > distPref)	distanceFromCenter += this.move;
		
		//logic to find preferred distance to center
		//check damage of each weapon/ammo count?
		
		
		//Move a random distance to/from center
		Random rand = new Random();
		int direction = 1;
		if(rand.nextInt(1) == 1) direction = -1;
		int distToMove = rand.nextInt(move) + 1;
		int temp = rand.nextInt(distToMove);
		xPos += (temp * direction);
		yPos += ((distToMove - temp) * direction);
	}
	
	public Weapon pickWeapon(ArrayList<Weapon> weapons, Player target)
	{
		//choose a weapon at random
		//if distance to target is 0 picks melee
		Weapon temp = weapons.get(rand.nextInt(weapons.size()));
		int tempDC = 50;
		int distanceToTarget = (int) getDistance(target.getXPos(), target.getYPos());
		
		if(distanceToTarget == 0)
		{
			for(int i = 0; i < weapons.size(); i++)
			{
				temp = weapons.get(i);
				if(MeleeWeapon.class.isAssignableFrom(temp.getClass()))
				{
					return temp;
				}
			}
		}
		for(int i = 0; i < weapons.size(); i++)
		{
			//Check ranged weapons for lowest DC to hit chosen target at range
			if(RangedWeapon.class.isAssignableFrom(weapons.get(i).getClass()))
			{
				//get rangeDC array from chosen weapon
				int[] rangeDC = weapons.get(i).getRangeDC();
				//find value of DC to hit from chosen weapon and range to chosen target
				int t = new RangeFinder().getRangeDCVal(distanceToTarget, rangeDC);
				if(t < tempDC) 
				{
					tempDC = t;
					temp = weapons.get(i);
				}
			}
		}
		return temp;
	}
	
	public double getDistance(int x, int y)
	{
		double totalX = this.xPos + x;
		double totalY = this.yPos + y;
		return Math.sqrt((totalX * totalX) + (totalY * totalY));
	}
	
	public int getXPos()
	{
		return xPos;
	}

	public int getYPos()
	{
		return yPos;
	}
}
