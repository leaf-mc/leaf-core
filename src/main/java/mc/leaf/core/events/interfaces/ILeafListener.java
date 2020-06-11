package mc.leaf.core.events.interfaces;

import org.bukkit.event.Listener;
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
 * Interface providing every listener available on minecraft. You may extends {@link mc.leaf.core.events.LeafListener}
 * instead of implementing this.
 *
 * @author alexpado
 */
@SuppressWarnings("ClassWithTooManyMethods")
public interface ILeafListener extends Listener {

    void onAreaEffectCloudApply(AreaEffectCloudApplyEvent event);

    void onAsyncPlayerChat(AsyncPlayerChatEvent event);

    void onAsyncPlayerPreLogin(AsyncPlayerPreLoginEvent event);

    void onBatToggleSleep(BatToggleSleepEvent event);

    void onBlock(BlockEvent event);

    void onBlockBreak(BlockBreakEvent event);

    void onBlockBurn(BlockBurnEvent event);

    void onBlockCanBuild(BlockCanBuildEvent event);

    void onBlockCook(BlockCookEvent event);

    void onBlockDamage(BlockDamageEvent event);

    void onBlockDispense(BlockDamageEvent event);

    void onBlockDispense(BlockDispenseEvent event);

    void onBlockDispenseArmor(BlockDispenseArmorEvent event);

    void onBlockDropItem(BlockDropItemEvent event);

    void onBlockExp(BlockExpEvent event);

    void onBlockExplode(BlockExplodeEvent event);

    void onBlockFade(BlockFadeEvent event);

    void onBlockFertilize(BlockFadeEvent event);

    void onBlockForm(BlockFormEvent event);

    void onBlockFromTo(BlockFromToEvent event);

    void onBlockGrow(BlockGrowEvent event);

    void onBlockIgnite(BlockIgniteEvent event);

    void onBlockMultiPlace(BlockMultiPlaceEvent event);

    void onBlockPhysics(BlockPhysicsEvent event);

    void onBlockPistonExtend(BlockPistonExtendEvent event);

    void onBlockPistonRetract(BlockPistonRetractEvent event);

    void onBlockPlace(BlockPlaceEvent event);

    void onBlockRedstone(BlockRedstoneEvent event);

    void onBlockShearEntity(BlockShearEntityEvent event);

    void onBlockSpread(BlockSpreadEvent event);

    void onBrew(BrewEvent event);

    void onBrewingStandFuel(BrewingStandFuelEvent event);

    void onBroadcastMessage(BroadcastMessageEvent event);

    void onCauldronLevelChange(CauldronLevelChangeEvent event);

    void onChunk(ChunkEvent event);

    void onChunkLoad(ChunkLoadEvent event);

    void onChunkPopulate(ChunkPopulateEvent event);

    void onChunkUnload(ChunkUnloadEvent event);

    void onCraftItem(CraftItemEvent event);

    void onCreatureSpawn(CreatureSpawnEvent event);

    void onCreeperPower(CreeperPowerEvent event);

    void onEnchantItem(EnchantItemEvent event);

    void onEnderDragonChangePhase(EnderDragonChangePhaseEvent event);

    void onEntity(EntityEvent event);

    void onEntityAirChange(EntityAirChangeEvent event);

    void onEntityBlockForm(EntityBlockFormEvent event);

    void onEntityBreakDoorEvent(EntityBreakDoorEvent event);

    void onEntityBreed(EntityBreedEvent event);

    void onEntityChangeBlock(EntityChangeBlockEvent event);

    void onEntityCombust(EntityCombustEvent event);

    void onEntityCombustByBlock(EntityCombustByBlockEvent event);

    void onEntityCombustByEntity(EntityCombustByEntityEvent event);

    void onEntityDamage(EntityDamageEvent event);

    void onEntityDamageByBlock(EntityDamageEvent event);

    void onEntityDamageByEntity(EntityDamageByEntityEvent event);

    void onEntityDeath(EntityDeathEvent event);

    void onEntityDropItem(EntityDropItemEvent event);

    void onEntityEnterBlock(EntityEnterBlockEvent event);

    void onEntityExplode(EntityExplodeEvent event);

    void onEntityInteract(EntityInteractEvent event);

    void onEntityPickupItem(EntityPickupItemEvent event);

    void onEntityPortal(EntityPortalEvent event);

    void onEntityPortalExit(EntityPortalExitEvent event);

    void onEntityPoseChange(EntityPoseChangeEvent event);

    void onEntityPotionEffect(EntityPotionEffectEvent event);

    void onEntityRegainHealth(EntityRegainHealthEvent event);

    void onEntityResurrect(EntityResurrectEvent event);

    void onEntityShootBow(EntityShootBowEvent event);

