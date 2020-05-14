package com.crmbl.arena_mod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("arena_mod")
public class ArenaMod
{
    public static final String MOD_ID = "arena_mod";

    public ArenaMod() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onClientSetup);
        MinecraftForge.EVENT_BUS.register(this);
        ArenaModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ArenaModBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ArenaModTileEntityTypes.TILE_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    private void onClientSetup(final FMLClientSetupEvent event) {
        //ClientRegistry.bindTileEntityRenderer(CommandSignModEntityType.COMMAND_SIGN_TILE_ENTITY.get(), CommandSignTileEntityRenderer::new);
    }
}