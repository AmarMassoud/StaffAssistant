package me.amar.staffchat;

import me.amar.staffchat.Events.ChatPlayerStaffChatEvent;
import me.amar.staffchat.Files.DataYml;
import me.amar.staffchat.commands.StaffChatCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;

public class StaffChat extends JavaPlugin {

    @Override
    public void onEnable() {
        loadConfigManager();
        getCommand("staffchat").setExecutor(new StaffChatCommand());
        Bukkit.getPluginManager().registerEvents(new ChatPlayerStaffChatEvent(), this);
        getLogger().info("Staffchat enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("Staffchat disabled");
    }
    public void loadConfigManager() {
        DataYml.setUpDataYml();
        DataYml.reloadDataYml();
        final List<String> list = Arrays.asList("");
        DataYml.getDataYml().addDefault("staffchat-toggled", list);
        DataYml.getDataYml().options().copyDefaults(true);
        DataYml.saveDataYml();
    }
    public static String colorize(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}

