package com.lukehemmin.lukeVanlia.lobby

import com.lukehemmin.lukeVanlia.Main
import net.md_5.bungee.api.chat.ClickEvent
import net.md_5.bungee.api.chat.TextComponent
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

class lobbysystem(private val plugin: Main) : Listener, CommandExecutor {
    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        event.joinMessage = "       §f§l[§a§l+§f§l] §f§l${event.player.name} 님이 로비 서버에 접속했습니다!"

        val player = event.player
        Bukkit.getScheduler().runTaskLater(plugin, Runnable {
            for (i in 1..100) {
                player.sendMessage("")
            }
            player.sendMessage("§b§l${player.name} §a§l님, 이곳은 로비서버에요!")
            player.sendMessage("")
            player.sendMessage("§a§l이곳은 서버 점검, 패치가 있을때 서버가 다시 열릴때까지 기다리는 서버에요!")
            player.sendMessage("§a§l서버가 열리면 다시 원래 서버, 원래 위치로 돌아가게 되요!")
            player.sendMessage("§a§l잠시만 기다려주세요! ( 예정시간은 공지사항이나 패치노트에 있어요! )")
            player.sendMessage("")
        }, 60L)
    }

    @EventHandler
    fun onPlayerQuit(event: PlayerQuitEvent) {
        event.quitMessage = "       §f§l[§c§l-§f§l] §f§l${event.player.name} 님이 로비 서버에서 나갔습니다!"
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender is Player) {
            //sender.sendMessage("")
            return true
        }
        return false
    }
}