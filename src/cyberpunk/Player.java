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
	private PlayerBrain brain;
	Random rand = new Random();
	private int distanceToTarget;
	Player target;
	
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
		this.brain = new PlayerBrain();
	}
	
	public Player()
	{
		// TODO Auto-generated constructor stub
	}

	public Player getTarget(ArrayList<Player> enemy)
	{
		target = brain.getTargetPlayer(enemy);
		return target;
	}
	
	public Weapon pickWeapon()
	{
		return brain.pickWeapon(weapons, target);
	}
	
	public void movePlayer(ArrayList<Player> enemy)
	{
		brain.movePlayer(enemy, this.move);
	}
	
	public void takeRangedDamage(int dmg)
	{
		//Armor blocks damage by SP, and armor ablates if damage exceeds
		if(dmg > this.bodyArmorSP)
		{
			dmg -= bodyArmorSP;
			bodyArmorSP--;
			HP -= dmg;
		}
	}
	
	public void takeMeleeDamage(int dmg)
	{
		//Armor blocks damage by half of SP, and armor ablates if damage exceeds
		if(dmg > this.bodyArmorSP / 2)
		{
			dmg -= bodyArmorSP / 2;
			bodyArmorSP--;
			HP -= dmg;
		}
	}
	
	public int getDistanceToTarget()
	{
		return this.distanceToTarget;
	}
	
	public int getXPos()
	{
		return brain.getXPos();
	}
	
	public int getYPos()
	{
		return brain.getYPos();
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
