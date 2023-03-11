# Snowflake generator
Simple Java [Snowflake Id](https://en.wikipedia.org/wiki/Snowflake_ID) generator.

## Limitations

Guarantees at most 256 unique values each millisecond, with higher load duplicates are generated. See [UniquenessTest](https://github.com/pszymczyk/snowflake/blob/main/lib/src/test/java/com/pszymczyk/snowflake/UniquenessTest.java), you can bump `snowflakesPerMillisecond` and test is going to fail.
