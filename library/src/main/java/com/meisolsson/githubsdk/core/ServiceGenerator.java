/*
 * Copyright 2015 Henrik Olsson
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.meisolsson.githubsdk.core;

import android.content.Context;

import com.squareup.moshi.Moshi;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class ServiceGenerator {

    public final static Moshi moshi = new Moshi.Builder()
            .add(new GitHubEventAdapter())
            .add(new GitHubPayloadAdapter())
            .add(MyAdapterFactory.create())
            .add(new FormattedHtmlAdapter())
            .add(new FormattedTimeAdapter())
            .build();

    private final static HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY);

    private final static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(new StringResponseConverterFactory())
            .addConverterFactory(MoshiConverterFactory.create(moshi));

    private final static OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(new GitHubPaginationInterceptor());


    public static <S> S createService(final Context context, Class<S> serviceClass){
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();

                Request.Builder requestBuilder = original.newBuilder()
                        .header("Accept", "application/json")
                        .header("Authorization", "Token " + TokenStore.getInstance(context).getToken())
                        .method(original.method(), original.body());

                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        });

        OkHttpClient client = httpClient.build();
        Retrofit retrofit = builder.client(client).build();
        return retrofit.create(serviceClass);
    }


}
