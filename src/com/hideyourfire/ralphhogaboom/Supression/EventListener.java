package com.hideyourfire.ralphhogaboom.Supression;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class EventListener implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler(ignoreCancelled = true)
	public void onPlayerBucket(PlayerBucketEmptyEvent event)
	{
		Player player = event.getPlayer();
		if (player.getItemInHand().getTypeId() == Material.LAVA_BUCKET.getId()) {
			if (player.hasPermission("Suppression.Use")) {
				Main.getPlugin().getLogger().info(player.getDisplayName() + " placed lava bucket.");
			} else {
				Main.getPlugin().getLogger().info(player.getDisplayName() + " lava bucket place cancelled.");
				event.setCancelled(true);
			}
		}
	}

	@EventHandler(ignoreCancelled = true)
	public void onPlayerFirecharge(PlayerInteractEvent event)
	{
		Player player = event.getPlayer();
		if (player.getItemInHand().getTypeId() == Material.FIREWORK_CHARGE.getId()) {
			if (player.hasPermission("Suppression.Use")) {
				Main.getPlugin().getLogger().info(player.getDisplayName() + " used a firecharge." );
			} else {
				Main.getPlugin().getLogger().info(player.getDisplayName() + " firecharge use cancelled.");
				event.setCancelled(true);
			}
		}
	}	
	
	@EventHandler(ignoreCancelled = true)
	public void onPlayerLighter(PlayerInteractEvent event)
	{
		Player player = event.getPlayer();
		if (player.getItemInHand().getTypeId() == Material.FLINT_AND_STEEL.getId()) {
			if (player.hasPermission("Suppression.Use")) {
				Main.getPlugin().getLogger().info(player.getDisplayName() + " used a lighter." );
			} else {
				Main.getPlugin().getLogger().info(player.getDisplayName() + " lighter use cancelled.");
				event.setCancelled(true);
			}
		}
	}
		
}
