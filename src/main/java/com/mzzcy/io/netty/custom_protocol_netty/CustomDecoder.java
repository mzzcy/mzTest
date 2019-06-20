package com.mzzcy.io.netty.custom_protocol_netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;

/**
 * @author changyin.zhao on 6/19/19
 */
public class CustomDecoder extends ByteToMessageDecoder {

    private final int BASE_LENGTH = 28;

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf buffer, List<Object> out) throws Exception {
        //1. 首先确认可读长度大于基本长度
        int readableLength = buffer.readableBytes();
        if (readableLength > BASE_LENGTH) {

            System.out.println("开始 LENGTH：" + readableLength);

            //3. 记录阅读开始
            byte[] version = new byte[4];

            while (true) {
                System.out.println("开始查找头");

                buffer.readBytes(version);

                new String(version);

                if ("v1.0".equals(new String(version))) {
                    System.out.println("t_head:" + new String(version));
                    break;
                }

                System.out.println("t_head:" + new String(version));

                buffer.resetReaderIndex();
                buffer.readByte();

                if (buffer.readableBytes() < BASE_LENGTH) {
                    return;
                }
            }

            System.out.println("找到版本标识，读取元数据...");

            int length = buffer.readInt();

            //判断请求数据包是否到齐
            if (buffer.readableBytes() < length + 20) {
                buffer.resetReaderIndex();
                return;
            }

            //获取数据类型
            int dataType = buffer.readInt();

            byte[] sateId = new byte[5];

            buffer.readBytes(sateId);

            //跳过3字节保留字
            buffer.skipBytes(3);

            //时间戳
            long timestamp = buffer.readLong();

            System.out.println("读取完元数据，获取bmp数据：" + length);
            byte[] date = new byte[length];
            buffer.readBytes(date);
            CustomDate customDate =
                new CustomDate(new String(version), length, dataType, new String(sateId), timestamp, date);
            out.add(customDate);

        }

    }
}