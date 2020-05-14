package com.crmbl.arena_mod;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ArenaModBlocks {

    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, ArenaMod.MOD_ID);
    public static final RegistryObject<Block> RESPAWN_BLOCK = BLOCKS.register("respawn_block", () ->
        new RespawnBlock(Block.Properties.create(Material.ROCK)
            .hardnessAndResistance(5.0F)
            .sound(SoundType.STONE)
    ));
}
