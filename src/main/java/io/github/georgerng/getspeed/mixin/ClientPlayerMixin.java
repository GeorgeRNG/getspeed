package io.github.georgerng.getspeed.mixin;

import io.github.georgerng.getspeed.client.GetspeedClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Date;

@Mixin(PlayerEntity.class)
public abstract class ClientPlayerMixin {
    @Inject(method = "tick", at = @At("HEAD"))
    private void onTick(CallbackInfo ci) {
        Entity player = (Entity)(Object)this;
        GetspeedClient.LOGGER.info("%s %s:: POS: %s, VEL: %s, LEN: %s, GROUNDED: %b".formatted(new Date().getTime(), player.getEntityName(), player.getPos(), player.getVelocity(), player.getVelocity().length(), player.isOnGround()));
    }
}
