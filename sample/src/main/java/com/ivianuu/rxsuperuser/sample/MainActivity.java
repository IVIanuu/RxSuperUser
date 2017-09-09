package com.ivianuu.rxsuperuser.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.ivianuu.rxsuperuser.RxSuperUser;

import java.util.List;
import java.util.StringTokenizer;

import io.reactivex.MaybeSource;
import io.reactivex.SingleSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RxSuperUser.available()
                .filter(rootAvailable -> rootAvailable)
                .flatMapSingle(__ -> RxSuperUser.run("some cool root command"))
                .toCompletable()
                .subscribe(() -> Log.d("tag", "successfully executed root command"));
    }
}
