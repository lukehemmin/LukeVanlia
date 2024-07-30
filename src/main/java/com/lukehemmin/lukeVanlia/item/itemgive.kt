package com.lukehemmin.lukeVanlia.item

import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta

class itemgive : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender is Player) {
            if (args.size >= 1){
                if (args.isNotEmpty() && args[0] == "네더라이트검쿠폰") {
                    val itemName = "§f네더라이트 검 지급권"
                    val lore = "§f우클릭하여 네더라이트 검을 지급받으세요."
                    val customItem = createCustomItem(itemName, lore)
                    sender.inventory.addItem(customItem)
                    sender.sendMessage("네더라이트 검 지급권을 지급했습니다.")
                    return true
                }else{
                    sender.sendMessage("§c올바른 아이템 이름을 적어주세요.")
                    return false
                }
            }
        }
        return false
    }

    private fun createCustomItem(name: String, loreText: String): ItemStack {
        val item = ItemStack(Material.PAPER)
        val meta: ItemMeta? = item.itemMeta
        meta?.setDisplayName(name)
        meta?.lore = listOf(loreText)
        item.itemMeta = meta
        return item
    }
}