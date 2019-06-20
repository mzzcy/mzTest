package com.mzzcy.io.netty.custom_protocol_netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @author changyin.zhao on 6/19/19
 */
public class ServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof CustomDate) {
            CustomDate customDate = (CustomDate)msg;
            System.out.println("获取到的内容" + customDate.getSateId());
            OutputStream out = new FileOutputStream("/home/mzzcy/Desktop/tcp_test.bmp");

            //读取数据
            out.write(customDate.getBmp(), 0, customDate.getBmpLength());
            System.out.println("保存成功.");
            out.flush();
            out.close();

            ReferenceCountUtil.release(msg);
        }
    }
}