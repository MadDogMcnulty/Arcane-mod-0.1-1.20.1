package net.Jackson.arcanemod.item.custom;

import net.Jackson.arcanemod.sound.ModSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RefinedGemstoneItem extends Item {
    public RefinedGemstoneItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        ItemStack itemstack = pPlayer.getItemInHand(InteractionHand.MAIN_HAND);

        if (!pLevel.isClientSide) {


            //gemstone sound effect
            pLevel.playSeededSound(null, pPlayer.getX(),pPlayer.getY(), pPlayer.getZ(),
                    ModSounds.GEMSTONE_RISE.get(), SoundSource.BLOCKS,4f,1f,0);


            double radius = 6.0;
            AABB boundingBox = new AABB(
                    pPlayer.getX() - radius, pPlayer.getY() - radius, pPlayer.getZ() - radius,
                    pPlayer.getX() + radius, pPlayer.getY() + radius, pPlayer.getZ() + radius
            );

            // Retrieve all mobs within the bounding box
            List<Mob> nearbyMobs = pLevel.getEntitiesOfClass(Mob.class, boundingBox);

            // Position in front of the player (adjust as needed)
            double knockbackDistance = 1.0; // Distance in front of the player
            double knockbackX = pPlayer.getX() + pPlayer.getLookAngle().x * knockbackDistance;
            double knockbackZ = pPlayer.getZ() + pPlayer.getLookAngle().z * knockbackDistance;
            double knockbackY = pPlayer.getY() + 0;

            // Apply levitation to the player
            pPlayer.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 100, 1));

            double pDeltaX = pPlayer.getX() - knockbackX;
            double pDeltaY = pPlayer.getY() - knockbackY; // Include Y-axis
            double pDeltaZ = pPlayer.getZ() - knockbackZ;

// Calculate the total 3D distance (X, Y, Z)
            double pDistance = Math.sqrt(pDeltaX * pDeltaX + pDeltaY * pDeltaY + pDeltaZ * pDeltaZ);

            if (pDistance > 0) {
                double knockbackStrength = 1.5; // Strength of the knockback
                // Push the player
                pPlayer.push(
                        (pDeltaX / pDistance) * knockbackStrength,
                        2.5, // Add upward force
                        (pDeltaZ / pDistance) * knockbackStrength
                );

                // Debugging: Print new velocity
                System.out.println("Player knockback: " + pPlayer.getDeltaMovement());
            }

            // Apply levitation and knockback to mobs
            for (Mob mob : nearbyMobs) {
                mob.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 100, 1));

                // Calculate knockback direction for each mob
                double deltaX = mob.getX() - knockbackX;
                double deltaZ = mob.getZ() - knockbackZ;
                double distance = Math.sqrt(deltaX * deltaX + deltaZ * deltaZ);

                if (distance > 0) {
                    double knockbackStrength = 1.5; // Strength of the knockback
                    mob.setDeltaMovement(
                            mob.getDeltaMovement().x + (deltaX / distance) * knockbackStrength,
                            mob.getDeltaMovement().y + 0.5, // Add upward force
                            mob.getDeltaMovement().z + (deltaZ / distance) * knockbackStrength
                    );
                }
            }



        }

        return InteractionResultHolder.success(itemstack);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.arcanemod.refined_gemstone.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
