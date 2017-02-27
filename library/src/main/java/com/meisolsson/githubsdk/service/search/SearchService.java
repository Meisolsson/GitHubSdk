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

package com.meisolsson.githubsdk.service.search;

import com.meisolsson.githubsdk.model.Issue;
import com.meisolsson.githubsdk.model.Repository;
import com.meisolsson.githubsdk.model.SearchCode;
import com.meisolsson.githubsdk.model.SearchPage;
import com.meisolsson.githubsdk.model.User;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SearchService {

    @GET("/search/repositories")
    Single<SearchPage<Repository>> searchRepositories(@Query("q") String query, @Query("sort") String sort, @Query("order") String order, @Query("page") long page);

    @GET("/search/code")
    Single<SearchPage<SearchCode>> searchCode(@Query("q") String query, @Query("sort") String sort, @Query("order") String order, @Query("page") long page);

    @GET("/search/issues")
    Single<SearchPage<Issue>> searchIssues(@Query("q") String query, @Query("sort") String sort, @Query("order") String order, @Query("page") long page);

    @GET("/search/users")
    Single<SearchPage<User>> searchUsers(@Query("q") String query, @Query("sort") String sort, @Query("order") String order, @Query("page") long page);
}
