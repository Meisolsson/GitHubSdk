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

package com.meisolsson.githubsdk.service.activity;

import com.meisolsson.githubsdk.model.Page;
import com.meisolsson.githubsdk.model.Repository;
import com.meisolsson.githubsdk.model.request.repository.CreateSubscription;
import com.meisolsson.githubsdk.model.Subscription;
import com.meisolsson.githubsdk.model.User;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WatchingService {

    @GET("repos/{owner}/{repo}/subscribers")
    Single<Response<Page<User>>> getRepositoryWatchers(@Path("owner") String owner, @Path("repo") String repo, @Query("page") long page);

    @GET("users/{username}/subscriptions")
    Single<Response<Page<Repository>>> getWatchedRepositories(@Path("username") String username, @Query("page") long page);

    @GET("user/subscriptions")
    Single<Response<Page<Repository>>> getWatchedRepositories(@Query("page") long page);

    @GET("repos/{owner}/{repo}/subscription")
    Single<Response<Subscription>> getRepositorySubscription(@Path("owner") String owner, @Path("repo") String repo);

    @PUT("repos/{owner}/{repo}/subscription")
    Single<Response<Subscription>> setRepositorySubscription(@Path("owner") String owner, @Path("repo") String repo,
                                                             @Body CreateSubscription subscriptionBody);

    @DELETE("repos/{owner}/{repo}/subscription")
    Single<Response<Boolean>> deleteRepositorySubscription(@Path("owner") String owner, @Path("repo") String repo);
}