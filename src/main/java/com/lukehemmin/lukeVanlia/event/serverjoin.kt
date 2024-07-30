package com.lukehemmin.lukeVanlia.event

import net.md_5.bungee.api.chat.ClickEvent
import net.md_5.bungee.api.chat.TextComponent
import com.lukehemmin.lukeVanlia.Main
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class serverjoin(private val plugin: Main) : Listener {
    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val player = event.player
        Bukkit.getScheduler().runTaskLater(plugin, Runnable {
            for (i in 1..100) {
                player.sendMessage("")
            }
            player.sendMessage("§b§l${player.name} §a§l님, 오늘도 서버에 오셨네요! 반가워요!")
            player.sendMessage("")
            val mapLink = TextComponent("§a§l[클릭하여 지도사이트로 이동]")
            mapLink.clickEvent = ClickEvent(ClickEvent.Action.OPEN_URL, "https://map.mine.lukehemmin.com/")
            player.spigot().sendMessage(mapLink)
            player.sendMessage("")
        }, 60L)

    }
}