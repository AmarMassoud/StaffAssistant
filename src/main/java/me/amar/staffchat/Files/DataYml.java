package me.amar.staffchat.Files;

import me.amar.staffchat.StaffChat;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class DataYml {

    private static StaffChat plugin = StaffChat.getPlugin(StaffChat.class);

    public static FileConfiguration dataYml;
    public static File dataFile;

    public static void setUpDataYml() {
        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdirs();
        }

        dataFile = new File(plugin.getDataFolder(), "data.yml");


        if (!dataFile.exists()) {
            try {
                dataFile.createNewFile();
                Bukkit.getConsoleSender().sendMessage(StaffChat.colorize("&eLoaded data.yml &asuccessfully"));
            } catch (IOException e) {
                Bukkit.getConsoleSender().sendMessage(StaffChat.colorize("&cCould not load data.yml"));
                e.printStackTrace();
            }

        }

        dataYml = YamlConfiguration.loadConfiguration(dataFile);


    }

    public static FileConfiguration getDataYml() {
        return dataYml;
    }

    public static void saveDataYml() {
        try {
            dataYml.save(dataFile);
            Bukkit.getConsoleSender().sendMessage(StaffChat.colorize("&e Saved data.yml &asuccessfully"));
        } catch (IOException e) {
            Bukkit.getConsoleSender().sendMessage(StaffChat.colorize("&cCould not save data.yml"));
            e.printStackTrace();
        }
    }

    public static void reloadDataYml() {
        dataYml = YamlConfiguration.loadConfiguration(dataFile);
        Bukkit.getConsoleSender().sendMessage(StaffChat.colorize("&eReloaded data.yml &asuccessfully"));
    }

}



