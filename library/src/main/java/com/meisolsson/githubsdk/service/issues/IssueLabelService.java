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

package com.meisolsson.githubsdk.service.issues;

import com.meisolsson.githubsdk.model.Label;
import com.meisolsson.githubsdk.model.Page;

import java.util.List;

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

public interface IssueLabelService {

    @GET("repos/{owner}/{repo}/labels")
    Single<Page<Label>> getRepositoryLabels(@Path("owner") String owner, @Path("repo") String repo, @Query("page") long page);

    @GET("repos/{owner}/{repo}/labels/{name}")
    Single<Label> getLabel(@Path("owner") String owner, @Path("repo") String repo, @Path("name") String name);

    @POST("repos/{owner}/{repo}/labels")
    Single<Label> createLabel(@Path("owner") String owner, @Path("repo") String repo, @Body Label label);

    @PATCH("repos/{owner}/{repo}/labels/{name}")
    Single<Label> editLabel(@Path("owner") String owner, @Path("repo") String repo, @Path("name") String name, @Body Label label);

    @DELETE("repos/{owner}/{repo}/labels/{name}")
    Single<Label> deleteLabel(@Path("owner") String owner, @Path("repo") String repo, @Path("name") String name);

    @GET("repos/{owner}/{repo}/issues/{number}/labels")
    Single<Page<Label>> getIssueLabels(@Path("owner") String owner, @Path("repo") String repo, @Path("number") long number, @Query("page") long page);

    @POST("repos/{owner}/{repo}/issues/{number}/labels")
    Single<List<Label>> addLablesToIssue(@Path("owner") String owner, @Path("repo") String repo, @Path("number") long number, @Body List<String> labels);

    @DELETE("repos/{owner}/{repo}/issues/{number}/labels/{name}")
    Single<Response<Boolean>> deleteLableFromIssue(@Path("owner") String owner, @Path("repo") String repo, @Path("number") long number, @Path("name") String label);

    @PUT("repos/{owner}/{repo}/issues/{number}/labels")
    Single<List<Label>> replaceLablesForIssue(@Path("owner") String owner, @Path("repo") String repo, @Path("number") long number, @Body List<String> labels);

    @DELETE("repos/{owner}/{repo}/issues/{number}/labels")
    Single<Response<Boolean>> deleteLablesFromIssue(@Path("owner") String owner, @Path("repo") String repo, @Path("number") long number);

    @GET("repos/{owner}/{repo}/milestones/{number}/labels")
    Single<Page<Label>> getMilestoneIssueLabels(@Path("owner") String owner, @Path("repo") String repo, @Path("number") long number, @Query("page") long page);
}
