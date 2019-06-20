package com.mzzcy.io.netty.udp;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;

/**
 * @author changyin.zhao on 6/20/19
 */
public class UDPServer {
    public static void main(String[] args) {
        try {
            Bootstrap b = new Bootstrap();
            EventLoopGroup group = new NioEventLoopGroup();
            b.group(group).channel(NioDatagramChannel.class).option(ChannelOption.SO_BROADCAST, true)
                .handler(new UdpServerHandler());

            b.bind(9091).sync().channel().closeFuture().await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class UdpServerHandler extends SimpleChannelInboundHandler<DatagramPacket> {

        @Override
        protected void channelRead0(ChannelHandlerContext ctx, DatagramPacket packet) throws Exception {
            ByteBuf buf = packet.copy().content();
            //            byte[] req = new byte[buf.readableBytes()];
            //            buf.readBytes(req);
            //            String body = new String(req, "UTF-8");
            //
            //            System.out.println(body);

            handleData(buf);

            //向客户端发送消息
            //            String json = "来自服务端: 南无阿弥陀佛";
            //            // 由于数据报的数据是以字符数组传的形式存储的，所以传转数据
            //            byte[] bytes = json.getBytes("UTF-8");
            //            DatagramPacket data = new DatagramPacket(Unpooled.copiedBuffer(bytes), packet.sender());
            //            ctx.writeAndFlush(data);//向客户端发送消息

        }
    }

    private static void handleData(ByteBuf byteBuf) {
        int PACKET_LENGTH = 36;
        if (byteBuf.readableBytes() < PACKET_LENGTH) {
            System.out.println("Bad packet, length is: " + byteBuf.readableBytes());
            return;
        }

        System.out.println("Get packet, begin analysing: " + byteBuf.readableBytes());

        byte[] version = new byte[4];
        byteBuf.readBytes(version);

        int length = byteBuf.readInt();

        int dataType = byteBuf.readInt();

        byte[] sateId = new byte[5];

        byteBuf.readBytes(sateId);

        byteBuf.skipBytes(3);

        //时间戳
        long timestamp = byteBuf.readLong();

        byte[] azimuth = new byte[4];
        byteBuf.readBytes(azimuth);

        byte[] height = new byte[4];
        byteBuf.readBytes(height);

        AirLine airLine =
            new AirLine(new String(version), length, dataType, new String(sateId), timestamp, azimuth, height);

        System.out.println(airLine.getSateId());
        System.out.println(new String(airLine.getHeight()));

    }

}
