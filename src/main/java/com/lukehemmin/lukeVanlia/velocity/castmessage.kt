package com.lukehemmin.lukeVanlia.velocity

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.ConsoleCommandSender

class castmessage : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        if (sender is ConsoleCommandSender) {
            if (args.isNotEmpty()) {
                val message = args.joinToString(" ")
                Bukkit.broadcastMessage("Broadcast: $message")
                return true
            } else {
                sender.sendMessage("Please provide a message to broadcast.")
                return false
            }
        }
        sender.sendMessage("This command can only be executed from the console.")
        return false
    }
}