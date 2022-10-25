package net.linkle.valleycraft.network;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking.PlayChannelHandler;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.util.Identifier;

/** Handles client network packets using Fabric API. See {@link ServerNetwork} for the client side. */
@Environment(EnvType.CLIENT)
public class ClientNetwork {
    
    // Initialize
    
    public static void initialize() {
        ClientPlayConnectionEvents.INIT.register(ClientNetwork::onPlayInit);
    }
    
    private static void onPlayInit(ClientPlayNetworkHandler handler, MinecraftClient client) {
        register(Networks.FLOATING_ITEM, ClientNetwork::showFloatingItem);
    }
    
    // List of packet handlers
    
    /**
     * Show the item on player's screen like the Totem Of Undying. See
     * {@link ServerNetwork#sendFloatingItem} where it sent from.
     */
    private static void showFloatingItem(MinecraftClient client, ClientPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {
        var stack = buf.readItemStack();
        client.execute(()->{
            if (stack == null) return;
            client.gameRenderer.showFloatingItem(stack);
        });
    }
    
    // Utilities
    
    private static void register(Networks channel, PlayChannelHandler handler) {
        register(channel.id, handler);
    }
    
    private static void register(Identifier channel, PlayChannelHandler handler) {
        ClientPlayNetworking.registerReceiver(channel, handler);
    }
}
