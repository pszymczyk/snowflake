package com.pszymczyk.snowflake;

public record Snowflake(byte[] rawData, long currentMilis, byte machineId, byte localCounter) {

}
