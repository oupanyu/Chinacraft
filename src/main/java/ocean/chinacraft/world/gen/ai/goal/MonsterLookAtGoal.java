package ocean.chinacraft.world.gen.ai.goal;

import net.minecraft.command.EntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityStatuses;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.TargetPredicate;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.predicate.entity.EntityPredicates;
import ocean.chinacraft.items.armor.SilkNightArmor;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

public class MonsterLookAtGoal extends Goal {
    public static final float DEFAULT_PROBABILITY = 0.02F;
    protected final MobEntity mob;
    @Nullable
    protected Entity lookAt;
    protected final float lookDistance;
    private int lookTime;
    protected final float probability;
    private final boolean onlyHorizontal;
    protected final Class<? extends LivingEntity> lookAtType;
    protected final TargetPredicate lookAtContext;

    public MonsterLookAtGoal(MobEntity mob, Class<? extends LivingEntity> entity, float lookDistance) {
        this(mob, entity, lookDistance, 0.02F);
    }

    public MonsterLookAtGoal(MobEntity mob, Class<? extends LivingEntity> entity, float lookDistance, float probability) {
        this(mob, entity, lookDistance, probability, false);
    }

    public MonsterLookAtGoal(MobEntity mob, Class<? extends LivingEntity> entity, float lookDistance, float probability, boolean onlyHorizontal) {
        this.mob = mob;
        this.lookAtType = entity;
        this.lookDistance = lookDistance;
        this.probability = probability;
        this.onlyHorizontal = onlyHorizontal;
        this.setControls(EnumSet.of(Goal.Control.LOOK));
        if (entity == PlayerEntity.class) {
            this.lookAtContext =
                    TargetPredicate.createNonAttackable().setBaseMaxDistance(lookDistance).setPredicate((res) -> EntityPredicates.rides(mob).test(res));
        } else {
            this.lookAtContext = TargetPredicate.createNonAttackable().setBaseMaxDistance(lookDistance);
        }

    }

    @Override
    public boolean canStart() {
        if (this.mob.getRandom().nextFloat() >= this.probability) {
            return false;
        } else {
            if (this.mob.getTarget() != null) {
                this.lookAt = this.mob.getTarget();
            }
            if (this.lookAtType == PlayerEntity.class) {
                this.lookAt = this.mob.world.getClosestPlayer(this.lookAtContext, this.mob, this.mob.getX(), this.mob.getEyeY(),
                        this.mob.getZ());
            } else {
                this.lookAt = this.mob.world.getClosestEntity(this.mob.world.getEntitiesByClass(this.lookAtType,
                                this.mob.getBoundingBox().expand(this.lookDistance, 3.0D, this.lookDistance), (res) -> true),
                        this.lookAtContext
                        , this.mob, this.mob.getX(), this.mob.getEyeY(), this.mob.getZ());
            }
            return this.lookAt != null;
        }
    }

    @Override
    public boolean shouldContinue() {
        if (lookAt == null || !this.lookAt.isAlive()) {
            return false;
        } else if (lookAt != null && this.mob.distanceTo(this.lookAt) > (double) (this.lookDistance * this.lookDistance)) {
            return false;
        } else if (lookAt instanceof PlayerEntity player && SilkNightArmor.invalid(player)) {
            return false;
        } else {
            return this.lookTime > 0;
        }
    }

    @Override
    public void start() {
        this.lookTime = this.getTickCount(40 + this.mob.getRandom().nextInt(40));
    }

    @Override
    public void stop() {
        this.lookAt = null;
    }

    @Override
    public void tick() {
        if (lookAt != null && this.lookAt.isAlive()) {
            double d0 = this.onlyHorizontal ? this.mob.getEyeY() : this.lookAt.getEyeY();
            this.mob.getLookControl().lookAt(this.lookAt.getX(), d0, this.lookAt.getZ());
            --this.lookTime;
        }
    }
}
