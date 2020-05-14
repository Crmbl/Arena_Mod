package com.crmbl.arena_mod;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ArenaModTileEntityTypes {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, ArenaMod.MOD_ID);
    public static final RegistryObject<TileEntityType<?>> RESPAWN_BLOCK_ENTITY = TILE_ENTITIES.register("respawn_block", () ->
            TileEntityType.Builder.create(RespawnBlockTileEntity::new, ArenaModBlocks.RESPAWN_BLOCK.get()).build(null));
}