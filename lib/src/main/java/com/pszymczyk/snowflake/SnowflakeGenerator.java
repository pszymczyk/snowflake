package com.pszymczyk.snowflake;

import java.time.Clock;
import java.util.function.Supplier;

public final class SnowflakeGenerator {

    private final byte machineId;
    private final Supplier<Long> currentMilisSupplier;
    private byte localCounter = 127;


    public SnowflakeGenerator(byte machineId, Clock clock) {
        this(machineId, clock::millis);
    }

    public SnowflakeGenerator(byte machineId, Supplier<Long> currentMilisSupplier) {
        this.machineId = machineId;
        this.currentMilisSupplier = currentMilisSupplier;
    }

    public Snowflake randomSnowflake2() {
        localCounter++;
        byte[] newSnowflake = new byte[8];
        newSnowflake[0] = localCounter;
        newSnowflake[1] = machineId;
        long currentMilis = currentMilisSupplier.get();
        byte[] bytes = longToBytes(currentMilis);
        newSnowflake[2] = bytes[0];
        newSnowflake[3] = bytes[1];
        newSnowflake[4] = bytes[2];
        newSnowflake[5] = bytes[3];
        newSnowflake[6] = bytes[4];
        newSnowflake[7] = bytes[5];
        return new Snowflake(newSnowflake, currentMilis, machineId, localCounter);
    }

    public byte[] randomSnowflake() {
        localCounter++;
        byte[] newSnowflake = new byte[8];
        newSnowflake[0] = localCounter;
        newSnowflake[1] = machineId;
        long currentMilis = currentMilisSupplier.get();
        byte[] bytes = longToBytes(currentMilis);
        newSnowflake[2] = bytes[0];
        newSnowflake[3] = bytes[1];
        newSnowflake[4] = bytes[2];
        newSnowflake[5] = bytes[3];
        newSnowflake[6] = bytes[4];
        newSnowflake[7] = bytes[5];
        return newSnowflake;
    }

    private static byte[] longToBytes(long currentMilis) {
        if (currentMilis > 281474976710655L) {
            throw new RuntimeException("dupa");
        }
        return new byte[]{
                (byte) ((currentMilis >> 40) & 0xff),
                (byte) ((currentMilis >> 32) & 0xff),
                (byte) ((currentMilis >> 24) & 0xff),
                (byte) ((currentMilis >> 16) & 0xff),
                (byte) ((currentMilis >> 8) & 0xff),
                (byte) ((currentMilis) & 0xff)
        };
    }

}
