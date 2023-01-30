package ocean.chinacraft.items.spell;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.sensor.NearestLivingEntitiesSensor;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.AttackGoal;
import net.minecraft.entity.ai.goal.GoalSelector;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import ocean.chinacraft.Chinacraft;
import ocean.chinacraft.mixin.entity.MobEntityMixin;

public class ChaoticSpell extends Item {
    public ChaoticSpell() {
        super(new FabricItemSettings().group(Chinacraft.ITEM_GROUP));
    }
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof PlayerEntity player && target.isAlive() && target instanceof MobEntity monster){
            GoalSelector targetSelector = ((MobEntityMixin)monster).getTargetSelector();
            targetSelector.add(0,new ActiveTargetGoal<>(monster, MobEntity.class,false));
        }
        if (attacker instanceof PlayerEntity player && !player.isCreative()){
            stack.decrement(1);
        }
        return true;
    }
}
