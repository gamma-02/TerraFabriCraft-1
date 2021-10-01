package malek.terrafabricraft.common.item;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static malek.terrafabricraft.client.CalendarClient.minuteHand;

public class TFCFood extends Item {
    public int weigthCategory;
    public int sizeCategory;
    public TFCFood(String id, Settings settings, int weigthCategory, int sizeCategory) {
        super(settings);
        this.weigthCategory = weigthCategory;
        this.sizeCategory = sizeCategory;


    }
    public int getWeight(int weightCategory){
        return weightCategory == 0 ? 100 : weightCategory == 1 ? 150 : 200;
    }
    public String getSize(int sizeCategory){
        return sizeCategory == 0 ? "Small" : sizeCategory == 1 ? "Medium" : "Large";
    }


    @Override
    public void onCraft(ItemStack stack, World world, PlayerEntity player) {
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("tooltip.terrafabricraft.itemprop", new TranslatableText(String.valueOf(getWeight(this.weigthCategory))+"g"), new TranslatableText(String.valueOf(getSize(this.sizeCategory))), minuteHand));
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {

    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        return TypedActionResult.fail(user.getStackInHand(hand));
    }
}