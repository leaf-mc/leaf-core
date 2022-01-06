package mc.leaf.core.internal;

import mc.leaf.core.events.LeafListener;
import mc.leaf.core.interfaces.ILeafCore;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.List;

public class LeafInternalListener extends LeafListener {

    private final ILeafCore core;

    public LeafInternalListener(ILeafCore core) {

        this.core = core;
    }

    private List<String> getOnlinePlayerNames() {

        return Bukkit.getOnlinePlayers().stream().map(Player::getName).toList();
    }

    @EventHandler
    @Override
    public void onPlayerJoin(PlayerJoinEvent event) {

        this.core.registerDynamicOptions("player", this.getOnlinePlayerNames());
    }

    @EventHandler
    @Override
    public void onPlayerQuit(PlayerQuitEvent event) {

        this.core.registerDynamicOptions("player", this.getOnlinePlayerNames());
    }

    @EventHandler
    @Override
    public void onPlayerKick(PlayerKickEvent event) {

        this.core.registerDynamicOptions("player", this.getOnlinePlayerNames());
    }

}
