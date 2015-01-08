package com.hideyourfire.ralphhogaboom.Suppression;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class EventListener implements Listener {

	@SuppressWarnings("deprecation")

	@EventHandler(ignoreCancelled = true)
	public void onPlayerBucket(PlayerBucketEmptyEvent event)
	{
		Player player = event.getPlayer();
		if (player.getItemInHand().getTypeId() == Material.LAVA_BUCKET.getId()) {
			if (!(player.hasPermission("suppression.use"))) {
				Main.getPlugin().getLogger().info("[Suppression INFO]: " + player.getDisplayName() + " lava bucket place cancelled.");
				player.sendMessage("You don't have permission to use a lava bucket.");
				alertOperators(player, "lava bucket");
				event.setCancelled(true);
			}
		}
	}

	@SuppressWarnings("deprecation")
	@EventHandler(ignoreCancelled = true)
	public void onPlayerFirecharge(PlayerInteractEvent event)
	{
		Player player = event.getPlayer();
		if (player.getItemInHand().getTypeId() == 385) {
			if (!(player.hasPermission("suppression.use"))) {
				Main.getPlugin().getLogger().info("[Suppression INFO]: " + player.getDisplayName() + " firecharge use cancelled.");
				player.sendMessage("You don't have permission to use a fire charge.");
				alertOperators(player, "fire charge");
				event.setCancelled(true);
			}
		}
	}	
	
	@SuppressWarnings("deprecation")
	@EventHandler(ignoreCancelled = true)
	public void onPlayerLighter(PlayerInteractEvent event)
	{
		Player player = event.getPlayer();
		if (player.getItemInHand().getTypeId() == Material.FLINT_AND_STEEL.getId()) {
			if (!(player.hasPermission("suppression.use"))) {
				Main.getPlugin().getLogger().info("[Suppression INFO]: " + player.getDisplayName() + " lighter use cancelled.");
				player.sendMessage("You don't have permission to use flint and steel.");
				alertOperators(player, "lighter");
				event.setCancelled(true);
			}
		}
	}
		
	@SuppressWarnings("deprecation")
	private void alertOperators(Player player, String attemptedObject) {
		for(Player p : Bukkit.getOnlinePlayers()){
            if(p.hasPermission("suppression.admin")){
                p.sendMessage("[Suppression INFO]: " + player + " was stopped from using a " + attemptedObject + " at x:" + player.getLocation().getX() + " y:" + player.getLocation().getY() + " z:" + player.getLocation().getZ() + " [" + player.getWorld() + "]");
            }
        }
	}
}
