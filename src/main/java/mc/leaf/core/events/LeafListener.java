package mc.leaf.core.events;

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
import mc.leaf.core.events.interfaces.ILeafListener;
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
import org.spigotmc.event.entity.EntityDismountEvent;
import org.spigotmc.event.entity.EntityMountEvent;
import org.spigotmc.event.player.PlayerSpawnLocationEvent;

/**
 * Helper class containing all Bukkit events. You can extend it to benefit from your IDE "Override Method" feature.
 * Don't forget to add the {@link org.bukkit.event.EventHandler} annotation on overridden methods.
 *
 * @author alexpado
 */
public class LeafListener implements ILeafListener {

    @Override
    public void onAnvilDamaged(AnvilDamagedEvent event) {

    }

    @Override
    public void onBeaconEffect(BeaconEffectEvent event) {

    }

    @Override
    public void onBlockDestroy(BlockDestroyEvent event) {

    }

    @Override
    public void onTNTPrime(TNTPrimeEvent event) {

    }

    @Override
    public void onBeaconActivated(BeaconActivatedEvent event) {

    }

    @Override
    public void onBeaconDeactivated(BeaconDeactivatedEvent event) {

    }

    @Override
    public void onBellRevealRaider(BellRevealRaiderEvent event) {

    }

    @Override
    public void onBellRing(BellRingEvent event) {

    }

    @Override
    public void onBlockBreakBlock(BlockBreakBlockEvent event) {

    }

    @Override
    public void onBlockFailedDispense(BlockFailedDispenseEvent event) {

    }

    @Override
    public void onBlockPreDispense(BlockPreDispenseEvent event) {

    }

    @Override
    public void onDragonEggForm(DragonEggFormEvent event) {

    }

    @Override
    public void onPlayerShearBlock(PlayerShearBlockEvent event) {

    }

    @Override
    public void onTargetHit(TargetHitEvent event) {

    }

    @Override
    public void onCreeperIgnite(CreeperIgniteEvent event) {

    }

    @Override
    public void onEnderDragonFireballHit(EnderDragonFireballHitEvent event) {

    }

    @Override
    public void onEnderDragonFlame(EnderDragonFlameEvent event) {

    }

    @Override
    public void onEnderDragonShootFireball(EnderDragonShootFireballEvent event) {

    }

    @Override
    public void onEndermanAttackPlayer(EndermanAttackPlayerEvent event) {

    }

    @Override
    public void onEndermanEscape(EndermanEscapeEvent event) {

    }

    @Override
    public void onEntityAddToWorld(EntityAddToWorldEvent event) {

    }

    @Override
    public void onEntityJump(EntityJumpEvent event) {

    }

    @Override
    public void onEntityKnockbackByEntity(EntityKnockbackByEntityEvent event) {

    }

    @Override
    public void onEntityPathfind(EntityPathfindEvent event) {

    }

    @Override
    public void onEntityRemoveFromWorld(EntityRemoveFromWorldEvent event) {

    }

    @Override
    public void onEntityTeleportEndGateway(EntityTeleportEndGatewayEvent event) {

    }

    @Override
    @Deprecated
    public void onEntityTransformed(EntityTransformedEvent event) {

    }

    @Override
    public void onEntityZap(EntityZapEvent event) {

    }

    @Override
    public void onExperienceOrbMerge(ExperienceOrbMergeEvent event) {

    }

    @Override
    public void onPhantomPreSpawn(PhantomPreSpawnEvent event) {

    }

    @Override
    public void onPlayerNaturallySpawnCreatures(PlayerNaturallySpawnCreaturesEvent event) {

    }

    @Override
    public void onPreCreatureSpawn(PreCreatureSpawnEvent event) {

    }

    @Override
    public void onPreSpawnerSpawn(PreSpawnerSpawnEvent event) {

    }

    @Override
    public void onProjectileCollide(ProjectileCollideEvent event) {

    }

    @Override
    public void onSkeletonHorseTrap(SkeletonHorseTrapEvent event) {

    }

    @Override
    public void onSlimeChangeDirection(SlimeChangeDirectionEvent event) {

    }

    @Override
    public void onSlimePathfind(SlimePathfindEvent event) {

    }

    @Override
    public void onSlimeSwim(SlimeSwimEvent event) {

    }

