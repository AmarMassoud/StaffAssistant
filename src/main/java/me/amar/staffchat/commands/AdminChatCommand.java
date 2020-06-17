package me.amar.staffchat.commands;

import me.amar.staffchat.Listeners.StaffChatToggle;
import me.amar.staffchat.StaffChat;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminChatCommand implements CommandExecutor {
    @Override
        public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

            if(sender instanceof Player) {
                Player p = (Player) sender;
                if(p.hasPermission("adminchat.use")) {
                    if (args.length == 0) {
                        if (StaffChatToggle.isPlayerInStaffChat(p.getUniqueId().toString())) {
                            StaffChatToggle.removePlayerFromStaffChat(p.getUniqueId().toString());
                            p.sendMessage(StaffChat.colorize("&cDisabled AdminChat"));
                        } else {
                            StaffChatToggle.addPlayerToStaffChat(p.getUniqueId().toString());
                            p.sendMessage(StaffChat.colorize("&aEnabled AdminChat"));
                        }
                    } else {
                        for (Player staff : Bukkit.getOnlinePlayers()) {
                            if (staff.hasPermission("AdminChat.see")) {
                                StringBuilder sb = new StringBuilder();
                                for (int i = 0; i < args.length; i++){
                                    sb.append(args[i]).append(" ");
                                }

                                String allArgs = sb.toString().trim();
                                staff.sendMessage(StaffChat.colorize("&7[&cAdminChat&7] - " + p.getDisplayName() + " >> &a" +  allArgs));

                            }
                        }
                    }

                }






            } else {
                sender.sendMessage(StaffChat.colorize("&cThis command can only be used by players."));
            }





            return true;
        }
}
