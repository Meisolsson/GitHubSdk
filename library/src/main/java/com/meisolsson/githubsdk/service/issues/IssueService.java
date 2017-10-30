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

import com.meisolsson.githubsdk.model.Issue;
import com.meisolsson.githubsdk.model.Page;
import com.meisolsson.githubsdk.model.request.issue.IssueRequest;

import java.util.Map;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface IssueService {

    /**
     *
     * @param filter Parameters: <a>https://developer.github.com/v3/issues/#parameters</a>
     * @return List all issues assigned to the authenticated user across all visible repositories
     * including owned repositories, member repositories, and organization repositories
     */
    @GET("issues")
    Single<Response<Page<Issue>>> getIssues(@QueryMap Map<String, Object> filter, @Query("page") long page);

    /**
     *
     * @param filter See {@link #getIssues(Map, long)}
     * @return List all issues across owned and member repositories assigned to the authenticated user
     */
    @GET("user/issues")
    Single<Response<Page<Issue>>> getRepoMemberIssues(@QueryMap Map<String, Object> filter, @Query("page") long page);

    /**
     *
     * @param filter See {@link #getIssues(Map, long)}
     * @return List all issues for a given organization assigned to the authenticated user:
     */
    @GET("orgs/{org}/issues")
    Single<Response<Page<Issue>>> getOrgIssues(@QueryMap Map<String, Object> filter, @Query("page") long page);

    /**
     *
     * @param owner Login of the repository owner (can be org)
     * @param repo Name of the repository
     * @param filter Parameters <a>https://developer.github.com/v3/issues/#parameters-1</a>
     * @return List of issue form the repository
     */
    @GET("repos/{owner}/{repo}/issues")
    Single<Response<Page<Issue>>> getRepositoryIssues(@Path("owner") String owner, @Path("repo") String repo,
                                                @QueryMap Map<String, Object> filter, @Query("page") long page);

    /**
     *
     * @param owner Login of the repository owner (can be org)
     * @param repo Name of the repository
     * @param number Issue number
     * @return An issue
     */
    @GET("repos/{owner}/{repo}/issues/{number}")
    Single<Response<Issue>> getIssue(@Path("owner") String owner, @Path("repo") String repo, @Path("number") long number);

    /**
     *
     * @param owner Login of the repository owner (can be org)
     * @param repo Name of the repository
     * @param issue The issue to create, parameters: <a>https://developer.github.com/v3/issues/#parameters-2</a>
     * @return The created issue
     */
    @POST("repos/{owner}/{repo}/issues")
    Single<Response<Issue>> createIssue(@Path("owner") String owner, @Path("repo") String repo, @Body IssueRequest issue);

    /**
     *
     * @param owner Login of the repository owner (can be org)
     * @param repo Name of the repository
     * @param number Issue number
     * @param issue The issue to create, parameters: <a>https://developer.github.com/v3/issues/#parameters-2</a>
     * @return The edited issue
     */
    @PATCH("repos/{owner}/{repo}/issues/{number}")
    Single<Response<Issue>> editIssue(@Path("owner") String owner, @Path("repo") String repo, @Path("number") long number, @Body IssueRequest issue);

    /**
     *
     * @param owner Login of the repository owner (can be org)
     * @param repo Name of the repository
     * @param number Issue number
     * @return 204 if success
     */
    @Headers("Content-Length: 0")
    @PUT("repos/{owner}/{repo}/issues/{number}/lock")
    Single<Response<Void>> lockIssue(@Path("owner") String owner, @Path("repo") String repo, @Path("number") long number);

    /**
     *
     * @param owner Login of the repository owner (can be org)
     * @param repo Name of the repository
     * @param number Issue number
     * @return 204 if success
     */
    @DELETE("repos/{owner}/{repo}/issues/{number}/lock")
    Single<Response<Void>> unlockIssue(@Path("owner") String owner, @Path("repo") String repo, @Path("number") long number);
}