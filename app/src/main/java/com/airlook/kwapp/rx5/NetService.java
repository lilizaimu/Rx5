package com.airlook.kwapp.rx5;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface NetService {

    @GET("ajax.php?a=fy&f=auto&t=auto&w=hello")
    Observable<Translation> translate();


    @GET("ajax.php?a=fy&f=auto&t=auto&w=register")
    Observable<Translation> translate2();


    @GET("ajax.php?a=fy&f=auto&t=auto&w=login")
    Observable<Translation> translate3();

}
