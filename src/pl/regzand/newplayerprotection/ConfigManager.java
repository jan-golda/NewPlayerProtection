package pl.regzand.newplayerprotection;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigManager {
	private NewPlayerProtectionPlugin plugin;
	
	public ConfigManager(NewPlayerProtectionPlugin plugin){
		this.plugin = plugin;
		
		load();
	}
	
	public void load(){
		//preparing file
		File configFile = new File(plugin.getDataFolder(), "config.yml");
		if(!configFile.exists()){
			configFile.getParentFile().mkdirs();
			Helper.copy(plugin.getResource("config.yml"), configFile);
		}
		
		//preparing config
		FileConfiguration config = new YamlConfiguration();
		try {
			config.load(configFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//filling variables
		newPlayerTime					= config.getLong("new-player-time", 0);
		
		take_PLAYER_damage				= config.getBoolean("take-PLAYER-damage", true);
		take_MOB_damage					= config.getBoolean("take-MOB-damage", true);
		take_MOB_EXPLOSION_damage		= config.getBoolean("take-MOB-EXPLOSION-damage", true);
		take_BLOCK_EXPLOSION_damage		= config.getBoolean("take-BLOCK-EXPLOSION-damage", true);
		take_CONTACT_damage				= config.getBoolean("take-CONTACT-damage", true);
		take_DROWNING_damage			= config.getBoolean("take-DROWNING-damage", true);
		take_FALL_damage				= config.getBoolean("take-FALL-damage", true);
		take_FALLING_BLOCK_damage		= config.getBoolean("take-FALLING-BLOCK-damage", true);
		take_FIRE_damage				= config.getBoolean("take-FIRE-damage", true);
		take_LAVA_damage				= config.getBoolean("take-LAVA-damage", true);
		take_LIGHTNING_damage			= config.getBoolean("take-LIGHTNING-damage", true);
		take_MAGIC_damage				= config.getBoolean("take-MAGIC-damage", true);
		take_POISON_damage				= config.getBoolean("take-POISON-damage", true);
		take_PROJECTILE_damage			= config.getBoolean("take-PROJECTILE-damage", true);
		take_SUFFOCATION_damage			= config.getBoolean("take-SUFFOCATION-damage", true);
		take_WITHER_damage				= config.getBoolean("take-WITHER-damage", true);
		take_STARVATION_damage			= config.getBoolean("take-STARVATION-damage", true);

		give_PLAYER_damage				= config.getBoolean("give-PLAYER-damage", true);
		give_MOB_damage					= config.getBoolean("give-MOB-damage", true);
	}
	
	
	
	/**
	 * STATIC
	 */
	private static long newPlayerTime;
	
	private static boolean take_PLAYER_damage;
	private static boolean take_MOB_damage;
	private static boolean take_MOB_EXPLOSION_damage;
	private static boolean take_BLOCK_EXPLOSION_damage;
	private static boolean take_CONTACT_damage;
	private static boolean take_DROWNING_damage;
	private static boolean take_FALL_damage;
	private static boolean take_FALLING_BLOCK_damage;
	private static boolean take_FIRE_damage;
	private static boolean take_LAVA_damage;
	private static boolean take_LIGHTNING_damage;
	private static boolean take_MAGIC_damage;
	private static boolean take_POISON_damage;
	private static boolean take_PROJECTILE_damage;
	private static boolean take_SUFFOCATION_damage;
	private static boolean take_WITHER_damage;
	private static boolean take_STARVATION_damage;

	private static boolean give_PLAYER_damage;
	private static boolean give_MOB_damage;
	
	
	
	public static long		getNewPlayerTime()					{return newPlayerTime;}
	
	public static boolean 	getTakePlayerDamage()				{return take_PLAYER_damage;}
	public static boolean 	getTakeMobDamage()					{return take_MOB_damage;}
	public static boolean 	getTakeMobExplosionDamage()			{return take_MOB_EXPLOSION_damage;}
	public static boolean 	getTakeBlockExplosionDamage()		{return take_BLOCK_EXPLOSION_damage;}
	public static boolean 	getTakeContactDamage()				{return take_CONTACT_damage;}
	public static boolean 	getTakeDrowingDamage()				{return take_DROWNING_damage;}
	public static boolean 	getTakeFallDamage()					{return take_FALL_damage;}
	public static boolean 	getTakeFallingBlockDamage()			{return take_FALLING_BLOCK_damage;}
	public static boolean 	getTakeFireDamage()					{return take_FIRE_damage;}
	public static boolean 	getTakeLavaDamage()					{return take_LAVA_damage;}
	public static boolean 	getTakeLightningDamage()			{return take_LIGHTNING_damage;}
	public static boolean 	getTakeMagicDamage()				{return take_MAGIC_damage;}
	public static boolean 	getTakePoisonDamage()				{return take_POISON_damage;}
	public static boolean 	getTakeProjectileDamage()			{return take_PROJECTILE_damage;}
	public static boolean 	getTakeSuffocationDamage()			{return take_SUFFOCATION_damage;}
	public static boolean 	getTakeWitherDamage()				{return take_WITHER_damage;}
	public static boolean 	getTakeStarvationDamage()			{return take_STARVATION_damage;}
	
	public static boolean 	getGivePlayerDamage()				{return give_PLAYER_damage;}
	public static boolean 	getGiveMobDamage()					{return give_MOB_damage;}
}
