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

package com.meisolsson.githubsdk.service.reactions;

import com.meisolsson.githubsdk.model.Page;
import com.meisolsson.githubsdk.model.Reaction;
import com.meisolsson.githubsdk.model.request.ReactionRequest;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ReactionService {

    @GET("repos/{owner}/{repo}/comments/{id}/reactions")
    Single<Response<Page<Reaction>>> getCommitCommentReactions(@Path("owner") String owner, @Path("repo") String repo, @Path("id") long commentId, @Query("page") long page);

    @POST("repos/{owner}/{repo}/comments/{id}/reactions")
    Single<Response<Reaction>> createCommitCommentReaction(@Path("owner") String owner, @Path("repo") String repo, @Path("id") long commentId, @Body ReactionRequest request);

    @GET("repos/{owner}/{repo}/issues/{number}/reactions")
    Single<Response<Page<Reaction>>> getIssueReactions(@Path("owner") String owner, @Path("repo") String repo, @Path("number") long number, @Query("page") long page);

    @POST("repos/{owner}/{repo}/issues/{number}/reactions")
    Single<Response<Reaction>> createIssueReaction(@Path("owner") String owner, @Path("repo") String repo, @Path("number") long number, @Body ReactionRequest request);

    @GET("repos/{owner}/{repo}/issues/comments/{id}/reactions")
    Single<Response<Page<Reaction>>> getIssueCommentReactions(@Path("owner") String owner, @Path("repo") String repo, @Path("id") long commentId, @Query("page") long page);

    @POST("repos/{owner}/{repo}/issues/comments/{id}/reactions")
    Single<Response<Reaction>> createIssueCommentReaction(@Path("owner") String owner, @Path("repo") String repo, @Path("id") long commentId, @Body ReactionRequest request);

    @GET("repos/{owner}/{repo}/pulls/comments/{id}/reactions")
    Single<Response<Page<Reaction>>> getPullRequestReviewCommentReactions(@Path("owner") String owner, @Path("repo") String repo, @Path("id") long commentId, @Query("page") long page);

    @POST("repos/{owner}/{repo}/pulls/comments/{id}/reactions")
    Single<Response<Reaction>> createPullRequestReviewCommentReaction(@Path("owner") String owner, @Path("repo") String repo, @Path("id") long commentId, @Body ReactionRequest request);

    @DELETE("reactions/{id}")
    Single<Response<Boolean>> deleteReaction(@Path("id") long id);
}
