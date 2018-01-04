package com.ivianuu.rxsuperuser

import android.support.annotation.CheckResult

import eu.chainfire.libsuperuser.Shell
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

/**
 * Factory for [Single]'s which emits results of SU commands
 */
object RxSuperUser {

    /**
     * Runs the command and emits the result
     */
    @JvmStatic
    @CheckResult
    fun run(command: String): Single<List<String>> {
        return run(listOf(command))
    }

    /**
     * Runs the command and emits the result
     */
    @JvmStatic
    @CheckResult
    fun run(commands: List<String>): Single<List<String>> {
        return run(commands.toTypedArray())
    }

    /**
     * Runs the command and emits the result
     */
    @JvmStatic
    @CheckResult
    fun run(commands: Array<String>): Single<List<String>> {
        return Single.fromCallable<List<String>> { Shell.SU.run(commands) }
    }


    /**
     * Emits whether or not root is available
     */
    @JvmStatic
    @CheckResult
    fun available(): Single<Boolean> {
        return Single.fromCallable<Boolean> { Shell.SU.available() }
    }
}
