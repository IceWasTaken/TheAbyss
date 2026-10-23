package net.iskyla.abyss.mixin;

import net.iskyla.abyss.block.BlockRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.extensions.IBlockExtension;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(IBlockExtension.class)
public interface IBlockExtensionMixin {

	@Inject(method = "isConduitFrame", at = @At("HEAD"), cancellable = true)
	default void Abyss$isConduitFrame(BlockState state, LevelReader level, BlockPos pos, BlockPos conduit, CallbackInfoReturnable<Boolean> cir) {
		if(state.getBlock() == BlockRegistry.PRISMATIC_ROCK.get() ||
				state.getBlock() == BlockRegistry.AQUASLATE.get()
		) {
			cir.setReturnValue(true);
		}
	}
}
