package ocean.chinacraft.items.spell;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import ocean.chinacraft.Chinacraft;

public class NightSpell extends Item {
    public NightSpell() {
        super(new FabricItemSettings().group(Chinacraft.ITEM_GROUP));
    }

    int time = 20 * 8 * 60;

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (target.isAlive()){
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION,time,0,false,false));
        }
        if (attacker instanceof PlayerEntity player && !player.isCreative()){
            stack.decrement(1);
        }
        return true;
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        user.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION,time,0,false,false));
        ItemStack itemInHand = user.getStackInHand(hand);
        if (!itemInHand.isEmpty() && !user.isCreative()) {
            itemInHand.decrement(1);
        }
        return TypedActionResult.success(itemInHand);
    }
}
