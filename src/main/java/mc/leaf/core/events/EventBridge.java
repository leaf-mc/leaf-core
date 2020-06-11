package mc.leaf.core.events;

import mc.leaf.core.events.interfaces.IEventBridge;
import mc.leaf.core.events.interfaces.ILeafListener;
import mc.leaf.core.interfaces.ILeafModule;
import org.bukkit.event.block.*;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.enchantment.PrepareItemEnchantEvent;
import org.bukkit.event.entity.*;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.hanging.HangingBreakEvent;
import org.bukkit.event.hanging.HangingEvent;
import org.bukkit.event.hanging.HangingPlaceEvent;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.*;
import org.bukkit.event.raid.*;
import org.bukkit.event.server.*;
import org.bukkit.event.vehicle.*;
import org.bukkit.event.weather.LightningStrikeEvent;
import org.bukkit.event.weather.ThunderChangeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.event.weather.WeatherEvent;
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
    public void onAreaEffectCloudApply(AreaEffectCloudApplyEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onAreaEffectCloudApply(event));
    }

    @Override
    public void onAsyncPlayerChat(AsyncPlayerChatEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onAsyncPlayerChat(event));
    }

    @Override
    public void onAsyncPlayerPreLogin(AsyncPlayerPreLoginEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onAsyncPlayerPreLogin(event));
    }

    @Override
    public void onBatToggleSleep(BatToggleSleepEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBatToggleSleep(event));
    }

    @Override
    public void onBlock(BlockEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlock(event));
    }

    @Override
    public void onBlockBreak(BlockBreakEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockBreak(event));
    }

    @Override
    public void onBlockBurn(BlockBurnEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockBurn(event));
    }

    @Override
    public void onBlockCanBuild(BlockCanBuildEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockCanBuild(event));
    }

    @Override
    public void onBlockCook(BlockCookEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockCook(event));
    }

    @Override
    public void onBlockDamage(BlockDamageEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockDamage(event));
    }

    @Override
    public void onBlockDispense(BlockDamageEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockDispense(event));
    }

    @Override
    public void onBlockDispense(BlockDispenseEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockDispense(event));
    }

    @Override
    public void onBlockDispenseArmor(BlockDispenseArmorEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockDispenseArmor(event));
    }

    @Override
    public void onBlockDropItem(BlockDropItemEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockDropItem(event));
    }

    @Override
    public void onBlockExp(BlockExpEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockExp(event));
    }

    @Override
    public void onBlockExplode(BlockExplodeEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockExplode(event));
    }

    @Override
    public void onBlockFade(BlockFadeEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockFade(event));
    }

    @Override
    public void onBlockFertilize(BlockFadeEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockFertilize(event));
    }

    @Override
    public void onBlockForm(BlockFormEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockForm(event));
    }

    @Override
    public void onBlockFromTo(BlockFromToEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockFromTo(event));
    }

    @Override
    public void onBlockGrow(BlockGrowEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockGrow(event));
    }

    @Override
    public void onBlockIgnite(BlockIgniteEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockIgnite(event));
    }

    @Override
    public void onBlockMultiPlace(BlockMultiPlaceEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockMultiPlace(event));
    }

    @Override
    public void onBlockPhysics(BlockPhysicsEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockPhysics(event));
    }

    @Override
    public void onBlockPistonExtend(BlockPistonExtendEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockPistonExtend(event));
    }

    @Override
    public void onBlockPistonRetract(BlockPistonRetractEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockPistonRetract(event));
    }

    @Override
    public void onBlockPlace(BlockPlaceEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockPlace(event));
    }

    @Override
    public void onBlockRedstone(BlockRedstoneEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockRedstone(event));
    }

    @Override
    public void onBlockShearEntity(BlockShearEntityEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockShearEntity(event));
    }

    @Override
    public void onBlockSpread(BlockSpreadEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBlockSpread(event));
    }

    @Override
    public void onBrew(BrewEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBrew(event));
    }

    @Override
    public void onBrewingStandFuel(BrewingStandFuelEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBrewingStandFuel(event));
    }

    @Override
    public void onBroadcastMessage(BroadcastMessageEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onBroadcastMessage(event));
    }

    @Override
    public void onCauldronLevelChange(CauldronLevelChangeEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onCauldronLevelChange(event));
    }

    @Override
    public void onChunk(ChunkEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onChunk(event));
    }

    @Override
    public void onChunkLoad(ChunkLoadEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onChunkLoad(event));
    }

    @Override
    public void onChunkPopulate(ChunkPopulateEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onChunkPopulate(event));
    }

    @Override
    public void onChunkUnload(ChunkUnloadEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onChunkUnload(event));
    }

    @Override
    public void onCraftItem(CraftItemEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onCraftItem(event));
    }

    @Override
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onCreatureSpawn(event));
    }

    @Override
    public void onCreeperPower(CreeperPowerEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onCreeperPower(event));
    }

    @Override
    public void onEnchantItem(EnchantItemEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEnchantItem(event));
    }

    @Override
    public void onEnderDragonChangePhase(EnderDragonChangePhaseEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEnderDragonChangePhase(event));
    }

    @Override
    public void onEntity(EntityEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntity(event));
    }

    @Override
    public void onEntityAirChange(EntityAirChangeEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityAirChange(event));
    }

    @Override
    public void onEntityBlockForm(EntityBlockFormEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityBlockForm(event));
    }

    @Override
    public void onEntityBreakDoorEvent(EntityBreakDoorEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityBreakDoorEvent(event));
    }

    @Override
    public void onEntityBreed(EntityBreedEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityBreed(event));
    }

    @Override
    public void onEntityChangeBlock(EntityChangeBlockEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityChangeBlock(event));
    }

    @Override
    public void onEntityCombust(EntityCombustEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityCombust(event));
    }

    @Override
    public void onEntityCombustByBlock(EntityCombustByBlockEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityCombustByBlock(event));
    }

    @Override
    public void onEntityCombustByEntity(EntityCombustByEntityEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityCombustByEntity(event));
    }

    @Override
    public void onEntityDamage(EntityDamageEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityDamage(event));
    }

    @Override
    public void onEntityDamageByBlock(EntityDamageEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityDamageByBlock(event));
    }

    @Override
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityDamageByEntity(event));
    }

    @Override
    public void onEntityDeath(EntityDeathEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityDeath(event));
    }

    @Override
    public void onEntityDropItem(EntityDropItemEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityDropItem(event));
    }

    @Override
    public void onEntityEnterBlock(EntityEnterBlockEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityEnterBlock(event));
    }

    @Override
    public void onEntityExplode(EntityExplodeEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityExplode(event));
    }

    @Override
    public void onEntityInteract(EntityInteractEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityInteract(event));
    }

    @Override
    public void onEntityPickupItem(EntityPickupItemEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityPickupItem(event));
    }

    @Override
    public void onEntityPortal(EntityPortalEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityPortal(event));
    }

    @Override
    public void onEntityPortalExit(EntityPortalExitEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityPortalExit(event));
    }

    @Override
    public void onEntityPoseChange(EntityPoseChangeEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityPoseChange(event));
    }

    @Override
    public void onEntityPotionEffect(EntityPotionEffectEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityPotionEffect(event));
    }

    @Override
    public void onEntityRegainHealth(EntityRegainHealthEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityRegainHealth(event));
    }

    @Override
    public void onEntityResurrect(EntityResurrectEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityResurrect(event));
    }

    @Override
    public void onEntityShootBow(EntityShootBowEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityShootBow(event));
    }

    @Override
    public void onEntitySpawn(EntitySpawnEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntitySpawn(event));
    }

    @Override
    public void onEntityTame(EntityTameEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityTame(event));
    }

    @Override
    public void onEntityTarget(EntityTargetEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityTarget(event));
    }

    @Override
    public void onEntityTargetLivingEntity(EntityTargetLivingEntityEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityTargetLivingEntity(event));
    }

    @Override
    public void onEntityTeleport(EntityTeleportEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityTeleport(event));
    }

    @Override
    public void onEntityToggleGlide(EntityToggleGlideEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityToggleGlide(event));
    }

    @Override
    public void onEntityToggleSwim(EntityToggleSwimEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityToggleSwim(event));
    }

    @Override
    public void onEntityTransform(EntityTransformEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityTransform(event));
    }

    @Override
    public void onEntityUnleash(EntityUnleashEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onEntityUnleash(event));
    }

    @Override
    public void onExpBottle(ExpBottleEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onExpBottle(event));
    }

    @Override
    public void onExplosionPrime(ExplosionPrimeEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onExplosionPrime(event));
    }

    @Override
    public void onFireworkExplode(FireworkExplodeEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onFireworkExplode(event));
    }

    @Override
    public void onFluidLevelChange(FluidLevelChangeEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onFluidLevelChange(event));
    }

    @Override
    public void onFoodLevelChange(FoodLevelChangeEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onFoodLevelChange(event));
    }

    @Override
    public void onFurnaceBurn(FurnaceBurnEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onFurnaceBurn(event));
    }

    @Override
    public void onFurnaceExtract(FurnaceExtractEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onFurnaceExtract(event));
    }

    @Override
    public void onFurnaceSmelt(FurnaceSmeltEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onFurnaceSmelt(event));
    }

    @Override
    public void onHanging(HangingEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onHanging(event));
    }

    @Override
    public void onHangingBreak(HangingBreakEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onHangingBreak(event));
    }

    @Override
    public void onHangingBreakByEntity(HangingBreakByEntityEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onHangingBreakByEntity(event));
    }

    @Override
    public void onHangingPlace(HangingPlaceEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onHangingPlace(event));
    }

    @Override
    public void onHorseJump(HorseJumpEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onHorseJump(event));
    }

    @Override
    public void onInventory(InventoryEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onInventory(event));
    }

    @Override
    public void onInventoryClick(InventoryClickEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onInventoryClick(event));
    }

    @Override
    public void onInventoryClose(InventoryCloseEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onInventoryClose(event));
    }

    @Override
    public void onInventoryCreative(InventoryCreativeEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onInventoryCreative(event));
    }

    @Override
    public void onInventoryDrag(InventoryDragEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onInventoryDrag(event));
    }

    @Override
    public void onInventoryInteract(InventoryInteractEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onInventoryInteract(event));
    }

    @Override
    public void onInventoryMoveItem(InventoryMoveItemEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onInventoryMoveItem(event));
    }

    @Override
    public void onInventoryOpen(InventoryOpenEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onInventoryOpen(event));
    }

    @Override
    public void onInventoryPickupItem(InventoryPickupItemEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onInventoryPickupItem(event));
    }

    @Override
    public void onItemDespawn(ItemDespawnEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onItemDespawn(event));
    }

    @Override
    public void onItemMerge(ItemMergeEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onItemMerge(event));
    }

    @Override
    public void onItemSpawn(ItemSpawnEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onItemSpawn(event));
    }

    @Override
    public void onLeaveDecay(LeavesDecayEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onLeaveDecay(event));
    }

    @Override
    public void onLightningStrike(LightningStrikeEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onLightningStrike(event));
    }

    @Override
    public void onLingeringPotionSplash(LingeringPotionSplashEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onLingeringPotionSplash(event));
    }

    @Override
    public void onMapInitialize(MapInitializeEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onMapInitialize(event));
    }

    @Override
    public void onMoistureChange(MoistureChangeEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onMoistureChange(event));
    }

    @Override
    public void onNotePlay(NotePlayEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onNotePlay(event));
    }

    @Override
    public void onPigZap(PigZapEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPigZap(event));
    }

    @Override
    public void onPigZombieAnger(PigZombieAngerEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPigZombieAnger(event));
    }

    @Override
    public void onPlayer(PlayerEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayer(event));
    }

    @Override
    public void onPlayerAdvancementDone(PlayerAdvancementDoneEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerAdvancementDone(event));
    }

    @Override
    public void onPlayerAnimation(PlayerAnimationEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerAnimation(event));
    }

    @Override
    public void onPlayerArmorStandManipulate(PlayerArmorStandManipulateEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerArmorStandManipulate(event));
    }

    @Override
    public void onPlayerBedEnter(PlayerBedEnterEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerBedEnter(event));
    }

    @Override
    public void onPlayerBedLeave(PlayerBedLeaveEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerBedLeave(event));
    }

    @Override
    public void onPlayerBucket(PlayerBucketEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerBucket(event));
    }

    @Override
    public void onPlayerBucketEmpty(PlayerBucketEmptyEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerBucketEmpty(event));
    }

    @Override
    public void onPlayerBucketFill(PlayerBucketFillEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerBucketFill(event));
    }

    @Override
    public void onPlayerChangedMainHand(PlayerChangedMainHandEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerChangedMainHand(event));
    }

    @Override
    public void onPlayerChangedWorld(PlayerChangedWorldEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerChangedWorld(event));
    }

    @Override
    public void onPlayerChannel(PlayerChannelEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerChannel(event));
    }

    @Override
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerCommandPreprocess(event));
    }

    @Override
    public void onPlayerCommandSend(PlayerCommandSendEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerCommandSend(event));
    }

    @Override
    public void onPlayerDeath(PlayerDeathEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerDeath(event));
    }

    @Override
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerDropItem(event));
    }

    @Override
    public void onPlayerEditBook(PlayerEditBookEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerEditBook(event));
    }

    @Override
    public void onPlayerEggThrow(PlayerEggThrowEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerEggThrow(event));
    }

    @Override
    public void onPlayerEntityUnleash(PlayerUnleashEntityEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerEntityUnleash(event));
    }

    @Override
    public void onPlayerExpChange(PlayerExpChangeEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerExpChange(event));
    }

    @Override
    public void onPlayerFish(PlayerFishEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerFish(event));
    }

    @Override
    public void onPlayerGameModeChange(PlayerGameModeChangeEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerGameModeChange(event));
    }

    @Override
    public void onPlayerInteract(PlayerInteractEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerInteract(event));
    }

    @Override
    public void onPlayerInteractAtEntity(PlayerInteractAtEntityEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerInteractAtEntity(event));
    }

    @Override
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerInteractEntity(event));
    }

    @Override
    public void onPlayerItemBreak(PlayerItemBreakEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerItemBreak(event));
    }

    @Override
    public void onPlayerItemConsume(PlayerItemConsumeEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerItemConsume(event));
    }

    @Override
    public void onPlayerItemDamage(PlayerItemDamageEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerItemDamage(event));
    }

    @Override
    public void onPlayerItemHeld(PlayerItemHeldEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerItemHeld(event));
    }

    @Override
    public void onPlayerItemMend(PlayerItemMendEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerItemMend(event));
    }

    @Override
    public void onPlayerJoin(PlayerJoinEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerJoin(event));
    }

    @Override
    public void onPlayerKick(PlayerKickEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerKick(event));
    }

    @Override
    public void onPlayerLeashEntity(PlayerLeashEntityEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerLeashEntity(event));
    }

    @Override
    public void onPlayerLevelChange(PlayerLevelChangeEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerLevelChange(event));
    }

    @Override
    public void onPlayerLocaleChange(PlayerLocaleChangeEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerLocaleChange(event));
    }

    @Override
    public void onPlayerLogin(PlayerLoginEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerLogin(event));
    }

    @Override
    public void onPlayerMove(PlayerMoveEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerMove(event));
    }

    @Override
    public void onPlayerPickupArrow(PlayerPickupArrowEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerPickupArrow(event));
    }

    @Override
    public void onPlayerQuit(PlayerQuitEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerQuit(event));
    }

    @Override
    public void onPlayerRecipeDiscover(PlayerRecipeDiscoverEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerRecipeDiscover(event));
    }

    @Override
    public void onPlayerRegisterChannel(PlayerRegisterChannelEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerRegisterChannel(event));
    }

    @Override
    public void onPlayerResourcePackStatus(PlayerResourcePackStatusEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerResourcePackStatus(event));
    }

    @Override
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerRespawn(event));
    }

    @Override
    public void onPlayerRiptide(PlayerRiptideEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerRiptide(event));
    }

    @Override
    public void onPlayerShearEntity(PlayerShearEntityEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerShearEntity(event));
    }

    @Override
    public void onPlayerStatisticIncrement(PlayerStatisticIncrementEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerStatisticIncrement(event));
    }

    @Override
    public void onPlayerSwapHandItems(PlayerSwapHandItemsEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerSwapHandItems(event));
    }

    @Override
    public void onPlayerTakeLecternBook(PlayerTakeLecternBookEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerTakeLecternBook(event));
    }

    @Override
    public void onPlayerToggleFlight(PlayerToggleFlightEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerToggleFlight(event));
    }

    @Override
    public void onPlayerToggleSneak(PlayerToggleSneakEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerToggleSneak(event));
    }

    @Override
    public void onPlayerToggleSpring(PlayerToggleSprintEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerToggleSpring(event));
    }

    @Override
    public void onPlayerUnregisterChannel(PlayerUnregisterChannelEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerUnregisterChannel(event));
    }

    @Override
    public void onPlayerVelocity(PlayerVelocityEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlayerVelocity(event));
    }

    @Override
    public void onPlugin(PluginEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPlugin(event));
    }

    @Override
    public void onPluginDisable(PluginDisableEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPluginDisable(event));
    }

    @Override
    public void onPluginEnable(PluginEnableEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPluginEnable(event));
    }

    @Override
    public void onPortalCreate(PortalCreateEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPortalCreate(event));
    }

    @Override
    public void onPotionSplash(PotionSplashEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPotionSplash(event));
    }

    @Override
    public void onPrepareAnvil(PrepareAnvilEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPrepareAnvil(event));
    }

    @Override
    public void onPrepareItemCraft(PrepareItemCraftEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPrepareItemCraft(event));
    }

    @Override
    public void onPrepareItemEnchant(PrepareItemEnchantEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onPrepareItemEnchant(event));
    }

    @Override
    public void onProjectileHit(ProjectileHitEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onProjectileHit(event));
    }

    @Override
    public void onProjectileLaunch(ProjectileLaunchEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onProjectileLaunch(event));
    }

    @Override
    public void onRaid(RaidEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onRaid(event));
    }

    @Override
    public void onRaidFinish(RaidFinishEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onRaidFinish(event));
    }

    @Override
    public void onRaidSpawnWave(RaidSpawnWaveEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onRaidSpawnWave(event));
    }

    @Override
    public void onRaidStop(RaidStopEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onRaidStop(event));
    }

    @Override
    public void onRaidTrigger(RaidTriggerEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onRaidTrigger(event));
    }

    @Override
    public void onRemoteServerCommand(RemoteServerCommandEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onRemoteServerCommand(event));
    }

    @Override
    public void onServer(ServerEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onServer(event));
    }

    @Override
    public void onServerCommand(ServerCommandEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onServerCommand(event));
    }

    @Override
    public void onServerListPing(ServerListPingEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onServerListPing(event));
    }

    @Override
    public void onServerLoad(ServerLoadEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onServerLoad(event));
    }

    @Override
    public void onService(ServiceEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onService(event));
    }

    @Override
    public void onServiceRegister(ServiceRegisterEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onServiceRegister(event));
    }

    @Override
    public void onServiceUnregister(ServiceUnregisterEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onServiceUnregister(event));
    }

    @Override
    public void onSheepDyeWool(SheepDyeWoolEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onSheepDyeWool(event));
    }

    @Override
    public void onSheepRegrowWool(SheepRegrowWoolEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onSheepRegrowWool(event));
    }

    @Override
    public void onSignChange(SignChangeEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onSignChange(event));
    }

    @Override
    public void onSlimeSplit(SlimeSplitEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onSlimeSplit(event));
    }

    @Override
    public void onSpawnChange(SpawnChangeEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onSpawnChange(event));
    }

    @Override
    public void onSpongeAbsorb(SpongeAbsorbEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onSpongeAbsorb(event));
    }

    @Override
    public void onStructureGrow(StructureGrowEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onStructureGrow(event));
    }

    @Override
    public void onTabComplete(TabCompleteEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onTabComplete(event));
    }

    @Override
    public void onThunderChange(ThunderChangeEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onThunderChange(event));
    }

    @Override
    public void onTimeSkip(TimeSkipEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onTimeSkip(event));
    }

    @Override
    public void onTradeSelect(TradeSelectEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onTradeSelect(event));
    }

    @Override
    public void onVehicle(VehicleEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onVehicle(event));
    }

    @Override
    public void onVehicleBlockCollision(VehicleBlockCollisionEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onVehicleBlockCollision(event));
    }

    @Override
    public void onVehicleCollision(VehicleCollisionEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onVehicleCollision(event));
    }

    @Override
    public void onVehicleCreate(VehicleCreateEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onVehicleCreate(event));
    }

    @Override
    public void onVehicleDamage(VehicleDamageEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onVehicleDamage(event));
    }

    @Override
    public void onVehicleDestroy(VehicleDestroyEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onVehicleDestroy(event));
    }

    @Override
    public void onVehicleEnter(VehicleEnterEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onVehicleEnter(event));
    }

    @Override
    public void onVehicleEntityCollision(VehicleEntityCollisionEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onVehicleEntityCollision(event));
    }

    @Override
    public void onVehicleExit(VehicleExitEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onVehicleExit(event));
    }

    @Override
    public void onVehicleMove(VehicleMoveEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onVehicleMove(event));
    }

    @Override
    public void onVehicleUpdate(VehicleUpdateEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onVehicleUpdate(event));
    }

    @Override
    public void onVillagerAcquireTrade(VillagerAcquireTradeEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onVillagerAcquireTrade(event));
    }

    @Override
    public void onVillagerCareerChange(VillagerCareerChangeEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onVillagerCareerChange(event));
    }

    @Override
    public void onVillagerReplenishTrade(VillagerReplenishTradeEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onVillagerReplenishTrade(event));
    }

    @Override
    public void onWeather(WeatherEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onWeather(event));
    }

    @Override
    public void onWeatherChange(WeatherChangeEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onWeatherChange(event));
    }

    @Override
    public void onWorld(WorldEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onWorld(event));
    }

    @Override
    public void onWorldInit(WorldInitEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onWorldInit(event));
    }

    @Override
    public void onWorldLoad(WorldLoadEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onWorldLoad(event));
    }

    @Override
    public void onWorldSave(WorldSaveEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onWorldSave(event));
    }

    @Override
    public void onWorldUnload(WorldUnloadEvent event) {
        this.listeners.keySet().stream()
                .filter(ILeafModule::isEnabled)
                .flatMap(module -> this.listeners.get(module).stream())
                .forEach(listener -> listener.onWorldUnload(event));
    }
    //</editor-fold>

}
