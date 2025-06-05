package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import cyberpunk.Player;
import cyberpunk.Weapons.AssaultRifle;
import cyberpunk.Weapons.HeavyMelee;
import cyberpunk.Weapons.HeavyPistol;
import cyberpunk.Weapons.LightMelee;
import cyberpunk.Weapons.MediumMelee;
import cyberpunk.Weapons.MediumPistol;
import cyberpunk.Weapons.Pistol;
import cyberpunk.Weapons.SMG;
import cyberpunk.Weapons.Shotgun;
import cyberpunk.Weapons.VeryHeavyPistol;
import cyberpunk.Weapons.Weapon;

public class PlayerTest
{

	@Test
	public void test()
	{
		ArrayList<Player> players = makePlayers();
		ArrayList<Player> enemies = makeEnemies();
		
		Player player = players.get(2);
		
		assertTrue(player.getTarget(enemies).getClass() == new Player().getClass());
		assertTrue(Weapon.class.isAssignableFrom(player.pickWeapon().getClass()));
		assertTrue(player.pickWeapon().getClass() == new Shotgun().getClass());
		
		int dist1 = player.getDistanceFromCenter();
		player.movePlayer(enemies);
		int dist2 = player.getDistanceFromCenter();
		assertNotEquals(dist1, dist2);
		
		int temp = player.getHP();
		player.takeRangedDamage(9);
		assertEquals(player.getHP(), temp);
		player.takeRangedDamage(15);
		assertNotEquals(player.getHP(), temp);
		
		player = players.get(0);
		player.takeMeleeDamage(10);
		assertEquals(player.getHP(), 45- 7);
	}

	public static ArrayList<Player> makePlayers()
	{
		//hp, bodySP, headSP, handgun, shoulder, autofire, melee, evasion, move, ArrayList<Weapon> weapons
		ArrayList<Weapon> DocWeapons = new ArrayList<>();
		DocWeapons.add(new MediumMelee(6));
		DocWeapons.add(new MediumPistol(10));
		Player Doc = new Player("Doc", 45, 7, 0, 10, 5, 5, 6, 8, 5, DocWeapons);
		
		ArrayList<Weapon> JonestownWeapons = new ArrayList<>();
		JonestownWeapons.add(new HeavyMelee(2));
		JonestownWeapons.add(new HeavyPistol(8));
		Player Jonestown = new Player("Jonestown", 45, 12, 0, 8, 2, 2, 2, 6, 5, JonestownWeapons);
		
		ArrayList<Weapon> LanternWeapons = new ArrayList<>();
		LanternWeapons.add(new Shotgun(12));
		Player Lantern = new Player("Lantern", 40, 11, 11, 6, 12, 6, 5, 11, 5, LanternWeapons);
		
		ArrayList<Weapon> PhibesWeapons = new ArrayList<>();
		PhibesWeapons.add(new VeryHeavyPistol(9));
		PhibesWeapons.add(new LightMelee(1));
		Player Phibes = new Player("Phibes", 35, 11, 11, 9, 3, 3, 1, 7, 7, PhibesWeapons);
		
		ArrayList<Weapon> PunishedWeapons = new ArrayList<>();
		PunishedWeapons.add(new MediumMelee(5));
		PunishedWeapons.add(new SMG(11));
		PunishedWeapons.add(new VeryHeavyPistol(11));
		Player Punished = new Player("Punished", 40, 11, 11, 11, 5, 5, 5, 11, 5, PunishedWeapons);
		
		ArrayList<Weapon> RidgeWeapons = new ArrayList<>();
		RidgeWeapons.add(new AssaultRifle(13));
		RidgeWeapons.add(new HeavyMelee(13));
		RidgeWeapons.add(new VeryHeavyPistol(13));
		Player Ridge = new Player("Ridge", 60, 11, 11, 13, 13, 13, 13, 13, 5, RidgeWeapons);
		
		ArrayList<Weapon> TripwireWeapons = new ArrayList<>();
		TripwireWeapons.add(new VeryHeavyPistol(12));
		Player Tripwire = new Player("Tripwire", 35, 11, 11, 12, 6, 6, 6, 12, 7, TripwireWeapons);
		
		ArrayList<Player> players = new ArrayList<>();
		players.add(Doc);
		players.add(Jonestown);
		players.add(Lantern);
		players.add(Phibes);
		players.add(Punished);
		players.add(Ridge);
		players.add(Tripwire);
		
		return players;
	}
	
	public static ArrayList<Player> makeEnemies()
	{
		//hp, bodySP, headSP, handgun, shoulder, autofire, melee, evasion, move, ArrayList<Weapon> weapons
		ArrayList<Weapon> LegionnaireWeapons = new ArrayList<>();
		LegionnaireWeapons.add(new MediumMelee(11));
		LegionnaireWeapons.add(new HeavyPistol(11));
		Player Legion1 = new Player("Legion1", 35, 7, 0, 11, 11, 11, 11, 11, 4, LegionnaireWeapons);
		Player Legion2 = new Player("Legion2", 35, 7, 0, 11, 11, 11, 11, 11, 4, LegionnaireWeapons);
		Player Legion3 = new Player("Legion3", 35, 7, 0, 11, 11, 11, 11, 11, 4, LegionnaireWeapons);
		Player Legion4 = new Player("Legion4", 35, 7, 0, 11, 11, 11, 11, 11, 4, LegionnaireWeapons);
		
		ArrayList<Weapon> CobraWeapons = new ArrayList<>();
		CobraWeapons.add(new HeavyMelee(10));
		CobraWeapons.add(new HeavyPistol(10));
		Player Cobra1 = new Player("Cobra1", 30, 4, 4, 10, 10, 10, 10, 10, 4, CobraWeapons);
		Player Cobra2 = new Player("Cobra2", 30, 4, 4, 10, 10, 10, 10, 10, 4, CobraWeapons);
		Player Cobra3 = new Player("Cobra3", 30, 4, 4, 10, 10, 10, 10, 10, 4, CobraWeapons);
		Player Cobra4 = new Player("Cobra4", 30, 4, 4, 10, 10, 10, 10, 10, 4, CobraWeapons);
		
		ArrayList<Weapon> JoshuaWeapons = new ArrayList<>();
		JoshuaWeapons.add(new HeavyMelee(12));
		JoshuaWeapons.add(new Shotgun(12));
		Player Joshua = new Player("Joshua", 40, 11, 11, 4, 10, 4, 12, 12, 4, JoshuaWeapons);
		
		ArrayList<Weapon> AdamWeapons = new ArrayList<>();
		AdamWeapons.add(new HeavyMelee(18));
		AdamWeapons.get(0).setDamageDice(5);
		AdamWeapons.add(new Shotgun(18));
		AdamWeapons.get(1).setDamageDice(6);
		//AdamWeapons.add(new RocketLauncher(18));
		//AdamWeapons.get(2).setDamageDice(9);
		//AdamWeapons.add(new AssaultRifle(18));
		//AdamWeapons.get(3).setDamageDice(2);
		Player Adam = new Player("Adam", 75, 18, 18, 18, 18, 18, 18, 18, 8, AdamWeapons);
		
		ArrayList<Player> players = new ArrayList<>();
		players.add(Legion1);
		players.add(Legion2);
		players.add(Legion3);
		players.add(Legion4);
		players.add(Cobra1);
		players.add(Cobra2);
		players.add(Cobra3);
		players.add(Cobra4);
		players.add(Joshua);
		//players.add(Adam);
				
		return players;
	}
}
