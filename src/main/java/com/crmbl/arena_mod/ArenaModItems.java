package com.crmbl.arena_mod;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ArenaModItems {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, ArenaMod.MOD_ID);
    public static final RegistryObject<Item> RESPAWN_ITEM = ITEMS.register("respawn_block", () ->
            new BlockItem(ArenaModBlocks.RESPAWN_BLOCK.get(), new Item.Properties()
                    .group(ItemGroup.MISC)
            )
    );
}