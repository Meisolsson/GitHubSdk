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

import com.meisolsson.githubsdk.model.GitHubEvent;
import com.meisolsson.githubsdk.model.Page;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface EventService {

    /**
     * Lists public events from GitHub
     *
     * @param page Page index, starts at 0
     * @return Paged list of events
     */
    @GET("events")
    Single<Page<GitHubEvent>> getPublicEvents(@Query("page") long page);

    /**
     * Lists events from a repository
     *
     * @param owner Owner of the repository
     * @param repo Repository name
     * @param page Page index, starts at 0
     * @return Paged list of events
     */
    @GET("repos/{owner}/{repo}/events")
    Single<Page<GitHubEvent>> getRepositoryEvents(@Path("owner") String owner, @Path("repo") String repo, @Query("page") long page);

    /**
     * Lists public events for a network of repositories
     *
     * @param owner Owner of the repository
     * @param repo Repository name
     * @param page Page index, starts at 0
     * @return Paged list of events
     */
    @GET("networks/{owner}/{repo}/events")
    Single<Page<GitHubEvent>> getNetworkRepositoryEvents(@Path("owner") String owner, @Path("repo") String repo, @Query("page") long page);

    /**
     * Lists public events for an organization
     *
     * @param org Organization name
     * @param page Page index, starts at 0
     * @return Paged list of events
     */
    @GET("orgs/{org}/events")
    Single<Page<GitHubEvent>> getPublicOrganizationEvents(@Path("org") String org, @Query("page") long page);

    /**
     * Lists users organization dashboard events
     *
     * @param username Users login
     * @param org Organization name
     * @param page Page index, starts at 0
     * @return Paged list of events
     */
    @GET("users/{username}/events/orgs/{org}")
    Single<Page<GitHubEvent>> getOrganizationEvents(@Path("username") String username, @Path("org") String org, @Query("page") long page);

    /**
     * Lists a user's received events, if not authenticated as the given user
     * it will function as {@link #getPublicUserRecievedEvents(String, long)}
     *
     * @param username Users login
     * @param page Page index, starts at 0
     * @return Paged list of events
     */
    @GET("users/{username}/received_events")
    Single<Page<GitHubEvent>> getUserRecievedEvents(@Path("username") String username, @Query("page") long page);

    /**
     * Lists a user's public received events
     *
     * @param username Users login
     * @param page Page index, starts at 0
     * @return Paged list of events
     */
    @GET("users/{username}/received_events/public")
    Single<Page<GitHubEvent>> getPublicUserRecievedEvents(@Path("username") String username, @Query("page") long page);

    /**
     * Lists a user's performed events, if not authenticated as the given user
     * it will function as {@link #getPublicUserPerformedEvents(String, long)}
     *
     * @param username Users login
     * @param page Page index, starts at 0
     * @return Paged list of events
     */
    @GET("users/{username}/events")
    Single<Page<GitHubEvent>> getUserPerformedEvents(@Path("username") String username, @Query("page") long page);

    /**
     * Lists a user's public performed events
     *
     * @param username Users login
     * @param page Page index, starts at 0
     * @return Paged list of events
     */
    @GET("users/{username}/events/public")
    Single<Page<GitHubEvent>> getPublicUserPerformedEvents(@Path("username") String username, @Query("page") long page);
}
