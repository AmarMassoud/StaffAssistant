package me.amar.staffchat.Listeners;

import me.amar.staffchat.Files.DataYml;

import java.util.ArrayList;
import java.util.List;

public class AdminChatToggle {
    public static void addPlayerToAdminChat(String p) {
        List<String> copy = new ArrayList<>(DataYml.getDataYml().getStringList("adminchat-toggled"));
        copy.add(p);
        DataYml.getDataYml().set("staffchat-toggled", copy);
        DataYml.saveDataYml();
    }
    public static void removePlayerFromAdminChat(String p) {
        List<String> copy = new ArrayList<>(DataYml.getDataYml().getStringList("adminchat-toggled"));
        copy.remove(p);
        DataYml.getDataYml().set("staffchat-toggled", copy);
        DataYml.saveDataYml();
    }
    public static boolean isPlayerInAdminChat(String p) {
        List<String> copy = new ArrayList<>(DataYml.getDataYml().getStringList("adminchat-toggled"));
        if (copy.contains(p)) {
            return true;
        } else {
            return false;
        }
    }

}
