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

import com.meisolsson.githubsdk.model.Page;
import com.meisolsson.githubsdk.model.Release;
import com.meisolsson.githubsdk.model.ReleaseAsset;
import com.meisolsson.githubsdk.model.request.repository.CreateRelease;
import com.meisolsson.githubsdk.model.request.repository.EditReleaseAsset;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RepositoryReleaseService {

    @GET("repos/{owner}/{repo}/releases")
    Single<Response<Page<Release>>> getReleases(@Path("owner") String owner, @Path("repo") String repo, @Query("page") long page);

    @GET("repos/{owner}/{repo}/releases/{id}")
    Single<Response<Release>> getRelease(@Path("owner") String owner, @Path("repo") String repo, @Path("id") String id);

    @GET("repos/{owner}/{repo}/releases/latest")
	Single<Response<Release>> getLatestRelease(@Path("owner") String owner, @Path("repo") String repo);

    @GET("repos/{owner}/{repo}/releases/tags/{tag}")
	Single<Response<Release>> getRelaseByTagName(@Path("owner") String owner, @Path("repo") String repo, @Path("tag") String tag);

    @POST("repos/{owner}/{repo}/releases")
	Single<Response<Release>> createRelease(@Path("owner") String owner, @Path("repo") String repo, @Body CreateRelease body);

    @PATCH("repos/{owner}/{repo}/releases/{id}")
	Single<Response<Release>> editRelease(@Path("owner") String owner, @Path("repo") String repo, @Path("id") String id, @Body CreateRelease body);

    @DELETE("repos/{owner}/{repo}/releases/{id}")
	Single<Response<Boolean>> deleteRelease(@Path("owner") String owner, @Path("repo") String repo, @Path("id") String id);

    @GET("repos/{owner}/{repo}/releases/{id}/assets")
	Single<Response<Page<ReleaseAsset>>> getRelaseAssets(@Path("owner") String owner, @Path("repo") String repo, @Path("id") String id, @Query("page") long page);

    @GET("repos/{owner}/{repo}/releases/assets/{id}")
	Single<Response<ReleaseAsset>> getReleaseAsset(@Path("owner") String owner, @Path("repo") String repo, @Path("id") String id);

    @PATCH("repos/{owner}/{repo}/releases/assets/{id}")
	Single<Response<ReleaseAsset>> editReleaseAsset(@Path("owner") String owner, @Path("repo") String repo, @Path("id") String id, @Body EditReleaseAsset body);

    @DELETE("repos/{owner}/{repo}/releases/assets/{id}")
	Single<Response<Boolean>> deleteReleaseAsset(@Path("owner") String owner, @Path("repo") String repo, @Path("id") String id);
}