    @Override
    public void onSlimeTargetLivingEntity(SlimeTargetLivingEntityEvent event) {

    }

    @Override
    public void onSlimeWander(SlimeWanderEvent event) {

    }

    @Override
    public void onThrownEggHatch(ThrownEggHatchEvent event) {

    }

    @Override
    public void onTurtleGoHome(TurtleGoHomeEvent event) {

    }

    @Override
    public void onTurtleLayEgg(TurtleLayEggEvent event) {

    }

    @Override
    public void onTurtleStartDigging(TurtleStartDiggingEvent event) {

    }

    @Override
    public void onWitchConsumePotion(WitchConsumePotionEvent event) {

    }

    @Override
    public void onWitchReadyPotion(WitchReadyPotionEvent event) {

    }

    @Override
    public void onWitchThrowPotion(WitchThrowPotionEvent event) {

    }

    @Override
    public void onElderGuardianAppearance(ElderGuardianAppearanceEvent event) {

    }

    @Override
    public void onEntityDamageItem(EntityDamageItemEvent event) {

    }

    @Override
    public void onEntityDye(EntityDyeEvent event) {

    }

    @Override
    public void onEntityInsideBlock(EntityInsideBlockEvent event) {

    }

    @Override
    public void onEntityLoadCrossbow(EntityLoadCrossbowEvent event) {

    }

    @Override
    public void onEntityMove(EntityMoveEvent event) {

    }

    @Override
    public void onEntityPortalReady(EntityPortalReadyEvent event) {

    }

    @Override
    public void onPufferFishStateChange(PufferFishStateChangeEvent event) {

    }

    @Override
    public void onTameableDeathMessage(TameableDeathMessageEvent event) {

    }

    @Override
    public void onWardenAngerChange(WardenAngerChangeEvent event) {

    }

    @Override
    @Deprecated
    public void onPrepareGrindstone(PrepareGrindstoneEvent event) {

    }

    @Override
    public void onPrepareResult(PrepareResultEvent event) {

    }

    @Override
    @Deprecated
    public void onIllegalPacked(IllegalPacketEvent event) {

    }

    @Override
    public void onPlayerAdvancementCriterionGrant(PlayerAdvancementCriterionGrantEvent event) {

    }

    @Override
    public void onPlayerArmorChange(PlayerArmorChangeEvent event) {

    }

    @Override
    public void onPlayerAttackEntityCooldownReset(PlayerAttackEntityCooldownResetEvent event) {

    }

    @Override
    public void onPlayerClientOptionsChange(PlayerClientOptionsChangeEvent event) {

    }

    @Override
    public void onPlayerConnectionClose(PlayerConnectionCloseEvent event) {

    }

    @Override
    public void onPlayerElytraBoost(PlayerElytraBoostEvent event) {

    }

    @Override
    public void onPlayerHandshake(PlayerHandshakeEvent event) {

    }

    @Override
    @Deprecated
    public void onPlayerInitialSpawn(PlayerInitialSpawnEvent event) {

    }

    @Override
    public void onPlayerJumpEvent(PlayerJumpEvent event) {

    }

    @Override
    public void onPlayerLaunchProjectile(PlayerLaunchProjectileEvent event) {

    }

    @Override
    public void onPlayerPickupExperience(PlayerPickupExperienceEvent event) {

    }

    @Override
    public void onPlayerPostRespawn(PlayerPostRespawnEvent event) {

    }

    @Override
    public void onPlayerReadyArrow(PlayerReadyArrowEvent event) {

    }

    @Override
    public void onPlayerRecipeBookClick(PlayerRecipeBookClickEvent event) {

    }

    @Override
    public void onPlayerSetSpawn(PlayerSetSpawnEvent event) {

    }

    @Override
    public void onPlayerStartSpectatingEntity(PlayerStartSpectatingEntityEvent event) {

    }

    @Override
    public void onPlayerStopSpectatingEntity(PlayerStopSpectatingEntityEvent event) {

    }

    @Override
    public void onPlayerTeleportEndGateway(PlayerTeleportEndGatewayEvent event) {

    }

    @Override
    public void onPlayerUseUnknownEntity(PlayerUseUnknownEntityEvent event) {

    }

