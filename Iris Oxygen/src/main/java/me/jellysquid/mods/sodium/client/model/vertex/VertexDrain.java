package me.jellysquid.mods.sodium.client.model.vertex;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import me.jellysquid.mods.sodium.client.model.vertex.type.VertexType;
//import net.minecraft.client.render.VertexConsumer;

/**
 * A drain allows the instantiation of {@link VertexSink} and is implemented on outputs which take vertex data.
 */
public interface VertexDrain {
    /**
     * Returns a {@link VertexDrain} implementation on the provided {@link IVertexBuilder}. Since the interface
     * is always implemented on a given VertexConsumer, this is simply implemented as a cast internally.
     * @param consumer The {@link IVertexBuilder}
     * @return A {@link VertexDrain}
     */
    static VertexDrain of(IVertexBuilder consumer) {
        return (VertexDrain) consumer;
    }

    /**
     * Returns a {@link VertexSink} of type {@link T}, created from {@param factory}, which transforms and writes
     * vertices through this vertex drain.
     *
     * @param factory The factory to create a vertex sink using
     * @param <T> The vertex sink's type
     * @return A new {@link VertexSink} of type {@link T}
     */
    <T extends VertexSink> T createSink(VertexType<T> factory);
}

