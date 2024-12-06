package net.Jackson.arcanemod.item.custom;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PrecisionRuneItem extends Item {
    public PrecisionRuneItem(Properties pProperties) {
        super(pProperties);
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemstack = pPlayer.getItemInHand(InteractionHand.MAIN_HAND);

        if(!pLevel.isClientSide) {

            pPlayer.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 200, 5));
            pPlayer.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 200, 3));

            //change this to do less health damage if you are combined with a hexcore
            pPlayer.hurt(pLevel.damageSources().magic(), 6f);


        }else{
            pLevel.addParticle(
                    ParticleTypes.EXPLOSION,
                    pPlayer.getX(),
                    pPlayer.getY(),
                    pPlayer.getZ(),
                    0.0,
                    0.0,
                    0.0
            );

            pLevel.playSound(
                    pPlayer,
                    pPlayer.getX(),
                    pPlayer.getY(),
                    pPlayer.getZ(),
                    SoundEvents.BEACON_ACTIVATE,
                    SoundSource.PLAYERS,
                    1.6f,
                    1.0f
            );


        }




        return InteractionResultHolder.success(itemstack);





    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.arcanemod.world_rune_precision.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);

}}
