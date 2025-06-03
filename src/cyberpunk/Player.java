package cyberpunk;
import cyberpunk.Weapons.MeleeWeapon;
import cyberpunk.Weapons.Pistol;
import cyberpunk.Weapons.Weapon;
import cyberpunk.Weapons.forPlayer.*;
import java.util.Random;

public class Player
{
	private static final int mediumPistol = 0;
	private static final int heavyPistol = 1;
	private static final int veryHeavyPistol = 2;
	private static final int SMG = 3;
	private static final int heavySMG = 4;
	private static final int shotgun = 5;
	private static final int assaultRifle = 6;
	
	private int HP;
	private int bodyArmorSP;
	private int headArmorSP;
	private int handgun;
	private int shoulderArms;
	private int autofire;
	private int melee;
	private int move;
	private int ammo = 120;
	private Weapon[] weapons;
	
	private int distanceFromCenter = 15;
	private int distanceToTarget;
	

	

	public Player(int hp, int bodySP, int headSP, int handgun, int shoulder, int autofire, int melee, int move, Weapon[] weapons)
	{
		this.HP = hp;
		this.bodyArmorSP = bodySP;
		this.headArmorSP = headSP;
		this.handgun = handgun;
		this.shoulderArms = shoulder;
		this.autofire = autofire;
		this.melee = melee;
		this.move = move;
		//this.ammo = ammo;
		this.weapons = weapons;
		
		for(int i = 0; i < this.weapons.length; i++)
		{
			if(this.weapons[i].getClass() == new Pistol().getClass()) this.weapons[i].setSkill(this.handgun);
			if(this.weapons[i].getClass() == new SMG().getClass()) this.weapons[i].setSkill(this.handgun);
			if(this.weapons[i].getClass() == new Shotgun().getClass()) this.weapons[i].setSkill(this.shoulderArms);
			if(this.weapons[i].getClass() == new AssaultRifle().getClass()) this.weapons[i].setSkill(this.shoulderArms);
		}
	}
	
	public Player getTarget(Player[] enemy)
	{
		int tempMin = 100000;
		int temp = 0;
		Player tempTarget = null;
		
		for(int i = 0; i < enemy.length; i++)
		{
			temp = Math.abs(this.distanceFromCenter) + Math.abs(enemy[i].getDistanceFromCenter());
			if(temp < tempMin) 
			{
				temp = tempMin;
				tempTarget = enemy[i];
			}
		}
		
		if(tempMin == 0)
		{
			this.distanceToTarget = temp;
			return tempTarget;
		}
		else
		{
			Random rand = new Random();
			this.distanceToTarget = temp;
			return enemy[rand.nextInt(enemy.length)];
		}
	}
	
	public Weapon pickWeapon()
	{
		//choose a weapon at random
		//if distance to target is 0 picks melee
		Weapon temp = null;
		int tempDC = 50;
		
		if(this.distanceToTarget == 0)
		{
			for(int i = 0; i < this.weapons.length; i++)
			{
				temp = weapons[i];
				if(temp.getClass() == new MeleeWeapon().getClass())
				{
					return temp;
				}
			}
		}
		for(int i = 0; i < weapons.length; i++)
		{
			int t = new RangeFinder().getRangeDCVal(distanceToTarget, weapons[i].getRangeDC());	//TODO fix this shit!!!
			if(t < tempDC) 
			{
				tempDC = t;
				temp = weapons[i];
			}
		}
		return temp;
	}
	
	public void movePlayer()
	{
		//logic to find preferred distance to center
		//check damage of each weapon/ammo count?
		Random rand = new Random();
		int direction = 1;
		if(rand.nextInt(1) == 1) direction = -1;
		this.distanceFromCenter += (rand.nextInt(this.move) + 1) * direction;
		
	}
	
	public int getDistanceFromCenter()
	{
		return this.distanceFromCenter;
	}

}
