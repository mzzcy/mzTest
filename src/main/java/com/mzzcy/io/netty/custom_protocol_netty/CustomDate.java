package com.mzzcy.io.netty.custom_protocol_netty;

/**
 * @author changyin.zhao on 6/19/19
 */

public class CustomDate {

    private String version;
    private int bmpLength;
    private int dataType;
    private String sateId;
    private long timestamp;
    private byte[] bmp;

    public CustomDate(String version, int bmpLength, int dataType, String sateId, long timestamp, byte[] bmp) {
        this.version = version;
        this.bmpLength = bmpLength;
        this.dataType = dataType;
        this.sateId = sateId;
        this.timestamp = timestamp;
        this.bmp = bmp;
    }

    public CustomDate() {
        super();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getBmpLength() {
        return bmpLength;
    }

    public void setBmpLength(int bmpLength) {
        this.bmpLength = bmpLength;
    }

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public String getSateId() {
        return sateId;
    }

    public void setSateId(String sateId) {
        this.sateId = sateId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public byte[] getBmp() {
        return bmp;
    }

    public void setBmp(byte[] bmp) {
        this.bmp = bmp;
    }
}
