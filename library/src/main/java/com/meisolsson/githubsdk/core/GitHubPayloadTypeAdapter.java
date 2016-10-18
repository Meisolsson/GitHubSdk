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

import android.os.Parcel;

import com.meisolsson.githubsdk.model.GitHubEventType;
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
import com.ryanharter.auto.value.parcel.TypeAdapter;

public class GitHubPayloadTypeAdapter implements TypeAdapter<GitHubPayload>{

    @Override
    public GitHubPayload fromParcel(Parcel in) {
        switch (GitHubEventType.valueOf(in.readString())) {
            case CommitCommentEvent:
                return CommitCommentPayload.createFromParcel(in);
            case CreateEvent:
                return CreatePayload.createFromParcel(in);
            case DeleteEvent:
                return DeletePayload.createFromParcel(in);
            case DeploymentEvent:
                return DeploymentPayload.createFromParcel(in);
            case DeploymentStatusEvent:
                return DeploymentStatusPayload.createFromParcel(in);
            case DownloadEvent:
                return DownloadPayload.createFromParcel(in);
            case FollowEvent:
                return FollowPayload.createFromParcel(in);
            case ForkEvent:
                return ForkPayload.createFromParcel(in);
            case ForkApplyEvent:
                return ForkApplyPayload.createFromParcel(in);
            case GistEvent:
                return GistPayload.createFromParcel(in);
            case GollumEvent:
                return GollumPayload.createFromParcel(in);
            case IssueCommentEvent:
                return IssueCommentPayload.createFromParcel(in);
            case IssuesEvent:
                return IssuesPayload.createFromParcel(in);
            case MemberEvent:
                return MemberPayload.createFromParcel(in);
            case MembershipEvent:
                return MembershipPayload.createFromParcel(in);
            case PageBuildEvent:
                return PageBuildPayload.createFromParcel(in);
            case PublicEvent:
                return PublicPayload.createFromParcel(in);
            case PullRequestEvent:
                return PullRequestPayload.createFromParcel(in);
            case PullRequestReviewCommentEvent:
                return PullRequestReviewCommentPayload.createFromParcel(in);
            case PushEvent:
                return PushPayload.createFromParcel(in);
            case ReleaseEvent:
                return ReleasePayload.createFromParcel(in);
            case RepositoryEvent:
                return RepositoryPayload.createFromParcel(in);
            case StatusEvent:
                return StatusPayload.createFromParcel(in);
            case TeamAddEvent:
                return TeamAddPayload.createFromParcel(in);
            case WatchEvent:
                return WatchPayload.createFromParcel(in);
            default:
                return null;
        }
    }

    @Override
    public void toParcel(GitHubPayload value, Parcel dest) {
        String className = value.getClass()
                .getSimpleName()
                .replace("AutoValue_", "")
                .replace("Payload", "Event");

        dest.writeString(className);
        value.writeToParcel(dest, 0);
    }
}
