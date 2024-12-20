package net.Jackson.arcanemod.sound;

import net.Jackson.arcanemod.ArcaneMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ArcaneMod.MOD_ID);

    //sounds
    public static final RegistryObject<SoundEvent> GEMSTONE_RISE = registerSoundEvents("gemstone_rise");

// this is for creating soundTYPES for blocks, hitting, breaking, stepping on, etc.
//    public static final ForgeSoundType ARCANE_SOUNDS = new ForgeSoundType(1f,1f,
//            ModSounds.Blocksounds);

    public static final RegistryObject<SoundEvent> DYNASTIES_DYSTOPIA = registerSoundEvents("dynasties_dystopia");
    public static final RegistryObject<SoundEvent> MA_MEILLEUERE = registerSoundEvents("ma_meilleuere");
    public static final RegistryObject<SoundEvent> PLAYGROUND = registerSoundEvents("playground");


    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {

        return SOUND_EVENTS.register(name, ()-> SoundEvent.createVariableRangeEvent(new ResourceLocation(ArcaneMod.MOD_ID, name)));
    }


    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
