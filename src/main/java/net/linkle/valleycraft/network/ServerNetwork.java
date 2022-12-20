package net.linkle.valleycraft.network;

import static net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking.*;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking.PlayChannelHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;

/** Handles server network packets using Fabric API. See {@link ClientNetwork} for the client side. */
public class ServerNetwork {

    // Initialize

    public static void initialize() {
        ServerPlayConnectionEvents.INIT.register(ServerNetwork::onPlayInit);
    }

    private static void onPlayInit(ServerPlayNetworkHandler handler, MinecraftServer server) {

    }

    // List of packet handlers

    // List of packet sender

    /**
     * Show the item on the player's screen like the Totem Of Undying. See
     * {@link ClientNetwork#showFloatingItem} where it sent to.
     */
    public static void sendFloatingItem(ServerPlayerEntity player, ItemStack stack) {
        send(player, Networks.FLOATING_ITEM, PacketByteBufs.create().writeItemStack(stack));
    }

    // Utilities

    private static void register(ServerPlayNetworkHandler network, Networks channel, PlayChannelHandler handler) {
        registerReceiver(network, channel.id, handler);
    }

    private static void send(ServerPlayerEntity player, Networks channel, PacketByteBuf buf) {
        ServerPlayNetworking.send(player, channel.id, buf);
    }
}