    @Override
    public void onAsyncChatCommandDecorate(AsyncChatCommandDecorateEvent event) {

    }

    @Override
    public void onAsyncChatDecorate(AsyncChatDecorateEvent event) {

    }

    @Override
    public void onAsyncChat(AsyncChatEvent event) {

    }

    @Override
    @Deprecated
    public void onChat(ChatEvent event) {

    }

    @Override
    public void onPlayerArmSwingEvent(PlayerArmSwingEvent event) {

    }

    @Override
    public void onPlayerBedFailEnter(PlayerBedFailEnterEvent event) {

    }

    @Override
    public void onPlayerChangeBeaconEffect(PlayerChangeBeaconEffectEvent event) {

    }

    @Override
    public void onPlayerDeepSleep(PlayerDeepSleepEvent event) {

    }

    @Override
    public void onPlayerFlowerPotManipulate(PlayerFlowerPotManipulateEvent event) {

    }

    @Override
    public void onPlayerItemCooldown(PlayerItemCooldownEvent event) {

    }

    @Override
    public void onPlayerItemFrameChange(PlayerItemFrameChangeEvent event) {

    }

    @Override
    public void onPlayerLecternPageChange(PlayerLecternPageChangeEvent event) {

    }

    @Override
    public void onPlayerLoomPatternSelect(PlayerLoomPatternSelectEvent event) {

    }

    @Override
    public void onPlayerNameEntity(PlayerNameEntityEvent event) {

    }

    @Override
    public void onPlayerPurchase(PlayerPurchaseEvent event) {

    }

    @Override
    public void onPlayerSignCommandPreprocess(PlayerSignCommandPreprocessEvent event) {

    }

    @Override
    public void onPlayerStonecutterRecipeSelect(PlayerStonecutterRecipeSelectEvent event) {

    }

    @Override
    public void onPlayerStopUsingItem(PlayerStopUsingItemEvent event) {

    }

    @Override
    public void onPlayerTrade(PlayerTradeEvent event) {

    }

    @Override
    public void onFillProfile(FillProfileEvent event) {

    }

    @Override
    public void onLookupProfile(LookupProfileEvent event) {

    }

    @Override
    public void onPreFillProfile(PreFillProfileEvent event) {

    }

    @Override
    public void onPreLookupProfile(PreLookupProfileEvent event) {

    }

    @Override
    public void onProfileWhitelistVerify(ProfileWhitelistVerifyEvent event) {

    }

    @Override
    public void onAsyncTabComplete(AsyncTabCompleteEvent event) {

    }

    @Override
    public void onGS4Query(GS4QueryEvent event) {

    }

    @Override
    public void onPaperServerListPingEvent(PaperServerListPingEvent event) {

    }

    @Override
    public void onServerException(ServerExceptionEvent event) {

    }

    @Override
    public void onServerTickEnd(ServerTickEndEvent event) {

    }

    @Override
    public void onServerTickStart(ServerTickStartEvent event) {

    }

    @Override
    public void onWhitelistToggle(WhitelistToggleEvent event) {

    }

    @Override
    public void onServerResourcesReloaded(ServerResourcesReloadedEvent event) {

    }

    @Override
    public void onPlayerChunkLoad(PlayerChunkLoadEvent event) {

    }

    @Override
    public void onPlayerChunkUnload(PlayerChunkUnloadEvent event) {

    }

    @Override
    public void onWorldBorderBoundsChange(WorldBorderBoundsChangeEvent event) {

    }

    @Override
    public void onWorldBorderBoundsChangeFinished(WorldBorderBoundsChangeFinishEvent event) {

    }

    @Override
    public void onWorldBoardCenterChange(WorldBorderCenterChangeEvent event) {

    }

    @Override
    @Deprecated(forRemoval = true)
    public void onStructureLocate(StructureLocateEvent event) {

    }

    @Override
    public void onStructuresLocate(StructuresLocateEvent event) {

    }

    @Override
    public void onWorldGameRuleChange(WorldGameRuleChangeEvent event) {

    }

    @Override
    public void onBlockBreak(BlockBreakEvent event) {

    }

    @Override
    public void onBlockBurn(BlockBurnEvent event) {

    }

    @Override
    public void onBlockCanBuild(BlockCanBuildEvent event) {

    }

