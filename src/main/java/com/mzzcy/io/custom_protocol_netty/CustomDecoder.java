package com.mzzcy.io.custom_protocol_netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;

/**
 * @author changyin.zhao on 6/19/19
 */
public class CustomDecoder extends ByteToMessageDecoder {

    /**
     * 协议开始的标准head_data，int类型，占据4个字节. 表示数据的长度contentLength，int类型，占据4个字节.
     */

    private final int BASE_LENGTH = 4 + 4;

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf buffer, List<Object> out) throws Exception {
        //1. 首先确认可读长度大于基本长度
        int readableLength = buffer.readableBytes();
        if (readableLength > BASE_LENGTH) {

            System.out.println("开始 LENGTH：" + readableLength);
            //2.
            // 防止socket字节流攻击
            // 防止，客户端传来的数据过大
            // 因为，太大的数据，是不合理的
            if (buffer.readableBytes() > 2048) {
                //将readerIndex移动
                buffer = buffer.skipBytes(buffer.readableBytes());
            }

            //3. 记录阅读开始
            int beginRead;
            while (true) {

                System.out.println("开始查找头");

                //获取包头开始的index;
                beginRead = buffer.readerIndex();
                // 标记包头开始的index
                buffer.markReaderIndex();
                //如果读到了数据包的协议开头，那么就结束循环
                int t_head;
                if ((t_head = buffer.readInt()) == Costom.HEAD_DATA.getValue()) {
                    System.out.println("t_head:" + t_head);
                    break;
                }
                System.out.println("t_head:" + t_head);

                //没读到协议开头，退回到标记
                buffer.resetReaderIndex();
                //跳过一个字节
                buffer.readByte();

                //如果可读长度小于基本长度
                //
                if (buffer.readableBytes() < BASE_LENGTH) {
                    return;
                }
            }
            System.out.println("找到头，读取数据...");

            //获取消息的长度
            int length = buffer.readInt();

            //判断请求数据包是否到齐
            if (buffer.readableBytes() < length) {
                buffer.resetReaderIndex();
                return;
            }

            System.out.println("读取完数据，数据长度：" + length);
            byte[] date = new byte[length];
            buffer.readBytes(date);
            CustomDate customDate = new CustomDate(length, date);
            out.add(customDate);

        }

    }
}