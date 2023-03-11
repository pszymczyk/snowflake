package com.pszymczyk.snowflake;

class LongConverters {

    static byte[] longToBytes(long currentMilis) {
        if (currentMilis > 281474976710655L) {
            throw new RuntimeException("dupa");
        }
        return new byte[]{
                (byte) ((currentMilis >> 56) & 0xFFL),
                (byte) ((currentMilis >> 48) & 0xFFL),
                (byte) ((currentMilis >> 40) & 0xFFL),
                (byte) ((currentMilis >> 32) & 0xFFL),
                (byte) ((currentMilis >> 24) & 0xFFL),
                (byte) ((currentMilis >> 16) & 0xFFL),
                (byte) ((currentMilis >> 8) & 0xFFL),
                (byte) ((currentMilis) & 0xFFL)
        };
    }

    static long longFromBytes(byte[] randomSnowflake) {
        return (randomSnowflake[0] & 0xFFL) << 56
                | (randomSnowflake[1] & 0xFFL) << 48
                | (randomSnowflake[2] & 0xFFL) << 40
                | (randomSnowflake[3] & 0xFFL) << 32
                | (randomSnowflake[4] & 0xFFL) << 24
                | (randomSnowflake[5] & 0xFFL) << 16
                | (randomSnowflake[6] & 0xFFL) << 8
                | (randomSnowflake[7] & 0xFFL);
    }
}
