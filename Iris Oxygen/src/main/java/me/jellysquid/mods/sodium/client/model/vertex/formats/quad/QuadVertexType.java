package me.jellysquid.mods.sodium.client.model.vertex.formats.quad;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import me.jellysquid.mods.sodium.client.model.vertex.buffer.VertexBufferView;
import me.jellysquid.mods.sodium.client.model.vertex.formats.quad.writer.QuadVertexBufferWriterNio;
import me.jellysquid.mods.sodium.client.model.vertex.formats.quad.writer.QuadVertexBufferWriterUnsafe;
import me.jellysquid.mods.sodium.client.model.vertex.formats.quad.writer.QuadVertexWriterFallback;
import me.jellysquid.mods.sodium.client.model.vertex.type.BlittableVertexType;
import me.jellysquid.mods.sodium.client.model.vertex.type.VanillaVertexType;
//import net.minecraft.client.render.VertexConsumer;
//import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.renderer.vertex.VertexFormat;

public class QuadVertexType implements VanillaVertexType<QuadVertexSink>, BlittableVertexType<QuadVertexSink> {
    @Override
    public QuadVertexSink createFallbackWriter(IVertexBuilder consumer) {
        return new QuadVertexWriterFallback(consumer);
    }

    @Override
    public QuadVertexSink createBufferWriter(VertexBufferView buffer, boolean direct) {
        return direct ? new QuadVertexBufferWriterUnsafe(buffer) : new QuadVertexBufferWriterNio(buffer);
    }

    @Override
    public VertexFormat getVertexFormat() {
        return QuadVertexSink.VERTEX_FORMAT;
    }

    @Override
    public BlittableVertexType<QuadVertexSink> asBlittable() {
        return this;
    }
}
