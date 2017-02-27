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

import com.meisolsson.githubsdk.model.IssueEvent;
import com.meisolsson.githubsdk.model.Page;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IssueEventService {

    @GET("repos/{owner}/{repo}/issues/{issue_number}/events")
    Observable<Page<IssueEvent>> getIssueEvents(@Path("owner") String owner, @Path("repo") String repo, @Path("issue_number") int issue_number, @Query("page") long page);

    @GET("repos/{owner}/{repo}/issues/events")
	Observable<Page<IssueEvent>> getRepositoryIssueEvents(@Path("owner") String owner, @Path("repo") String repo, @Query("page") long page);

    @GET("repos/{owner}/{repo}/issues/events/{id}")
	Observable<IssueEvent> getIssueEvent(@Path("owner") String owner, @Path("repo") String repo, @Path("id") String id);
}
