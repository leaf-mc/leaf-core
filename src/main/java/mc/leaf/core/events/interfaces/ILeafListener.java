package mc.leaf.core.events.interfaces;

import com.destroystokyo.paper.event.block.AnvilDamagedEvent;
import com.destroystokyo.paper.event.block.BeaconEffectEvent;
import com.destroystokyo.paper.event.block.BlockDestroyEvent;
import com.destroystokyo.paper.event.block.TNTPrimeEvent;
import com.destroystokyo.paper.event.entity.*;
import com.destroystokyo.paper.event.inventory.PrepareGrindstoneEvent;
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
import io.papermc.paper.event.world.StructuresLocateEvent;
import io.papermc.paper.event.world.WorldGameRuleChangeEvent;
import io.papermc.paper.event.world.border.WorldBorderBoundsChangeEvent;
import io.papermc.paper.event.world.border.WorldBorderBoundsChangeFinishEvent;
import io.papermc.paper.event.world.border.WorldBorderCenterChangeEvent;
import org.bukkit.event.Listener;
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
import org.jetbrains.annotations.ApiStatus;
import org.spigotmc.event.entity.EntityDismountEvent;
import org.spigotmc.event.entity.EntityMountEvent;
import org.spigotmc.event.player.PlayerSpawnLocationEvent;

/**
 * Interface providing every listener available on minecraft. You may extend {@link mc.leaf.core.events.LeafListener}
 * instead of implementing this.
 *
 * @author alexpado
 */
@SuppressWarnings("ClassWithTooManyMethods")
public interface ILeafListener extends Listener {

    // <editor-fold desc="Paper Events">
    // <editor-fold desc="block">
    void onAnvilDamaged(AnvilDamagedEvent event);

    void onBeaconEffect(BeaconEffectEvent event);

    void onBlockDestroy(BlockDestroyEvent event);

    void onTNTPrime(TNTPrimeEvent event);

    void onBeaconActivated(BeaconActivatedEvent event);

    void onBeaconDeactivated(BeaconDeactivatedEvent event);

    void onBellRevealRaider(BellRevealRaiderEvent event);

    void onBellRing(BellRingEvent event);

    void onBlockBreakBlock(BlockBreakBlockEvent event);

    void onBlockFailedDispense(BlockFailedDispenseEvent event);

    void onBlockPreDispense(BlockPreDispenseEvent event);

    void onDragonEggForm(DragonEggFormEvent event);

    void onPlayerShearBlock(PlayerShearBlockEvent event);

    void onTargetHit(TargetHitEvent event);

    // </editor-fold>
    // <editor-fold desc="entity">
    void onCreeperIgnite(CreeperIgniteEvent event);

    void onEnderDragonFireballHit(EnderDragonFireballHitEvent event);

    void onEnderDragonFlame(EnderDragonFlameEvent event);

    void onEnderDragonShootFireball(EnderDragonShootFireballEvent event);

    void onEndermanAttackPlayer(EndermanAttackPlayerEvent event);

    void onEndermanEscape(EndermanEscapeEvent event);

    void onEntityAddToWorld(EntityAddToWorldEvent event);

    void onEntityJump(EntityJumpEvent event);

    void onEntityKnockbackByEntity(EntityKnockbackByEntityEvent event);

    void onEntityPathfind(EntityPathfindEvent event);

    void onEntityRemoveFromWorld(EntityRemoveFromWorldEvent event);

    void onEntityTeleportEndGateway(EntityTeleportEndGatewayEvent event);

    @Deprecated
    void onEntityTransformed(EntityTransformedEvent event);

    void onEntityZap(EntityZapEvent event);

    void onExperienceOrbMerge(ExperienceOrbMergeEvent event);

    void onPhantomPreSpawn(PhantomPreSpawnEvent event);

    void onPlayerNaturallySpawnCreatures(PlayerNaturallySpawnCreaturesEvent event);

