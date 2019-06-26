package com.mzzcy.io.custom_protocol_netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author changyin.zhao on 6/19/19
 */
public class CustomEncoder extends MessageToByteEncoder<CustomDate> {

    @Override
    protected void encode(ChannelHandlerContext ctx, CustomDate msg, ByteBuf out) throws Exception {
        out.writeInt(msg.getHead_Date());
        out.writeInt(msg.getContentLength());
        out.writeBytes(msg.getConctent());
    }
}