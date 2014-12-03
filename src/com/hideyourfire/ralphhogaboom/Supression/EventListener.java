package com.hideyourfire.ralphhogaboom.Supression;

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
			if (!(player.hasPermission("Suppression.Use"))) {
				Main.getPlugin().getLogger().info("[Suppression INFO]: " + player.getDisplayName() + " lava bucket place cancelled.");
				player.sendMessage("You don't have permission to use a lava bucket.");
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
			if (!(player.hasPermission("Suppression.Use"))) {
				Main.getPlugin().getLogger().info("[Suppression INFO]: " + player.getDisplayName() + " firecharge use cancelled.");
				player.sendMessage("You don't have permission to use a fire charge.");
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
			if (!(player.hasPermission("Suppression.Use"))) {
				Main.getPlugin().getLogger().info("[Suppression INFO]: " + player.getDisplayName() + " lighter use cancelled.");
				player.sendMessage("You don't have permission to use flint and steel.");
				event.setCancelled(true);
			}
		}
	}
		
}
