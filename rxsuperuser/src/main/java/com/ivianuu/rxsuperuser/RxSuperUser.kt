package com.ivianuu.rxsuperuser

import eu.chainfire.libsuperuser.Shell
import io.reactivex.Single

/**
 * Factory for [Single]'s which emits results of SU commands
 */
object RxSuperUser {

    fun run(command: String): Single<List<String>> {
        return run(listOf(command))
    }

    fun run(commands: List<String>): Single<List<String>> {
        return run(commands.toTypedArray())
    }

    fun run(commands: Array<String>): Single<List<String>> {
        return Single.fromCallable<List<String>> { Shell.SU.run(commands) }
    }

    fun available(): Single<Boolean> {
        return Single.fromCallable<Boolean> { Shell.SU.available() }
    }
}
