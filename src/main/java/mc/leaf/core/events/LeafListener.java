package mc.leaf.core.events;

import mc.leaf.core.events.interfaces.ILeafListener;
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

/**
 * Helper class containing all Bukkit events. You can extends it to benefit from your IDE "Override Method" feature.
 * Don't forget to add the {@link org.bukkit.event.EventHandler} annotation on overridden methods.
 *
 * @author alexpado
 */
public class LeafListener implements ILeafListener {

    @Override
    public void onAreaEffectCloudApply(AreaEffectCloudApplyEvent event) {}

    @Override
    public void onAsyncPlayerChat(AsyncPlayerChatEvent event) {}

    @Override
    public void onAsyncPlayerPreLogin(AsyncPlayerPreLoginEvent event) {}

    @Override
    public void onBatToggleSleep(BatToggleSleepEvent event) {}

    @Override
    public void onBlock(BlockEvent event) {}

    @Override
    public void onBlockBreak(BlockBreakEvent event) {}

    @Override
    public void onBlockBurn(BlockBurnEvent event) {}

    @Override
    public void onBlockCanBuild(BlockCanBuildEvent event) {}

    @Override
    public void onBlockCook(BlockCookEvent event) {}

    @Override
    public void onBlockDamage(BlockDamageEvent event) {}

    @Override
    public void onBlockDispense(BlockDamageEvent event) {}

    @Override
    public void onBlockDispense(BlockDispenseEvent event) {}

    @Override
    public void onBlockDispenseArmor(BlockDispenseArmorEvent event) {}

    @Override
    public void onBlockDropItem(BlockDropItemEvent event) {}

    @Override
    public void onBlockExp(BlockExpEvent event) {}

    @Override
    public void onBlockExplode(BlockExplodeEvent event) {}

    @Override
    public void onBlockFade(BlockFadeEvent event) {}

    @Override
    public void onBlockFertilize(BlockFadeEvent event) {}

    @Override
    public void onBlockForm(BlockFormEvent event) {}

    @Override
    public void onBlockFromTo(BlockFromToEvent event) {}

    @Override
    public void onBlockGrow(BlockGrowEvent event) {}

    @Override
    public void onBlockIgnite(BlockIgniteEvent event) {}

    @Override
    public void onBlockMultiPlace(BlockMultiPlaceEvent event) {}

    @Override
    public void onBlockPhysics(BlockPhysicsEvent event) {}

    @Override
    public void onBlockPistonExtend(BlockPistonExtendEvent event) {}

    @Override
    public void onBlockPistonRetract(BlockPistonRetractEvent event) {}

    @Override
    public void onBlockPlace(BlockPlaceEvent event) {}

    @Override
    public void onBlockRedstone(BlockRedstoneEvent event) {}

    @Override
    public void onBlockShearEntity(BlockShearEntityEvent event) {}

    @Override
    public void onBlockSpread(BlockSpreadEvent event) {}

    @Override
    public void onBrew(BrewEvent event) {}

    @Override
    public void onBrewingStandFuel(BrewingStandFuelEvent event) {}

    @Override
    public void onBroadcastMessage(BroadcastMessageEvent event) {}

    @Override
    public void onCauldronLevelChange(CauldronLevelChangeEvent event) {}

    @Override
    public void onChunk(ChunkEvent event) {}

    @Override
    public void onChunkLoad(ChunkLoadEvent event) {}

    @Override
    public void onChunkPopulate(ChunkPopulateEvent event) {}

    @Override
    public void onChunkUnload(ChunkUnloadEvent event) {}

    @Override
    public void onCraftItem(CraftItemEvent event) {}

    @Override
    public void onCreatureSpawn(CreatureSpawnEvent event) {}

    @Override
    public void onCreeperPower(CreeperPowerEvent event) {}

    @Override
    public void onEnchantItem(EnchantItemEvent event) {}

    @Override
    public void onEnderDragonChangePhase(EnderDragonChangePhaseEvent event) {}

    @Override
    public void onEntity(EntityEvent event) {}

    @Override
    public void onEntityAirChange(EntityAirChangeEvent event) {}

    @Override
    public void onEntityBlockForm(EntityBlockFormEvent event) {}

    @Override
    public void onEntityBreakDoorEvent(EntityBreakDoorEvent event) {}

    @Override
    public void onEntityBreed(EntityBreedEvent event) {}

    @Override
    public void onEntityChangeBlock(EntityChangeBlockEvent event) {}

    @Override
    public void onEntityCombust(EntityCombustEvent event) {}

    @Override
    public void onEntityCombustByBlock(EntityCombustByBlockEvent event) {}