    @Override
    public void onBlockCook(BlockCookEvent event) {

    }

    @Override
    public void onBlockDamageAbort(BlockDamageAbortEvent event) {

    }

    @Override
    public void onBlockDamage(BlockDamageEvent event) {

    }

    @Override
    public void onBlockDispenseArmor(BlockDispenseArmorEvent event) {

    }

    @Override
    public void onBlockDispense(BlockDispenseEvent event) {

    }

    @Override
    public void onBlockDropItem(BlockDropItemEvent event) {

    }

    @Override
    public void onBlockExp(BlockExpEvent event) {

    }

    @Override
    public void onBlockExplode(BlockExplodeEvent event) {

    }

    @Override
    public void onBlockFade(BlockFadeEvent event) {

    }

    @Override
    public void onBlockFertilize(BlockFertilizeEvent event) {

    }

    @Override
    public void onBlockFormEvent(BlockFormEvent event) {

    }

    @Override
    public void onBlockFromTo(BlockFromToEvent event) {

    }

    @Override
    public void onBlockGrow(BlockGrowEvent event) {

    }

    @Override
    public void onBlockIgnite(BlockIgniteEvent event) {

    }

    @Override
    public void onBlockMultiPlace(BlockMultiPlaceEvent event) {

    }

    @Override
    public void onBlockPhysics(BlockPhysicsEvent event) {

    }

    @Override
    public void onBlockPistonExtend(BlockPistonExtendEvent event) {

    }

    @Override
    public void onBlockPistonRetract(BlockPistonRetractEvent event) {

    }

    @Override
    public void onBlockPlace(BlockPlaceEvent event) {

    }

    @Override
    public void onBlockReceiveGame(BlockReceiveGameEvent event) {

    }

    @Override
    public void onBlockRedstone(BlockRedstoneEvent event) {

    }

    @Override
    public void onBlockShearEntity(BlockShearEntityEvent event) {

    }

    @Override
    public void onBlockSpread(BlockSpreadEvent event) {

    }

    @Override
    public void onCauldronLevelChange(CauldronLevelChangeEvent event) {

    }

    @Override
    public void onEntityBlockForm(EntityBlockFormEvent event) {

    }

    @Override
    public void onFluidLevelChange(FluidLevelChangeEvent event) {

    }

    @Override
    public void onLeavesDecay(LeavesDecayEvent event) {

    }

    @Override
    public void onMoistureChange(MoistureChangeEvent event) {

    }

    @Override
    public void onNotePlay(NotePlayEvent event) {

    }

    @Override
    public void onSignChange(SignChangeEvent event) {

    }

    @Override
    public void onSpongeAbsorb(SpongeAbsorbEvent event) {

    }

    @Override
    public void onUnknownCommand(UnknownCommandEvent event) {

    }

    @Override
    public void onEnchantItem(EnchantItemEvent event) {

    }

    @Override
    public void onPrepareItemEnchant(PrepareItemEnchantEvent event) {

    }

    @Override
    public void onAreaEffectCloudApply(AreaEffectCloudApplyEvent event) {

    }

    @Override
    public void onArrowBodyCountChange(ArrowBodyCountChangeEvent event) {

    }

    @Override
    public void onBatToggleSleep(BatToggleSleepEvent event) {

    }

    @Override
    public void onCreatureSpawn(CreatureSpawnEvent event) {

    }

    @Override
    public void onCreeperPower(CreeperPowerEvent event) {

    }

    @Override
    public void onEnderDragonChangePhase(EnderDragonChangePhaseEvent event) {

    }

    @Override
    public void onEntityAirChange(EntityAirChangeEvent event) {

    }

    @Override
    public void onEntityBreakDoor(EntityBreakDoorEvent event) {

    }

    @Override
    public void onEntityBreed(EntityBreedEvent event) {

    }

    @Override
    public void onEntityChangeBlock(EntityChangeBlockEvent event) {

    }

    @Override
    public void onEntityCombustByBlock(EntityCombustByBlockEvent event) {

    }

    @Override
    public void onEntityCombustByEntity(EntityCombustByEntityEvent event) {

    }

    @Override
    public void onEntityCombust(EntityCombustEvent event) {

    }

