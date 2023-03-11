package ocean.chinacraft;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.GoalSelector;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.PrioritizedGoal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import ocean.chinacraft.event.EntityJoinCallback;
import ocean.chinacraft.mixin.entity.MobEntityMixin;
import ocean.chinacraft.world.gen.ai.goal.AttackGoal;
import ocean.chinacraft.world.gen.ai.goal.MonsterLookAtGoal;

import java.util.Iterator;

public class ModEventRegister {
    public static void register(){
        EntityJoinCallback.EVENT.register((entity) -> {
            // create diamond item entity at sheep position
            Entity entity2 = entity;
            if (entity.isAlive() && entity instanceof Monster monster) {
                GoalSelector targetSelector = ((MobEntityMixin)monster).getTargetSelector();
                GoalSelector goalSelector = ((MobEntityMixin)monster).getGoalSelector();
                Iterator<PrioritizedGoal> iterator = goalSelector.getGoals().iterator();
                while (iterator.hasNext()) {
                    Goal nextGoal = iterator.next().getGoal();
                    if (nextGoal instanceof LookAtEntityGoal) {
                        goalSelector.getGoals().stream().filter((res) ->
                                res.getGoal() == nextGoal).filter(PrioritizedGoal::isRunning).forEach(PrioritizedGoal::stop);
                        iterator.remove();
                    }
                }
                targetSelector.add(2, new AttackGoal((MobEntity) monster, false));
                goalSelector.add(1, new MonsterLookAtGoal((MobEntity) monster, PlayerEntity.class, 8F));
            }
            return ActionResult.PASS;
        });
    }
}
