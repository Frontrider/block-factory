package hu.frontrider.blockfactory.mixin.client;

import hu.frontrider.blockfactory.client.ColorManager;
import net.minecraft.resource.ReloadableResourceManagerImpl;
import net.minecraft.resource.ResourceReloadListener;
import net.minecraft.resource.ResourceReloadMonitor;
import net.minecraft.util.Unit;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Mixin(ReloadableResourceManagerImpl.class)
public class ResourceManagerMixin {

    @Inject(at = @At("RETURN"),method = "beginReloadInner(Ljava/util/concurrent/Executor;Ljava/util/concurrent/Executor;Ljava/util/List;Ljava/util/concurrent/CompletableFuture;)Lnet/minecraft/resource/ResourceReloadMonitor;")
    private void reload(Executor executor_1, Executor executor_2, List<ResourceReloadListener> list_1, CompletableFuture<Unit> completableFuture_1, CallbackInfoReturnable<ResourceReloadMonitor> cir){
        ColorManager.getInstance().clear();
    }
}
