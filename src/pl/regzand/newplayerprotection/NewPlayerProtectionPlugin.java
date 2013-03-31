package pl.regzand.newplayerprotection;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class NewPlayerProtectionPlugin extends JavaPlugin {
	
	public void onEnable(){
		CM = new ConfigManager(this);
		
		Bukkit.getServer().getPluginManager().registerEvents(new TakeDamagePlayerListener(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new GiveDamagePlayerListener(), this);
	}
	public void onDisable(){
		
	}
	
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("NewPlayerProtection")){
			//if contains arguments
			if(args != null && args.length == 1){
				//if reload
				if(args[0].equalsIgnoreCase("reload")){
					if(!s.hasPermission("newplayerprotection.reload")){
						s.sendMessage(ChatColor.RED+"You don't have permissions to do that.");
						return true;
					}
					CM.load();
					s.sendMessage(ChatColor.GREEN+"NewPlayerProtection plugin reloaded!");
					return true;
				}
			}
			
			//if info/help or unknow argument
			s.sendMessage(ChatColor.DARK_PURPLE+	"===|"+this.getName()+"|===");
			s.sendMessage(ChatColor.DARK_PURPLE+	"Version: "		+ChatColor.DARK_RED		+this.getDescription().getVersion());
			s.sendMessage(ChatColor.DARK_PURPLE+	"Author: "		+ChatColor.DARK_RED		+this.getDescription().getAuthors().get(0));
			s.sendMessage(ChatColor.DARK_PURPLE+	"Website: "		+ChatColor.DARK_RED		+this.getDescription().getWebsite());
			s.sendMessage(ChatColor.DARK_PURPLE+	"Commands:");
			s.sendMessage(ChatColor.DARK_RED+		"    /npp reload");
		}
		return true;
	}
	
	
	
	/**
	 * STATIC
	 */
	private static ConfigManager CM;
	
	public ConfigManager getConfigManager(){return CM;}
}
