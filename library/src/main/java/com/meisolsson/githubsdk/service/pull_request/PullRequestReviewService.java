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
import com.meisolsson.githubsdk.model.Review;
import com.meisolsson.githubsdk.model.ReviewComment;
import com.meisolsson.githubsdk.model.request.CommentRequest;
import com.meisolsson.githubsdk.model.request.pull_request.CreateReview;
import com.meisolsson.githubsdk.model.request.pull_request.DismissReview;
import com.meisolsson.githubsdk.model.request.pull_request.SubmitReview;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PullRequestReviewService {

    @GET("repos/{owner}/{repo}/pulls/{number}/reviews")
    Single<Response<Page<Review>>> getReviews(@Path("owner") String owner, @Path("repo") String repo, @Path("number") long number, @Query("page") long page);

    @GET("repos/{owner}/{repo}/pulls/{number}/reviews/{id}")
    Single<Response<Review>> getReview(@Path("owner") String owner, @Path("repo") String repo, @Path("number") long number, @Path("id") long id);

    @GET("repos/{owner}/{repo}/pulls/{number}/reviews/{id}/comments")
    Single<Response<Page<ReviewComment>>> getReviewComments(@Path("owner") String owner, @Path("repo") String repo, @Path("number") long number, @Path("id") long id);

    @POST("repos/{owner}/{repo}/pulls/{number}/reviews")
    Single<Response<Review>> createReview(@Path("owner") String owner, @Path("repo") String repo, @Path("number") long number, @Body CreateReview body);

    @POST("repos/{owner}/{repo}/pulls/{number}/reviews/{id}/events")
    Single<Response<Review>> submitReview(@Path("owner") String owner, @Path("repo") String repo, @Path("number") long number, @Path("id") long id,  @Body SubmitReview body);

    @PUT("repos/{owner}/{repo}/pulls/{number}/reviews/{id}/dismissals")
    Single<Response<Review>> dismissReview(@Path("owner") String owner, @Path("repo") String repo, @Path("number") long number, @Path("id") long id,  @Body DismissReview body);

    @DELETE("repos/{owner}/{repo}/pulls/{number}/reviews/{id}")
    Single<Response<Void>> deleteReview(@Path("owner") String owner, @Path("repo") String repo, @Path("number") long number, @Path("id") long id);
}
