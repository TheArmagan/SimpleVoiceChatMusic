package dev.klash.simpleVoiceChatMusic.commands;

import dev.klash.simpleVoiceChatMusic.SimpleVoiceChatMusic;
import dev.klash.simpleVoiceChatMusic.audio.GroupManager;
import dev.klash.simpleVoiceChatMusic.audio.MusicManager;
import dev.klash.simpleVoiceChatMusic.util.ModUtils;
import dev.klash.simpleVoiceChatMusic.util.Text;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.Style;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.UUID;

import static dev.klash.simpleVoiceChatMusic.util.ModUtils.checkPlayerGroup;

public class KillCommand implements Command {
    private static HashSet<UUID> warned = new HashSet<>();

    public int execute(Player player, String[] args) throws Exception {
        ModUtils.CheckPlayerGroup result = checkPlayerGroup(player);
        if (result == null) return 1;

        if (warned.add(result.source().getUniqueId())) {
            result.source().sendMessage(
                () -> Text.literal("Are you sure you want to do this? This command should be used when everything is broken and you need to alt-f4 the plugin. Group members may hear a bit of earrape as the opus packets abruptly end.")
                    .style(Style.empty().color(NamedTextColor.RED)).append(Text.literal("\n\nIf you understand this, run the command again."))
            );

            return 0;
        }

        Bukkit.getScheduler().runTask(SimpleVoiceChatMusic.get(), () -> {
            GroupManager gm = MusicManager.getInstance().getGroup(result.group(), result.source().getServer());
            gm.broadcast(Text.literal("Playback forcibly killed by " + result.source().getName() + "."));
            gm.cleanup();
        });

        return 0;
    }

}