    void onEntitySpawn(EntitySpawnEvent event);

    void onEntityTame(EntityTameEvent event);

    void onEntityTarget(EntityTargetEvent event);

    void onEntityTargetLivingEntity(EntityTargetLivingEntityEvent event);

    void onEntityTeleport(EntityTeleportEvent event);

    void onEntityToggleGlide(EntityToggleGlideEvent event);

    void onEntityToggleSwim(EntityToggleSwimEvent event);

    void onEntityTransform(EntityTransformEvent event);

    void onEntityUnleash(EntityUnleashEvent event);

    void onExpBottle(ExpBottleEvent event);

    void onExplosionPrime(ExplosionPrimeEvent event);

    void onFireworkExplode(FireworkExplodeEvent event);

    void onFluidLevelChange(FluidLevelChangeEvent event);

    void onFoodLevelChange(FoodLevelChangeEvent event);

    void onFurnaceBurn(FurnaceBurnEvent event);

    void onFurnaceExtract(FurnaceExtractEvent event);

    void onFurnaceSmelt(FurnaceSmeltEvent event);

    void onHanging(HangingEvent event);

    void onHangingBreak(HangingBreakEvent event);

    void onHangingBreakByEntity(HangingBreakByEntityEvent event);

    void onHangingPlace(HangingPlaceEvent event);

    void onHorseJump(HorseJumpEvent event);

    void onInventory(InventoryEvent event);

    void onInventoryClick(InventoryClickEvent event);

    void onInventoryClose(InventoryCloseEvent event);

    void onInventoryCreative(InventoryCreativeEvent event);

    void onInventoryDrag(InventoryDragEvent event);

    void onInventoryInteract(InventoryInteractEvent event);

    void onInventoryMoveItem(InventoryMoveItemEvent event);

    void onInventoryOpen(InventoryOpenEvent event);

    void onInventoryPickupItem(InventoryPickupItemEvent event);

    void onItemDespawn(ItemDespawnEvent event);

    void onItemMerge(ItemMergeEvent event);

    void onItemSpawn(ItemSpawnEvent event);

    void onLeaveDecay(LeavesDecayEvent event);

    void onLightningStrike(LightningStrikeEvent event);

    void onLingeringPotionSplash(LingeringPotionSplashEvent event);

    void onMapInitialize(MapInitializeEvent event);

    void onMoistureChange(MoistureChangeEvent event);

    void onNotePlay(NotePlayEvent event);

    void onPigZap(PigZapEvent event);

    void onPigZombieAnger(PigZombieAngerEvent event);

    void onPlayer(PlayerEvent event);

    void onPlayerAdvancementDone(PlayerAdvancementDoneEvent event);

    void onPlayerAnimation(PlayerAnimationEvent event);

    void onPlayerArmorStandManipulate(PlayerArmorStandManipulateEvent event);

    void onPlayerBedEnter(PlayerBedEnterEvent event);

    void onPlayerBedLeave(PlayerBedLeaveEvent event);

    void onPlayerBucket(PlayerBucketEvent event);

    void onPlayerBucketEmpty(PlayerBucketEmptyEvent event);

    void onPlayerBucketFill(PlayerBucketFillEvent event);

    void onPlayerChangedMainHand(PlayerChangedMainHandEvent event);

    void onPlayerChangedWorld(PlayerChangedWorldEvent event);

    void onPlayerChannel(PlayerChannelEvent event);

