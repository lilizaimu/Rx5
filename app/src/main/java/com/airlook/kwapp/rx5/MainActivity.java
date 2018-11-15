package com.airlook.kwapp.rx5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    PMain pMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        pMain = new PMain(this);
    }


    @OnClick({R.id.btn_just, R.id.btn_interval, R.id.btn_flatmap})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_just:
                just();
                break;
            case R.id.btn_interval:
                interval();



                break;
            case R.id.btn_flatmap:
                flatMap();
                break;
        }

    }

    private void just() {
        Observable.just(1, 2, 3, 4, 5, 6)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d("just", "onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d("just", "next" + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("just", "onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.d("just", "onComplete");
                    }
                });
    }

    private void interval() {
        pMain.loopQuery();
    }

    private void flatMap() {
        pMain.flatMap();
    }

}
