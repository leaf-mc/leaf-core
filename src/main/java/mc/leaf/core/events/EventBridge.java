package mc.leaf.core.events;

import com.destroystokyo.paper.event.block.AnvilDamagedEvent;
import com.destroystokyo.paper.event.block.BeaconEffectEvent;
import com.destroystokyo.paper.event.block.BlockDestroyEvent;
import com.destroystokyo.paper.event.block.TNTPrimeEvent;
import com.destroystokyo.paper.event.entity.*;
import com.destroystokyo.paper.event.inventory.PrepareResultEvent;
import com.destroystokyo.paper.event.player.*;
import com.destroystokyo.paper.event.profile.*;
import com.destroystokyo.paper.event.server.*;
import io.papermc.paper.event.block.*;
import io.papermc.paper.event.entity.*;
import io.papermc.paper.event.packet.PlayerChunkLoadEvent;
import io.papermc.paper.event.packet.PlayerChunkUnloadEvent;
import io.papermc.paper.event.player.*;
import io.papermc.paper.event.server.ServerResourcesReloadedEvent;
import io.papermc.paper.event.world.StructureLocateEvent;
import io.papermc.paper.event.world.WorldGameRuleChangeEvent;
import io.papermc.paper.event.world.border.WorldBorderBoundsChangeEvent;
import io.papermc.paper.event.world.border.WorldBorderBoundsChangeFinishEvent;
import io.papermc.paper.event.world.border.WorldBorderCenterChangeEvent;
import mc.leaf.core.events.interfaces.IEventBridge;
import mc.leaf.core.events.interfaces.ILeafListener;
import mc.leaf.core.interfaces.ILeafModule;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.*;
import org.bukkit.event.command.UnknownCommandEvent;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;
import org.bukkit.event.entity.*;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.hanging.HangingBreakEvent;
import org.bukkit.event.hanging.HangingPlaceEvent;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.PlayerLocaleChangeEvent;
import org.bukkit.event.player.*;
import org.bukkit.event.raid.RaidFinishEvent;
import org.bukkit.event.raid.RaidSpawnWaveEvent;
import org.bukkit.event.raid.RaidStopEvent;
import org.bukkit.event.raid.RaidTriggerEvent;
import org.bukkit.event.server.*;
import org.bukkit.event.vehicle.*;
import org.bukkit.event.weather.LightningStrikeEvent;
import org.bukkit.event.weather.ThunderChangeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.event.world.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is an implementation of the interface {@link IEventBridge} allowing events distribution across all
 * modules.
 *
 * This is required as Bukkit doesn't provide a way to unregister {@link org.bukkit.event.Listener} without using
 * reflection (shame).
 *
 * @author alexpado
 */
public class EventBridge implements IEventBridge {

    private final Map<ILeafModule, List<ILeafListener>> listeners = new HashMap<>();

    /**
     * Register the provided {@link ILeafListener} under the provided {@link ILeafModule}.
     *
     * @param module
     *         The {@link ILeafModule} registering the {@link ILeafListener}.
     * @param listener
     *         The {@link ILeafListener} to register.
     */
    @Override
    public void register(ILeafModule module, ILeafListener listener) {

        List<ILeafListener> moduleListeners = this.listeners.getOrDefault(module, new ArrayList<>());
        moduleListeners.add(listener);
        this.listeners.put(module, moduleListeners);
    }

    /**
     * Remove all {@link ILeafListener}s registered by the provided {@link ILeafModule}.
     *
     * @param module
     *         The {@link ILeafModule} from which all {@link ILeafModule}s will be unregistered.
     */
    @Override
    public void unregister(ILeafModule module) {

        this.listeners.remove(module);
    }

    //<editor-fold desc="= Event Calls =">