    void onPreCreatureSpawn(PreCreatureSpawnEvent event);

    void onPreSpawnerSpawn(PreSpawnerSpawnEvent event);

    void onProjectileCollide(ProjectileCollideEvent event);

    void onSkeletonHorseTrap(SkeletonHorseTrapEvent event);

    void onSlimeChangeDirection(SlimeChangeDirectionEvent event);

    void onSlimePathfind(SlimePathfindEvent event);

    void onSlimeSwim(SlimeSwimEvent event);

    void onSlimeTargetLivingEntity(SlimeTargetLivingEntityEvent event);

    void onSlimeWander(SlimeWanderEvent event);

    void onThrownEggHatch(ThrownEggHatchEvent event);

    void onTurtleGoHome(TurtleGoHomeEvent event);

    void onTurtleLayEgg(TurtleLayEggEvent event);

    void onTurtleStartDigging(TurtleStartDiggingEvent event);

    void onWitchConsumePotion(WitchConsumePotionEvent event);

    void onWitchReadyPotion(WitchReadyPotionEvent event);

    void onWitchThrowPotion(WitchThrowPotionEvent event);

    void onElderGuardianAppearance(ElderGuardianAppearanceEvent event);

    void onEntityDamageItem(EntityDamageItemEvent event);

    void onEntityDye(EntityDyeEvent event);

    void onEntityInsideBlock(EntityInsideBlockEvent event);

    void onEntityLoadCrossbow(EntityLoadCrossbowEvent event);

    void onEntityMove(EntityMoveEvent event);

    void onEntityPortalReady(EntityPortalReadyEvent event);

    void onPufferFishStateChange(PufferFishStateChangeEvent event);

    void onTameableDeathMessage(TameableDeathMessageEvent event);

    void onWardenAngerChange(WardenAngerChangeEvent event);

    // </editor-fold>
    // <editor-fold desc="inventory">
    @Deprecated
    void onPrepareGrindstone(PrepareGrindstoneEvent event);

    void onPrepareResult(PrepareResultEvent event);

    // </editor-fold>
    // <editor-fold desc="player">
    @Deprecated
    void onIllegalPacked(IllegalPacketEvent event);

    void onPlayerAdvancementCriterionGrant(PlayerAdvancementCriterionGrantEvent event);

    void onPlayerArmorChange(PlayerArmorChangeEvent event);

    void onPlayerAttackEntityCooldownReset(PlayerAttackEntityCooldownResetEvent event);

    void onPlayerClientOptionsChange(PlayerClientOptionsChangeEvent event);

    void onPlayerConnectionClose(PlayerConnectionCloseEvent event);

    void onPlayerElytraBoost(PlayerElytraBoostEvent event);

    void onPlayerHandshake(PlayerHandshakeEvent event);

    @Deprecated
    void onPlayerInitialSpawn(PlayerInitialSpawnEvent event);

    void onPlayerJumpEvent(PlayerJumpEvent event);

    void onPlayerLaunchProjectile(PlayerLaunchProjectileEvent event);

    void onPlayerPickupExperience(PlayerPickupExperienceEvent event);

    void onPlayerPostRespawn(PlayerPostRespawnEvent event);

    void onPlayerReadyArrow(PlayerReadyArrowEvent event);

    void onPlayerRecipeBookClick(PlayerRecipeBookClickEvent event);

    void onPlayerSetSpawn(PlayerSetSpawnEvent event);

    void onPlayerStartSpectatingEntity(PlayerStartSpectatingEntityEvent event);

    void onPlayerStopSpectatingEntity(PlayerStopSpectatingEntityEvent event);

    void onPlayerTeleportEndGateway(PlayerTeleportEndGatewayEvent event);

    void onPlayerUseUnknownEntity(PlayerUseUnknownEntityEvent event);

    @ApiStatus.Experimental
    void onAsyncChatCommandDecorate(AsyncChatCommandDecorateEvent event);

