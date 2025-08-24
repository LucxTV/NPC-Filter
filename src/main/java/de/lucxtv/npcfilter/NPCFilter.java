package de.lucxtv.npcfilter;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import static sun.print.CUPSPrinter.getServer;

public class NPCFilter extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("NPCFilter enabled - No-Name NPCs are hidden in Tablist.");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player joined = event.getPlayer();
        for (Player online : Bukkit.getOnlinePlayers()) {
            NPC npc = CitizensAPI.getNPCRegistry().getNPC(online);
            if (npc != null) {
                joined.hidePlayer(online);
            }
        }
    }
}
