package com.ivianuu.rxsuperuser;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Preconditions
 */
final class Preconditions {

    private Preconditions() {
        // no instances
    }

    /**
     * Throws a npe if the object is null
     */
    static void checkNotNull(@Nullable Object o, @NonNull String message) {
        if (o == null) {
            throw new NullPointerException(message);
        }
    }
}