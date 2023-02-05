package net.linkle.valleycraft.villager;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.linkle.valleycraft.init.*;
import net.minecraft.item.ItemStack;
import net.minecraft.village.TradeOffer;

public class CustomTradeRegistry {

    public static void setupTrades() {
        RegisterCustomTrades();
    }

    private static void RegisterCustomTrades() {

        TradeOfferHelper.registerVillagerOffers(ModVillagers.STABLEHAND, 1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(net.minecraft.item.Items.EMERALD, 8),
                            new ItemStack(net.minecraft.item.Items.SADDLE, 1),
                            10, 2, 0.02f)));

                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(net.minecraft.item.Items.WHEAT, 20),
                            new ItemStack(net.minecraft.item.Items.EMERALD, 1),
                            16, 2, 0.05f)));

                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.STABLEHAND, 2,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(net.minecraft.item.Items.EMERALD, 1),
                            new ItemStack(net.minecraft.item.Items.LEAD, 2),
                            16, 5, 0.08f)));
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(net.minecraft.item.Items.EMERALD, 3),
                            new ItemStack(ItemsModded.ARROW_BUNDLE, 1),
                            10, 5, 0.02f)));

                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(net.minecraft.item.Items.CARROT, 20),
                            new ItemStack(net.minecraft.item.Items.EMERALD, 1),
                            16, 5, 0.05f)));
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(FoodIngredients.ENDURA_CARROT, 1),
                            new ItemStack(net.minecraft.item.Items.EMERALD, 1),
                            16, 5, 0.05f)));

                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(net.minecraft.item.Items.EMERALD, 1),
                            new ItemStack(FoodRegular.HARDTACK, 8),
                            16, 5, 0.05f)));
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(net.minecraft.item.Items.EMERALD, 1),
                            new ItemStack(net.minecraft.item.Items.APPLE, 8),
                            16, 5, 0.05f)));
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(net.minecraft.item.Items.EMERALD, 1),
                            new ItemStack(net.minecraft.item.Items.SUGAR, 16),
                            16, 5, 0.05f)));
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(net.minecraft.item.Items.EMERALD, 1),
                            new ItemStack(FoodRegular.BAKED_CARROT, 10),
                            16, 5, 0.05f)));

                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(net.minecraft.item.Items.EMERALD, 3),
                            new ItemStack(net.minecraft.item.Items.GOLDEN_CARROT, 1),
                            16, 5, 0.05f)));
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(net.minecraft.item.Items.EMERALD, 1),
                            new ItemStack(FoodRegular.VEGETABLE_MIX, 3),
                            16, 5, 0.05f)));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.STABLEHAND, 3,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(net.minecraft.item.Items.EMERALD, 12),
                            new ItemStack(net.minecraft.item.Items.LEATHER, 5),
                            new ItemStack(net.minecraft.item.Items.LEATHER_HORSE_ARMOR, 1),
                            1, 20, 0.05f)));
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(net.minecraft.item.Items.EMERALD, 12),
                            new ItemStack(ItemsModded.SHEEP_HIDE, 5),
                            new ItemStack(net.minecraft.item.Items.LEATHER_HORSE_ARMOR, 1),
                            1, 20, 0.05f)));
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(net.minecraft.item.Items.EMERALD, 5),
                            new ItemStack(Tools.CLIMBING_AXE, 1),
                            5, 20, 0.05f)));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.STABLEHAND, 4,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(net.minecraft.item.Items.EMERALD, 3),
                            new ItemStack(FoodIngredients.ENDURA_CARROT, 1),
                            16, 30, 0.05f)));
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(net.minecraft.item.Items.EMERALD, 5),
                            new ItemStack(FoodRegular.GOLDEN_ENDURA_CARROT, 1),
                            16, 30, 0.05f)));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.STABLEHAND, 5,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(net.minecraft.item.Items.EMERALD, 16),
                            new ItemStack(net.minecraft.item.Items.GOLD_INGOT, 6),
                            new ItemStack(net.minecraft.item.Items.GOLDEN_HORSE_ARMOR, 1),
                            1, 50, 0.05f)));
                });
    }
}
