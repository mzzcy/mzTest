package com.mzzcy.io.netty.custom_protocol_netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;
import java.util.List;

/**
 * @author changyin.zhao on 6/20/19
 */
public class CustomDecoder2 extends ReplayingDecoder<Void> {

    private static final int HEAD_LENGTH = 28;

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf buffer, List<Object> out) throws Exception {
        //1. 首先确认可读长度大于基本长度
        int readableLength = buffer.readableBytes();
        if (readableLength > HEAD_LENGTH) {

            System.out.println("readableLength：" + readableLength);

            //3. 记录阅读开始
            byte[] version = new byte[4];

            while (true) {

                System.out.println("开始查找头");

                buffer.readBytes(version);

                if ("v1.0".equals(new String(version))) {
                    System.out.println("t_head:" + new String(version));
                    break;
                }

                System.out.println("t_head:" + new String(version));

                //没读到协议开头，退回到标记
                buffer.resetReaderIndex();
                //跳过一个字节
                buffer.readByte();

                //如果可读长度小于基本长度
                if (buffer.readableBytes() < HEAD_LENGTH) {
                    return;
                }
            }

            System.out.println("找到版本标识，读取元数据...");

            //获取消息的长度
            int length = buffer.readInt();
            System.out.println("数据长度：" + length);

            //获取数据类型
            int dataType = buffer.readInt();

            byte[] sateId = new byte[5];

            buffer.readBytes(sateId);

            //跳过3字节保留字
            buffer.skipBytes(3);

            //时间戳
            long timestamp = buffer.readLong();

            System.out.println("读取完元数据，获取bmp数据：" + buffer.readableBytes());
            byte[] date = new byte[length - HEAD_LENGTH];
            buffer.readBytes(date);
            CustomDate customDate =
                new CustomDate(new String(version), length - HEAD_LENGTH, dataType, new String(sateId), timestamp,
                    date);
            out.add(customDate);

        }

    }
}
