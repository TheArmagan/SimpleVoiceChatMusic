# Simple Voice Chat Music Player for Paper

_This mod is a **port** of the [Simple Voice Chat Music](https://modrinth.com/mod/simple-voice-chat-music) fabric mod!_

Enjoy music with your friends on a Paper server. This mod allows you to stream youtube, soundcloud, bandcamp, vimeo, twitch, mp3, flac, wav, m3u, and more into SimpleVoiceChat groups.
Powered by the lightweight [lavaplayer](https://github.com/lavalink-devs/lavaplayer) library.

![Video example from MOD](https://github.com/ItzDerock/simplevoicechat-music/assets/14848722/c974d7a7-26a7-44b9-9c8a-b6d6722a8582)

## Commands

String args like `<song>` do not need quotes around them due to this version just joining args instead of using brigadier.

- `/music play <song>` - Searches and queues the first result
- `/music search <song>` - Lists all results and lets you choose which you want to queue
- `/music now-playing` - Shows the current song
- `/music queue` - Shows the queue
- `/music skip` - Skips the current song
- `/music pause` - Pauses the current song
- `/music resume` - Resumes the current song
- `/music stop` - Stops the current song and clears the queue
- `/music volume <int;1-100>` - Sets the volume
- `/music kill` - use when something goes wrong and you want to restart the plugin without restarting the server
- `/music bassboost <float;0-200>` - adds bass boost

Song can be a soundcloud URL, Youtube URL, bandcamp URL, etc or it can be just a search term. By default, it will search on YouTube. You can force it to search on soundcloud by using the query `"scsearch: your search terms"`. Lavaplayer also supports YouTube Music, though it wasn't very reliable in my testing. To search YouTube Music, use the query `"ytmsearch: your search terms"`.

## Support

Contact me on discord (@gavingogaming) for support with this Paper version - there are bugs in this version nonexistant in the fabric mod.

## Customization

Currently, no options are customizable as this was made for private use, but I thought I'd open-source it since others may find it useful.

## Bugs

This plugin was lightly tested, but heres some bugs I've found so far:
- Many features are extremely broken as I really only tested soundcloud search and a few yt songs that seemed to not work.
- Quotes are not needed around search terms, unlike the original
- /music bassboost errors if no number is given... oop

## Credits

The original mod was created by @ItzDerok - check out the original mod via the link at the top of this readme. I've gotten permission to port the mod to Paper using SVC's bukkit api [here](https://github.com/ItzDerock/simplevoicechat-music/issues/7).
