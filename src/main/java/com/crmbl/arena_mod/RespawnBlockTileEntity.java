package com.crmbl.arena_mod;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;

public class RespawnBlockTileEntity extends TileEntity {

    public RespawnBlockTileEntity() {
        super(ArenaModTileEntityTypes.RESPAWN_BLOCK_ENTITY.get());
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        return super.write(compound);
    }

    @Override
    public void read(CompoundNBT compound) {
        super.read(compound);
    }

    /*@Nullable
    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        CompoundNBT nbtTag = new CompoundNBT();
        return new SUpdateTileEntityPacket(getPos(), -1, nbtTag);
    }*/

    /*@Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
        CompoundNBT tag = pkt.getNbtCompound();
    }*/

    /*@Override
    public CompoundNBT getUpdateTag() {
        CompoundNBT tag = super.getUpdateTag();
        return tag;
    }*/

    /*@Override
    public void handleUpdateTag(CompoundNBT nbt) {
        super.handleUpdateTag(nbt);
    }*/
}