    @ApiStatus.Experimental
    void onAsyncChatDecorate(AsyncChatDecorateEvent event);

    void onAsyncChat(AsyncChatEvent event);

    @Deprecated
    void onChat(ChatEvent event);

    void onPlayerArmSwingEvent(PlayerArmSwingEvent event);

    void onPlayerBedFailEnter(PlayerBedFailEnterEvent event);

    void onPlayerChangeBeaconEffect(PlayerChangeBeaconEffectEvent event);

    void onPlayerDeepSleep(PlayerDeepSleepEvent event);

    void onPlayerFlowerPotManipulate(PlayerFlowerPotManipulateEvent event);

    void onPlayerItemCooldown(PlayerItemCooldownEvent event);

    void onPlayerItemFrameChange(PlayerItemFrameChangeEvent event);

    void onPlayerLecternPageChange(PlayerLecternPageChangeEvent event);

    void onPlayerLoomPatternSelect(PlayerLoomPatternSelectEvent event);

    void onPlayerNameEntity(PlayerNameEntityEvent event);

    void onPlayerPurchase(PlayerPurchaseEvent event);

    void onPlayerSignCommandPreprocess(PlayerSignCommandPreprocessEvent event);

    void onPlayerStonecutterRecipeSelect(PlayerStonecutterRecipeSelectEvent event);

    void onPlayerStopUsingItem(PlayerStopUsingItemEvent event);

    void onPlayerTrade(PlayerTradeEvent event);

    // </editor-fold>
    // <editor-fold desc="profile">
    void onFillProfile(FillProfileEvent event);

    void onLookupProfile(LookupProfileEvent event);

    void onPreFillProfile(PreFillProfileEvent event);

    void onPreLookupProfile(PreLookupProfileEvent event);

    void onProfileWhitelistVerify(ProfileWhitelistVerifyEvent event);

    // </editor-fold>
    // <editor-fold desc="server">
    void onAsyncTabComplete(AsyncTabCompleteEvent event);

    void onGS4Query(GS4QueryEvent event);

    void onPaperServerListPingEvent(PaperServerListPingEvent event);

    void onServerException(ServerExceptionEvent event);

    void onServerTickEnd(ServerTickEndEvent event);

    void onServerTickStart(ServerTickStartEvent event);

    void onWhitelistToggle(WhitelistToggleEvent event);

    void onServerResourcesReloaded(ServerResourcesReloadedEvent event);

    // </editor-fold>
    // <editor-fold desc="packet">
    void onPlayerChunkLoad(PlayerChunkLoadEvent event);

    void onPlayerChunkUnload(PlayerChunkUnloadEvent event);

    // </editor-fold>
    // <editor-fold desc="world">
    void onWorldBorderBoundsChange(WorldBorderBoundsChangeEvent event);

    void onWorldBorderBoundsChangeFinished(WorldBorderBoundsChangeFinishEvent event);

    void onWorldBoardCenterChange(WorldBorderCenterChangeEvent event);

    @Deprecated(forRemoval = true)
    void onStructureLocate(StructureLocateEvent event);

    void onStructuresLocate(StructuresLocateEvent event);

    void onWorldGameRuleChange(WorldGameRuleChangeEvent event);

    // </editor-fold>
    // </editor-fold>
    // <editor-fold desc="Bukkit Events">
    // <editor-fold desc="block">
    void onBlockBreak(BlockBreakEvent event);

    void onBlockBurn(BlockBurnEvent event);

    void onBlockCanBuild(BlockCanBuildEvent event);

    void onBlockCook(BlockCookEvent event);

    void onBlockDamageAbort(BlockDamageAbortEvent event);

    void onBlockDamage(BlockDamageEvent event);

    void onBlockDispenseArmor(BlockDispenseArmorEvent event);

    void onBlockDispense(BlockDispenseEvent event);

