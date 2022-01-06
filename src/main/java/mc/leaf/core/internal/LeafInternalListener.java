package mc.leaf.core.internal;

import mc.leaf.core.LeafCore;
import mc.leaf.core.events.LeafListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.List;

public class LeafInternalListener extends LeafListener {

    private final LeafCore core;

    public LeafInternalListener(LeafCore core) {

        this.core = core;
    }

    private List<String> getOnlinePlayerNames() {

        return Bukkit.getOnlinePlayers().stream().map(Player::getName).toList();
    }

    @Override
    public void onPlayerJoin(PlayerJoinEvent event) {

        this.core.registerDynamicOptions("players", this.getOnlinePlayerNames());
    }

    @Override
    public void onPlayerQuit(PlayerQuitEvent event) {

        this.core.registerDynamicOptions("players", this.getOnlinePlayerNames());
    }

    @Override
    public void onPlayerKick(PlayerKickEvent event) {

        this.core.registerDynamicOptions("players", this.getOnlinePlayerNames());
    }

}
