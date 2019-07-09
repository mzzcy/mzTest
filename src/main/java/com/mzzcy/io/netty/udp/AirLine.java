package com.mzzcy.io.netty.udp;

/**
 * @author changyin.zhao on 6/20/19
 */
public class AirLine {

    private String version;
    private int dataLength;
    private int dataType;
    private String sateId;
    private long timestamp;
    private byte[] azimuth;
    private byte[] height;

    public AirLine(String version, int dataLength, int dataType, String sateId, long timestamp, byte[] azimuth,
        byte[] height) {
        this.version = version;
        this.dataLength = dataLength;
        this.dataType = dataType;
        this.sateId = sateId;
        this.timestamp = timestamp;
        this.azimuth = azimuth;
        this.height = height;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getDataLength() {
        return dataLength;
    }

    public void setDataLength(int dataLength) {
        this.dataLength = dataLength;
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

    public byte[] getAzimuth() {
        return azimuth;
    }

    public void setAzimuth(byte[] azimuth) {
        this.azimuth = azimuth;
    }

    public byte[] getHeight() {
        return height;
    }

    public void setHeight(byte[] height) {
        this.height = height;
    }
}