    @Override
    @Deprecated
    public void onEntityCreatePortal(EntityCreatePortalEvent event) {

    }

    @Override
    public void onEntityDamageByBlock(EntityDamageByBlockEvent event) {

    }

    @Override
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {

    }

    @Override
    public void onEntityDamage(EntityDamageEvent event) {

    }

    @Override
    public void onEntityDeath(EntityDeathEvent event) {

    }

    @Override
    public void onEntityDropItem(EntityDropItemEvent event) {

    }

    @Override
    public void onEntityEnterBlock(EntityEnterBlockEvent event) {

    }

    @Override
    public void onEntityEnterLoveMode(EntityEnterLoveModeEvent event) {

    }

    @Override
    public void onEntityExhaustion(EntityExhaustionEvent event) {

    }

    @Override
    public void onEntityExplode(EntityExplodeEvent event) {

    }

    @Override
    public void onEntityInteract(EntityInteractEvent event) {

    }

    @Override
    public void onEntityPickupItem(EntityPickupItemEvent event) {

    }

    @Override
    public void onEntityPlace(EntityPlaceEvent event) {

    }

    @Override
    public void onEntityPortalEnter(EntityPortalEnterEvent event) {

    }

    @Override
    public void onEntityPortal(EntityPortalEvent event) {

    }

    @Override
    public void onEntityPortalExit(EntityPortalExitEvent event) {

    }

    @Override
    public void onEntityPoseChange(EntityPoseChangeEvent event) {

    }

    @Override
    public void onEntityPotionEffect(EntityPotionEffectEvent event) {

    }

    @Override
    public void onEntityRegainHealth(EntityRegainHealthEvent event) {

    }

    @Override
    public void onEntityResurrect(EntityResurrectEvent event) {

    }

    @Override
    public void onEntityShootBow(EntityShootBowEvent event) {

    }

    @Override
    public void onEntitySpawn(EntitySpawnEvent event) {

    }

    @Override
    public void onEntitySpellCast(EntitySpellCastEvent event) {

    }

    @Override
    public void onEntityTame(EntityTameEvent event) {

    }

    @Override
    public void onEntityTarget(EntityTargetEvent event) {

    }

    @Override
    public void onEntityTargetLivingEntity(EntityTargetLivingEntityEvent event) {

    }

    @Override
    public void onEntityTeleport(EntityTeleportEvent event) {

    }

    @Override
    public void onEntityToggleGlide(EntityToggleGlideEvent event) {

    }

    @Override
    public void onEntityToggleSwim(EntityToggleSwimEvent event) {

    }

    @Override
    public void onEntityTransform(EntityTransformEvent event) {

    }

    @Override
    public void onEntityUnleash(EntityUnleashEvent event) {

    }

    @Override
    public void onExpBottle(ExpBottleEvent event) {

    }

    @Override
    public void onExplosionPrime(ExplosionPrimeEvent event) {

    }

    @Override
    public void onFireworkExplode(FireworkExplodeEvent event) {

    }

    @Override
    public void onFoodLevelChange(FoodLevelChangeEvent event) {

    }

    @Override
    public void onHorseJump(HorseJumpEvent event) {

    }

    @Override
    public void onItemDespawn(ItemDespawnEvent event) {

    }

    @Override
    public void onItemMerge(ItemMergeEvent event) {

    }

    @Override
    public void onItemSpawn(ItemSpawnEvent event) {

    }

    @Override
    public void onLingeringPotionSplash(LingeringPotionSplashEvent event) {

    }

    @Override
    public void onPiglinBarter(PiglinBarterEvent event) {

    }

    @Override
    public void onPigZap(PigZapEvent event) {

    }

    @Override
    public void onPigZombieAnger(PigZombieAngerEvent event) {

    }

    @Override
    public void onPlayerDeath(PlayerDeathEvent event) {

    }

    @Override
    public void onPlayerLeashEntity(PlayerLeashEntityEvent event) {

    }

    @Override
    public void onPotionSplash(PotionSplashEvent event) {

    }

    @Override
    public void onProjectileHit(ProjectileHitEvent event) {

    }

    @Override
    public void onProjectileLaunch(ProjectileLaunchEvent event) {

    }

    @Override
    public void onSheepDyeWool(SheepDyeWoolEvent event) {

    }

