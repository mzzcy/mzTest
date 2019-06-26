package com.mzzcy.io.custom_protocol_netty;

/**
 * @author changyin.zhao on 6/19/19
 */
public enum Costom {
    HEAD_DATA;

    public int getValue() {
        switch (this) {
            case HEAD_DATA:
                return 1;
            default:
                return -1;
        }
    }
}