    @Override
    public void onEntityCombustByEntity(EntityCombustByEntityEvent event) {}

    @Override
    public void onEntityDamage(EntityDamageEvent event) {}

    @Override
    public void onEntityDamageByBlock(EntityDamageEvent event) {}

    @Override
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {}

    @Override
    public void onEntityDeath(EntityDeathEvent event) {}

    @Override
    public void onEntityDropItem(EntityDropItemEvent event) {}

    @Override
    public void onEntityEnterBlock(EntityEnterBlockEvent event) {}

    @Override
    public void onEntityExplode(EntityExplodeEvent event) {}

    @Override
    public void onEntityInteract(EntityInteractEvent event) {}

    @Override
    public void onEntityPickupItem(EntityPickupItemEvent event) {}

    @Override
    public void onEntityPortal(EntityPortalEvent event) {}

    @Override
    public void onEntityPortalExit(EntityPortalExitEvent event) {}

    @Override
    public void onEntityPoseChange(EntityPoseChangeEvent event) {}

    @Override
    public void onEntityPotionEffect(EntityPotionEffectEvent event) {}

    @Override
    public void onEntityRegainHealth(EntityRegainHealthEvent event) {}

    @Override
    public void onEntityResurrect(EntityResurrectEvent event) {}

    @Override
    public void onEntityShootBow(EntityShootBowEvent event) {}

    @Override
    public void onEntitySpawn(EntitySpawnEvent event) {}

    @Override
    public void onEntityTame(EntityTameEvent event) {}

    @Override
    public void onEntityTarget(EntityTargetEvent event) {}

    @Override
    public void onEntityTargetLivingEntity(EntityTargetLivingEntityEvent event) {}

    @Override
    public void onEntityTeleport(EntityTeleportEvent event) {}

    @Override
    public void onEntityToggleGlide(EntityToggleGlideEvent event) {}

    @Override
    public void onEntityToggleSwim(EntityToggleSwimEvent event) {}

    @Override
    public void onEntityTransform(EntityTransformEvent event) {}

    @Override
    public void onEntityUnleash(EntityUnleashEvent event) {}

    @Override
    public void onExpBottle(ExpBottleEvent event) {}

    @Override
    public void onExplosionPrime(ExplosionPrimeEvent event) {}

    @Override
    public void onFireworkExplode(FireworkExplodeEvent event) {}

    @Override
    public void onFluidLevelChange(FluidLevelChangeEvent event) {}

    @Override
    public void onFoodLevelChange(FoodLevelChangeEvent event) {}

    @Override
    public void onFurnaceBurn(FurnaceBurnEvent event) {}

    @Override
    public void onFurnaceExtract(FurnaceExtractEvent event) {}

    @Override
    public void onFurnaceSmelt(FurnaceSmeltEvent event) {}

    @Override
    public void onHanging(HangingEvent event) {}

    @Override
    public void onHangingBreak(HangingBreakEvent event) {}

    @Override
    public void onHangingBreakByEntity(HangingBreakByEntityEvent event) {}

    @Override
    public void onHangingPlace(HangingPlaceEvent event) {}

    @Override
    public void onHorseJump(HorseJumpEvent event) {}

    @Override
    public void onInventory(InventoryEvent event) {}

    @Override
    public void onInventoryClick(InventoryClickEvent event) {}

    @Override
    public void onInventoryClose(InventoryCloseEvent event) {}

    @Override
    public void onInventoryCreative(InventoryCreativeEvent event) {}

    @Override
    public void onInventoryDrag(InventoryDragEvent event) {}

    @Override
    public void onInventoryInteract(InventoryInteractEvent event) {}

    @Override
    public void onInventoryMoveItem(InventoryMoveItemEvent event) {}

    @Override
    public void onInventoryOpen(InventoryOpenEvent event) {}

    @Override
    public void onInventoryPickupItem(InventoryPickupItemEvent event) {}

    @Override
    public void onItemDespawn(ItemDespawnEvent event) {}

    @Override
    public void onItemMerge(ItemMergeEvent event) {}

    @Override
    public void onItemSpawn(ItemSpawnEvent event) {}

    @Override
    public void onLeaveDecay(LeavesDecayEvent event) {}

    @Override
    public void onLightningStrike(LightningStrikeEvent event) {}

    @Override
    public void onLingeringPotionSplash(LingeringPotionSplashEvent event) {}

    @Override
    public void onMapInitialize(MapInitializeEvent event) {}

    @Override
    public void onMoistureChange(MoistureChangeEvent event) {}

    @Override
    public void onNotePlay(NotePlayEvent event) {}

