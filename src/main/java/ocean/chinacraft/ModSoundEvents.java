package ocean.chinacraft;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModSoundEvents {
    public static final SoundEvent FIRE_CRACKER = register("fire_cracker");
    public static final SoundEvent HMARW = register("high_mountains_and_running_water");
    public static final SoundEvent TPBMPTT = register("the_plum_blossom_melody_play_three_times");
    public static final SoundEvent SFAD = register("sunset_flute_and_drum");
    public static final SoundEvent AMIHP = register("autumn_moon_in_han_palace");
    public static final SoundEvent TSS = register("the_spring_snow");
    public static final SoundEvent DBTFATW = register("dialogue_between_the_fisherman_and_the_woodcutter");
    public static final SoundEvent ASFABRP = register("a_song_for_a_barbarian_reed_pipe");
    public static final SoundEvent GLV = register("guang_ling_verse");
    public static final SoundEvent WGFIP = register("wild_goose_falling_in_pingsha");
    public static final SoundEvent AOAS = register("ambush_on_all_sides");




    private static SoundEvent register(String id){
        return Registry.register(Registry.SOUND_EVENT,new Identifier(Chinacraft.MODID,id),new SoundEvent(new Identifier(Chinacraft.MODID,id)));
    }
    public static void register(){
        Chinacraft.LOGGER.info("registering SoundEvents...");
    }
}
