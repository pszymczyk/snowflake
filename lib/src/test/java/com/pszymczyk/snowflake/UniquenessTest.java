package com.pszymczyk.snowflake;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.util.HashSet;

public class UniquenessTest {
    @Test
    void shouldBeUnique() throws InterruptedException {
        int snowflakesPerMillisecond = 256;

        var set = new HashSet<Long>();
        var snowflake = new SnowflakeGenerator((byte) 19, Clock.systemUTC());
        for (int i = 0; i < 10_000; i++) {
            for (int j = 0; j < snowflakesPerMillisecond; j++) {
                set.add(snowflake.randomSnowflake2());
            }
            Thread.sleep(1);
        }

        Assertions.assertEquals(10_000 * snowflakesPerMillisecond, set.size());
    }
}
