package com.ivianuu.rxsuperuser;

import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;

import java.util.List;

import eu.chainfire.libsuperuser.Shell;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

import static com.ivianuu.rxsuperuser.Preconditions.checkNotNull;

/**
 * Wraps su commands in observables
 */
public final class RxSuperUser {

    private RxSuperUser() {
        // no instances
    }

    /**
     * Runs command as root (if available) and returns the output
     *
     * Returns Output of the command, or throw an error if root isn't available or in
     * case of an error
     */
    @CheckResult @NonNull
    public static Single<List<String>> run(@NonNull final String command) {
        checkNotNull(command, "command == null");
        return Single.fromCallable(() -> {
            List<String> output = Shell.SU.run(command);
            checkNotNull(output, "output == null");
            return output;
        }).subscribeOn(Schedulers.io());
    }

    /**
     * Runs commands as root (if available) and returns the output
     *
     * Returns Output of the commands, or throw an error if root isn't available or in
     * case of an error
     */
    @CheckResult @NonNull
    public static Single<List<String>> run(@NonNull final List<String> commands) {
        checkNotNull(commands, "commands == null");
        return Single.fromCallable(() -> {
            List<String> output = Shell.SU.run(commands);
            checkNotNull(output, "output == null");
            return output;
        }).subscribeOn(Schedulers.io());
    }

    /**
     * Runs commands as root (if available) and return output
     *
     * Returns Output of the commands, or throw an error if root isn't available or in
     * case of an error
     */
    @CheckResult @NonNull
    public static Single<List<String>> run(@NonNull final String[] commands) {
        checkNotNull(commands, "commands == null");
        return Single.fromCallable(() -> {
            List<String> output = Shell.SU.run(commands);
            checkNotNull(output, "output == null");
            return output;
        }).subscribeOn(Schedulers.io());
    }
    

    /**
     * Detects whether or not superuser access is available, by checking the
     * output of the "id" command if available, checking if a shell runs at
     * all otherwise
     *
     * Returns true if available
     */
    @CheckResult @NonNull
    public static Single<Boolean> available() {
        return Single.fromCallable(Shell.SU::available)
                .subscribeOn(Schedulers.io());
    }
}
