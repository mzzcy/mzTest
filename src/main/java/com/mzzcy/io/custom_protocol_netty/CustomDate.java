package com.mzzcy.io.custom_protocol_netty;

/**
 * @author changyin.zhao on 6/19/19
 */
public class CustomDate {

    /**
     * 消息开头的信息标志 是一个常量 X077
     */
    private final int head_Date = Costom.HEAD_DATA.getValue();
    //    private  final int head_Date = 1;

    /**
     * 消息的长度
     */
    private int contentLength;

    /**
     * 消息的内容
     */
    private byte[] conctent;

    public CustomDate() {
        super();
    }

    public CustomDate(int contentLength, byte[] conctent) {
        this.contentLength = contentLength;
        this.conctent = conctent;
    }

    public int getContentLength() {
        return contentLength;
    }

    public void setContentLength(int contentLength) {
        this.contentLength = contentLength;
    }

    public byte[] getConctent() {
        return conctent;
    }

    public void setConctent(byte[] conctent) {
        this.conctent = conctent;
    }

    public int getHead_Date() {
        return head_Date;
    }
}
