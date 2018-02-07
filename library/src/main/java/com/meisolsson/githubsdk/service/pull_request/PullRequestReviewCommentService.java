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

package com.meisolsson.githubsdk.service.pull_request;

import com.meisolsson.githubsdk.model.Page;
import com.meisolsson.githubsdk.model.ReviewComment;
import com.meisolsson.githubsdk.model.request.CommentRequest;
import com.meisolsson.githubsdk.model.request.pull_request.CreateReviewComment;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PullRequestReviewCommentService {

    @GET("repos/{owner}/{repo}/pulls/{number}/comments")
    Single<Response<Page<ReviewComment>>> getPullRequestComments(@Path("owner") String owner, @Path("repo") String repo, @Path("number") long number, @Query("page") long page);

    @GET("repos/{owner}/{repo}/pulls/comments")
    Single<Response<Page<ReviewComment>>> getRepositoryComments(@Path("owner") String owner, @Path("repo") String repo, @Query("page") long page);

    @GET("repos/{owner}/{repo}/pulls/comments/{id}")
	Single<Response<ReviewComment>> getReviewComment(@Path("owner") String owner, @Path("repo") String repo, @Path("id") long id);

    @POST("repos/{owner}/{repo}/pulls/{number}/comments")
    Single<Response<ReviewComment>> createReviewComment(@Path("owner") String owner, @Path("repo") String repo, @Path("number") long number, @Body CreateReviewComment body);

    @PATCH("repos/{owner}/{repo}/pulls/comments/{id}")
	Single<Response<ReviewComment>> editReviewComment(@Path("owner") String owner, @Path("repo") String repo, @Path("id") long id,  @Body CommentRequest body);

    @DELETE("repos/{owner}/{repo}/pulls/comments/{id}")
	Single<Response<Void>> deleteComment(@Path("owner") String owner, @Path("repo") String repo, @Path("id") long id);
}