    @Override
    public void onSheepRegrowWool(SheepRegrowWoolEvent event) {

    }

    @Override
    public void onSlimeSplit(SlimeSplitEvent event) {

    }

    @Override
    public void onSpawnerSpawn(SpawnerSpawnEvent event) {

    }

    @Override
    public void onStriderTemperatureChange(StriderTemperatureChangeEvent event) {

    }

    @Override
    public void onVillagerAcquireTrade(VillagerAcquireTradeEvent event) {

    }

    @Override
    public void onVillagerCareerChange(VillagerCareerChangeEvent event) {

    }

    @Override
    public void onVillagerReplenishTrade(VillagerReplenishTradeEvent event) {

    }

    @Override
    public void onHangingBreakByEntity(HangingBreakByEntityEvent event) {

    }

    @Override
    public void onHangingBreak(HangingBreakEvent event) {

    }

    @Override
    public void onHangingPlace(HangingPlaceEvent event) {

    }

    @Override
    public void onBrew(BrewEvent event) {

    }

    @Override
    public void onBrewingStandFuel(BrewingStandFuelEvent event) {

    }

    @Override
    public void onCraftItem(CraftItemEvent event) {

    }

    @Override
    public void onFurnaceBurn(FurnaceBurnEvent event) {

    }

    @Override
    public void onFurnaceExtract(FurnaceExtractEvent event) {

    }

    @Override
    public void onFurnaceSmelt(FurnaceSmeltEvent event) {

    }

    @Override
    public void onFurnaceStartSmelt(FurnaceStartSmeltEvent event) {

    }

    @Override
    public void onInventoryClick(InventoryClickEvent event) {

    }

    @Override
    public void onInventoryClose(InventoryCloseEvent event) {

    }

    @Override
    public void onInventoryCreative(InventoryCreativeEvent event) {

    }

    @Override
    public void onInventoryDrag(InventoryDragEvent event) {

    }

    @Override
    public void onInventory(InventoryEvent event) {

    }

    @Override
    public void onInventoryMoveItem(InventoryMoveItemEvent event) {

    }

    @Override
    public void onInventoryOpen(InventoryOpenEvent event) {

    }

    @Override
    public void onInventoryPickupItem(InventoryPickupItemEvent event) {

    }

    @Override
    public void onPrepareAnvil(PrepareAnvilEvent event) {

    }

    @Override
    public void onPrepareItemCraft(PrepareItemCraftEvent event) {

    }

    @Override
    public void onPrepareSmithing(PrepareSmithingEvent event) {

    }

    @Override
    public void onSmithItem(SmithItemEvent event) {

    }

    @Override
    public void onTradeSelect(TradeSelectEvent event) {

    }

    @Override
    @Deprecated
    public void onAsyncPlayerChat(AsyncPlayerChatEvent event) {

    }

    @Override
    @Deprecated
    public void onAsyncPlayerChatPreview(AsyncPlayerChatPreviewEvent event) {

    }

    @Override
    public void onAsyncPlayerPreLogin(AsyncPlayerPreLoginEvent event) {

    }

    @Override
    public void onPlayerAdvancementDone(PlayerAdvancementDoneEvent event) {

    }

    @Override
    public void onPlayerAnimation(PlayerAnimationEvent event) {

    }

    @Override
    public void onPlayerArmorStandManipulate(PlayerArmorStandManipulateEvent event) {

    }

    @Override
    public void onPlayerAttemptPickupItem(PlayerAttemptPickupItemEvent event) {

    }

    @Override
    public void onPlayerBedEnter(PlayerBedEnterEvent event) {

    }

    @Override
    public void onPlayerBedLeave(PlayerBedLeaveEvent event) {

    }

    @Override
    public void onPlayerBucketEmpty(PlayerBucketEmptyEvent event) {

    }

    @Override
    public void onPlayerBucketEntity(PlayerBucketEntityEvent event) {

    }

    @Override
    public void onPlayerBucketFill(PlayerBucketFillEvent event) {

    }

    @Override
    @Deprecated
    public void onPlayerBucketFish(PlayerBucketFishEvent event) {

    }

    @Override
    public void onPlayerChangedMainHand(PlayerChangedMainHandEvent event) {

    }

