/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.pszymczyk.snowflake;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SnowflakeGeneratorTest {

    @Test
    void shouldGenerateMaxValidSnowflake() {
        //given
        byte machineId = 127;

        SnowflakeGenerator snowflakeGenerator = new SnowflakeGenerator(machineId, () -> 281474976710655L);

        //expect
        assertEquals(new byte[]{-128,127,-1,-1,-1,-1,-1,-1}, snowflakeGenerator.randomSnowflake());
    }


}