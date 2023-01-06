package com.flexcub.common.lang;

import com.flexcub.common.exception.CustomException;
import com.flexcub.common.exception.RequestValidationException;
import com.flexcub.common.lang.string.Strings;
import com.flexcub.common.message.MessageCode;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Utility methods for working with {@code Optional} values.
 */
public final class Optionals {

    @SuppressWarnings("unchecked")
    public static <T> Optional<T> from(final T candidate) {
        return (candidate instanceof String)
            ? (Optional<T>) Strings.absentIfBlank((String) candidate)
            : Optional.ofNullable(candidate);
    }

    public static <T> T checkPresent(final Optional<T> candidate, final MessageCode messageCode) {
        return checkPresent(candidate, messageCode, RequestValidationException::new);
    }

    public static <T> T checkPresent(
        final Optional<T> candidate,
        final MessageCode messageCode,
        final Function<MessageCode, ? extends CustomException> messageToException) {

        final Supplier<RuntimeException> runtimeExceptionSupplier =
            () -> messageToException.apply(messageCode);

        return candidate.orElseThrow(runtimeExceptionSupplier);
    }

    private Optionals() {
    }

}