    @Override
    public void onPlayerChangedWorld(PlayerChangedWorldEvent event) {

    }

    @Override
    @Deprecated
    public void onPlayerChat(PlayerChatEvent event) {

    }

    @Override
    @Deprecated
    public void onPlayerChatTabComplete(PlayerChatTabCompleteEvent event) {

    }

    @Override
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {

    }

    @Override
    public void onPlayerCommandSend(PlayerCommandSendEvent event) {

    }

    @Override
    public void onPlayerDropItem(PlayerDropItemEvent event) {

    }

    @Override
    public void onPlayerEditBook(PlayerEditBookEvent event) {

    }

    @Override
    public void onPlayerEggThrow(PlayerEggThrowEvent event) {

    }

    @Override
    public void onPlayerExpChange(PlayerExpChangeEvent event) {

    }

    @Override
    public void onPlayerFish(PlayerFishEvent event) {

    }

    @Override
    public void onPlayerGameModeChange(PlayerGameModeChangeEvent event) {

    }

    @Override
    public void onPlayerHarvestBlock(PlayerHarvestBlockEvent event) {

    }

    @Override
    public void onPlayerHideEntity(PlayerHideEntityEvent event) {

    }

    @Override
    public void onPlayerInteractAtEntity(PlayerInteractAtEntityEvent event) {

    }

    @Override
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {

    }

    @Override
    public void onPlayerInteract(PlayerInteractEvent event) {

    }

    @Override
    public void onPlayerItemBreak(PlayerItemBreakEvent event) {

    }

    @Override
    public void onPlayerItemConsume(PlayerItemConsumeEvent event) {

    }

    @Override
    public void onPlayerItemDamage(PlayerItemDamageEvent event) {

    }

    @Override
    public void onPlayerItemHeld(PlayerItemHeldEvent event) {

    }

    @Override
    public void onPlayerItemMend(PlayerItemMendEvent event) {

    }

    @Override
    public void onPlayerJoin(PlayerJoinEvent event) {

    }

    @Override
    public void onPlayerKick(PlayerKickEvent event) {

    }

    @Override
    public void onPlayerLevelChange(PlayerLevelChangeEvent event) {

    }

    @Override
    public void onPlayerLocaleChange(PlayerLocaleChangeEvent event) {

    }

    @Override
    public void onPlayerLogin(PlayerLoginEvent event) {

    }

    @Override
    public void onPlayerMove(PlayerMoveEvent event) {

    }

    @Override
    public void onPlayerPickupArrow(PlayerPickupArrowEvent event) {

    }

    @Override
    @Deprecated
    public void onPlayerPickupItem(PlayerPickupItemEvent event) {

    }

    @Override
    public void onPlayerPortal(PlayerPortalEvent event) {

    }

    @Override
    @Deprecated
    public void onPlayerPreLogin(PlayerPreLoginEvent event) {

    }

    @Override
    public void onPlayerQuit(PlayerQuitEvent event) {

    }

    @Override
    public void onPlayerRecipeDiscover(PlayerRecipeDiscoverEvent event) {

    }

    @Override
    public void onPlayerRegisterChannel(PlayerRegisterChannelEvent event) {

    }

    @Override
    public void onPlayerResourcePackStatus(PlayerResourcePackStatusEvent event) {

    }

    @Override
    public void onPlayerRespawn(PlayerRespawnEvent event) {

    }

    @Override
    public void onPlayerRiptide(PlayerRiptideEvent event) {

    }

    @Override
    public void onPlayerShearEntity(PlayerShearEntityEvent event) {

    }

    @Override
    public void onPlayerShowEntity(PlayerShowEntityEvent event) {

    }

    @Override
    public void onPlayerStatisticIncrement(PlayerStatisticIncrementEvent event) {

    }

    @Override
    public void onPlayerSwapHandItem(PlayerSwapHandItemsEvent event) {

    }

    @Override
    public void onPlayerTakeLecternBook(PlayerTakeLecternBookEvent event) {

    }

    @Override
    public void onPlayerTeleport(PlayerTeleportEvent event) {

    }

    @Override
    public void onPlayerToggleFlight(PlayerToggleFlightEvent event) {

    }

    @Override
    public void onPlayerToggleSneak(PlayerToggleSneakEvent event) {

    }

