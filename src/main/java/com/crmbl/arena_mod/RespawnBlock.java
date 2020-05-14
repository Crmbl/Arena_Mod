package com.crmbl.arena_mod;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Optional;

public class RespawnBlock extends HorizontalBlock {
    public static final DirectionProperty HORIZONTAL_FACING = BlockStateProperties.HORIZONTAL_FACING;

    public RespawnBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ArenaModTileEntityTypes.RESPAWN_BLOCK_ENTITY.get().create();
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult result) {
        super.onBlockActivated(state, worldIn, pos, player, handIn, result);
        if (player instanceof ServerPlayerEntity)
            player.setSpawnPoint(pos, true, true, player.dimension);

        return ActionResultType.SUCCESS;
    }

    @Override
    public boolean isBed(BlockState state, IBlockReader world, BlockPos pos, @Nullable Entity player) {
        return true;
    }

    @Override
    public Optional<Vec3d> getBedSpawnPosition(EntityType<?> entityType, BlockState state, IWorldReader world, BlockPos pos, @Nullable LivingEntity sleeper) {
        Direction direction = world.getBlockState(pos).get(HORIZONTAL_FACING);
        int i = pos.getX();
        int j = pos.getY();
        int k = pos.getZ();

        for(int l = 0; l <= 1; ++l) {
            int i1 = i - direction.getXOffset() * l - 1;
            int j1 = k - direction.getZOffset() * l - 1;
            int k1 = i1 + 2;
            int l1 = j1 + 2;

            for(int i2 = i1; i2 <= k1; ++i2) {
                for(int j2 = j1; j2 <= l1; ++j2) {
                    BlockPos blockpos = new BlockPos(i2, j, j2);
                    Optional<Vec3d> optional = func_220175_a(entityType, world, blockpos);
                    if (optional.isPresent()) {
                        return optional;
                    }
                }
            }
        }

        return Optional.empty();
    }

    protected static Optional<Vec3d> func_220175_a(EntityType<?> p_220175_0_, IWorldReader p_220175_1_, BlockPos p_220175_2_) {
        VoxelShape voxelshape = p_220175_1_.getBlockState(p_220175_2_).getCollisionShape(p_220175_1_, p_220175_2_);
        if (voxelshape.getEnd(Direction.Axis.Y) > 0.4375D) {
            return Optional.empty();
        } else {
            BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable(p_220175_2_);

            while(blockpos$mutable.getY() >= 0 && p_220175_2_.getY() - blockpos$mutable.getY() <= 2 && p_220175_1_.getBlockState(blockpos$mutable).getCollisionShape(p_220175_1_, blockpos$mutable).isEmpty()) {
                blockpos$mutable.move(Direction.DOWN);
            }

            VoxelShape voxelshape1 = p_220175_1_.getBlockState(blockpos$mutable).getCollisionShape(p_220175_1_, blockpos$mutable);
            if (voxelshape1.isEmpty()) {
                return Optional.empty();
            } else {
                double d0 = (double)blockpos$mutable.getY() + voxelshape1.getEnd(Direction.Axis.Y) + 2.0E-7D;
                if ((double)p_220175_2_.getY() - d0 > 2.0D) {
                    return Optional.empty();
                } else {
                    float f = p_220175_0_.getWidth() / 2.0F;
                    Vec3d vec3d = new Vec3d((double)blockpos$mutable.getX() + 0.5D, d0, (double)blockpos$mutable.getZ() + 0.5D);
                    return p_220175_1_.func_226664_a_(new AxisAlignedBB(vec3d.x - (double)f, vec3d.y, vec3d.z - (double)f, vec3d.x + (double)f, vec3d.y + (double)p_220175_0_.getHeight(), vec3d.z + (double)f)) ? Optional.of(vec3d) : Optional.empty();
                }
            }
        }
    }
}