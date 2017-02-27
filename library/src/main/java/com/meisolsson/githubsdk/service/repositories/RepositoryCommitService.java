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

import com.meisolsson.githubsdk.model.Commit;
import com.meisolsson.githubsdk.model.CommitCompare;
import com.meisolsson.githubsdk.model.Page;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RepositoryCommitService {

    @GET("repos/{owner}/{repo}/commits")
    Single<Page<Commit>> getCommits(@Path("owner") String owner, @Path("repo") String repo, @Query("page") long page);

    @GET("repos/{owner}/{repo}/commits")
    Single<Page<Commit>> getCommits(@Path("owner") String owner, @Path("repo") String repo, @Query("sha") String sha, @Query("page") long page);

    @GET("repos/{owner}/{repo}/commits/{sha}")
	Single<Commit> getCommit(@Path("owner") String owner, @Path("repo") String repo, @Path("sha") String sha);

    @GET("repos/{owner}/{repo}/compare/{base}...{head}")
	Single<CommitCompare> compareCommits(@Path("owner") String owner, @Path("repo") String repo, @Path("base") String base, @Path("head") String head);
}
