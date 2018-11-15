package com.airlook.kwapp.rx5;

import android.util.Log;
import android.widget.Toast;

import com.airlook.kwapp.rx5.enumModel.SmsCodeType;
import com.airlook.kwapp.rx5.model.BaseModel;
import com.airlook.kwapp.rx5.model.LoginResultModel;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class PMain {


    public MainActivity activity;

    public PMain(MainActivity activity) {
        this.activity = activity;
    }

    public void loopQuery() {
        Observable.interval(2000, 2000, TimeUnit.MILLISECONDS)
                .observeOn(Schedulers.io())
                .flatMap(new Function<Long, ObservableSource<Translation>>() {
                    @Override
                    public ObservableSource<Translation> apply(Long aLong) {
                        return Net.getNetService().translate().subscribeOn(Schedulers.io());
                    }
                }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Translation>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Translation translation) {
                        Log.d("looper", translation.getContent().getWord_mean().get(0));
                    }

                    @Override
                    public void onError(Throwable e) {
                        loopQuery();
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    public void flatMap() {
        Net.getNetService().translate2()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<Translation>() {
                    @Override
                    public void accept(Translation translation) {
                        Log.d("accept", translation.getContent().getWord_mean().get(0));
                    }
                }).observeOn(Schedulers.io())
                .flatMap(new Function<Translation, ObservableSource<Translation>>() {
                    @Override
                    public ObservableSource<Translation> apply(Translation translation) throws Exception {
                        if (translation.getStatus() == 0) {
                            return Observable.error(new Throwable("注册出错了"));
                        }
                        return Net.getNetService().translate3();
                    }
                }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Translation>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d("onSubscribe", "onSubscribe");
                    }

                    @Override
                    public void onNext(Translation translation) {
                        Log.d("onNext", translation.getContent().getWord_mean().get(0));
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("onError", e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Log.d("onComplete", "onComplete");
                    }
                });
    }

    String smsCode;

    public void concat() {
        Observable.concat(getSmsCode(), login(smsCode))
                .observeOn(Schedulers.io())
                .subscribe(new Observer<BaseModel<Object>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(BaseModel<Object> baseModel) {
                        if (baseModel.getData() instanceof LoginResultModel) {
                            Toast.makeText(activity, ((LoginResultModel) baseModel.getData()).getUserId(), Toast.LENGTH_SHORT).show();
                        } else {
                            smsCode = "1234";
                            Log.d("TAG", smsCode);

                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(activity, e.getMessage(), Toast.LENGTH_SHORT);
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    public Observable<BaseModel<Object>> login(String smsCode) {
        return Net.getNetService().queryLogin("15653571607"
                , "15653571607", smsCode, "ANDROID"
                , "MI", "1.1")
                .subscribeOn(Schedulers.io());
    }

    public Observable<BaseModel<Object>> getSmsCode() {
        return Net.getNetService()
                .querySmsCode("15653571607"
                        , "15653571607"
                        , SmsCodeType.SMSUPDATEPWD.getType())
                .subscribeOn(Schedulers.io());
    }

}
