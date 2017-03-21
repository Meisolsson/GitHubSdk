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

import com.meisolsson.githubsdk.model.Page;
import com.meisolsson.githubsdk.model.User;
import com.meisolsson.githubsdk.model.request.organization.EditOrganization;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface OrganizationService {

    @GET("/user/orgs")
    Single<Response<Page<User>>> getMyOrganizations(@Query("page") long page);

    @GET("/organizations")
    Single<Response<Page<User>>> getAllOrganizations(@Query("page") long page);

    @GET("users/{username}/orgs")
	Single<Response<Page<User>>> getUserPublicOrganizations(@Path("username") String username, @Query("page") long page);

    @GET("orgs/{org}")
	Single<Response<Page<User>>> getOrganization(@Path("org") String org, @Query("page") long page);

    @PATCH("orgs/{org}")
	Single<Response<User>> editOrganization(@Path("org") String org, @Body EditOrganization body);

}