    @Override
    public void onPlayerToggleSprint(PlayerToggleSprintEvent event) {

    }

    @Override
    public void onPlayerUnleashEntity(PlayerUnleashEntityEvent event) {

    }

    @Override
    public void onPlayerUnregisterChannel(PlayerUnregisterChannelEvent event) {

    }

    @Override
    public void onPlayerVelocity(PlayerVelocityEvent event) {

    }

    @Override
    public void onRaidFinish(RaidFinishEvent event) {

    }

    @Override
    public void onRaidSpawnWave(RaidSpawnWaveEvent event) {

    }

    @Override
    public void onRaidStop(RaidStopEvent event) {

    }

    @Override
    public void onRaidTrigger(RaidTriggerEvent event) {

    }

    @Override
    public void onBroadcastMessage(BroadcastMessageEvent event) {

    }

    @Override
    public void onMapInitialize(MapInitializeEvent event) {

    }

    @Override
    public void onPluginDisable(PluginDisableEvent event) {

    }

    @Override
    public void onPluginEnable(PluginEnableEvent event) {

    }

    @Override
    public void onRemoteServerCommand(RemoteServerCommandEvent event) {

    }

    @Override
    public void onServerCommand(ServerCommandEvent event) {

    }

    @Override
    public void onServerListPing(ServerListPingEvent event) {

    }

    @Override
    public void onServerLoad(ServerLoadEvent event) {

    }

    @Override
    public void onServiceRegister(ServiceRegisterEvent event) {

    }

    @Override
    public void onServiceUnregister(ServiceUnregisterEvent event) {

    }

    @Override
    public void onTabComplete(TabCompleteEvent event) {

    }

    @Override
    public void onVehicleBlockCollision(VehicleBlockCollisionEvent event) {

    }

    @Override
    public void onVehicleCreate(VehicleCreateEvent event) {

    }

    @Override
    public void onVehicleDamage(VehicleDamageEvent event) {

    }

    @Override
    public void onVehicleDestroy(VehicleDestroyEvent event) {

    }

    @Override
    public void onVehicleEnter(VehicleEnterEvent event) {

    }

    @Override
    public void onVehicleEntityCollision(VehicleEntityCollisionEvent event) {

    }

    @Override
    public void onVehicleExit(VehicleExitEvent event) {

    }

    @Override
    public void onVehicleMove(VehicleMoveEvent event) {

    }

    @Override
    public void onVehicleUpdate(VehicleUpdateEvent event) {

    }

    @Override
    public void onLightningStrike(LightningStrikeEvent event) {

    }

    @Override
    public void onThunderChange(ThunderChangeEvent event) {

    }

    @Override
    public void onWeatherChange(WeatherChangeEvent event) {

    }

    @Override
    public void onChunkLoad(ChunkLoadEvent event) {

    }

    @Override
    public void onChunkPopulate(ChunkPopulateEvent event) {

    }

    @Override
    public void onChunkUnload(ChunkUnloadEvent event) {

    }

    @Override
    public void onEntitiesLoad(EntitiesLoadEvent event) {

    }

    @Override
    public void onEntitiesUnload(EntitiesUnloadEvent event) {

    }

    @Override
    public void onGenericGame(GenericGameEvent event) {

    }

    @Override
    public void onLootGenerate(LootGenerateEvent event) {

    }

    @Override
    public void onPortalCreate(PortalCreateEvent event) {

    }

    @Override
    public void onSpawnChange(SpawnChangeEvent event) {

    }

    @Override
    public void onStructureGrow(StructureGrowEvent event) {

    }

    @Override
    public void onTimeSkip(TimeSkipEvent event) {

    }

    @Override
    public void onWorldInit(WorldInitEvent event) {

    }

    @Override
    public void onWorldLoad(WorldLoadEvent event) {

    }

    @Override
    public void onWorldSave(WorldSaveEvent event) {

    }

    @Override
    public void onWorldUnload(WorldUnloadEvent event) {

    }

    @Override
    public void onEntityDismount(EntityDismountEvent event) {

    }

    @Override
    public void onEntityMount(EntityMountEvent event) {

    }

    @Override
    public void onPlayerSpawnLocation(PlayerSpawnLocationEvent event) {

    }

}
