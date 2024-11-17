package dev.klash.simpleVoiceChatMusic.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.sedmelluq.discord.lavaplayer.filter.equalizer.EqualizerFactory;
import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import dev.klash.simpleVoiceChatMusic.SimpleVoiceChatMusic;
import dev.klash.simpleVoiceChatMusic.audio.GroupManager;
import dev.klash.simpleVoiceChatMusic.audio.MusicManager;
import dev.klash.simpleVoiceChatMusic.util.ModUtils;
import dev.klash.simpleVoiceChatMusic.util.Text;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import static dev.klash.simpleVoiceChatMusic.util.ModUtils.checkPlayerGroup;

public class BassboostCommand implements Command {
    public int execute(Player player, String[] args) throws Exception {
        float bass = Float.parseFloat(args[0]);
        ModUtils.CheckPlayerGroup result = checkPlayerGroup(player);
        if (result == null) return 1;

        Bukkit.getScheduler().runTask(SimpleVoiceChatMusic.get(), () -> {
            GroupManager gm = MusicManager.getInstance().getGroup(result.group(), result.source().getServer());
            gm.broadcast(Text.literal("Bassboost set to " + bass + "% by " + player.getName()));
            gm.setBassBoost(bass);
        });

        return 0;
    }

}
