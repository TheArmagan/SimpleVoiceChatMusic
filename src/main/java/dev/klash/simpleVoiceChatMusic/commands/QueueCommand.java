package dev.klash.simpleVoiceChatMusic.commands;

import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import dev.klash.simpleVoiceChatMusic.SimpleVoiceChatMusic;
import dev.klash.simpleVoiceChatMusic.audio.GroupManager;
import dev.klash.simpleVoiceChatMusic.audio.MusicManager;
import dev.klash.simpleVoiceChatMusic.util.ModUtils;
import dev.klash.simpleVoiceChatMusic.util.Text;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.concurrent.BlockingQueue;

import static dev.klash.simpleVoiceChatMusic.util.ModUtils.checkPlayerGroup;

public class QueueCommand implements Command {
    public int execute(Player context, String[] args) throws Exception {
        ModUtils.CheckPlayerGroup result = checkPlayerGroup(context);
        if (result == null) return 1;

        Bukkit.getScheduler().runTask(SimpleVoiceChatMusic.get(), () -> {
            GroupManager gm = MusicManager.getInstance().getGroup(result.group(), result.source().getServer());

            Component text = Text.empty();
            AudioTrack currentTrack = gm.getPlayer().getPlayingTrack();
            BlockingQueue<AudioTrack> tracks = gm.getQueue();

            if (currentTrack != null) {
                text.append(Text.literal("Current: ").append(ModUtils.trackInfo(currentTrack.getInfo())).append(Text.literal("\n")));
            }

            AudioTrack[] tracksArr = tracks.toArray(AudioTrack[]::new);
            for (int i = 0; i < tracksArr.length; i++) {
                AudioTrack track = tracksArr[i];
                text.append(Text.literal(i + ". ").append(ModUtils.trackInfo(track.getInfo())).append(Text.literal("\n")));
            }

            if (PlainTextComponentSerializer.plainText().serialize(text).isBlank()) {
                text.append(Text.literal("No songs in the queue."));
            }

            result.source().sendMessage(
                text
            );
        });

        return 0;
    }

}
