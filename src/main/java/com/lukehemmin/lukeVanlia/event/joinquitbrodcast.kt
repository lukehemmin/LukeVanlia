package com.lukehemmin.lukeVanlia.event

import com.lukehemmin.lukeVanlia.Main
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

class joinquitbrodcast(private val plugin: Main) : Listener {
    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        if (!event.player.hasPlayedBefore()) {
            event.joinMessage = "       §f§l[§e§l++§f§l] §f§l${event.player.name} 님이 처음으로 서버에 접속했습니다!"
        } else {
            event.joinMessage = "       §f§l[§a§l+§f§l] §f§l${event.player.name} 님이 서버에 접속했습니다!"
        }
    }

    @EventHandler
    fun onPlayerQuit(event: PlayerQuitEvent) {
        event.quitMessage = "       §f§l[§c§l-§f§l] §f§l${event.player.name} 님이 서버에서 나갔습니다!"
    }
}