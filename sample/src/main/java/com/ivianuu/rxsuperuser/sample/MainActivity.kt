package com.ivianuu.rxsuperuser.sample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import com.ivianuu.rxsuperuser.RxSuperUser
import java.util.StringTokenizer

import io.reactivex.MaybeSource
import io.reactivex.SingleSource
import io.reactivex.annotations.NonNull
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Action
import io.reactivex.functions.BiConsumer
import io.reactivex.functions.Function
import io.reactivex.functions.Predicate

class MainActivity : AppCompatActivity() {

    private var disposable: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        disposable = RxSuperUser.available()
                .filter { it }
                .flatMapSingle { RxSuperUser.run("some cool root command") }
                .subscribe { commands, exception ->
                    if (commands != null) {
                        Log.d("tag", "successfully executed root command $commands")
                    } else {
                        Log.e("tag", "oh no error.. $exception")
                    }
                }
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable?.dispose()
    }
}
