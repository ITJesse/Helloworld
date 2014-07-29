/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cn.itjesse.helloworld;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

/**
 *
 * @author Jesse
 */
public final class Main extends JavaPlugin {
 
    @Override
    public void onEnable() {
        this.getConfig().options().copyDefaults(true);
        saveConfig();
        reloadConfig();
        new LoginListener(this);
    }
}
 
class LoginListener implements Listener {
 
    private final Main plugin;
 
    public LoginListener(Main plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
 
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        // Create the task and schedule to run it once, after 200 ticks
        int DelayTime = plugin.getConfig().getInt("config.DelayTime", 20);
        Player player = event.getPlayer(); // The player who joined
        BukkitTask task = new Helloworld(this.plugin, event, player).runTaskLater(this.plugin, DelayTime);
    }
 
}
