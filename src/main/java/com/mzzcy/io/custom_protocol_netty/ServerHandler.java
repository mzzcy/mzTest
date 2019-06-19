package com.mzzcy.io.custom_protocol_netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * @author changyin.zhao on 6/19/19
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof CustomDate) {
            CustomDate customDate = (CustomDate)msg;
            byte[] conctent = customDate.getConctent();
            System.out.println("获取到的内容" + conctent[3]);
            ReferenceCountUtil.release(msg);
        }
    }
}