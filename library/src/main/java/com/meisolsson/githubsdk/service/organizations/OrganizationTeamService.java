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

package com.meisolsson.githubsdk.service.organizations;

import com.meisolsson.githubsdk.model.Membership;
import com.meisolsson.githubsdk.model.Page;
import com.meisolsson.githubsdk.model.Repository;
import com.meisolsson.githubsdk.model.Team;
import com.meisolsson.githubsdk.model.User;
import com.meisolsson.githubsdk.model.request.organization.CreateTeam;
import com.meisolsson.githubsdk.model.request.organization.CreateTeamMembership;

import io.reactivex.Observable;
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

public interface OrganizationTeamService {

    @GET("orgs/{org}/teams")
    Observable<Page<Team>> getOrganizationTeams(@Path("org") String org, @Query("page") long page);

    @GET("teams/{id}")
	Observable<Team> getTeam(@Path("id") String id);

    @POST("orgs/{org}/teams")
	Observable<Team> createTeam(@Path("org") String org, @Body CreateTeam body);

    @PATCH("teams/{id}")
	Observable<Team> editTeam(@Path("id") String id, @Body CreateTeam body);

    @DELETE("teams/{id}")
	Observable<Response<Boolean>> deleteTeam(@Path("id") String id);

    @GET("teams/{id}/members")
	Observable<Page<User>> getTeamMembers(@Path("id") String id, @Query("page") long page);

    @GET("teams/{id}/memberships/{username}")
	Observable<Membership> getTeamMembership(@Path("id") String id, @Path("username") String username);

    @PUT("teams/{id}/memberships/{username}")
	Observable<Membership> createTeamMembership(@Path("id") String id, @Path("username") String username, @Body CreateTeamMembership body);

    @DELETE("teams/{id}/memberships/{username}")
	Observable<Response<Boolean>> deleteTeamMembership(@Path("id") String id, @Path("username") String username);

    @GET("teams/{id}/repos")
	Observable<Page<Repository>> getTeamRepositories(@Path("id") String id, @Query("page") long page);

    @GET("teams/{id}/repos/{owner}/{repo}")
	Observable<Response<Boolean>> isTeamManagingRepository(@Path("id") String id, @Path("owner") String owner, @Path("repo") String repo);

    @Headers("Content-Length: 0")
    @PUT("teams/{id}/repos/{org}/{repo}")
	Observable<Response<Boolean>> changeTeamRepository(@Path("id") String id, @Path("org") String org, @Path("repo") String repo);

    @DELETE("teams/{id}/repos/{owner}/{repo}")
	Observable<Response<Boolean>> deleteTeamRepository(@Path("id") String id, @Path("owner") String owner, @Path("repo") String repo);

    @GET("/user/teams")
	Observable<Page<Team>> getTeams(@Query("page") long page);
}
