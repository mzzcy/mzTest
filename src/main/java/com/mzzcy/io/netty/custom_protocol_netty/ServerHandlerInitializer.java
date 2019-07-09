package com.mzzcy.io.netty.custom_protocol_netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;

/**
 * @author changyin.zhao on 6/19/19
 */
public class ServerHandlerInitializer extends ChannelInitializer<Channel> {

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new CustomDecoder2());
        pipeline.addLast(new CustomEncoder());
        pipeline.addLast(new ServerHandler());

    }
}