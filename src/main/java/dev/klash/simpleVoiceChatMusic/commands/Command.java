package dev.klash.simpleVoiceChatMusic.commands;

import org.bukkit.entity.Player;

public interface Command {
    int execute(Player player, String[] args) throws Exception;
}
