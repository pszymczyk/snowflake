package com.pszymczyk.snowflake;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SnowflakeTest {

    @Test
    void from() {
        //given
        long currentMilis = System.currentTimeMillis();
        byte machineId = 127;
        SnowflakeGenerator snowflakeGenerator = new SnowflakeGenerator(machineId, () -> currentMilis);

        //when
        byte[] rawSnowflake = snowflakeGenerator.randomSnowflake();

        //then
        Assertions.assertEquals(
                new Snowflake(rawSnowflake, currentMilis, machineId, (byte) -128),
                Snowflake.from(rawSnowflake));
    }
}