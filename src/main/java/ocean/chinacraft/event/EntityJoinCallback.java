package ocean.chinacraft.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import ocean.chinacraft.mixin.entity.MobEntityMixin;
import ocean.chinacraft.world.gen.ai.goal.AttackGoal;
import ocean.chinacraft.world.gen.ai.goal.MonsterLookAtGoal;

import java.util.Iterator;

public interface EntityJoinCallback {
    Event<EntityJoinCallback> EVENT = EventFactory.createArrayBacked(EntityJoinCallback.class,
            (listeners) -> (entity) -> {
                for (EntityJoinCallback listener : listeners) {
                        ActionResult result = listener.interact(entity);

                        if(result != ActionResult.PASS) {
                            return result;
                        }
                }

                return ActionResult.PASS;
            });

    ActionResult interact(MobEntity entity);
}
