package ocean.chinacraft.world.gen.ai.goal;

import net.minecraft.advancement.criterion.TargetHitCriterion;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.brain.task.ConditionalTask;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.TrackTargetGoal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import ocean.chinacraft.items.armor.SilkNightArmor;
import ocean.chinacraft.util.ModUtil;

import java.util.List;
import java.util.function.Predicate;

public class AttackGoal extends TrackTargetGoal {

    private static final Predicate<LivingEntity> LIVING_ENTITY_SELECTOR =
            LivingEntity::isAttackable;

    private static final TargetPredicate TARGETING_CONDITIONS =
            TargetPredicate.createAttackable().setBaseMaxDistance(20).setPredicate(LIVING_ENTITY_SELECTOR);

    public AttackGoal(MobEntity mob, boolean checkVisibility) {
        super(mob, checkVisibility);
    }

    @Override
    public boolean canStart() {
        return true;
    }


    @Override
    public void tick() {
        LivingEntity target = mob.getTarget();
        if (target instanceof PlayerEntity player) {
            if (SilkNightArmor.invalid(player)) {
                List<MobEntity> mobEntities = ModUtil.getNearbyMobs(player, 20, TARGETING_CONDITIONS);
                for (MobEntity mob : mobEntities) {
                    if (mob.getTarget() != null && mob.getTarget().getUuid().equals(player.getUuid())) {
                        mob.setTarget(null);
                    }
                }
            }
        }
    }
}
