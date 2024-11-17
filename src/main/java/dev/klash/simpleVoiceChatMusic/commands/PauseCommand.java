package dev.klash.simpleVoiceChatMusic.commands;

import dev.klash.simpleVoiceChatMusic.SimpleVoiceChatMusic;
import dev.klash.simpleVoiceChatMusic.audio.GroupManager;
import dev.klash.simpleVoiceChatMusic.audio.MusicManager;
import dev.klash.simpleVoiceChatMusic.util.ModUtils;
import dev.klash.simpleVoiceChatMusic.util.Text;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import static dev.klash.simpleVoiceChatMusic.util.ModUtils.checkPlayerGroup;

public class PauseCommand implements Command {
    public int execute(Player context, String[] args) throws Exception {
        ModUtils.CheckPlayerGroup result = checkPlayerGroup(context);
        if (result == null) return 1;

        Bukkit.getScheduler().runTask(SimpleVoiceChatMusic.get(), () -> {
            GroupManager gm = MusicManager.getInstance().getGroup(result.group(), result.source().getServer());
            gm.broadcast(Text.literal("Playback paused by " + result.source().getName()));
            gm.getPlayer().setPaused(true);
        });

        return 0;
    }

}
