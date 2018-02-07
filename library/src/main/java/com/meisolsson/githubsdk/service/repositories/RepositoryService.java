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

package com.meisolsson.githubsdk.service.repositories;

import com.meisolsson.githubsdk.model.Branch;
import com.meisolsson.githubsdk.model.Page;
import com.meisolsson.githubsdk.model.Repository;
import com.meisolsson.githubsdk.model.Team;
import com.meisolsson.githubsdk.model.User;
import com.meisolsson.githubsdk.model.request.repository.CreateRepository;
import com.meisolsson.githubsdk.model.request.repository.EditRepository;

import java.util.Map;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface RepositoryService {

    @GET("/user/repos")
    Single<Response<Page<Repository>>> getUserRepositories(@Query("page") long page);

    @GET("/user/repos")
    Single<Response<Page<Repository>>> getUserRepositories(@QueryMap Map<String, String> options, @Query("page") long page);

    @GET("users/{username}/repos")
	Single<Response<Page<Repository>>> getUserRepositories(@Path("username") String username, @Query("page") long page);

    @GET("users/{username}/repos")
	Single<Response<Page<Repository>>> getUserRepositories(@Path("username") String username, @QueryMap Map<String, String> options, @Query("page") long page);

    @GET("orgs/{org}/repos")
	Single<Response<Page<Repository>>> getOrganizationRepositories(@Path("org") String org, @Query("page") long page);

    @GET("orgs/{org}/repos")
    Single<Response<Page<Repository>>> getOrganizationRepositories(@Path("org") String org, @QueryMap Map<String, String> options, @Query("page") long page);

    @GET("/repositories")
	Single<Response<Page<Repository>>> getRepositories(@Query("page") long page);

    @POST("/user/repos")
	Single<Response<Repository>> createRepository(@Body CreateRepository body);

    @POST("orgs/{org}/repos")
	Single<Response<Repository>> createOrganizationRepository(@Path("org") String org, @Body CreateRepository body);

    @GET("repos/{owner}/{repo}")
	Single<Response<Repository>> getRepository(@Path("owner") String owner, @Path("repo") String repo);

    @PATCH("repos/{owner}/{repo}")
	Single<Response<Repository>> editRepository(@Path("owner") String owner, @Path("repo") String repo, @Body EditRepository body);

    @GET("repos/{owner}/{repo}/contributors")
	Single<Response<Page<User>>> getContributors(@Path("owner") String owner, @Path("repo") String repo, @Query("page") long page);

    @GET("repos/{owner}/{repo}/languages")
	Single<Response<Void>> getLanguages(@Path("owner") String owner, @Path("repo") String repo);

    @GET("repos/{owner}/{repo}/teams")
	Single<Response<Page<Team>>> getTeams(@Path("owner") String owner, @Path("repo") String repo, @Query("page") long page);

    @GET("repos/{owner}/{repo}/tags")
	Single<Response<Page<Branch>>> getTags(@Path("owner") String owner, @Path("repo") String repo, @Query("page") long page);

    @DELETE("repos/{owner}/{repo}")
	Single<Response<Void>> deleteRepository(@Path("owner") String owner, @Path("repo") String repo);

}