    void onBlockDropItem(BlockDropItemEvent event);

    void onBlockExp(BlockExpEvent event);

    void onBlockExplode(BlockExplodeEvent event);

    void onBlockFade(BlockFadeEvent event);

    void onBlockFertilize(BlockFertilizeEvent event);

    void onBlockFormEvent(BlockFormEvent event);

    void onBlockFromTo(BlockFromToEvent event);

    void onBlockGrow(BlockGrowEvent event);

    void onBlockIgnite(BlockIgniteEvent event);

    void onBlockMultiPlace(BlockMultiPlaceEvent event);

    void onBlockPhysics(BlockPhysicsEvent event);

    void onBlockPistonExtend(BlockPistonExtendEvent event);

    void onBlockPistonRetract(BlockPistonRetractEvent event);

    void onBlockPlace(BlockPlaceEvent event);

    void onBlockReceiveGame(BlockReceiveGameEvent event);

    void onBlockRedstone(BlockRedstoneEvent event);

    void onBlockShearEntity(BlockShearEntityEvent event);

    void onBlockSpread(BlockSpreadEvent event);

    void onCauldronLevelChange(CauldronLevelChangeEvent event);

    void onEntityBlockForm(EntityBlockFormEvent event);

    void onFluidLevelChange(FluidLevelChangeEvent event);

    void onLeavesDecay(LeavesDecayEvent event);

    void onMoistureChange(MoistureChangeEvent event);

    void onNotePlay(NotePlayEvent event);

    void onSignChange(SignChangeEvent event);

    void onSpongeAbsorb(SpongeAbsorbEvent event);

    // </editor-fold>
    // <editor-fold desc="command">
    void onUnknownCommand(UnknownCommandEvent event);

    // </editor-fold>
    // <editor-fold desc="enchantment">
    void onEnchantItem(EnchantItemEvent event);

    void onPrepareItemEnchant(PrepareItemEnchantEvent event);

    // </editor-fold>
    // <editor-fold desc="entity">
    void onAreaEffectCloudApply(AreaEffectCloudApplyEvent event);

    void onArrowBodyCountChange(ArrowBodyCountChangeEvent event);

    void onBatToggleSleep(BatToggleSleepEvent event);

    void onCreatureSpawn(CreatureSpawnEvent event);

    void onCreeperPower(CreeperPowerEvent event);

    void onEnderDragonChangePhase(EnderDragonChangePhaseEvent event);

    void onEntityAirChange(EntityAirChangeEvent event);

    void onEntityBreakDoor(EntityBreakDoorEvent event);

    void onEntityBreed(EntityBreedEvent event);

    void onEntityChangeBlock(EntityChangeBlockEvent event);

    void onEntityCombustByBlock(EntityCombustByBlockEvent event);

    void onEntityCombustByEntity(EntityCombustByEntityEvent event);

    void onEntityCombust(EntityCombustEvent event);

    @Deprecated
    void onEntityCreatePortal(EntityCreatePortalEvent event);

    void onEntityDamageByBlock(EntityDamageByBlockEvent event);

    void onEntityDamageByEntity(EntityDamageByEntityEvent event);

    void onEntityDamage(EntityDamageEvent event);

    void onEntityDeath(EntityDeathEvent event);

    void onEntityDropItem(EntityDropItemEvent event);

    void onEntityEnterBlock(EntityEnterBlockEvent event);

    void onEntityEnterLoveMode(EntityEnterLoveModeEvent event);

    void onEntityExhaustion(EntityExhaustionEvent event);

    void onEntityExplode(EntityExplodeEvent event);

    void onEntityInteract(EntityInteractEvent event);

    void onEntityPickupItem(EntityPickupItemEvent event);

    void onEntityPlace(EntityPlaceEvent event);

    void onEntityPortalEnter(EntityPortalEnterEvent event);

    void onEntityPortal(EntityPortalEvent event);

