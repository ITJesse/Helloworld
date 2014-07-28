/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cn.itjesse.helloworld;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
/**
 *
 * @author Jesse
 */
public final class helloworld extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        // TODO Insert logic to be performed when the plugin is enabled
        //getLogger().info("HelloWorld is Enabled!");
        this.getConfig().options().copyDefaults(true);
        saveConfig();
        reloadConfig();
        getServer().getPluginManager().registerEvents(this, this);
    }
    
    @EventHandler
    public void onLogin(PlayerJoinEvent event) {
        Player player = event.getPlayer(); // The player who joined
        ItemStack item = player.getItemInHand();
        Material type = item.getType();
        String name = this.getConfig().getString("item." + type, "空气");
        getServer().broadcastMessage(ChatColor.GREEN + player.getName() + "手拿"
                + ChatColor.RED + name + ChatColor.GREEN + "闪亮登场！");
    }
}
