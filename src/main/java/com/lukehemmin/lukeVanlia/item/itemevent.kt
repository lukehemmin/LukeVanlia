package com.lukehemmin.lukeVanlia.item

import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.ItemStack

class itemevent : Listener {
    @EventHandler
    fun onPlayerUse(event: PlayerInteractEvent) {
        val player = event.player
        val item = event.item

        if (event.action.isRightClick && item != null) {
            if (item.type == Material.PAPER && item.itemMeta?.displayName == "§f네더라이트 검 지급권" && item.itemMeta?.lore?.contains("§f우클릭하여 네더라이트 검을 지급받으세요.") == true) {
                val netheriteSword = ItemStack(Material.NETHERITE_SWORD)
                player.inventory.addItem(netheriteSword)
                player.sendMessage("네더라이트 검을 지급했습니다.")

                item.amount = item.amount - 1
            }
        }
    }
}