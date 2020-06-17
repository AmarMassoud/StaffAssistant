package me.amar.staffchat.Listeners;

import me.amar.staffchat.Files.DataYml;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class StaffChatToggle {
    public static void addPlayerToStaffChat(String p) {
        List<String> copy = new ArrayList<>(DataYml.getDataYml().getStringList("staffchat-toggled"));
            copy.add(p);
            DataYml.getDataYml().set("staffchat-toggled", copy);
            DataYml.saveDataYml();
    }
    public static void removePlayerFromStaffChat(String p) {
        List<String> copy = new ArrayList<>(DataYml.getDataYml().getStringList("staffchat-toggled"));
        copy.remove(p);
        DataYml.getDataYml().set("staffchat-toggled", copy);
        DataYml.saveDataYml();
    }
    public static boolean isPlayerInStaffChat(String p) {
        List<String> copy = new ArrayList<>(DataYml.getDataYml().getStringList("staffchat-toggled"));
        if (copy.contains(p)) {
            return true;
        } else {
            return false;
        }
    }



    }
