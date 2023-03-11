package com.pszymczyk.snowflake;

import java.time.Clock;
import java.util.function.Supplier;

import static com.pszymczyk.snowflake.LongConverters.longToBytes;

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

    public Snowflake randomSnowflake3() {
        localCounter++;
        byte[] newSnowflake = new byte[8];
        newSnowflake[6] = localCounter;
        newSnowflake[7] = machineId;
        long currentMilis = currentMilisSupplier.get();
        byte[] bytes = longToBytes(currentMilis);
        newSnowflake[0] = bytes[2];
        newSnowflake[1] = bytes[3];
        newSnowflake[2] = bytes[4];
        newSnowflake[3] = bytes[5];
        newSnowflake[4] = bytes[6];
        newSnowflake[5] = bytes[7];
        return new Snowflake(newSnowflake, currentMilis, machineId, localCounter);
    }

    public long randomSnowflake2() {
        return LongConverters.longFromBytes(randomSnowflake());
    }

    public byte[] randomSnowflake() {
        localCounter++;
        byte[] newSnowflake = new byte[8];
        newSnowflake[6] = localCounter;
        newSnowflake[7] = machineId;
        long currentMilis = currentMilisSupplier.get();
        byte[] bytes = longToBytes(currentMilis);
        newSnowflake[0] = bytes[2];
        newSnowflake[1] = bytes[3];
        newSnowflake[2] = bytes[4];
        newSnowflake[3] = bytes[5];
        newSnowflake[4] = bytes[6];
        newSnowflake[5] = bytes[7];
        return newSnowflake;
    }
}
