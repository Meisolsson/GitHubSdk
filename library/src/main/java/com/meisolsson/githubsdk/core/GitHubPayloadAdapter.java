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

package com.meisolsson.githubsdk.core;

import com.meisolsson.githubsdk.model.payload.CommitCommentPayload;
import com.meisolsson.githubsdk.model.payload.CreatePayload;
import com.meisolsson.githubsdk.model.payload.DeletePayload;
import com.meisolsson.githubsdk.model.payload.DeploymentPayload;
import com.meisolsson.githubsdk.model.payload.DeploymentStatusPayload;
import com.meisolsson.githubsdk.model.payload.DownloadPayload;
import com.meisolsson.githubsdk.model.payload.FollowPayload;
import com.meisolsson.githubsdk.model.payload.ForkApplyPayload;
import com.meisolsson.githubsdk.model.payload.ForkPayload;
import com.meisolsson.githubsdk.model.payload.GistPayload;
import com.meisolsson.githubsdk.model.payload.GitHubPayload;
import com.meisolsson.githubsdk.model.payload.GollumPayload;
import com.meisolsson.githubsdk.model.payload.IssueCommentPayload;
import com.meisolsson.githubsdk.model.payload.IssuesPayload;
import com.meisolsson.githubsdk.model.payload.MemberPayload;
import com.meisolsson.githubsdk.model.payload.MembershipPayload;
import com.meisolsson.githubsdk.model.payload.PageBuildPayload;
import com.meisolsson.githubsdk.model.payload.PublicPayload;
import com.meisolsson.githubsdk.model.payload.PullRequestPayload;
import com.meisolsson.githubsdk.model.payload.PullRequestReviewCommentPayload;
import com.meisolsson.githubsdk.model.payload.PushPayload;
import com.meisolsson.githubsdk.model.payload.ReleasePayload;
import com.meisolsson.githubsdk.model.payload.RepositoryPayload;
import com.meisolsson.githubsdk.model.payload.StatusPayload;
import com.meisolsson.githubsdk.model.payload.TeamAddPayload;
import com.meisolsson.githubsdk.model.payload.WatchPayload;
import com.squareup.moshi.FromJson;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.ToJson;

import java.io.IOException;

public class GitHubPayloadAdapter {

    @FromJson
    GitHubPayload fromJson(JsonReader json) throws IOException {
        return null;
    }

    @ToJson
    String toJson(GitHubPayload payload) {
        Moshi moshi = ServiceGenerator.moshi;
                
        if (payload instanceof CommitCommentPayload) {
            return CommitCommentPayload.jsonAdapter(moshi).toJson((CommitCommentPayload) payload);
        } else if (payload instanceof CreatePayload) {
            return CreatePayload.jsonAdapter(moshi).toJson((CreatePayload) payload);
        } else if (payload instanceof DeletePayload) {
            return DeletePayload.jsonAdapter(moshi).toJson((DeletePayload) payload);
        } else if (payload instanceof DeploymentPayload) {
            return DeploymentPayload.jsonAdapter(moshi).toJson((DeploymentPayload) payload);
        } else if (payload instanceof DeploymentStatusPayload) {
            return DeploymentStatusPayload.jsonAdapter(moshi).toJson((DeploymentStatusPayload) payload);
        } else if (payload instanceof DownloadPayload) {
            return DownloadPayload.jsonAdapter(moshi).toJson((DownloadPayload) payload);
        } else if (payload instanceof FollowPayload) {
            return FollowPayload.jsonAdapter(moshi).toJson((FollowPayload) payload);
        } else if (payload instanceof ForkPayload) {
            return ForkPayload.jsonAdapter(moshi).toJson((ForkPayload) payload);
        } else if (payload instanceof ForkApplyPayload) {
            return ForkApplyPayload.jsonAdapter(moshi).toJson((ForkApplyPayload) payload);
        } else if (payload instanceof GistPayload) {
            return GistPayload.jsonAdapter(moshi).toJson((GistPayload) payload);
        } else if (payload instanceof GollumPayload) {
            return GollumPayload.jsonAdapter(moshi).toJson((GollumPayload) payload);
        } else if (payload instanceof IssueCommentPayload) {
            return IssueCommentPayload.jsonAdapter(moshi).toJson((IssueCommentPayload) payload);
        } else if (payload instanceof IssuesPayload) {
            return IssuesPayload.jsonAdapter(moshi).toJson((IssuesPayload) payload);
        } else if (payload instanceof MemberPayload) {
            return MemberPayload.jsonAdapter(moshi).toJson((MemberPayload) payload);
        } else if (payload instanceof MembershipPayload) {
            return MembershipPayload.jsonAdapter(moshi).toJson((MembershipPayload) payload);
        } else if (payload instanceof PageBuildPayload) {
            return PageBuildPayload.jsonAdapter(moshi).toJson((PageBuildPayload) payload);
        } else if (payload instanceof PublicPayload) {
            return PublicPayload.jsonAdapter(moshi).toJson((PublicPayload) payload);
        } else if (payload instanceof PullRequestPayload) {
            return PullRequestPayload.jsonAdapter(moshi).toJson((PullRequestPayload) payload);
        } else if (payload instanceof PullRequestReviewCommentPayload) {
            return PullRequestReviewCommentPayload.jsonAdapter(moshi).toJson((PullRequestReviewCommentPayload) payload);
        } else if (payload instanceof PushPayload) {
            return PushPayload.jsonAdapter(moshi).toJson((PushPayload) payload);
        } else if (payload instanceof ReleasePayload) {
            return ReleasePayload.jsonAdapter(moshi).toJson((ReleasePayload) payload);
        } else if (payload instanceof RepositoryPayload) {
            return RepositoryPayload.jsonAdapter(moshi).toJson((RepositoryPayload) payload);
        } else if (payload instanceof StatusPayload) {
            return StatusPayload.jsonAdapter(moshi).toJson((StatusPayload) payload);
        } else if (payload instanceof TeamAddPayload) {
            return TeamAddPayload.jsonAdapter(moshi).toJson((TeamAddPayload) payload);
        } else if (payload instanceof WatchPayload) {
            return WatchPayload.jsonAdapter(moshi).toJson((WatchPayload) payload);
        }

        return null;
    }
}
