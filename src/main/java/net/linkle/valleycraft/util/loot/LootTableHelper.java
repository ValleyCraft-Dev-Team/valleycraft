package net.linkle.valleycraft.util.loot;

import static net.linkle.valleycraft.Main.LOGGER;

import java.util.function.Consumer;

import com.google.common.collect.ArrayListMultimap;

import net.fabricmc.fabric.api.loot.v2.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.api.loot.v2.LootTableSource;
import net.linkle.valleycraft.mixin.LootBuilderMixin;
import net.minecraft.loot.LootManager;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;

/** Loot table helper using fabric's loot API. */
public class LootTableHelper {
    private static final ArrayListMultimap<Identifier, LootPool.Builder> APPEND_MAP = ArrayListMultimap.create(64, 5);
    private static final ArrayListMultimap<Identifier, Consumer<LootPool.Builder>> INJECT_MAP = ArrayListMultimap.create(64, 5);

    /** Create and append a new pool. */
    public static void appendLoot(Identifier lootID, LootBuilder loot) {
        APPEND_MAP.put(lootID, loot.build());
    }

    /** Inject pool with new entry. */
    public static void injectLoot(Identifier lootID, Consumer<LootPool.Builder> consumer) {
        INJECT_MAP.put(lootID, consumer);
    }
    
    private static void onLootLoad(ResourceManager resourceManager, LootManager lootManager, Identifier id, LootTable.Builder tableBuilder, LootTableSource source) {
        var inject = INJECT_MAP.get(id);
        if (inject != null) {
            var pools = ((LootBuilderMixin)tableBuilder).getPools();
            if (pools.isEmpty()) {
                LOGGER.warn("Unable inject loot for {}", id);
            } else {
                var pool = FabricLootPoolBuilder.copyOf(pools.get(0));
                inject.forEach(c->c.accept(pool));
                pools.set(0, pool.build());
            }
        }

        var append = APPEND_MAP.get(id);
        if (append != null) {
            append.forEach(tableBuilder::pool);
        }
    }
    
    static {
        LootTableEvents.MODIFY.register(LootTableHelper::onLootLoad);
    }
}