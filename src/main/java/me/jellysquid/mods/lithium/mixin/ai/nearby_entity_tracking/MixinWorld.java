package me.jellysquid.mods.lithium.mixin.ai.nearby_entity_tracking;

import me.jellysquid.mods.lithium.common.entity.tracker.EntityTrackerEngine;
import me.jellysquid.mods.lithium.common.entity.tracker.EntityTrackerEngineProvider;
import net.minecraft.util.profiler.Profiler;
import net.minecraft.world.MutableWorldProperties;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Extends the base world class to provide a {@link EntityTrackerEngine}.
 */
@Mixin(World.class)
public class MixinWorld implements EntityTrackerEngineProvider {
    private EntityTrackerEngine tracker;

    /**
     * Initialize the {@link EntityTrackerEngine} which all entities of the world will interact with.
     */
    @Inject(method = "<init>", at = @At("RETURN"))
    private void init(MutableWorldProperties mutableWorldProperties, DimensionType dimensionType, java.util.function.Supplier<Profiler> supplier, boolean bl, boolean bl2, long l, CallbackInfo ci) {
        this.tracker = new EntityTrackerEngine();
    }

    @Override
    public EntityTrackerEngine getEntityTracker() {
        return this.tracker;
    }
}
