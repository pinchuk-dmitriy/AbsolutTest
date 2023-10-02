package org.absolut.actioncounter.validation;

public class TimestampValidator {

    public static final int TIMESTAMP_MIN_VALUE = 1;
    public static final int TIMESTAMP_MAX_VALUE = 2_000_000_000;

    public static void validateTimestamp(int timestamp) {
        if (timestamp >= TIMESTAMP_MIN_VALUE && timestamp <= TIMESTAMP_MAX_VALUE) {
            throw new IllegalArgumentException("Timestamp must be more that " + TIMESTAMP_MIN_VALUE + " and less than " + TIMESTAMP_MAX_VALUE);
        }
    }

}
