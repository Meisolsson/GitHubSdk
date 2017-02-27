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

import com.meisolsson.githubsdk.model.Deployment;
import com.meisolsson.githubsdk.model.DeploymentStatus;
import com.meisolsson.githubsdk.model.Page;
import com.meisolsson.githubsdk.model.request.repository.CreateDeployment;
import com.meisolsson.githubsdk.model.request.repository.CreateDeploymentStatus;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RepositoryDeploymentService {

    @GET("repos/{owner}/{repo}/deployments")
    Observable<Page<Deployment>> getDeployments(@Path("owner") String owner, @Path("repo") String repo, @Query("page") long page);


    @POST("repos/{owner}/{repo}/deployments")
	Observable<Deployment> createDeployment(@Path("owner") String owner, @Path("repo") String repo, @Body CreateDeployment body);

    @GET("repos/{owner}/{repo}/deployments/{id}/statuses")
	Observable<Page<DeploymentStatus>> getDeploymentStatuses(@Path("owner") String owner, @Path("repo") String repo, @Path("id") String id, @Query("page") long page);

    @POST("repos/{owner}/{repo}/deployments/{id}/statuses")
	Observable<DeploymentStatus> createDeploymentStatus(@Path("owner") String owner, @Path("repo") String repo, @Path("id") String id, @Body CreateDeploymentStatus body);
}
