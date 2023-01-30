package ocean.chinacraft.mixin.entity;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.ai.goal.GoalSelector;
import net.minecraft.entity.mob.MobEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.selectors.TargetSelector;

@Mixin(MobEntity.class)
public interface MobEntityMixin {
    @Accessor
    GoalSelector getGoalSelector();

    @Accessor
    GoalSelector getTargetSelector();

}
