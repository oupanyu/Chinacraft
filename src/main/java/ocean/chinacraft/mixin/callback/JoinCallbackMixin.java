package ocean.chinacraft.mixin.callback;

import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.ActionResult;
import ocean.chinacraft.event.EntityJoinCallback;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientWorld.class)
public abstract class JoinCallbackMixin {


    @Shadow protected abstract void addEntityPrivate(int id, Entity entity);

    @Inject(method = "addEntity", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/world/ClientWorld;addEntityPrivate(ILnet/minecraft/entity/Entity;)V"))
    /*private void onShear(final PlayerEntity player, final Hand hand, final CallbackInfoReturnable<Boolean> info) {
        ActionResult result = SheepShearCallback.EVENT.invoker().interact(player, (SheepEntity) (Object) this);

        if(result == ActionResult.FAIL) {
            info.cancel();
        }
    }*/
    public void addEntity(int id, Entity entity, CallbackInfo ci) {
        this.addEntityPrivate(id, entity);
        if (entity instanceof MobEntity mobEntity){
            ActionResult result = EntityJoinCallback.EVENT.invoker().interact(mobEntity);

        }

    }
}
