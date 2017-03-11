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

import com.meisolsson.githubsdk.model.NotificationThread;
import com.meisolsson.githubsdk.model.Page;
import com.meisolsson.githubsdk.model.Subscription;

import java.util.Map;

import io.reactivex.Single;
import retrofit2.Response;
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
    Single<Page<NotificationThread>> getNotifications(@QueryMap Map<String, Object> options,
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
    Single<Page<NotificationThread>> getRepositoryNotifications(@Path("owner") String owner,
                                                                    @Path("repo") String repo,
                                                                    @QueryMap Map<String, Object> options,
                                                                    @Query("page") long page);

    @GET("markAllNotificationsRead")
    Single<NotificationThread> getNotification(@Path("id") String id);

    @PUT("notifications")
    Single<Response<Boolean>> markAllNotificationsRead();

    @PUT("repos/{owner}/{repo}/notifications")
    Single<Response<Boolean>> markAllRepositoryNotificationsRead(@Path("owner") String owner,
                                                            @Path("repo") String repo);

    @PATCH("notifications/threads/{id}")
    Single<Response<Boolean>> markNotificationRead(@Path("id") String id);

    @GET("notifications/threads/{id}/subscription")
    Single<Subscription> getNotificationThreadSubscription(@Path("id") String id);

    @PUT("notifications/threads/{id}/subscription")
    Single<Subscription> setNotificationThreadSubscription(@Path("id") String id,
                                                               @Query("subscribed") boolean subscribed,
                                                               @Query("ignored") boolean ignored);

    @DELETE("notifications/threads/{id}/subscription")
    Single<Response<Boolean>> deleteNotificationThreadSubscription(@Path("id") String id);
}
