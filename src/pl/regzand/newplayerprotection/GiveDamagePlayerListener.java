package pl.regzand.newplayerprotection;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class GiveDamagePlayerListener implements Listener {
	
	@EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
		
		if(event.isCancelled())
			return;
		
		if(event.getDamager().getType() != EntityType.PLAYER)
			return;
		
		Player p = (Player)event.getDamager();
		
		if(!Helper.isUnderProtection(p))
			return;
		
		if(event.getEntityType() == EntityType.PLAYER){
			event.setCancelled(!ConfigManager.getGivePlayerDamage());
		}else{
			event.setCancelled(!ConfigManager.getGiveMobDamage());
		}
		
		
    }
}
