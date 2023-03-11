package com.pszymczyk.snowflake;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongConvertersTest {

    @Test
    void longToBytesAndFromBytes() {
        long aLong = 1678559073578L;
        byte[] bytes = LongConverters.longToBytes(aLong);
        Assertions.assertEquals(aLong, LongConverters.longFromBytes(bytes));
    }
}