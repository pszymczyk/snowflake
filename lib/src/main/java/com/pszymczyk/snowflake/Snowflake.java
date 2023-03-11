package com.pszymczyk.snowflake;

import java.util.Arrays;
import java.util.Objects;

public record Snowflake(byte[] rawData, long currentMilis, byte machineId, byte localCounter) {

    static Snowflake from(byte[] rawData) {

        return new Snowflake(
                rawData,
                LongConverters.longFromBytes(new byte[]{
                        0, 0, rawData[0], rawData[1], rawData[2], rawData[3], rawData[4], rawData[5]
                }),
                rawData[7],
                rawData[6]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Snowflake snowflake = (Snowflake) o;
        return currentMilis == snowflake.currentMilis && machineId == snowflake.machineId && localCounter == snowflake.localCounter && Arrays.equals(rawData, snowflake.rawData);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(currentMilis, machineId, localCounter);
        result = 31 * result + Arrays.hashCode(rawData);
        return result;
    }
}
