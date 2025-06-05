package cyberpunk;
import cyberpunk.Weapons.*;

import java.util.ArrayList;
import java.util.Random;

public class Player
{
	private String name;
	private int HP;
	private int bodyArmorSP;
	private int headArmorSP;
	private int handgun;
	private int shoulderArms;
	private int autofire;
	private int melee;
	private int evasion;
	private int move;
	private int ammo = 120;
	private ArrayList<Weapon> weapons;
	
	Random rand = new Random();
	private int distanceFromCenter = rand.nextInt(30);
	private int distanceToTarget;
	
	public Player(String name, int hp, int bodySP, int headSP, int handgun, int shoulder, int autofire, int melee, int evasion, int move, ArrayList<Weapon> weapons)
	{
		this.name = name;
		this.HP = hp;
		this.bodyArmorSP = bodySP;
		this.headArmorSP = headSP;
		this.handgun = handgun;
		this.shoulderArms = shoulder;
		this.autofire = autofire;
		this.melee = melee;
		this.evasion = evasion;
		this.move = move;
		this.weapons = weapons;
	}
	
	public Player()
	{
		// TODO Auto-generated constructor stub
	}

	public Player getTarget(ArrayList<Player> enemy)
	{
		int tempMin = 100000;
		int temp = 0;
		Player tempTarget = enemy.get(rand.nextInt(enemy.size()));
		
		for(int i = 0; i < enemy.size(); i++)
		{
			temp = Math.abs(this.distanceFromCenter) + Math.abs(enemy.get(i).getDistanceFromCenter());
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
	
	public Weapon pickWeapon()
	{
		//choose a weapon at random
		//if distance to target is 0 picks melee
		Weapon temp = weapons.get(rand.nextInt(weapons.size()));
		int tempDC = 50;
		
		if(this.distanceToTarget == 0)
		{
			for(int i = 0; i < this.weapons.size(); i++)
			{
				temp = weapons.get(i);
				//System.out.println(MeleeWeapon.class.isAssignableFrom(temp.getClass()));
				if(MeleeWeapon.class.isAssignableFrom(temp.getClass()))
				{
					return temp;
				}
			}
		}
		for(int i = 0; i < weapons.size(); i++)
		{
			if(RangedWeapon.class.isAssignableFrom(weapons.get(i).getClass()))
			{
				int t = new RangeFinder().getRangeDCVal(distanceToTarget, weapons.get(i).getRangeDC());	//TODO fix this shit!!!
				if(t < tempDC) 
				{
					tempDC = t;
					temp = weapons.get(i);
				}
			}
		}
		//System.out.println(temp.getClass());
		return temp;
	}
	
	public void movePlayer(ArrayList<Player> enemy)
	{
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
		/*for(int i = 0; i < temp.getRangeDC().length; i++)
		{
			if(temp.getRangeDC()[i] < dc)
			{
				dc = temp.getRangeDC()[i];
				index = i;
			}
		}*/
		
		if(index == 0)	distPref = 3;
		if(index == 1)	distPref = 10;
		if(index == 2)	distPref = 20;
		if(index == 3)	distPref = 40;
		if(index == 4)	distPref = 75;
		if(index == 5)	distPref = 150;
		if(index == 6)	distPref = 300;
		if(index == 7)	distPref = 500;
		
		//compare preferred dist to average to enemies
		
		//TODO FIGURE OUT MOVEMENT LOGIC
		
		//if(sumDist > distPref)	distanceFromCenter += this.move;
		
		//logic to find preferred distance to center
		//check damage of each weapon/ammo count?
		Random rand = new Random();
		int direction = 1;
		if(rand.nextInt(1) == 1) direction = -1;
		this.distanceFromCenter += (rand.nextInt(this.move) + 1) * direction;
		
	}
	
	public void takeRangedDamage(int dmg)
	{
		if(dmg > this.bodyArmorSP)
		{
			dmg -= bodyArmorSP;
			bodyArmorSP--;
			HP -= dmg;
		}
	}
	
	public void takeMeleeDamage(int dmg)
	{
		if(dmg > this.bodyArmorSP / 2)
		{
			dmg -= bodyArmorSP / 2;
			bodyArmorSP--;
			HP -= dmg;
		}
	}
	
	public int getDistanceFromCenter()
	{
		return this.distanceFromCenter;
	}
	
	public int getDistanceToTarget()
	{
		return this.distanceToTarget;
	}

	public int getAmmo()
	{
		return ammo;
	}

	public void setAmmo(int ammo)
	{
		this.ammo = ammo;
	}

	public int getHP()
	{
		return HP;
	}

	public int getBodyArmorSP()
	{
		return bodyArmorSP;
	}

	public int getHeadArmorSP()
	{
		return headArmorSP;
	}

	public int getHandgun()
	{
		return handgun;
	}

	public int getShoulderArms()
	{
		return shoulderArms;
	}

	public int getAutofire()
	{
		return autofire;
	}

	public int getMelee()
	{
		return melee;
	}

	public int getEvasion()
	{
		return evasion;
	}

	public int getMove()
	{
		return move;
	}

	public String getName()
	{
		return name;
	}
}
