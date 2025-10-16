package io.github.mooy1.infinityexpansion.items.storage;

import lombok.experimental.UtilityClass;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.mooy1.infinityexpansion.InfinityExpansion;
import io.github.mooy1.infinityexpansion.categories.Groups;
import io.github.mooy1.infinityexpansion.items.materials.Materials;
import io.github.mooy1.infinitylib.machines.MachineLore;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;

@UtilityClass
public final class Storage {

    public static final SlimefunItemStack STORAGE_FORGE = new SlimefunItemStack(
            "STORAGE_FORGE",
            Material.BEEHIVE,
            "&6Storage Forge",
            "&7Upgrades the tier of Storage Units",
            "&7Retains stored items"
    );

    private static final int BASIC_AMOUNT = 6400;
    private static final int ADVANCED_AMOUNT = 25600;
    private static final int REINFORCED_AMOUNT = 102400;
    private static final int VOID_AMOUNT = 409600;
    private static final int INFINITY_AMOUNT = 1_600_000_000;

    public static final SlimefunItemStack BASIC_STORAGE = new SlimefunItemStack(
            "BASIC_STORAGE",
            Material.OAK_WOOD,
            "&9Basic &8Storage Unit",
            "&6Capacity: &e" + MachineLore.format(BASIC_AMOUNT) + " &eitems"
    );
    public static final SlimefunItemStack ADVANCED_STORAGE = new SlimefunItemStack(
            "ADVANCED_STORAGE",
            Material.DARK_OAK_WOOD,
            "&cAdvanced &8Storage Unit",
            "&6Capacity: &e" + MachineLore.format(ADVANCED_AMOUNT) + " &eitems"
    );
    public static final SlimefunItemStack REINFORCED_STORAGE = new SlimefunItemStack(
            "REINFORCED_STORAGE",
            Material.ACACIA_WOOD,
            "&fReinforced &8Storage Unit",
            "&6Capacity: &e" + MachineLore.format(REINFORCED_AMOUNT) + " &eitems"
    );
    public static final SlimefunItemStack VOID_STORAGE = new SlimefunItemStack(
            "VOID_STORAGE",
            Material.CRIMSON_HYPHAE,
            "&8Void &8Storage Unit",
            "&6Capacity: &e" + MachineLore.format(VOID_AMOUNT) + " &eitems"
    );
    public static final SlimefunItemStack INFINITY_STORAGE = new SlimefunItemStack(
            "INFINITY_STORAGE",
            Material.WARPED_HYPHAE,
            "&bInfinity &8Storage Unit",
            "&6Capacity: &e" + MachineLore.format(INFINITY_AMOUNT) + " &eitems"
    );

    public static void setup(InfinityExpansion plugin) {
        new StorageForge(Groups.STORAGE, STORAGE_FORGE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
                Materials.MAGSTEEL.item().clone(), new ItemStack(Material.ANVIL), Materials.MAGSTEEL.item().clone(),
                Materials.MAGSTEEL.item().clone(), new ItemStack(Material.CRAFTING_TABLE), Materials.MAGSTEEL.item().clone(),
                Materials.MAGSTEEL.item().clone(), new ItemStack(Material.BARREL), Materials.MAGSTEEL.item().clone(),
        }).register(plugin);
        new StorageUnit(BASIC_STORAGE, BASIC_AMOUNT, new ItemStack[] {
                new ItemStack(Material.OAK_LOG), Materials.MAGSTEEL.item().clone(), new ItemStack(Material.OAK_LOG),
                new ItemStack(Material.OAK_LOG), new ItemStack(Material.BARREL), new ItemStack(Material.OAK_LOG),
                new ItemStack(Material.OAK_LOG), Materials.MAGSTEEL.item().clone(), new ItemStack(Material.OAK_LOG)
        }).register(plugin);
        new StorageUnit(ADVANCED_STORAGE, ADVANCED_AMOUNT, new ItemStack[] {
                Materials.MAGSTEEL.item().clone(), Materials.MACHINE_CIRCUIT.item().clone(), Materials.MAGSTEEL.item().clone(),
                Materials.MAGSTEEL.item().clone(), BASIC_STORAGE.item().clone(), Materials.MAGSTEEL.item().clone(),
                Materials.MAGSTEEL.item().clone(), Materials.MACHINE_CIRCUIT.item().clone(), Materials.MAGSTEEL.item().clone()
        }).register(plugin);
        new StorageUnit(REINFORCED_STORAGE, REINFORCED_AMOUNT, new ItemStack[] {
                Materials.MAGSTEEL_PLATE.item().clone(), Materials.MACHINE_CIRCUIT.item().clone(), Materials.MAGSTEEL_PLATE.item().clone(),
                Materials.MAGSTEEL_PLATE.item().clone(), ADVANCED_STORAGE.item().clone(), Materials.MAGSTEEL_PLATE.item().clone(),
                Materials.MAGSTEEL_PLATE.item().clone(), Materials.MACHINE_PLATE.item().clone(), Materials.MAGSTEEL_PLATE.item().clone()
        }).register(plugin);
        new StorageUnit(VOID_STORAGE, VOID_AMOUNT, new ItemStack[] {
                Materials.VOID_INGOT.item().clone(), Materials.MACHINE_PLATE.item().clone(), Materials.VOID_INGOT.item().clone(),
                Materials.MAGNONIUM.item().clone(), REINFORCED_STORAGE.item().clone(), Materials.MAGNONIUM.item().clone(),
                Materials.VOID_INGOT.item().clone(), Materials.MACHINE_CORE.item().clone(), Materials.VOID_INGOT.item().clone()
        }).register(plugin);
        new StorageUnit(INFINITY_STORAGE, INFINITY_AMOUNT, new ItemStack[] {
                Materials.INFINITE_INGOT.item().clone(), Materials.VOID_INGOT.item().clone(), Materials.INFINITE_INGOT.item().clone(),
                Materials.INFINITE_INGOT.item().clone(), VOID_STORAGE.item().clone(), Materials.INFINITE_INGOT.item().clone(),
                Materials.INFINITE_INGOT.item().clone(), Materials.VOID_INGOT.item().clone(), Materials.INFINITE_INGOT.item().clone()
        }).register(plugin);
    }

}
