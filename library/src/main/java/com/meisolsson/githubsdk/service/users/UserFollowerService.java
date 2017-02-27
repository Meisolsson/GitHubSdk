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

package com.meisolsson.githubsdk.service.users;

import com.meisolsson.githubsdk.model.Page;
import com.meisolsson.githubsdk.model.User;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserFollowerService {

    @GET("users/{username}/followers")
    Single<Page<User>> getFollowers(@Path("username") String username, @Query("page") long page);

    @GET("/user/followers")
	Single<Page<User>> getFollowers(@Query("page") long page);

    @GET("users/{username}/following")
	Single<Page<User>> getFollowing(@Path("username") String username, @Query("page") long page);

    @GET("/user/following")
	Single<Page<User>> getFollowing(@Query("page") long page);

    @GET("user/following/{username}")
	Single<Response<Boolean>> isFollowing(@Path("username") String username);

    @GET("users/{username}/following/{target_user}")
	Single<Response<Boolean>> isFollowing(@Path("username") String username, @Path("target_user") String target_user);

    @Headers("Content-Length: 0")
    @PUT("user/following/{username}")
	Single<Response<Boolean>> followUser(@Path("username") String username);

    @DELETE("user/following/{username}")
	Single<Response<Boolean>> unfollowUser(@Path("username") String username);

}