    void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event);

    void onPlayerCommandSend(PlayerCommandSendEvent event);

    void onPlayerDeath(PlayerDeathEvent event);

    void onPlayerDropItem(PlayerDropItemEvent event);

    void onPlayerEditBook(PlayerEditBookEvent event);

    void onPlayerEggThrow(PlayerEggThrowEvent event);

    void onPlayerEntityUnleash(PlayerUnleashEntityEvent event);

    void onPlayerExpChange(PlayerExpChangeEvent event);

    void onPlayerFish(PlayerFishEvent event);

    void onPlayerGameModeChange(PlayerGameModeChangeEvent event);

    void onPlayerInteract(PlayerInteractEvent event);

    void onPlayerInteractAtEntity(PlayerInteractAtEntityEvent event);

    void onPlayerInteractEntity(PlayerInteractEntityEvent event);

    void onPlayerItemBreak(PlayerItemBreakEvent event);

    void onPlayerItemConsume(PlayerItemConsumeEvent event);

    void onPlayerItemDamage(PlayerItemDamageEvent event);

    void onPlayerItemHeld(PlayerItemHeldEvent event);

    void onPlayerItemMend(PlayerItemMendEvent event);

    void onPlayerJoin(PlayerJoinEvent event);

    void onPlayerKick(PlayerKickEvent event);

    void onPlayerLeashEntity(PlayerLeashEntityEvent event);

    void onPlayerLevelChange(PlayerLevelChangeEvent event);

    void onPlayerLocaleChange(PlayerLocaleChangeEvent event);

    void onPlayerLogin(PlayerLoginEvent event);

    void onPlayerMove(PlayerMoveEvent event);

    void onPlayerPickupArrow(PlayerPickupArrowEvent event);

    void onPlayerQuit(PlayerQuitEvent event);

    void onPlayerRecipeDiscover(PlayerRecipeDiscoverEvent event);

    void onPlayerRegisterChannel(PlayerRegisterChannelEvent event);

    void onPlayerResourcePackStatus(PlayerResourcePackStatusEvent event);

    void onPlayerRespawn(PlayerRespawnEvent event);

    void onPlayerRiptide(PlayerRiptideEvent event);

    void onPlayerShearEntity(PlayerShearEntityEvent event);

    void onPlayerStatisticIncrement(PlayerStatisticIncrementEvent event);

    void onPlayerSwapHandItems(PlayerSwapHandItemsEvent event);

    void onPlayerTakeLecternBook(PlayerTakeLecternBookEvent event);

    void onPlayerToggleFlight(PlayerToggleFlightEvent event);

    void onPlayerToggleSneak(PlayerToggleSneakEvent event);

    void onPlayerToggleSpring(PlayerToggleSprintEvent event);

    void onPlayerUnregisterChannel(PlayerUnregisterChannelEvent event);

    void onPlayerVelocity(PlayerVelocityEvent event);

    void onPlugin(PluginEvent event);

    void onPluginDisable(PluginDisableEvent event);

    void onPluginEnable(PluginEnableEvent event);

    void onPortalCreate(PortalCreateEvent event);

    void onPotionSplash(PotionSplashEvent event);

    void onPrepareAnvil(PrepareAnvilEvent event);

    void onPrepareItemCraft(PrepareItemCraftEvent event);

    void onPrepareItemEnchant(PrepareItemEnchantEvent event);

    void onProjectileHit(ProjectileHitEvent event);

    void onProjectileLaunch(ProjectileLaunchEvent event);

    void onRaid(RaidEvent event);

    void onRaidFinish(RaidFinishEvent event);

    void onRaidSpawnWave(RaidSpawnWaveEvent event);

    void onRaidStop(RaidStopEvent event);

    void onRaidTrigger(RaidTriggerEvent event);

    void onRemoteServerCommand(RemoteServerCommandEvent event);

    void onServer(ServerEvent event);

    void onServerCommand(ServerCommandEvent event);

    void onServerListPing(ServerListPingEvent event);

    void onServerLoad(ServerLoadEvent event);

    void onService(ServiceEvent event);

    void onServiceRegister(ServiceRegisterEvent event);

    void onServiceUnregister(ServiceUnregisterEvent event);

    void onSheepDyeWool(SheepDyeWoolEvent event);

    void onSheepRegrowWool(SheepRegrowWoolEvent event);

    void onSignChange(SignChangeEvent event);

    void onSlimeSplit(SlimeSplitEvent event);

    void onSpawnChange(SpawnChangeEvent event);

    void onSpongeAbsorb(SpongeAbsorbEvent event);

    void onStructureGrow(StructureGrowEvent event);

    void onTabComplete(TabCompleteEvent event);

    void onThunderChange(ThunderChangeEvent event);

    void onTimeSkip(TimeSkipEvent event);

    void onTradeSelect(TradeSelectEvent event);

    void onVehicle(VehicleEvent event);

    void onVehicleBlockCollision(VehicleBlockCollisionEvent event);

    void onVehicleCollision(VehicleCollisionEvent event);

    void onVehicleCreate(VehicleCreateEvent event);

    void onVehicleDamage(VehicleDamageEvent event);

    void onVehicleDestroy(VehicleDestroyEvent event);

    void onVehicleEnter(VehicleEnterEvent event);

    void onVehicleEntityCollision(VehicleEntityCollisionEvent event);

    void onVehicleExit(VehicleExitEvent event);

    void onVehicleMove(VehicleMoveEvent event);

    void onVehicleUpdate(VehicleUpdateEvent event);

    void onVillagerAcquireTrade(VillagerAcquireTradeEvent event);

    void onVillagerCareerChange(VillagerCareerChangeEvent event);

    void onVillagerReplenishTrade(VillagerReplenishTradeEvent event);

    void onWeather(WeatherEvent event);

    void onWeatherChange(WeatherChangeEvent event);

    void onWorld(WorldEvent event);

    void onWorldInit(WorldInitEvent event);

    void onWorldLoad(WorldLoadEvent event);

    void onWorldSave(WorldSaveEvent event);

    void onWorldUnload(WorldUnloadEvent event);

}
