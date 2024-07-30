package com.lukehemmin.lukeVanlia

import com.lukehemmin.lukeVanlia.commands.admincommandsprotect
import com.lukehemmin.lukeVanlia.event.joinquitbrodcast
import com.lukehemmin.lukeVanlia.event.serverjoin
import com.lukehemmin.lukeVanlia.item.itemevent
import com.lukehemmin.lukeVanlia.item.itemgive
import com.lukehemmin.lukeVanlia.lobby.lobbysystem
import com.lukehemmin.lukeVanlia.lobby.SnowMinigame
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    private lateinit var snowMinigame: SnowMinigame
    override fun onEnable() {
        logger.info("Plugin enabled")

        // Custom Item Command / Event
        //getCommand("ticket_give")?.setExecutor(itemgive())
        //server.pluginManager.registerEvents(itemevent(), this)

        // Server Join Event
        //server.pluginManager.registerEvents(serverjoin(this), this)

        // Join / Quit Broadcast Event
        //server.pluginManager.registerEvents(joinquitbrodcast(this), this)

        // admincommandsprotect commands
        getCommand("pl")?.setExecutor(admincommandsprotect())

        // Lobby System
        val lobbySystem = lobbysystem(this)
        server.pluginManager.registerEvents(lobbySystem, this)
        getCommand("help")?.setExecutor(lobbySystem)

        snowMinigame = SnowMinigame(this)
        server.pluginManager.registerEvents(snowMinigame, this)
    }

    override fun onDisable() {
        logger.info("Plugin disabled")
    }
}
