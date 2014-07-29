/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cn.itjesse.helloworld;

import static org.bukkit.Bukkit.getLogger;
import static org.bukkit.Bukkit.getServer;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

/**
 *
 * @author Jesse
 */
public class Helloworld extends BukkitRunnable {
 
    private final JavaPlugin plugin;
    private final PlayerJoinEvent event;
    private final Player player;
 
    public Helloworld(JavaPlugin plugin, PlayerJoinEvent event, Player player) {
        this.plugin = plugin;
        this.event = event;
        this.player = player;
    }
 
    @Override
    public void run() {
        // What you want to schedule goes here
        //Player player = event.getPlayer(); // The player who joined
        ItemStack item = player.getItemInHand();
        Material type = item.getType();
        getLogger().info(type.toString());
        String name = plugin.getConfig().getString("item." + type, "空气");
        getServer().broadcastMessage(ChatColor.GREEN + player.getName() + "手拿"
                + ChatColor.RED + name + ChatColor.GREEN + "闪亮登场！");
    }
 
}
