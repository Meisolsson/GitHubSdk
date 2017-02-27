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

import io.reactivex.Observable;
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
    Observable<Page<Gist>> getUserGists(@Path("username") String username, @Query("page") long page);

    @GET("gists")
    Observable<Page<Gist>> getUserGists(@Query("page") long page);

    @GET("gists/public")
    Observable<Page<Gist>> getPublicGists(@Query("page") long page);

    @GET("gists/starred")
    Observable<Page<Gist>> getUserStarredGists(@Query("page") long page);

    @GET("gists/{id}")
    Observable<Gist> getGist(@Path("id") String id);

    @GET("gists/{id}/{sha}")
    Observable<Gist> getGistRevision(@Path("id") String id, @Path("sha") String sha);

    @POST("gists")
    Observable<Gist> createGist(@Body CreateGist gistBody);

    @POST("gists/{id}")
    Observable<Gist> editGist(@Body CreateGist gistBody);

    @GET("gists/{id}/commits")
    Observable<Page<GistRevision>> getGistCommits(@Path("id") String id, @Query("page") long page);

    @GET("gists/{id}/star")
    Observable<Response<Boolean>> checkIfGistIsStarred(@Path("id") String id);

    @PUT("gists/{id}/star")
    Observable<Response<Boolean>> starGist(@Path("id") String id);

    @DELETE("gists/{id}/star")
    Observable<Response<Boolean>> unstarGist(@Path("id") String id);

    @POST("gists/{id}/forks")
    Observable<Gist> forkGist(@Path("id") String id);

    @POST("gists/{id}/forks")
    Observable<Page<Gist>> gistGistForks(@Path("id") String id, @Query("page") long page);

    @DELETE("gists/{id}")
    Observable<Response<Boolean>> deleteGist(@Path("id") String id);
}