    @Override
    @EventHandler
    public void onAnvilDamaged(AnvilDamagedEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onAnvilDamaged(event));
    }

    @Override
    @EventHandler
    public void onBeaconEffect(BeaconEffectEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBeaconEffect(event));
    }

    @Override
    @EventHandler
    public void onBlockDestroy(BlockDestroyEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockDestroy(event));
    }

    @Override
    @EventHandler
    public void onTNTPrime(TNTPrimeEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onTNTPrime(event));
    }

    @Override
    @EventHandler
    public void onBeaconActivated(BeaconActivatedEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBeaconActivated(event));
    }

    @Override
    @EventHandler
    public void onBeaconDeactivated(BeaconDeactivatedEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBeaconDeactivated(event));
    }

    @Override
    @EventHandler
    public void onBellRevealRaider(BellRevealRaiderEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBellRevealRaider(event));
    }

    @Override
    @EventHandler
    public void onBellRing(BellRingEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBellRing(event));
    }

    @Override
    @EventHandler
    public void onBlockBreakBlock(BlockBreakBlockEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockBreakBlock(event));
    }

    @Override
    @EventHandler
    public void onBlockFailedDispense(BlockFailedDispenseEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockFailedDispense(event));
    }

    @Override
    @EventHandler
    public void onBlockPreDispense(BlockPreDispenseEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockPreDispense(event));
    }

    @Override
    @EventHandler
    public void onDragonEggForm(DragonEggFormEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onDragonEggForm(event));
    }

    @Override
    @EventHandler
    public void onPlayerShearBlock(PlayerShearBlockEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerShearBlock(event));
    }

    @Override
    @EventHandler
    public void onTargetHit(TargetHitEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onTargetHit(event));
    }

    @Override
    @EventHandler
    public void onCreeperIgnite(CreeperIgniteEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onCreeperIgnite(event));
    }

    @Override
    @EventHandler
    public void onEnderDragonFireballHit(EnderDragonFireballHitEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEnderDragonFireballHit(event));
    }

    @Override
    @EventHandler
    public void onEnderDragonFlame(EnderDragonFlameEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEnderDragonFlame(event));
    }

    @Override
    @EventHandler
    public void onEnderDragonShootFireball(EnderDragonShootFireballEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEnderDragonShootFireball(event));
    }

    @Override
    @EventHandler
    public void onEndermanAttackPlayer(EndermanAttackPlayerEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEndermanAttackPlayer(event));
    }

    @Override
    @EventHandler
    public void onEndermanEscape(EndermanEscapeEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEndermanEscape(event));
    }

    @Override
    @EventHandler
    public void onEntityAddToWorld(EntityAddToWorldEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityAddToWorld(event));
    }

    @Override
    @EventHandler
    public void onEntityJump(EntityJumpEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityJump(event));
    }

    @Override
    @EventHandler
    public void onEntityKnockbackByEntity(EntityKnockbackByEntityEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityKnockbackByEntity(event));
    }

    @Override
    @EventHandler
    public void onEntityPathfind(EntityPathfindEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityPathfind(event));
    }

    @Override
    @EventHandler
    public void onEntityRemoveFromWorld(EntityRemoveFromWorldEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityRemoveFromWorld(event));
    }

    @Override
    @EventHandler
    public void onEntityTeleportEndGateway(EntityTeleportEndGatewayEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityTeleportEndGateway(event));
    }

    @Override
    @EventHandler
    public void onEntityZap(EntityZapEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityZap(event));
    }

    @Override
    @EventHandler
    public void onExperienceOrbMerge(ExperienceOrbMergeEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onExperienceOrbMerge(event));
    }

    @Override
    @EventHandler
    public void onPhantomPreSpawn(PhantomPreSpawnEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPhantomPreSpawn(event));
    }

    @Override
    @EventHandler
    public void onPlayerNaturallySpawnCreatures(PlayerNaturallySpawnCreaturesEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerNaturallySpawnCreatures(event));
    }

    @Override
    @EventHandler
    public void onPreCreatureSpawn(PreCreatureSpawnEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPreCreatureSpawn(event));
    }

    @Override
    @EventHandler
    public void onPreSpawnerSpawn(PreSpawnerSpawnEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPreSpawnerSpawn(event));
    }

    @Override
    @EventHandler
    public void onProjectileCollide(ProjectileCollideEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onProjectileCollide(event));
    }

    @Override
    @EventHandler
    public void onSkeletonHorseTrap(SkeletonHorseTrapEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onSkeletonHorseTrap(event));
    }

    @Override
    @EventHandler
    public void onSlimeChangeDirection(SlimeChangeDirectionEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onSlimeChangeDirection(event));
    }

    @Override
    @EventHandler
    public void onSlimePathfind(SlimePathfindEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onSlimePathfind(event));
    }

    @Override
    @EventHandler
    public void onSlimeSwim(SlimeSwimEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onSlimeSwim(event));
    }

    @Override
    @EventHandler
    public void onSlimeTargetLivingEntity(SlimeTargetLivingEntityEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onSlimeTargetLivingEntity(event));
    }

    @Override
    @EventHandler
    public void onSlimeWander(SlimeWanderEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onSlimeWander(event));
    }

    @Override
    @EventHandler
    public void onThrownEggHatch(ThrownEggHatchEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onThrownEggHatch(event));
    }

    @Override
    @EventHandler
    public void onTurtleGoHome(TurtleGoHomeEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onTurtleGoHome(event));
    }

    @Override
    @EventHandler
    public void onTurtleLayEgg(TurtleLayEggEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onTurtleLayEgg(event));
    }

    @Override
    @EventHandler
    public void onTurtleStartDigging(TurtleStartDiggingEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onTurtleStartDigging(event));
    }

    @Override
    @EventHandler
    public void onWitchConsumePotion(WitchConsumePotionEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onWitchConsumePotion(event));
    }

    @Override
    @EventHandler
    public void onWitchReadyPotion(WitchReadyPotionEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onWitchReadyPotion(event));
    }

    @Override
    @EventHandler
    public void onWitchThrowPotion(WitchThrowPotionEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onWitchThrowPotion(event));
    }

    @Override
    @EventHandler
    public void onElderGuardianAppearance(ElderGuardianAppearanceEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onElderGuardianAppearance(event));
    }

    @Override
    @EventHandler
    public void onEntityDamageItem(EntityDamageItemEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityDamageItem(event));
    }

    @Override
    @EventHandler
    public void onEntityInsideBlock(EntityInsideBlockEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityInsideBlock(event));
    }

    @Override
    @EventHandler
    public void onEntityLoadCrossbow(EntityLoadCrossbowEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityLoadCrossbow(event));
    }

    @Override
    @EventHandler
    public void onEntityMove(EntityMoveEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityMove(event));
    }

    @Override
    @EventHandler
    public void onPufferFishStateChange(PufferFishStateChangeEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPufferFishStateChange(event));
    }

    @Override
    @EventHandler
    public void onPrepareResult(PrepareResultEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPrepareResult(event));
    }

    @Override
    @EventHandler
    public void onPlayerAdvancementCriterionGrant(PlayerAdvancementCriterionGrantEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerAdvancementCriterionGrant(event));
    }

    @Override
    @EventHandler
    public void onPlayerArmorChange(PlayerArmorChangeEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerArmorChange(event));
    }

    @Override
    @EventHandler
    public void onPlayerAttackEntityCooldownReset(PlayerAttackEntityCooldownResetEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerAttackEntityCooldownReset(event));
    }

    @Override
    @EventHandler
    public void onPlayerClientOptionsChange(PlayerClientOptionsChangeEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerClientOptionsChange(event));
    }

    @Override
    @EventHandler
    public void onPlayerConnectionClose(PlayerConnectionCloseEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerConnectionClose(event));
    }

    @Override
    @EventHandler
    public void onPlayerElytraBoost(PlayerElytraBoostEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerElytraBoost(event));
    }

    @Override
    @EventHandler
    public void onPlayerHandshake(PlayerHandshakeEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerHandshake(event));
    }

    @Override
    @EventHandler
    public void onPlayerJumpEvent(PlayerJumpEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerJumpEvent(event));
    }

    @Override
    @EventHandler
    public void onPlayerLaunchProjectile(PlayerLaunchProjectileEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerLaunchProjectile(event));
    }

    @Override
    @EventHandler
    public void onPlayerPickupExperience(PlayerPickupExperienceEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerPickupExperience(event));
    }

    @Override
    @EventHandler
    public void onPlayerPostRespawn(PlayerPostRespawnEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerPostRespawn(event));
    }

    @Override
    @EventHandler
    public void onPlayerReadyArrow(PlayerReadyArrowEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerReadyArrow(event));
    }

    @Override
    @EventHandler
    public void onPlayerRecipeBookClick(PlayerRecipeBookClickEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerRecipeBookClick(event));
    }

    @Override
    @EventHandler
    public void onPlayerSetSpawn(PlayerSetSpawnEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerSetSpawn(event));
    }

    @Override
    @EventHandler
    public void onPlayerStartSpectatingEntity(PlayerStartSpectatingEntityEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerStartSpectatingEntity(event));
    }

    @Override
    @EventHandler
    public void onPlayerStopSpectatingEntity(PlayerStopSpectatingEntityEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerStopSpectatingEntity(event));
    }

    @Override
    @EventHandler
    public void onPlayerTeleportEndGateway(PlayerTeleportEndGatewayEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerTeleportEndGateway(event));
    }

    @Override
    @EventHandler
    public void onPlayerUseUnknownEntity(PlayerUseUnknownEntityEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerUseUnknownEntity(event));
    }

    @Override
    @EventHandler
    public void onAsyncChat(AsyncChatEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onAsyncChat(event));
    }

    @Override
    @EventHandler
    public void onPlayerArmSwingEvent(PlayerArmSwingEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerArmSwingEvent(event));
    }

    @Override
    @EventHandler
    public void onPlayerBedFailEnter(PlayerBedFailEnterEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerBedFailEnter(event));
    }

    @Override
    @EventHandler
    public void onPlayerChangeBeaconEffect(PlayerChangeBeaconEffectEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerChangeBeaconEffect(event));
    }

    @Override
    @EventHandler
    public void onPlayerDeepSleep(PlayerDeepSleepEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerDeepSleep(event));
    }

    @Override
    @EventHandler
    public void onPlayerFlowerPotManipulate(PlayerFlowerPotManipulateEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerFlowerPotManipulate(event));
    }

    @Override
    @EventHandler
    public void onPlayerItemCooldown(PlayerItemCooldownEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerItemCooldown(event));
    }

    @Override
    @EventHandler
    public void onPlayerItemFrameChange(PlayerItemFrameChangeEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerItemFrameChange(event));
    }

    @Override
    @EventHandler
    public void onPlayerLecternPageChange(PlayerLecternPageChangeEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerLecternPageChange(event));
    }

    @Override
    @EventHandler
    public void onPlayerLoomPatternSelect(PlayerLoomPatternSelectEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerLoomPatternSelect(event));
    }

    @Override
    @EventHandler
    public void onPlayerNameEntity(PlayerNameEntityEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerNameEntity(event));
    }

    @Override
    @EventHandler
    public void onPlayerPurchase(PlayerPurchaseEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerPurchase(event));
    }

    @Override
    @EventHandler
    public void onPlayerSignCommandPreprocess(PlayerSignCommandPreprocessEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerSignCommandPreprocess(event));
    }

    @Override
    @EventHandler
    public void onPlayerStonecutterRecipeSelect(PlayerStonecutterRecipeSelectEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerStonecutterRecipeSelect(event));
    }

    @Override
    @EventHandler
    public void onPlayerTrade(PlayerTradeEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerTrade(event));
    }

    @Override
    @EventHandler
    public void onFillProfile(FillProfileEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onFillProfile(event));
    }

    @Override
    @EventHandler
    public void onLookupProfile(LookupProfileEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onLookupProfile(event));
    }

    @Override
    @EventHandler
    public void onPreFillProfile(PreFillProfileEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPreFillProfile(event));
    }

    @Override
    @EventHandler
    public void onPreLookupProfile(PreLookupProfileEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPreLookupProfile(event));
    }

    @Override
    @EventHandler
    public void onProfileWhitelistVerify(ProfileWhitelistVerifyEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onProfileWhitelistVerify(event));
    }

    @Override
    @EventHandler
    public void onAsyncTabComplete(AsyncTabCompleteEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onAsyncTabComplete(event));
    }

    @Override
    @EventHandler
    public void onGS4Query(GS4QueryEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onGS4Query(event));
    }

    @Override
    @EventHandler
    public void onPaperServerListPingEvent(PaperServerListPingEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPaperServerListPingEvent(event));
    }

    @Override
    @EventHandler
    public void onServerException(ServerExceptionEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onServerException(event));
    }

    @Override
    @EventHandler
    public void onServerTickEnd(ServerTickEndEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onServerTickEnd(event));
    }

    @Override
    @EventHandler
    public void onServerTickStart(ServerTickStartEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onServerTickStart(event));
    }

    @Override
    @EventHandler
    public void onWhitelistToggle(WhitelistToggleEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onWhitelistToggle(event));
    }

    @Override
    @EventHandler
    public void onServerResourcesReloaded(ServerResourcesReloadedEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onServerResourcesReloaded(event));
    }

    @Override
    @EventHandler
    public void onPlayerChunkLoad(PlayerChunkLoadEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerChunkLoad(event));
    }

    @Override
    @EventHandler
    public void onPlayerChunkUnload(PlayerChunkUnloadEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerChunkUnload(event));
    }

    @Override
    @EventHandler
    public void onWorldBorderBoundsChange(WorldBorderBoundsChangeEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onWorldBorderBoundsChange(event));
    }

    @Override
    @EventHandler
    public void onWorldBorderBoundsChangeFinished(WorldBorderBoundsChangeFinishEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onWorldBorderBoundsChangeFinished(event));
    }

    @Override
    @EventHandler
    public void onWorldBoardCenterChange(WorldBorderCenterChangeEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onWorldBoardCenterChange(event));
    }

    @Override
    @EventHandler
    public void onStructureLocate(StructureLocateEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onStructureLocate(event));
    }

    @Override
    @EventHandler
    public void onWorldGameRuleChange(WorldGameRuleChangeEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onWorldGameRuleChange(event));
    }

    @Override
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockBreak(event));
    }

    @Override
    @EventHandler
    public void onBlockBurn(BlockBurnEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockBurn(event));
    }

    @Override
    @EventHandler
    public void onBlockCanBuild(BlockCanBuildEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockCanBuild(event));
    }

    @Override
    @EventHandler
    public void onBlockCook(BlockCookEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockCook(event));
    }

    @Override
    @EventHandler
    public void onBlockDamage(BlockDamageEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockDamage(event));
    }

    @Override
    @EventHandler
    public void onBlockDispenseArmor(BlockDispenseArmorEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockDispenseArmor(event));
    }

    @Override
    @EventHandler
    public void onBlockDispense(BlockDispenseEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockDispense(event));
    }

    @Override
    @EventHandler
    public void onBlockDropItem(BlockDropItemEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockDropItem(event));
    }

    @Override
    @EventHandler
    public void onBlockExp(BlockExpEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockExp(event));
    }

    @Override
    @EventHandler
    public void onBlockExplode(BlockExplodeEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockExplode(event));
    }

    @Override
    @EventHandler
    public void onBlockFade(BlockFadeEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockFade(event));
    }

    @Override
    @EventHandler
    public void onBlockFertilize(BlockFertilizeEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockFertilize(event));
    }

    @Override
    @EventHandler
    public void onBlockFormEvent(BlockFormEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockFormEvent(event));
    }

    @Override
    @EventHandler
    public void onBlockFromTo(BlockFromToEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockFromTo(event));
    }

    @Override
    @EventHandler
    public void onBlockGrow(BlockGrowEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockGrow(event));
    }

    @Override
    @EventHandler
    public void onBlockIgnite(BlockIgniteEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockIgnite(event));
    }

    @Override
    @EventHandler
    public void onBlockMultiPlace(BlockMultiPlaceEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockMultiPlace(event));
    }

    @Override
    @EventHandler
    public void onBlockPhysics(BlockPhysicsEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockPhysics(event));
    }

    @Override
    @EventHandler
    public void onBlockPistonExtend(BlockPistonExtendEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockPistonExtend(event));
    }

    @Override
    @EventHandler
    public void onBlockPistonRetract(BlockPistonRetractEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockPistonRetract(event));
    }

    @Override
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockPlace(event));
    }

    @Override
    @EventHandler
    public void onBlockReceiveGame(BlockReceiveGameEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockReceiveGame(event));
    }

    @Override
    @EventHandler
    public void onBlockRedstone(BlockRedstoneEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockRedstone(event));
    }

    @Override
    @EventHandler
    public void onBlockShearEntity(BlockShearEntityEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockShearEntity(event));
    }

    @Override
    @EventHandler
    public void onBlockSpread(BlockSpreadEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockSpread(event));
    }

    @Override
    @EventHandler
    public void onCauldronLevelChange(CauldronLevelChangeEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onCauldronLevelChange(event));
    }

    @Override
    @EventHandler
    public void onEntityBlockForm(EntityBlockFormEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityBlockForm(event));
    }

    @Override
    @EventHandler
    public void onFluidLevelChange(FluidLevelChangeEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onFluidLevelChange(event));
    }

    @Override
    @EventHandler
    public void onLeavesDecay(LeavesDecayEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onLeavesDecay(event));
    }

    @Override
    @EventHandler
    public void onMoistureChange(MoistureChangeEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onMoistureChange(event));
    }

    @Override
    @EventHandler
    public void onNotePlay(NotePlayEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onNotePlay(event));
    }

    @Override
    @EventHandler
    public void onSignChange(SignChangeEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onSignChange(event));
    }

    @Override
    @EventHandler
    public void onSpongeAbsorb(SpongeAbsorbEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onSpongeAbsorb(event));
    }

    @Override
    @EventHandler
    public void onUnknownCommand(UnknownCommandEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onUnknownCommand(event));
    }

    @Override
    @EventHandler
    public void onEnchantItem(EnchantItemEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEnchantItem(event));
    }

    @Override
    @EventHandler
    public void onPrepareItemEnchant(PrepareItemEnchantEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPrepareItemEnchant(event));
    }

    @Override
    @EventHandler
    public void onAreaEffectCloudApply(AreaEffectCloudApplyEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onAreaEffectCloudApply(event));
    }

    @Override
    @EventHandler
    public void onArrowBodyCountChange(ArrowBodyCountChangeEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onArrowBodyCountChange(event));
    }

    @Override
    @EventHandler
    public void onBatToggleSleep(BatToggleSleepEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBatToggleSleep(event));
    }

    @Override
    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onCreatureSpawn(event));
    }

    @Override
    @EventHandler
    public void onCreeperPower(CreeperPowerEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onCreeperPower(event));
    }

    @Override
    @EventHandler
    public void onEnderDragonChangePhase(EnderDragonChangePhaseEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEnderDragonChangePhase(event));
    }

    @Override
    @EventHandler
    public void onEntityAirChange(EntityAirChangeEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityAirChange(event));
    }

    @Override
    @EventHandler
    public void onEntityBreakDoor(EntityBreakDoorEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityBreakDoor(event));
    }

    @Override
    @EventHandler
    public void onEntityBreed(EntityBreedEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityBreed(event));
    }

    @Override
    @EventHandler
    public void onEntityChangeBlock(EntityChangeBlockEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityChangeBlock(event));
    }

    @Override
    @EventHandler
    public void onEntityCombustByBlock(EntityCombustByBlockEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityCombustByBlock(event));
    }

    @Override
    @EventHandler
    public void onEntityCombustByEntity(EntityCombustByEntityEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityCombustByEntity(event));
    }

    @Override
    @EventHandler
    public void onEntityCombust(EntityCombustEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityCombust(event));
    }

    @Override
    @EventHandler
    public void onEntityDamageByBlock(EntityDamageByBlockEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityDamageByBlock(event));
    }

    @Override
    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityDamageByEntity(event));
    }

    @Override
    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityDamage(event));
    }

    @Override
    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityDeath(event));
    }

    @Override
    @EventHandler
    public void onEntityDropItem(EntityDropItemEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityDropItem(event));
    }

    @Override
    @EventHandler
    public void onEntityEnterBlock(EntityEnterBlockEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityEnterBlock(event));
    }

    @Override
    @EventHandler
    public void onEntityEnterLoveMode(EntityEnterLoveModeEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityEnterLoveMode(event));
    }

    @Override
    @EventHandler
    public void onEntityExhaustion(EntityExhaustionEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityExhaustion(event));
    }

    @Override
    @EventHandler
    public void onEntityExplode(EntityExplodeEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityExplode(event));
    }

    @Override
    @EventHandler
    public void onEntityInteract(EntityInteractEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityInteract(event));
    }

    @Override
    @EventHandler
    public void onEntityPickupItem(EntityPickupItemEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityPickupItem(event));
    }

    @Override
    @EventHandler
    public void onEntityPlace(EntityPlaceEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityPlace(event));
    }

    @Override
    @EventHandler
    public void onEntityPortalEnter(EntityPortalEnterEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityPortalEnter(event));
    }

    @Override
    @EventHandler
    public void onEntityPortal(EntityPortalEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityPortal(event));
    }

    @Override
    @EventHandler
    public void onEntityPortalExit(EntityPortalEnterEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityPortalExit(event));
    }

    @Override
    @EventHandler
    public void onEntityPoseChange(EntityPoseChangeEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityPoseChange(event));
    }

    @Override
    @EventHandler
    public void onEntityPotionEffect(EntityPotionEffectEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityPotionEffect(event));
    }

    @Override
    @EventHandler
    public void onEntityRegainHealth(EntityRegainHealthEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityRegainHealth(event));
    }

    @Override
    @EventHandler
    public void onEntityResurrect(EntityResurrectEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityResurrect(event));
    }

    @Override
    @EventHandler
    public void onEntityShootBow(EntityShootBowEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityShootBow(event));
    }

    @Override
    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntitySpawn(event));
    }

    @Override
    @EventHandler
    public void onEntitySpellCast(EntitySpellCastEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntitySpellCast(event));
    }

    @Override
    @EventHandler
    public void onEntityTame(EntityTameEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityTame(event));
    }

    @Override
    @EventHandler
    public void onEntityTarget(EntityTargetEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityTarget(event));
    }

    @Override
    @EventHandler
    public void onEntityTargetLivingEntity(EntityTargetEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityTargetLivingEntity(event));
    }

    @Override
    @EventHandler
    public void onEntityTeleport(EntityTeleportEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityTeleport(event));
    }

    @Override
    @EventHandler
    public void onEntityToggleGlide(EntityToggleGlideEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityToggleGlide(event));
    }

    @Override
    @EventHandler
    public void onEntityToggleSwim(EntityToggleSwimEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityToggleSwim(event));
    }

    @Override
    @EventHandler
    public void onEntityTransform(EntityTransformEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityTransform(event));
    }

    @Override
    @EventHandler
    public void onEntityUnleash(EntityUnleashEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityUnleash(event));
    }

    @Override
    @EventHandler
    public void onExpBottle(ExpBottleEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onExpBottle(event));
    }

    @Override
    @EventHandler
    public void onExplosionPrime(ExplosionPrimeEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onExplosionPrime(event));
    }

    @Override
    @EventHandler
    public void onFireworkExplode(FireworkExplodeEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onFireworkExplode(event));
    }

    @Override
    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onFoodLevelChange(event));
    }

    @Override
    @EventHandler
    public void onHorseJump(HorseJumpEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onHorseJump(event));
    }

    @Override
    @EventHandler
    public void onItemDespawn(ItemDespawnEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onItemDespawn(event));
    }

    @Override
    @EventHandler
    public void onItemMerge(ItemMergeEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onItemMerge(event));
    }

    @Override
    @EventHandler
    public void onItemSpawn(ItemSpawnEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onItemSpawn(event));
    }

    @Override
    @EventHandler
    public void onLingeringPotionSplash(LingeringPotionSplashEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onLingeringPotionSplash(event));
    }

    @Override
    @EventHandler
    public void onPiglinBarter(PiglinBarterEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPiglinBarter(event));
    }

    @Override
    @EventHandler
    public void onPigZap(PigZapEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPigZap(event));
    }

    @Override
    @EventHandler
    public void onPigZombieAnger(PigZombieAngerEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPigZombieAnger(event));
    }

    @Override
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerDeath(event));
    }

    @Override
    @EventHandler
    public void onPlayerLeashEntity(PlayerLeashEntityEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerLeashEntity(event));
    }

    @Override
    @EventHandler
    public void onPotionSplash(PotionSplashEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPotionSplash(event));
    }

    @Override
    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onProjectileHit(event));
    }

    @Override
    @EventHandler
    public void onProjectileLaunch(ProjectileLaunchEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onProjectileLaunch(event));
    }

    @Override
    @EventHandler
    public void onSheepDyeWool(SheepDyeWoolEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onSheepDyeWool(event));
    }

    @Override
    @EventHandler
    public void onSheepRegrowWool(SheepRegrowWoolEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onSheepRegrowWool(event));
    }

    @Override
    @EventHandler
    public void onSlimeSplit(SlimeSplitEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onSlimeSplit(event));
    }

    @Override
    @EventHandler
    public void onSpawnerSpawn(SpawnerSpawnEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onSpawnerSpawn(event));
    }

    @Override
    @EventHandler
    public void onStriderTemperatureChange(StriderTemperatureChangeEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onStriderTemperatureChange(event));
    }

    @Override
    @EventHandler
    public void onVillagerAcquireTrade(VillagerAcquireTradeEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onVillagerAcquireTrade(event));
    }

    @Override
    @EventHandler
    public void onVillagerCareerChange(VillagerCareerChangeEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onVillagerCareerChange(event));
    }

    @Override
    @EventHandler
    public void onVillagerReplenishTrade(VillagerReplenishTradeEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onVillagerReplenishTrade(event));
    }

    @Override
    @EventHandler
    public void onHangingBreakByEntity(HangingBreakByEntityEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onHangingBreakByEntity(event));
    }

    @Override
    @EventHandler
    public void onHangingBreak(HangingBreakEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onHangingBreak(event));
    }

    @Override
    @EventHandler
    public void onHangingPlace(HangingPlaceEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onHangingPlace(event));
    }

    @Override
    @EventHandler
    public void onBrew(BrewEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBrew(event));
    }

    @Override
    @EventHandler
    public void onBrewingStandFuel(BrewingStandFuelEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBrewingStandFuel(event));
    }

    @Override
    @EventHandler
    public void onCraftItem(CraftItemEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onCraftItem(event));
    }

    @Override
    @EventHandler
    public void onFurnaceBurn(FurnaceBurnEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onFurnaceBurn(event));
    }

    @Override
    @EventHandler
    public void onFurnaceExtract(FurnaceExtractEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onFurnaceExtract(event));
    }

    @Override
    @EventHandler
    public void onFurnaceSmelt(FurnaceSmeltEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onFurnaceSmelt(event));
    }

    @Override
    @EventHandler
    public void onFurnaceStartSmelt(FurnaceStartSmeltEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onFurnaceStartSmelt(event));
    }

    @Override
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onInventoryClick(event));
    }

    @Override
    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onInventoryClose(event));
    }

    @Override
    @EventHandler
    public void onInventoryCreative(InventoryCreativeEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onInventoryCreative(event));
    }

    @Override
    @EventHandler
    public void onInventoryDrag(InventoryDragEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onInventoryDrag(event));
    }

    @Override
    @EventHandler
    public void onInventory(InventoryEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onInventory(event));
    }

    @Override
    @EventHandler
    public void onInventoryMoveItem(InventoryMoveItemEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onInventoryMoveItem(event));
    }

    @Override
    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onInventoryOpen(event));
    }

    @Override
    @EventHandler
    public void onInventoryPickupItem(InventoryPickupItemEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onInventoryPickupItem(event));
    }

    @Override
    @EventHandler
    public void onPrepareAnvil(PrepareAnvilEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPrepareAnvil(event));
    }

    @Override
    @EventHandler
    public void onPrepareItemCraft(PrepareItemCraftEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPrepareItemCraft(event));
    }

    @Override
    @EventHandler
    public void onPrepareSmithing(PrepareSmithingEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPrepareSmithing(event));
    }

    @Override
    @EventHandler
    public void onSmithItem(SmithItemEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onSmithItem(event));
    }

    @Override
    @EventHandler
    public void onTradeSelect(TradeSelectEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onTradeSelect(event));
    }

    @Override
    @EventHandler
    public void onAsyncPlayerPreLogin(AsyncPlayerPreLoginEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onAsyncPlayerPreLogin(event));
    }

    @Override
    @EventHandler
    public void onPlayerAdvancementDone(PlayerAdvancementDoneEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerAdvancementDone(event));
    }

    @Override
    @EventHandler
    public void onPlayerAnimation(PlayerAnimationEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerAnimation(event));
    }

    @Override
    @EventHandler
    public void onPlayerArmorStandManipulate(PlayerArmorStandManipulateEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerArmorStandManipulate(event));
    }

    @Override
    @EventHandler
    public void onPlayerAttemptPickupItem(PlayerAttemptPickupItemEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerAttemptPickupItem(event));
    }

    @Override
    @EventHandler
    public void onPlayerBedEnter(PlayerBedEnterEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerBedEnter(event));
    }

    @Override
    @EventHandler
    public void onPlayerBedLeave(PlayerBedLeaveEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerBedLeave(event));
    }

    @Override
    @EventHandler
    public void onPlayerBucketEmpty(PlayerBucketEmptyEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerBucketEmpty(event));
    }

    @Override
    @EventHandler
    public void onPlayerBucketEntity(PlayerBucketEntityEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerBucketEntity(event));
    }

    @Override
    @EventHandler
    public void onPlayerBucketFill(PlayerBucketFillEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerBucketFill(event));
    }

    @Override
    @EventHandler
    public void onPlayerChangedMainHand(PlayerChangedMainHandEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerChangedMainHand(event));
    }

    @Override
    @EventHandler
    public void onPlayerChangedWorld(PlayerChangedWorldEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerChangedWorld(event));
    }

    @Override
    @EventHandler
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerCommandPreprocess(event));
    }

    @Override
    @EventHandler
    public void onPlayerCommandSend(PlayerCommandSendEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerCommandSend(event));
    }

    @Override
    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerDropItem(event));
    }

    @Override
    @EventHandler
    public void onPlayerEditBook(PlayerEditBookEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerEditBook(event));
    }

    @Override
    @EventHandler
    public void onPlayerEggThrow(PlayerEggThrowEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerEggThrow(event));
    }

    @Override
    @EventHandler
    public void onPlayerExpChange(PlayerExpChangeEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerExpChange(event));
    }

    @Override
    @EventHandler
    public void onPlayerFish(PlayerFishEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerFish(event));
    }

    @Override
    @EventHandler
    public void onPlayerGameModeChange(PlayerGameModeChangeEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerGameModeChange(event));
    }

    @Override
    @EventHandler
    public void onPlayerHarvestBlock(PlayerHarvestBlockEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerHarvestBlock(event));
    }

    @Override
    @EventHandler
    public void onPlayerInteractAtEntity(PlayerInteractAtEntityEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerInteractAtEntity(event));
    }

    @Override
    @EventHandler
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerInteractEntity(event));
    }

    @Override
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerInteract(event));
    }

    @Override
    @EventHandler
    public void onPlayerItemBreak(PlayerItemBreakEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerItemBreak(event));
    }

    @Override
    @EventHandler
    public void onPlayerItemConsume(PlayerItemConsumeEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerItemConsume(event));
    }

    @Override
    @EventHandler
    public void onPlayerItemDamage(PlayerItemDamageEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerItemDamage(event));
    }

    @Override
    @EventHandler
    public void onPlayerItemHeld(PlayerItemHeldEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerItemHeld(event));
    }

    @Override
    @EventHandler
    public void onPlayerItemMend(PlayerItemMendEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerItemMend(event));
    }

    @Override
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerJoin(event));
    }

    @Override
    @EventHandler
    public void onPlayerKick(PlayerKickEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerKick(event));
    }

    @Override
    @EventHandler
    public void onPlayerLevelChange(PlayerLevelChangeEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerLevelChange(event));
    }

    @Override
    @EventHandler
    public void onPlayerLocaleChange(PlayerLocaleChangeEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerLocaleChange(event));
    }

    @Override
    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerLogin(event));
    }

    @Override
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerMove(event));
    }

    @Override
    @EventHandler
    public void onPlayerPickupArrow(PlayerPickupArrowEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerPickupArrow(event));
    }

    @Override
    @EventHandler
    public void onPlayerPortal(PlayerPortalEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerPortal(event));
    }

    @Override
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerQuit(event));
    }

    @Override
    @EventHandler
    public void onPlayerRecipeDiscover(PlayerRecipeDiscoverEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerRecipeDiscover(event));
    }

    @Override
    @EventHandler
    public void onPlayerRegisterChannel(PlayerRegisterChannelEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerRegisterChannel(event));
    }

    @Override
    @EventHandler
    public void onPlayerResourcePackStatus(PlayerResourcePackStatusEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerResourcePackStatus(event));
    }

    @Override
    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerRespawn(event));
    }

    @Override
    @EventHandler
    public void onPlayerRiptide(PlayerRiptideEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerRiptide(event));
    }

    @Override
    @EventHandler
    public void onPlayerShearEntity(PlayerShearEntityEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerShearEntity(event));
    }

    @Override
    @EventHandler
    public void onPlayerStatisticIncrement(PlayerStatisticIncrementEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerStatisticIncrement(event));
    }

    @Override
    @EventHandler
    public void onPlayerSwapHandItem(PlayerSwapHandItemsEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerSwapHandItem(event));
    }

    @Override
    @EventHandler
    public void onPlayerTakeLecternBook(PlayerTakeLecternBookEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerTakeLecternBook(event));
    }

    @Override
    @EventHandler
    public void onPlayerTeleport(PlayerTeleportEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerTeleport(event));
    }

    @Override
    @EventHandler
    public void onPlayerToggleFlight(PlayerToggleFlightEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerToggleFlight(event));
    }

    @Override
    @EventHandler
    public void onPlayerToggleSneak(PlayerToggleSneakEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerToggleSneak(event));
    }

    @Override
    @EventHandler
    public void onPlayerToggleSprint(PlayerToggleSprintEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerToggleSprint(event));
    }

    @Override
    @EventHandler
    public void onPlayerUnleashEntity(PlayerUnleashEntityEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerUnleashEntity(event));
    }

    @Override
    @EventHandler
    public void onPlayerUnregisterChannel(PlayerUnregisterChannelEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerUnregisterChannel(event));
    }

    @Override
    @EventHandler
    public void onPlayerVelocity(PlayerVelocityEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerVelocity(event));
    }

    @Override
    @EventHandler
    public void onRaidFinish(RaidFinishEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onRaidFinish(event));
    }

    @Override
    @EventHandler
    public void onRaidSpawnWave(RaidSpawnWaveEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onRaidSpawnWave(event));
    }

    @Override
    @EventHandler
    public void onRaidStop(RaidStopEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onRaidStop(event));
    }

    @Override
    @EventHandler
    public void onRaidTrigger(RaidTriggerEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onRaidTrigger(event));
    }

    @Override
    @EventHandler
    public void onBroadcastMessage(BroadcastMessageEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBroadcastMessage(event));
    }

    @Override
    @EventHandler
    public void onMapInitialize(MapInitializeEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onMapInitialize(event));
    }

    @Override
    @EventHandler
    public void onPluginDisable(PluginDisableEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPluginDisable(event));
    }

    @Override
    @EventHandler
    public void onPluginEnable(PluginEnableEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPluginEnable(event));
    }

    @Override
    @EventHandler
    public void onRemoteServerCommand(RemoteServerCommandEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onRemoteServerCommand(event));
    }

    @Override
    @EventHandler
    public void onServerCommand(ServerCommandEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onServerCommand(event));
    }

    @Override
    @EventHandler
    public void onServerListPing(ServerListPingEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onServerListPing(event));
    }

    @Override
    @EventHandler
    public void onServerLoad(ServerLoadEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onServerLoad(event));
    }

    @Override
    @EventHandler
    public void onServiceRegister(ServiceRegisterEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onServiceRegister(event));
    }

    @Override
    @EventHandler
    public void onServiceUnregister(ServiceUnregisterEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onServiceUnregister(event));
    }

    @Override
    @EventHandler
    public void onTabComplete(TabCompleteEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onTabComplete(event));
    }

    @Override
    @EventHandler
    public void onVehicleBlockCollision(VehicleBlockCollisionEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onVehicleBlockCollision(event));
    }

    @Override
    @EventHandler
    public void onVehicleCreate(VehicleCreateEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onVehicleCreate(event));
    }

    @Override
    @EventHandler
    public void onVehicleDamage(VehicleDamageEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onVehicleDamage(event));
    }

    @Override
    @EventHandler
    public void onVehicleDestroy(VehicleDestroyEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onVehicleDestroy(event));
    }

    @Override
    @EventHandler
    public void onVehicleEnter(VehicleEnterEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onVehicleEnter(event));
    }

    @Override
    @EventHandler
    public void onVehicleEntityCollision(VehicleEntityCollisionEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onVehicleEntityCollision(event));
    }

    @Override
    @EventHandler
    public void onVehicleExit(VehicleExitEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onVehicleExit(event));
    }

    @Override
    @EventHandler
    public void onVehicleMove(VehicleMoveEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onVehicleMove(event));
    }

    @Override
    @EventHandler
    public void onVehicleUpdate(VehicleUpdateEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onVehicleUpdate(event));
    }

    @Override
    @EventHandler
    public void onLightningStrike(LightningStrikeEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onLightningStrike(event));
    }

    @Override
    @EventHandler
    public void onThunderChange(ThunderChangeEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onThunderChange(event));
    }

    @Override
    @EventHandler
    public void onWeatherChange(WeatherChangeEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onWeatherChange(event));
    }

    @Override
    @EventHandler
    public void onChunkLoad(ChunkLoadEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onChunkLoad(event));
    }

    @Override
    @EventHandler
    public void onChunkPopulate(ChunkPopulateEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onChunkPopulate(event));
    }

    @Override
    @EventHandler
    public void onChunkUnload(ChunkUnloadEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onChunkUnload(event));
    }

    @Override
    @EventHandler
    public void onEntitiesLoad(EntitiesLoadEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntitiesLoad(event));
    }

    @Override
    @EventHandler
    public void onEntitiesUnload(EntitiesUnloadEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntitiesUnload(event));
    }

    @Override
    @EventHandler
    public void onGenericGame(GenericGameEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onGenericGame(event));
    }

    @Override
    @EventHandler
    public void onLootGenerate(LootGenerateEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onLootGenerate(event));
    }

    @Override
    @EventHandler
    public void onPortalCreate(PortalCreateEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPortalCreate(event));
    }

    @Override
    @EventHandler
    public void onSpawnChange(SpawnChangeEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onSpawnChange(event));
    }

    @Override
    @EventHandler
    public void onStructureGrow(StructureGrowEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onStructureGrow(event));
    }

    @Override
    @EventHandler
    public void onTimeSkip(TimeSkipEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onTimeSkip(event));
    }

    @Override
    @EventHandler
    public void onWorldInit(WorldInitEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onWorldInit(event));
    }

    @Override
    @EventHandler
    public void onWorldLoad(WorldLoadEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onWorldLoad(event));
    }

    @Override
    @EventHandler
    public void onWorldSave(WorldSaveEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onWorldSave(event));
    }

    @Override
    @EventHandler
    public void onWorldUnload(WorldUnloadEvent event) {

        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onWorldUnload(event));
    }

    //</editor-fold>

}
