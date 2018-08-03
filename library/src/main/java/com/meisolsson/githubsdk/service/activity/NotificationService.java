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

import com.meisolsson.githubsdk.core.DateQuery;
import com.meisolsson.githubsdk.model.NotificationThread;
import com.meisolsson.githubsdk.model.Page;
import com.meisolsson.githubsdk.model.Subscription;
import com.meisolsson.githubsdk.model.request.activity.SubscriptionRequest;

import java.util.Map;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface NotificationService {

    /**
     * Lists notifications for the current user
     *
     * @param options Options can be any of these
     *                <a href="https://developer.github.com/v3/activity/notifications/#parameters">GitHub API docs</a>
     * @return Paged list of notifications
     */
    @GET("notifications")
    Single<Response<Page<NotificationThread>>> getNotifications(@QueryMap Map<String, Object> options,
                                                      @Query("page") long page);

    /**
     * Lists notifications for the current user about the given repository
     *
     * @param owner Name of the owner
     * @param repo Name of the repository
     * @param options See {@link #getNotifications(Map, long)}
     * @return Paged list of notifications
     */
    @GET("repos/{owner}/{repo}/notifications")
    Single<Response<Page<NotificationThread>>> getRepositoryNotifications(@Path("owner") String owner,
                                                                    @Path("repo") String repo,
                                                                    @QueryMap Map<String, Object> options,
                                                                    @Query("page") long page);

    @PUT("notifications")
    Single<Response<Void>> markAllNotificationsRead(@Query("last_read_at") DateQuery last_read_at);

    @PUT("repos/{owner}/{repo}/notifications")
    Single<Response<Void>> markAllRepositoryNotificationsRead(@Path("owner") String owner,
                                                              @Path("repo") String repo,
                                                              @Query("last_read_at") DateQuery last_read_at);

    @GET("notifications/threads/{id}")
    Single<Response<NotificationThread>> getNotification(@Path("id") String id);

    @PATCH("notifications/threads/{id}")
    Single<Response<Void>> markNotificationRead(@Path("id") String id);

    @GET("notifications/threads/{id}/subscription")
    Single<Response<Subscription>> getNotificationThreadSubscription(@Path("id") String id);

    @PUT("notifications/threads/{id}/subscription")
    Single<Response<Subscription>> setNotificationThreadSubscription(@Path("id") String id, @Body SubscriptionRequest request);

    @DELETE("notifications/threads/{id}/subscription")
    Single<Response<Void>> deleteNotificationThreadSubscription(@Path("id") String id);
}
