package com.bloomhousemc.terrafabricraft.common.world.generator.feature;

import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import com.bloomhousemc.terrafabricraft.common.util.TFCUtils;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class BoulderFeature extends Feature<DefaultFeatureConfig> {
    public BoulderFeature(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        var topPos = context.getWorld().getTopPosition(Heightmap.Type.OCEAN_FLOOR_WG, context.getOrigin());
//        Direction offset = Direction.NORTH;
//
//        for (int y = 0; y < 15; y++) {
//            offset = offset.rotateYClockwise();
//            context.getWorld().setBlockState(topPos.up(y).offset(offset), Blocks.STONE.getDefaultState(), 3);
//        }


        var radius = MathHelper.nextInt(context.getRandom(), 1, 4);
        BlockPos blockPos1 = new BlockPos(MathHelper.nextInt(context.getRandom(), topPos.getX(), topPos.getX()+2), MathHelper.nextInt(context.getRandom(), topPos.getY(), topPos.getY()+2), MathHelper.nextInt(context.getRandom(), topPos.getZ(), topPos.getZ()+2));
        BlockPos blockPos2 = new BlockPos(MathHelper.nextInt(context.getRandom(), topPos.getX(), topPos.getX()+2), MathHelper.nextInt(context.getRandom(), topPos.getY(), topPos.getY()+2), MathHelper.nextInt(context.getRandom(), topPos.getZ(), topPos.getZ()+2));
        BlockPos blockPos3 = new BlockPos(MathHelper.nextInt(context.getRandom(), topPos.getX(), topPos.getX()+3), MathHelper.nextInt(context.getRandom(), topPos.getY(), topPos.getY()+3), MathHelper.nextInt(context.getRandom(), topPos.getZ(), topPos.getZ()+3));
        BlockPos blockPos4 = new BlockPos(MathHelper.nextInt(context.getRandom(), topPos.getX(), topPos.getX()+3), MathHelper.nextInt(context.getRandom(), topPos.getY(), topPos.getY()+3), MathHelper.nextInt(context.getRandom(), topPos.getZ(), topPos.getZ()+3));
        BlockPos blockPos5 = new BlockPos(MathHelper.nextInt(context.getRandom(), topPos.getX(), topPos.getX()+3), MathHelper.nextInt(context.getRandom(), topPos.getY(), topPos.getY()+3), MathHelper.nextInt(context.getRandom(), topPos.getZ(), topPos.getZ()+3));
        BlockPos blockPos6 = new BlockPos(MathHelper.nextInt(context.getRandom(), topPos.getX(), topPos.getX()+4), MathHelper.nextInt(context.getRandom(), topPos.getY(), topPos.getY()+4), MathHelper.nextInt(context.getRandom(), topPos.getZ(), topPos.getZ()+4));
        BlockPos blockPos7 = new BlockPos(MathHelper.nextInt(context.getRandom(), topPos.getX(), topPos.getX()+4), MathHelper.nextInt(context.getRandom(), topPos.getY(), topPos.getY()+4), MathHelper.nextInt(context.getRandom(), topPos.getZ(), topPos.getZ()+4));
        BlockPos blockPos8 = new BlockPos(MathHelper.nextInt(context.getRandom(), topPos.getX(), topPos.getX()+4), MathHelper.nextInt(context.getRandom(), topPos.getY(), topPos.getY()+4), MathHelper.nextInt(context.getRandom(), topPos.getZ(), topPos.getZ()+4));
        int random = MathHelper.nextInt(context.getRandom(), 1, 3);
        for (int x = 0; x < radius; x++)
            for (int y = 0; y < radius; y++)
                for (int z = 0; z < radius; z++) {
                    if( random == 1 ){
                        if (TFCUtils.shouldPlaceBlock(blockPos1,blockPos2,blockPos3,blockPos4,blockPos5,blockPos6,topPos.add(x,y,z),radius)){
                            context.getWorld().setBlockState(topPos.add(x, y, z), TFCUtils.getRandomRawStone(context.getRandom()), 3);
                        }
                    }else if(random == 2){
                        if(TFCUtils.shouldPlaceBlock(blockPos1,blockPos2,blockPos3,blockPos4,blockPos5,blockPos6,blockPos7,topPos.add(x,y,z),radius)){
                            context.getWorld().setBlockState(topPos.add(x, y, z), TFCUtils.getRandomRawStone(context.getRandom()), 3);
                        }
                    }else{
                        if(TFCUtils.shouldPlaceBlock(blockPos1,blockPos2,blockPos3,blockPos4,blockPos5,blockPos6,blockPos7,blockPos8,topPos.add(x,y,z),radius)){
                            context.getWorld().setBlockState(topPos.add(x, y, z), TFCUtils.getRandomRawStone(context.getRandom()), 3);
                        }
                    }

                }
        return true;
    }
}