    void onEntityPortalExit(EntityPortalExitEvent event);

    void onEntityPoseChange(EntityPoseChangeEvent event);

    void onEntityPotionEffect(EntityPotionEffectEvent event);

    void onEntityRegainHealth(EntityRegainHealthEvent event);

    void onEntityResurrect(EntityResurrectEvent event);

    void onEntityShootBow(EntityShootBowEvent event);

    void onEntitySpawn(EntitySpawnEvent event);

    void onEntitySpellCast(EntitySpellCastEvent event);

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

    void onFoodLevelChange(FoodLevelChangeEvent event);

    void onHorseJump(HorseJumpEvent event);

    void onItemDespawn(ItemDespawnEvent event);

    void onItemMerge(ItemMergeEvent event);

    void onItemSpawn(ItemSpawnEvent event);

    void onLingeringPotionSplash(LingeringPotionSplashEvent event);

    void onPiglinBarter(PiglinBarterEvent event);

    void onPigZap(PigZapEvent event);

    void onPigZombieAnger(PigZombieAngerEvent event);

    void onPlayerDeath(PlayerDeathEvent event);

    void onPlayerLeashEntity(PlayerLeashEntityEvent event);

    void onPotionSplash(PotionSplashEvent event);

    void onProjectileHit(ProjectileHitEvent event);

    void onProjectileLaunch(ProjectileLaunchEvent event);

    void onSheepDyeWool(SheepDyeWoolEvent event);

    void onSheepRegrowWool(SheepRegrowWoolEvent event);

    void onSlimeSplit(SlimeSplitEvent event);

    void onSpawnerSpawn(SpawnerSpawnEvent event);

    void onStriderTemperatureChange(StriderTemperatureChangeEvent event);

    void onVillagerAcquireTrade(VillagerAcquireTradeEvent event);

    void onVillagerCareerChange(VillagerCareerChangeEvent event);

    void onVillagerReplenishTrade(VillagerReplenishTradeEvent event);

    // </editor-fold>
    // <editor-fold desc="hanging">
    void onHangingBreakByEntity(HangingBreakByEntityEvent event);

    void onHangingBreak(HangingBreakEvent event);

    void onHangingPlace(HangingPlaceEvent event);

    // </editor-fold>
    // <editor-fold desc="inventory">
    void onBrew(BrewEvent event);

    void onBrewingStandFuel(BrewingStandFuelEvent event);

    void onCraftItem(CraftItemEvent event);

    void onFurnaceBurn(FurnaceBurnEvent event);

    void onFurnaceExtract(FurnaceExtractEvent event);

    void onFurnaceSmelt(FurnaceSmeltEvent event);

    void onFurnaceStartSmelt(FurnaceStartSmeltEvent event);

    void onInventoryClick(InventoryClickEvent event);

    void onInventoryClose(InventoryCloseEvent event);

    void onInventoryCreative(InventoryCreativeEvent event);

    void onInventoryDrag(InventoryDragEvent event);

    void onInventory(InventoryEvent event);

    void onInventoryMoveItem(InventoryMoveItemEvent event);

    void onInventoryOpen(InventoryOpenEvent event);

    void onInventoryPickupItem(InventoryPickupItemEvent event);

    void onPrepareAnvil(PrepareAnvilEvent event);

    void onPrepareItemCraft(PrepareItemCraftEvent event);

    void onPrepareSmithing(PrepareSmithingEvent event);

    void onSmithItem(SmithItemEvent event);

    void onTradeSelect(TradeSelectEvent event);

    // </editor-fold>
    // <editor-fold desc="player">
    @Deprecated
    void onAsyncPlayerChat(AsyncPlayerChatEvent event);

    @Deprecated
    void onAsyncPlayerChatPreview(AsyncPlayerChatPreviewEvent event);

    void onAsyncPlayerPreLogin(AsyncPlayerPreLoginEvent event);

