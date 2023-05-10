package net.linkle.valleycraft.villager;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.linkle.valleycraft.init.FoodIngredients;
import net.linkle.valleycraft.init.FoodRegular;
import net.linkle.valleycraft.init.ItemsModded;
import net.linkle.valleycraft.init.Tools;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;

public class CustomTradeRegistry {

    public static void setupTrades() {
        registerCustomTrades();
        registerWanderingTrades();
    }

    private static void registerWanderingTrades() {
//        TradeOfferHelper.registerWanderingTraderOffers(0, factories -> {
//            factories.add(((entity, random) -> new TradeOffer(
//                    new ItemStack(Items.EMERALD, 8),
//                    new ItemStack(Items.SADDLE, 1),
//                    10, 2, 0.02f)));
//        });
    }

    private static void registerCustomTrades() {

        TradeOfferHelper.registerVillagerOffers(ModVillagers.STABLEHAND, 1,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 8),
                            new ItemStack(Items.SADDLE, 1),
                            10, 2, 0.02f)));

                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.WHEAT, 20),
                            new ItemStack(Items.EMERALD, 1),
                            16, 2, 0.05f)));

                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.STABLEHAND, 2,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 1),
                            new ItemStack(Items.LEAD, 2),
                            16, 5, 0.08f)));
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 3),
                            new ItemStack(ItemsModded.ARROW_BUNDLE, 1),
                            10, 5, 0.02f)));

                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.CARROT, 20),
                            new ItemStack(Items.EMERALD, 1),
                            16, 5, 0.05f)));
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(FoodIngredients.ENDURA_CARROT, 1),
                            new ItemStack(Items.EMERALD, 1),
                            16, 5, 0.05f)));

                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 1),
                            new ItemStack(FoodRegular.HARDTACK, 8),
                            16, 5, 0.05f)));
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 1),
                            new ItemStack(Items.APPLE, 8),
                            16, 5, 0.05f)));
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 1),
                            new ItemStack(Items.SUGAR, 16),
                            16, 5, 0.05f)));
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 1),
                            new ItemStack(FoodRegular.BAKED_CARROT, 10),
                            16, 5, 0.05f)));

                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 3),
                            new ItemStack(Items.GOLDEN_CARROT, 1),
                            16, 5, 0.05f)));
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 1),
                            new ItemStack(FoodRegular.VEGETABLE_MIX, 3),
                            16, 5, 0.05f)));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.STABLEHAND, 3,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 12),
                            new ItemStack(Items.LEATHER, 5),
                            new ItemStack(Items.LEATHER_HORSE_ARMOR, 1),
                            1, 20, 0.05f)));
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 12),
                            new ItemStack(ItemsModded.SHEEP_HIDE, 5),
                            new ItemStack(Items.LEATHER_HORSE_ARMOR, 1),
                            1, 20, 0.05f)));
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 5),
                            new ItemStack(Tools.CLIMBING_AXE, 1),
                            5, 20, 0.05f)));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.STABLEHAND, 4,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 3),
                            new ItemStack(FoodIngredients.ENDURA_CARROT, 1),
                            16, 30, 0.05f)));
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 5),
                            new ItemStack(FoodRegular.GOLDEN_ENDURA_CARROT, 1),
                            16, 30, 0.05f)));
                });

        TradeOfferHelper.registerVillagerOffers(ModVillagers.STABLEHAND, 5,
                factories -> {
                    factories.add(((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 16),
                            new ItemStack(Items.GOLD_INGOT, 6),
                            new ItemStack(Items.GOLDEN_HORSE_ARMOR, 1),
                            1, 50, 0.05f)));
                });
    }
}
