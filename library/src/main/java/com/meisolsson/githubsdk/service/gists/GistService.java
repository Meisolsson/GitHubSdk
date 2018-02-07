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

package com.meisolsson.githubsdk.service.gists;

import com.meisolsson.githubsdk.model.Gist;
import com.meisolsson.githubsdk.model.GistRevision;
import com.meisolsson.githubsdk.model.Page;
import com.meisolsson.githubsdk.model.request.gist.CreateGist;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GistService {

    @GET("users/{username}/gists")
    Single<Response<Page<Gist>>> getUserGists(@Path("username") String username, @Query("page") long page);

    @GET("gists")
    Single<Response<Page<Gist>>> getUserGists(@Query("page") long page);

    @GET("gists/public")
    Single<Response<Page<Gist>>> getPublicGists(@Query("page") long page);

    @GET("gists/starred")
    Single<Response<Page<Gist>>> getUserStarredGists(@Query("page") long page);

    @GET("gists/{id}")
    Single<Response<Gist>> getGist(@Path("id") String id);

    @GET("gists/{id}/{sha}")
    Single<Response<Gist>> getGistRevision(@Path("id") String id, @Path("sha") String sha);

    @POST("gists")
    Single<Response<Gist>> createGist(@Body CreateGist gistBody);

    @POST("gists/{id}")
    Single<Response<Gist>> editGist(@Body CreateGist gistBody);

    @GET("gists/{id}/commits")
    Single<Response<Page<GistRevision>>> getGistCommits(@Path("id") String id, @Query("page") long page);

    @GET("gists/{id}/star")
    Single<Response<Void>> checkIfGistIsStarred(@Path("id") String id);

    @PUT("gists/{id}/star")
    Single<Response<Void>> starGist(@Path("id") String id);

    @DELETE("gists/{id}/star")
    Single<Response<Void>> unstarGist(@Path("id") String id);

    @POST("gists/{id}/forks")
    Single<Response<Gist>> forkGist(@Path("id") String id);

    @POST("gists/{id}/forks")
    Single<Response<Page<Gist>>> gistGistForks(@Path("id") String id, @Query("page") long page);

    @DELETE("gists/{id}")
    Single<Response<Void>> deleteGist(@Path("id") String id);
}