    void onPlayerAdvancementDone(PlayerAdvancementDoneEvent event);

    void onPlayerAnimation(PlayerAnimationEvent event);

    void onPlayerArmorStandManipulate(PlayerArmorStandManipulateEvent event);

    void onPlayerAttemptPickupItem(PlayerAttemptPickupItemEvent event);

    void onPlayerBedEnter(PlayerBedEnterEvent event);

    void onPlayerBedLeave(PlayerBedLeaveEvent event);

    void onPlayerBucketEmpty(PlayerBucketEmptyEvent event);

    void onPlayerBucketEntity(PlayerBucketEntityEvent event);

    void onPlayerBucketFill(PlayerBucketFillEvent event);

    @Deprecated
    void onPlayerBucketFish(PlayerBucketFishEvent event);

    void onPlayerChangedMainHand(PlayerChangedMainHandEvent event);

    void onPlayerChangedWorld(PlayerChangedWorldEvent event);

    @Deprecated
    void onPlayerChat(PlayerChatEvent event);

    @Deprecated
    void onPlayerChatTabComplete(PlayerChatTabCompleteEvent event);

    void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event);

    void onPlayerCommandSend(PlayerCommandSendEvent event);

    void onPlayerDropItem(PlayerDropItemEvent event);

    void onPlayerEditBook(PlayerEditBookEvent event);

    void onPlayerEggThrow(PlayerEggThrowEvent event);

    void onPlayerExpChange(PlayerExpChangeEvent event);

    void onPlayerFish(PlayerFishEvent event);

    void onPlayerGameModeChange(PlayerGameModeChangeEvent event);

    void onPlayerHarvestBlock(PlayerHarvestBlockEvent event);

    @ApiStatus.Experimental
    void onPlayerHideEntity(PlayerHideEntityEvent event);

    void onPlayerInteractAtEntity(PlayerInteractAtEntityEvent event);

    void onPlayerInteractEntity(PlayerInteractEntityEvent event);

    void onPlayerInteract(PlayerInteractEvent event);

    void onPlayerItemBreak(PlayerItemBreakEvent event);

    void onPlayerItemConsume(PlayerItemConsumeEvent event);

    void onPlayerItemDamage(PlayerItemDamageEvent event);

    void onPlayerItemHeld(PlayerItemHeldEvent event);

    void onPlayerItemMend(PlayerItemMendEvent event);

    void onPlayerJoin(PlayerJoinEvent event);

    void onPlayerKick(PlayerKickEvent event);

    void onPlayerLevelChange(PlayerLevelChangeEvent event);

    void onPlayerLocaleChange(PlayerLocaleChangeEvent event);

    void onPlayerLogin(PlayerLoginEvent event);

    void onPlayerMove(PlayerMoveEvent event);

    void onPlayerPickupArrow(PlayerPickupArrowEvent event);

    @Deprecated
    void onPlayerPickupItem(PlayerPickupItemEvent event);

    void onPlayerPortal(PlayerPortalEvent event);

    @Deprecated
    void onPlayerPreLogin(PlayerPreLoginEvent event);

    void onPlayerQuit(PlayerQuitEvent event);

    void onPlayerRecipeDiscover(PlayerRecipeDiscoverEvent event);

    void onPlayerRegisterChannel(PlayerRegisterChannelEvent event);

    void onPlayerResourcePackStatus(PlayerResourcePackStatusEvent event);

    void onPlayerRespawn(PlayerRespawnEvent event);

    void onPlayerRiptide(PlayerRiptideEvent event);

    void onPlayerShearEntity(PlayerShearEntityEvent event);

    @ApiStatus.Experimental
    void onPlayerShowEntity(PlayerShowEntityEvent event);

    void onPlayerStatisticIncrement(PlayerStatisticIncrementEvent event);

    void onPlayerSwapHandItem(PlayerSwapHandItemsEvent event);

    void onPlayerTakeLecternBook(PlayerTakeLecternBookEvent event);

    void onPlayerTeleport(PlayerTeleportEvent event);

    void onPlayerToggleFlight(PlayerToggleFlightEvent event);

    void onPlayerToggleSneak(PlayerToggleSneakEvent event);

    void onPlayerToggleSprint(PlayerToggleSprintEvent event);

    void onPlayerUnleashEntity(PlayerUnleashEntityEvent event);

    void onPlayerUnregisterChannel(PlayerUnregisterChannelEvent event);

    void onPlayerVelocity(PlayerVelocityEvent event);

    // </editor-fold>
    // <editor-fold desc="raid">
    void onRaidFinish(RaidFinishEvent event);

    void onRaidSpawnWave(RaidSpawnWaveEvent event);

    void onRaidStop(RaidStopEvent event);

    void onRaidTrigger(RaidTriggerEvent event);

    // </editor-fold>
    // <editor-fold desc="server">
    void onBroadcastMessage(BroadcastMessageEvent event);

    void onMapInitialize(MapInitializeEvent event);

    void onPluginDisable(PluginDisableEvent event);

    void onPluginEnable(PluginEnableEvent event);

    void onRemoteServerCommand(RemoteServerCommandEvent event);

    void onServerCommand(ServerCommandEvent event);

    void onServerListPing(ServerListPingEvent event);

    void onServerLoad(ServerLoadEvent event);

    void onServiceRegister(ServiceRegisterEvent event);

    void onServiceUnregister(ServiceUnregisterEvent event);

    void onTabComplete(TabCompleteEvent event);

    // </editor-fold>
    // <editor-fold desc="vehicle">
    void onVehicleBlockCollision(VehicleBlockCollisionEvent event);

    void onVehicleCreate(VehicleCreateEvent event);

    void onVehicleDamage(VehicleDamageEvent event);

    void onVehicleDestroy(VehicleDestroyEvent event);

    void onVehicleEnter(VehicleEnterEvent event);

    void onVehicleEntityCollision(VehicleEntityCollisionEvent event);

    void onVehicleExit(VehicleExitEvent event);

    void onVehicleMove(VehicleMoveEvent event);

    void onVehicleUpdate(VehicleUpdateEvent event);

    // </editor-fold>
    // <editor-fold desc="weather">
    void onLightningStrike(LightningStrikeEvent event);

    void onThunderChange(ThunderChangeEvent event);

    void onWeatherChange(WeatherChangeEvent event);

    // </editor-fold>
    // <editor-fold desc="world">
    void onChunkLoad(ChunkLoadEvent event);

    void onChunkPopulate(ChunkPopulateEvent event);

    void onChunkUnload(ChunkUnloadEvent event);

    void onEntitiesLoad(EntitiesLoadEvent event);

    void onEntitiesUnload(EntitiesUnloadEvent event);

    void onGenericGame(GenericGameEvent event);

    void onLootGenerate(LootGenerateEvent event);

    void onPortalCreate(PortalCreateEvent event);

    void onSpawnChange(SpawnChangeEvent event);

    void onStructureGrow(StructureGrowEvent event);

    void onTimeSkip(TimeSkipEvent event);

    void onWorldInit(WorldInitEvent event);

    void onWorldLoad(WorldLoadEvent event);

    void onWorldSave(WorldSaveEvent event);

    void onWorldUnload(WorldUnloadEvent event);

    // </editor-fold>
    // </editor-fold>
    // <editor-fold desc="Spigot Events">
    // <editor-fold desc="entity">
    void onEntityDismount(EntityDismountEvent event);

    void onEntityMount(EntityMountEvent event);

    // </editor-fold>
    // <editor-fold desc="player">
    void onPlayerSpawnLocation(PlayerSpawnLocationEvent event);
    // </editor-fold>
    // </editor-fold>
}
