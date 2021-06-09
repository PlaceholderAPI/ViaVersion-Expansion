package me.glaremasters.papi.expansion.viaversion;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.protocol.version.ProtocolVersion;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public final class ViaVersionExpansion extends PlaceholderExpansion {

    @Override
    public boolean canRegister() {
        return Bukkit.getPluginManager().getPlugin("ViaVersion") != null;
    }

    @Override
    public String getIdentifier() {
        return "ViaVersion";
    }

    @Override
    public String getAuthor() {
        return "clip";
    }

    @Override
    public String getVersion() {
        return "2.0.0";
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public String onPlaceholderRequest(Player player, String identifier) {
        switch (identifier.toLowerCase()) {
            case "player_protocol_version":
                final ProtocolVersion protocolVersion = ProtocolVersion.getProtocol(Via.getAPI().getPlayerVersion(player.getUniqueId()));
                return protocolVersion.getName();
            case "player_protocol_id":
                return String.valueOf(Via.getAPI().getPlayerVersion(player.getUniqueId()));
        }
        return null;
    }
}
