/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.pszymczyk.snowflake;

public record Snowflake(byte[] rawData, long currentMilis, byte machineId, byte localCounter) {

}
