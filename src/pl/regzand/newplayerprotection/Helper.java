package pl.regzand.newplayerprotection;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.bukkit.entity.Player;

public class Helper {
	public static void copy(InputStream in, File file){
		try {
			OutputStream out = new FileOutputStream(file);
			byte[] buf = new byte[1024];
			int len;
			while((len=in.read(buf))>0){
				out.write(buf,0,len);
			}
			out.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean isUnderProtection(Player p){
		if(p.hasPermission("newplayerprotection.protect.allTime"))
			return true;
		
		if(!p.hasPermission("newplayerprotection.protect"))
			return false;
		
		if(p.getPlayerTime() < ConfigManager.getNewPlayerTime())
			return true;
		
		return false;
	}
}
