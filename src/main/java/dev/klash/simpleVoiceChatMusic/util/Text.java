package dev.klash.simpleVoiceChatMusic.util;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;

public class Text {
    public static Component literal(String text) {
        return MiniMessage.miniMessage().deserialize(text);
    }

    public static Component empty() {
        return literal("");
    }
}
