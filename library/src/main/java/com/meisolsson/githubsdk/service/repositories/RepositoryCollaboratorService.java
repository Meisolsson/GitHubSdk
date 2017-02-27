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
import com.meisolsson.githubsdk.model.User;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RepositoryCollaboratorService {

    @GET("repos/{owner}/{repo}/collaborators")
    Observable<Page<User>> getCollaborators(@Path("owner") String owner, @Path("repo") String repo, @Query("page") long page);

    @GET("repos/{owner}/{repo}/collaborators/{username}")
	Observable<Response<Boolean>> isUserCollaborator(@Path("owner") String owner, @Path("repo") String repo, @Path("username") String username);

    @Headers("Content-Length: 0")
    @PUT("repos/{owner}/{repo}/collaborators/{username}")
	Observable<Response<Boolean>> addUserAsCollaborator(@Path("owner") String owner, @Path("repo") String repo, @Path("username") String username);

    @DELETE("repos/{owner}/{repo}/collaborators/{username}")
	Observable<Response<Boolean>> deleteUseraAsCollaborator(@Path("owner") String owner, @Path("repo") String repo, @Path("username") String username);
}
