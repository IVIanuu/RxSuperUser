package com.ivianuu.rxsuperuser;

/**
 * @author Manuel Wrage (IVIanuu)
 */
public class RootNotAvailableException extends IllegalStateException {
    RootNotAvailableException() {
        super("Root not available");
    }
}
