package me.amar.staffchat.Events;

import me.amar.staffchat.Listeners.AdminChatToggle;
import me.amar.staffchat.Listeners.StaffChatToggle;
import me.amar.staffchat.StaffChat;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatPlayerStaffChatEvent implements Listener {
    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        String m = e.getMessage();
        if(StaffChatToggle.isPlayerInStaffChat(p.getUniqueId().toString())) {
            e.setCancelled(true);
            for(Player staff : Bukkit.getOnlinePlayers()) {
                if(staff.hasPermission("staff.see")) {
                    staff.sendMessage(StaffChat.colorize("&7[&cStaffChat&7] - " + p.getDisplayName() + " >> &a" + m));
                }
            }

        }
        if(AdminChatToggle.isPlayerInAdminChat(p.getUniqueId().toString())) {
            e.setCancelled(true);
            for(Player staff : Bukkit.getOnlinePlayers()) {
                if(staff.hasPermission("staff.see")) {
                    staff.sendMessage(StaffChat.colorize("&7[&cStaffChat&7] - " + p.getDisplayName() + " >> &a" + m));
                }
            }

        }



    }
}
