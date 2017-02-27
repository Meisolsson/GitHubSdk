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
import com.meisolsson.githubsdk.model.git.GitComment;
import com.meisolsson.githubsdk.model.request.CommentRequest;
import com.meisolsson.githubsdk.model.request.repository.CreateCommitComment;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RepositoryCommentService {

    @GET("repos/{owner}/{repo}/comments")
    Observable<Page<GitComment>> getRepositoryCommitComments(@Path("owner") String owner, @Path("repo") String repo, @Query("page") long page);

    @GET("repos/{owner}/{repo}/commits/{ref}/comments")
	Observable<Page<GitComment>> getCommitComments(@Path("owner") String owner, @Path("repo") String repo, @Path("ref") String ref, @Query("page") long page);

    @POST("repos/{owner}/{repo}/commits/{sha}/comments")
	Observable<GitComment> createCommitComment(@Path("owner") String owner, @Path("repo") String repo, @Path("sha") String sha, @Body CreateCommitComment body);

    @GET("repos/{owner}/{repo}/comments/{id}")
	Observable<GitComment> getCommitComment(@Path("owner") String owner, @Path("repo") String repo, @Path("id") String id);

    @PATCH("repos/{owner}/{repo}/comments/{id}")
	Observable<GitComment> editCommitComment(@Path("owner") String owner, @Path("repo") String repo, @Path("id") String id,  @Body CommentRequest body);

    @DELETE("repos/{owner}/{repo}/comments/{id}")
	Observable<Response<Boolean>> deleteCommitComment(@Path("owner") String owner, @Path("repo") String repo, @Path("id") String id);

}