    @Override
    public void onPigZap(PigZapEvent event) {}

    @Override
    public void onPigZombieAnger(PigZombieAngerEvent event) {}

    @Override
    public void onPlayer(PlayerEvent event) {}

    @Override
    public void onPlayerAdvancementDone(PlayerAdvancementDoneEvent event) {}

    @Override
    public void onPlayerAnimation(PlayerAnimationEvent event) {}

    @Override
    public void onPlayerArmorStandManipulate(PlayerArmorStandManipulateEvent event) {}

    @Override
    public void onPlayerBedEnter(PlayerBedEnterEvent event) {}

    @Override
    public void onPlayerBedLeave(PlayerBedLeaveEvent event) {}

    @Override
    public void onPlayerBucket(PlayerBucketEvent event) {}

    @Override
    public void onPlayerBucketEmpty(PlayerBucketEmptyEvent event) {}

    @Override
    public void onPlayerBucketFill(PlayerBucketFillEvent event) {}

    @Override
    public void onPlayerChangedMainHand(PlayerChangedMainHandEvent event) {}

    @Override
    public void onPlayerChangedWorld(PlayerChangedWorldEvent event) {}

    @Override
    public void onPlayerChannel(PlayerChannelEvent event) {}

    @Override
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {}

    @Override
    public void onPlayerCommandSend(PlayerCommandSendEvent event) {}

    @Override
    public void onPlayerDeath(PlayerDeathEvent event) {}

    @Override
    public void onPlayerDropItem(PlayerDropItemEvent event) {}

    @Override
    public void onPlayerEditBook(PlayerEditBookEvent event) {}

    @Override
    public void onPlayerEggThrow(PlayerEggThrowEvent event) {}

    @Override
    public void onPlayerEntityUnleash(PlayerUnleashEntityEvent event) {}

    @Override
    public void onPlayerExpChange(PlayerExpChangeEvent event) {}

    @Override
    public void onPlayerFish(PlayerFishEvent event) {}

    @Override
    public void onPlayerGameModeChange(PlayerGameModeChangeEvent event) {}

    @Override
    public void onPlayerInteract(PlayerInteractEvent event) {}

    @Override
    public void onPlayerInteractAtEntity(PlayerInteractAtEntityEvent event) {}

    @Override
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {}

    @Override
    public void onPlayerItemBreak(PlayerItemBreakEvent event) {}

    @Override
    public void onPlayerItemConsume(PlayerItemConsumeEvent event) {}

    @Override
    public void onPlayerItemDamage(PlayerItemDamageEvent event) {}

    @Override
    public void onPlayerItemHeld(PlayerItemHeldEvent event) {}

    @Override
    public void onPlayerItemMend(PlayerItemMendEvent event) {}

    @Override
    public void onPlayerJoin(PlayerJoinEvent event) {}

    @Override
    public void onPlayerKick(PlayerKickEvent event) {}

    @Override
    public void onPlayerLeashEntity(PlayerLeashEntityEvent event) {}

    @Override
    public void onPlayerLevelChange(PlayerLevelChangeEvent event) {}

    @Override
    public void onPlayerLocaleChange(PlayerLocaleChangeEvent event) {}

    @Override
    public void onPlayerLogin(PlayerLoginEvent event) {}

    @Override
    public void onPlayerMove(PlayerMoveEvent event) {}

    @Override
    public void onPlayerPickupArrow(PlayerPickupArrowEvent event) {}

    @Override
    public void onPlayerQuit(PlayerQuitEvent event) {}

    @Override
    public void onPlayerRecipeDiscover(PlayerRecipeDiscoverEvent event) {}

    @Override
    public void onPlayerRegisterChannel(PlayerRegisterChannelEvent event) {}

    @Override
    public void onPlayerResourcePackStatus(PlayerResourcePackStatusEvent event) {}

    @Override
    public void onPlayerRespawn(PlayerRespawnEvent event) {}

    @Override
    public void onPlayerRiptide(PlayerRiptideEvent event) {}

    @Override
    public void onPlayerShearEntity(PlayerShearEntityEvent event) {}

    @Override
    public void onPlayerStatisticIncrement(PlayerStatisticIncrementEvent event) {}

    @Override
    public void onPlayerSwapHandItems(PlayerSwapHandItemsEvent event) {}

    @Override
    public void onPlayerTakeLecternBook(PlayerTakeLecternBookEvent event) {}

    @Override
    public void onPlayerToggleFlight(PlayerToggleFlightEvent event) {}

    @Override
    public void onPlayerToggleSneak(PlayerToggleSneakEvent event) {}

