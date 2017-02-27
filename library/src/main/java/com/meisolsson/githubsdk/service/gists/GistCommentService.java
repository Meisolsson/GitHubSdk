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

import com.meisolsson.githubsdk.model.GitHubComment;
import com.meisolsson.githubsdk.model.Page;
import com.meisolsson.githubsdk.model.request.CommentRequest;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GistCommentService {

    @GET("gists/{gist_id}/comments")
    Single<Page<GitHubComment>> getGistComments(@Path("gist_id") String gistId, @Query("page") long page);

    @GET("gists/{gist_id}/comments/{id}")
    Single<GitHubComment> getGistComment(@Path("gist_id") String gistId, @Path("id") String id);

    @POST("gists/{gist_id}/comments")
    Single<GitHubComment> createGistComment(@Path("gist_id") String gistId, @Body CommentRequest body);

    @PATCH("gists/{gist_id}/comments/{id}")
    Single<GitHubComment> editGistComment(@Path("gist_id") String gistId, @Path("id") long id, @Body CommentRequest body);

    @DELETE("gists/{gist_id}/comments/{id}")
    Single<Response<Boolean>> deleteGistComment(@Path("gist_id") String gistId, @Path("id") long id);
}
