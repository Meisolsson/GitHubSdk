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
import com.meisolsson.githubsdk.model.User;

import java.util.Map;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface StarringService {

    @GET("repos/{owner}/{repo}/stargazers")
    Single<Response<Page<User>>> getStargazers(@Path("owner") String owner, @Path("repo") String repo, @Query("page") long page);

    /**
     *
     * @param username
     * @param options
     * The options can be any of these <a href="https://developer.github.com/v3/activity/starring/#parameters">GitHub API docs</a>
     * @return
     */
    @GET("users/{username}/starred")
    Single<Response<Page<Repository>>> getStarredRepositories(@Path("username") String username, @QueryMap Map<String, String> options, @Query("page") long page);

    /**
     *
     * @param options See {@link #getStarredRepositories(String, Map, long)}
     * @return
     */
    @GET("user/starred")
    Single<Response<Page<Repository>>> getStarredRepositories(@QueryMap Map<String, String> options, @Query("page") long page);

    /**
     *
     * @param owner
     * @param repo
     * @return If starred response code is 204. If not the code is 404
     */
    @GET("/user/starred/{owner}/{repo}")
    Single<Response<Void>> checkIfRepositoryIsStarred(@Path("owner") String owner, @Path("repo") String repo);

    /**
     *
     * @param owner
     * @param repo
     * @return If success response code is 204.
     */
    @Headers("Content-Length: 0")
    @PUT("/user/starred/{owner}/{repo}")
    Single<Response<Void>> starRepository(@Path("owner") String owner, @Path("repo") String repo);

    /**
     *
     * @param owner
     * @param repo
     * @return If success response code is 204.
     */
    @DELETE("/user/starred/{owner}/{repo}")
    Single<Response<Void>> unstarRepository(@Path("owner") String owner, @Path("repo") String repo);
}
