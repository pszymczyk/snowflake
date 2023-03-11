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

    @Test
    void visualRepresentationTest() {
        //given
        long currentMilis = 1678570238986L;
        byte machineId = 127;
        SnowflakeGenerator snowflakeGenerator = new SnowflakeGenerator(machineId, () -> currentMilis);

        //then
        Assertions.assertEquals(
                "2023-03-11T21:30:38.986-127-n128",
                snowflakeGenerator.randomSnowflake3().visualRepresentationUTC());
    }
}