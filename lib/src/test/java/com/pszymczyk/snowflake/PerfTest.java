package com.pszymczyk.snowflake;

import org.junit.jupiter.api.Test;

import java.time.Clock;

public class PerfTest {

    @Test
    void somePerfTestWithClock() {
        var snowflake = new SnowflakeGenerator((byte) 10, Clock.systemUTC());

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10_000_000; i++) {
            snowflake.randomSnowflake2();
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    @Test
    void somePerfTestWithSystemCurrentMilis() {
        var snowflake = new SnowflakeGenerator((byte) 10, System::currentTimeMillis);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 10_000_000; i++) {
            snowflake.randomSnowflake();
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    @Test
    void somePerfTestWithFixed() {
        var snowflake = new SnowflakeGenerator((byte) 10, () -> 1678566274L);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            snowflake.randomSnowflake();
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
