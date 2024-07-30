package com.lukehemmin.lukeVanlia.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.eclipse.sisu.space.asm.Label

class admincommandsprotect : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (command.name.equals("pl", ignoreCase = true)) {
            if (sender is Player && !sender.isOp) {
                sender.sendMessage("§fServer Plugins (1):")
                sender.sendMessage("§6Bukkit Plugins:")
                sender.sendMessage("§8 - §aLukeVanlia")
                return true
            }
        }
        return false
    }
}