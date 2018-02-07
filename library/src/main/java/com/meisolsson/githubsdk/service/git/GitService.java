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

package com.meisolsson.githubsdk.service.git;

import com.meisolsson.githubsdk.model.Page;
import com.meisolsson.githubsdk.model.git.GitBlob;
import com.meisolsson.githubsdk.model.git.GitCommit;
import com.meisolsson.githubsdk.model.git.GitReference;
import com.meisolsson.githubsdk.model.git.GitTag;
import com.meisolsson.githubsdk.model.git.GitTree;
import com.meisolsson.githubsdk.model.request.git.CreateGitBlob;
import com.meisolsson.githubsdk.model.request.git.CreateGitCommit;
import com.meisolsson.githubsdk.model.request.git.CreateGitReference;
import com.meisolsson.githubsdk.model.request.git.CreateGitTag;
import com.meisolsson.githubsdk.model.request.git.CreateGitTree;
import com.meisolsson.githubsdk.model.request.git.UpdateGitReference;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GitService {

    @GET("repos/{owner}/{repo}/git/blobs/{sha}")
    @Headers("Accept: application/json")
    Single<Response<GitBlob>> getGitBlob(@Path("owner") String owner, @Path("repo") String repo, @Path("sha") String sha);

    @POST("repos/{owner}/{repo}/git/blobs")
    Single<Response<GitBlob>> createGitBlob(@Path("owner") String owner, @Path("repo") String repo, @Body CreateGitBlob blob);

    @GET("repos/{owner}/{repo}/git/commits/{sha}")
    Single<Response<GitCommit>> getGitCommit(@Path("owner") String owner, @Path("repo") String repo, @Path("sha") String sha);

    @POST("repos/{owner}/{repo}/git/commits")
    Single<Response<GitCommit>> createGitCommit(@Path("owner") String owner, @Path("repo") String repo, @Body CreateGitCommit blob);

    @GET("repos/{owner}/{repo}/git/tags/{sha}")
    Single<Response<GitTag>> getGitTag(@Path("owner") String owner, @Path("repo") String repo, @Path("sha") String sha);

    @POST("repos/{owner}/{repo}/git/tags")
    Single<Response<GitTag>> createGitTag(@Path("owner") String owner, @Path("repo") String repo, @Body CreateGitTag blob);

    @GET("repos/{owner}/{repo}/git/trees/{sha}")
    Single<Response<GitTree>> getGitTree(@Path("owner") String owner, @Path("repo") String repo, @Path("sha") String sha);

    @GET("repos/{owner}/{repo}/git/trees/{sha}?recursive=1")
    Single<Response<GitTree>> getGitTreeRecursive(@Path("owner") String owner, @Path("repo") String repo, @Path("sha") String sha);

    @POST("repos/{owner}/{repo}/git/trees")
    Single<Response<GitTree>> createGitTree(@Path("owner") String owner, @Path("repo") String repo, @Body CreateGitTree blob);

    @GET("repos/{owner}/{repo}/git/refs/heads/{branch}")
    Single<Response<GitReference>> getGitReference(@Path("owner") String owner, @Path("repo") String repo, @Path("branch") String branch);

    @GET("repos/{owner}/{repo}/git/refs")
    Single<Response<Page<GitReference>>> getGitReferences(@Path("owner") String owner, @Path("repo") String repo, @Query("page") long page);

    /**
     *
     * @param owner
     * @param repo
     * @param type Either <b>tags</b> or <b>heads</b> (Could be others but these are most common)
     * @return
     */
    @GET("repos/{owner}/{repo}/git/refs/{type}")
    Single<Response<Page<GitReference>>> getGitReferencesByType(@Path("owner") String owner, @Path("repo") String repo, @Path("type") String type, @Query("page") long page);

    @POST("repos/{owner}/{repo}/git/refs")
    Single<Response<GitReference>> createGitReference(@Path("owner") String owner, @Path("repo") String repo, @Body CreateGitReference body);

    @PATCH("repos/{owner}/{repo}/git/refs/{ref}")
    Single<Response<GitReference>> updateGitReference(@Path("owner") String owner, @Path("repo") String repo, @Path("ref") String branch, @Body UpdateGitReference body);

    @DELETE("repos/{owner}/{repo}/git/refs/{ref}")
    Single<Response<Void>> deleteGitReference(@Path("owner") String owner, @Path("repo") String repo, @Path("ref") String branch);
}
