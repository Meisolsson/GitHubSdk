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
import com.meisolsson.githubsdk.model.User;
import com.meisolsson.githubsdk.model.request.organization.EditOrganizationMembership;
import com.meisolsson.githubsdk.model.request.organization.EditOrganizationMembershipState;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface OrganizationMemberService {

    @GET("orgs/{org}/members")
    Single<Page<User>> getMembers(@Path("org") String org, @Query("page") long page);

    @GET("orgs/{org}/members/{username}")
	Single<Response<Boolean>> isMember(@Path("org") String org, @Path("username") String username);

    @DELETE("orgs/{org}/members/{username}")
	Single<Response<Boolean>> deleteMember(@Path("org") String org, @Path("username") String username);

    @GET("orgs/{org}/public_members")
	Single<Page<User>> getPublicMembers(@Path("org") String org, @Query("page") long page);

    @GET("orgs/{org}/public_members/{username}")
	Single<Response<Boolean>> isMemberPublic(@Path("org") String org, @Path("username") String username);

    @Headers("Content-Length: 0")
    @PUT("orgs/{org}/public_members/{username}")
	Single<Response<Boolean>> publicizeMembership(@Path("org") String org, @Path("username") String username);

    @DELETE("orgs/{org}/public_members/{username}")
	Single<Response<Boolean>> unpublicizeMembership(@Path("org") String org, @Path("username") String username);

    @GET("orgs/{org}/memberships/{username}")
	Single<Membership> getMembership(@Path("org") String org, @Path("username") String username);

    @PUT("orgs/{org}/memberships/{username}")
	Single<Membership> changeOrganizationMembership(@Path("org") String org, @Path("username") String username, @Body EditOrganizationMembership body);

    @DELETE("orgs/{org}/memberships/{username}")
	Single<Response<Boolean>> deleteOrganizationMembership(@Path("org") String org, @Path("username") String username);

    @GET("/user/memberships/orgs")
	Single<Page<Membership>> getOrganizationMemberships(@Query("page") long page);

    @GET("user/memberships/orgs/{org}")
	Single<Membership> getOrganizationMembership(@Path("org") String org);

    @PATCH("user/memberships/orgs/{org}")
	Single<Membership> changeOrganizationMembershipState(@Path("org") String org, @Body EditOrganizationMembershipState state);

}
