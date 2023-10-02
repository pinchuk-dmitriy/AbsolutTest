package org.absolut.actioncounter.validation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TimestampValidatorTest {

    @ParameterizedTest
    @ValueSource(ints = {TimestampValidator.TIMESTAMP_MIN_VALUE - 1, TimestampValidator.TIMESTAMP_MAX_VALUE + 1})
    void checkTimestampValidationWithInvalidTimestamp(int timestamp) {
        assertThrows(IllegalArgumentException.class, () -> TimestampValidator.validateTimestamp(timestamp));
    }

    @ParameterizedTest
    @ValueSource(ints = {TimestampValidator.TIMESTAMP_MIN_VALUE, 15, TimestampValidator.TIMESTAMP_MAX_VALUE})
    void checkTimestampValidationWithValidTimestamp(int timestamp) {
        assertDoesNotThrow(() -> TimestampValidator.validateTimestamp(timestamp));
    }

}