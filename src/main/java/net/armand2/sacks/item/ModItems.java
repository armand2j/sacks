package net.armand2.sacks.item;

import net.armand2.sacks.Sacks;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public class ModItems {

    public static final Item SALT = registerItem("salt", Item::new);
    public static final Item PEPPER = registerItem("pepper", Item::new);


    private static Item registerItem(String name, Function<Item.Properties, Item> function) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(Sacks.MOD_ID, name),
                function.apply(new Item.Properties().setId(ResourceKey.create(Registries.ITEM , Identifier.fromNamespaceAndPath(Sacks.MOD_ID, name)))));
    }
    public static void registerModItems() {
        Sacks.LOGGER.info("Registering Mod Items for " + Sacks.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> {
            output.accept(SALT);
            output.accept(PEPPER);
        });
    }
}
