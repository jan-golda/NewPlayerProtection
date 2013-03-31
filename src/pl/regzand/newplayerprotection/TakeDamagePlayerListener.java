package pl.regzand.newplayerprotection;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class TakeDamagePlayerListener implements Listener {
	
	@EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
		
		if(event.isCancelled())
			return;
		
		if(event.getEntityType() != EntityType.PLAYER)
			return;
		
		Player p = (Player)event.getEntity();
		
		if(!Helper.isUnderProtection(p))
			return;
		
		if(event.getDamager().getType() == EntityType.PLAYER){
			event.setCancelled(!ConfigManager.getTakePlayerDamage());
		}else{
			event.setCancelled(!ConfigManager.getTakeMobDamage());
		}
		
		
    }
	
	@EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityDamage(EntityDamageEvent event) {
		
		if(event.isCancelled())
			return;
		
		if(event.getEntityType() != EntityType.PLAYER)
			return;
		
		Player p = (Player)event.getEntity();
		
		if(!Helper.isUnderProtection(p))
			return;
		
		switch(event.getCause()){
		case ENTITY_EXPLOSION:
			event.setCancelled(!ConfigManager.getTakeMobExplosionDamage());
			break;
		case BLOCK_EXPLOSION:
			event.setCancelled(!ConfigManager.getTakeBlockExplosionDamage());
			break;
		case CONTACT:
			event.setCancelled(!ConfigManager.getTakeContactDamage());
			break;
		case DROWNING:
			event.setCancelled(!ConfigManager.getTakeDrowingDamage());
			break;
		case FALL:
			event.setCancelled(!ConfigManager.getTakeFallDamage());
			break;
		case FALLING_BLOCK:
			event.setCancelled(!ConfigManager.getTakeFallingBlockDamage());
			break;
		case FIRE:
			event.setCancelled(!ConfigManager.getTakeFireDamage());
			break;
		case LAVA:
			event.setCancelled(!ConfigManager.getTakeLavaDamage());
			break;
		case LIGHTNING:
			event.setCancelled(!ConfigManager.getTakeLightningDamage());
			break;
		case MAGIC:
			event.setCancelled(!ConfigManager.getTakeMagicDamage());
			break;
		case POISON:
			event.setCancelled(!ConfigManager.getTakePoisonDamage());
			break;
		case PROJECTILE:
			event.setCancelled(!ConfigManager.getTakeProjectileDamage());
			break;
		case SUFFOCATION:
			event.setCancelled(!ConfigManager.getTakeSuffocationDamage());
			break;
		case WITHER:
			event.setCancelled(!ConfigManager.getTakeWitherDamage());
			break;
		case FIRE_TICK:
			event.setCancelled(!ConfigManager.getTakeFireDamage());
			break;
		case STARVATION:
			event.setCancelled(!ConfigManager.getTakeStarvationDamage());
			break;
		default:
			break;
		}
    }
}
