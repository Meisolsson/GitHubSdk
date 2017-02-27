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

import com.meisolsson.githubsdk.model.PagesBuild;
import com.meisolsson.githubsdk.model.PagesInfo;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RepositoryPagesService {

    @GET("repos/{owner}/{repo}/pages")
    Observable<PagesInfo> getPagesInformation(@Path("owner") String owner, @Path("repo") String repo);

    @GET("repos/{owner}/{repo}/pages/builds")
	Observable<PagesBuild> getPagesBuilds(@Path("owner") String owner, @Path("repo") String repo);

    @GET("repos/{owner}/{repo}/pages/builds/latest")
	Observable<PagesBuild> getLatestPagesBuild(@Path("owner") String owner, @Path("repo") String repo);

    @GET("repos/{owner}/{repo}/pages/builds/{id}")
	Observable<PagesBuild> getPagesBuild(@Path("owner") String owner, @Path("repo") String repo, @Path("id") String id);

}