    @Override
    public void onPlayerToggleSpring(PlayerToggleSprintEvent event) {}

    @Override
    public void onPlayerUnregisterChannel(PlayerUnregisterChannelEvent event) {}

    @Override
    public void onPlayerVelocity(PlayerVelocityEvent event) {}

    @Override
    public void onPlugin(PluginEvent event) {}

    @Override
    public void onPluginDisable(PluginDisableEvent event) {}

    @Override
    public void onPluginEnable(PluginEnableEvent event) {}

    @Override
    public void onPortalCreate(PortalCreateEvent event) {}

    @Override
    public void onPotionSplash(PotionSplashEvent event) {}

    @Override
    public void onPrepareAnvil(PrepareAnvilEvent event) {}

    @Override
    public void onPrepareItemCraft(PrepareItemCraftEvent event) {}

    @Override
    public void onPrepareItemEnchant(PrepareItemEnchantEvent event) {}

    @Override
    public void onProjectileHit(ProjectileHitEvent event) {}

    @Override
    public void onProjectileLaunch(ProjectileLaunchEvent event) {}

    @Override
    public void onRaid(RaidEvent event) {}

    @Override
    public void onRaidFinish(RaidFinishEvent event) {}

    @Override
    public void onRaidSpawnWave(RaidSpawnWaveEvent event) {}

    @Override
    public void onRaidStop(RaidStopEvent event) {}

    @Override
    public void onRaidTrigger(RaidTriggerEvent event) {}

    @Override
    public void onRemoteServerCommand(RemoteServerCommandEvent event) {}

    @Override
    public void onServer(ServerEvent event) {}

    @Override
    public void onServerCommand(ServerCommandEvent event) {}

    @Override
    public void onServerListPing(ServerListPingEvent event) {}

    @Override
    public void onServerLoad(ServerLoadEvent event) {}

    @Override
    public void onService(ServiceEvent event) {}

    @Override
    public void onServiceRegister(ServiceRegisterEvent event) {}

    @Override
    public void onServiceUnregister(ServiceUnregisterEvent event) {}

    @Override
    public void onSheepDyeWool(SheepDyeWoolEvent event) {}

    @Override
    public void onSheepRegrowWool(SheepRegrowWoolEvent event) {}

    @Override
    public void onSignChange(SignChangeEvent event) {}

    @Override
    public void onSlimeSplit(SlimeSplitEvent event) {}

    @Override
    public void onSpawnChange(SpawnChangeEvent event) {}

    @Override
    public void onSpongeAbsorb(SpongeAbsorbEvent event) {}

    @Override
    public void onStructureGrow(StructureGrowEvent event) {}

    @Override
    public void onTabComplete(TabCompleteEvent event) {}

    @Override
    public void onThunderChange(ThunderChangeEvent event) {}

    @Override
    public void onTimeSkip(TimeSkipEvent event) {}

    @Override
    public void onTradeSelect(TradeSelectEvent event) {}

    @Override
    public void onVehicle(VehicleEvent event) {}

    @Override
    public void onVehicleBlockCollision(VehicleBlockCollisionEvent event) {}

    @Override
    public void onVehicleCollision(VehicleCollisionEvent event) {}

    @Override
    public void onVehicleCreate(VehicleCreateEvent event) {}

    @Override
    public void onVehicleDamage(VehicleDamageEvent event) {}

    @Override
    public void onVehicleDestroy(VehicleDestroyEvent event) {}

    @Override
    public void onVehicleEnter(VehicleEnterEvent event) {}

    @Override
    public void onVehicleEntityCollision(VehicleEntityCollisionEvent event) {}

    @Override
    public void onVehicleExit(VehicleExitEvent event) {}

    @Override
    public void onVehicleMove(VehicleMoveEvent event) {}

    @Override
    public void onVehicleUpdate(VehicleUpdateEvent event) {}

    @Override
    public void onVillagerAcquireTrade(VillagerAcquireTradeEvent event) {}

    @Override
    public void onVillagerCareerChange(VillagerCareerChangeEvent event) {}

    @Override
    public void onVillagerReplenishTrade(VillagerReplenishTradeEvent event) {}

    @Override
    public void onWeather(WeatherEvent event) {}

    @Override
    public void onWeatherChange(WeatherChangeEvent event) {}

    @Override
    public void onWorld(WorldEvent event) {}

    @Override
    public void onWorldInit(WorldInitEvent event) {}

    @Override
    public void onWorldLoad(WorldLoadEvent event) {}

    @Override
    public void onWorldSave(WorldSaveEvent event) {}

    @Override
    public void onWorldUnload(WorldUnloadEvent event) {}

}
