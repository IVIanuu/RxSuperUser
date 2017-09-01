package com.ivianuu.rxsuperuser;

/**
 * Thrown on when root is not available
 */
public class RootNotAvailableException extends IllegalStateException {
    RootNotAvailableException() {
        super("Root not available");
    }
}
