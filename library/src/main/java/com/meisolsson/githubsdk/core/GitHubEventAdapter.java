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

import com.meisolsson.githubsdk.model.GitHubEvent;
import com.meisolsson.githubsdk.model.GitHubEventType;
import com.meisolsson.githubsdk.model.Repository;
import com.meisolsson.githubsdk.model.User;
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
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.ToJson;

import java.io.IOException;
import java.util.Date;

import okio.Buffer;

public class GitHubEventAdapter {

    @FromJson GitHubEvent fromJson(JsonReader json) throws IOException {
        GitHubPayload payload = null;
        GitHubEventType type = null;
        User actor = null;
        User org = null;
        String id = null;
        Date createdAt = null;
        boolean _public = false;
        GitHubEvent.RepoIdentifier repo = null;

        Moshi moshi = ServiceGenerator.moshi;

        json.beginObject();
        while (json.hasNext()) {
            switch (json.nextName()) {
                case "type":
                    type = GitHubEventType.valueOf(json.nextString());
                    break;
                case "actor":
                    actor = User.jsonAdapter(moshi).fromJson(json);
                    break;
                case "org":
                    org = User.jsonAdapter(moshi).fromJson(json);
                    break;
                case "id":
                    id = json.nextString();
                    break;
                case "created_at":
                    createdAt = new FormattedTimeAdapter().fromJson(json.nextString());
                    break;
                case "public":
                    _public = json.nextBoolean();
                    break;
                case "repo":
                    repo = GitHubEvent.RepoIdentifier.jsonAdapter(moshi).fromJson(json);
                    break;
                case "payload":
                    payload = readPayload(type, moshi, json).toBuilder().type(type).build();
                    break;
                default:
                    json.skipValue();
                    break;
            }
        }
        json.endObject();

        return GitHubEvent.builder()
                .type(type)
                .id(id)
                .payload(payload)
                .repo(repo)
                .actor(actor)
                .org(org)
                .isPublic(_public)
                .createdAt(createdAt)
                .build();
    }

    @ToJson
    String toJson(GitHubEvent event) {
        Buffer buffer = new Buffer();
        JsonWriter writer = JsonWriter.of(buffer);
        Moshi moshi = ServiceGenerator.moshi;

        try {
            writer.beginObject()
                    .name("type").value(event.type().toString())
                    .name("ud").value(event.id())
                    .name("created_at").value(new FormattedTimeAdapter().toJson(event.createdAt()))
                    .name("public").value(event.isPublic() != null ? event.isPublic() : true);
            
            writer.name("org");
            User.jsonAdapter(moshi).toJson(writer, event.org());
            writer.name("actor");
            User.jsonAdapter(moshi).toJson(writer, event.actor());
            writer.name("repo");
            GitHubEvent.RepoIdentifier.jsonAdapter(moshi).toJson(writer, event.repo());
            writer.name("payload");
            payloadToJson(event.type(), moshi, event.payload(), writer);

            writer.endObject();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return buffer.toString();
    }
    
    private GitHubPayload readPayload(GitHubEventType type, Moshi moshi, JsonReader json) throws IOException {
        switch (type) {
            case CommitCommentEvent:
                return CommitCommentPayload.jsonAdapter(moshi).fromJson(json);
            case CreateEvent:
                return CreatePayload.jsonAdapter(moshi).fromJson(json);
            case DeleteEvent:
                return DeletePayload.jsonAdapter(moshi).fromJson(json);
            case DeploymentEvent:
                return DeploymentPayload.jsonAdapter(moshi).fromJson(json);
            case DeploymentStatusEvent:
                return DeploymentStatusPayload.jsonAdapter(moshi).fromJson(json);
            case DownloadEvent:
                return DownloadPayload.jsonAdapter(moshi).fromJson(json);
            case FollowEvent:
                return FollowPayload.jsonAdapter(moshi).fromJson(json);
            case ForkEvent:
                return ForkPayload.jsonAdapter(moshi).fromJson(json);
            case ForkApplyEvent:
                return ForkApplyPayload.jsonAdapter(moshi).fromJson(json);
            case GistEvent:
                return GistPayload.jsonAdapter(moshi).fromJson(json);
            case GollumEvent:
                return GollumPayload.jsonAdapter(moshi).fromJson(json);
            case IssueCommentEvent:
                return IssueCommentPayload.jsonAdapter(moshi).fromJson(json);
            case IssuesEvent:
                return IssuesPayload.jsonAdapter(moshi).fromJson(json);
            case MemberEvent:
                return MemberPayload.jsonAdapter(moshi).fromJson(json);
            case MembershipEvent:
                return MembershipPayload.jsonAdapter(moshi).fromJson(json);
            case PageBuildEvent:
                return PageBuildPayload.jsonAdapter(moshi).fromJson(json);
            case PublicEvent:
                return PublicPayload.jsonAdapter(moshi).fromJson(json);
            case PullRequestEvent:
                return PullRequestPayload.jsonAdapter(moshi).fromJson(json);
            case PullRequestReviewCommentEvent:
                return PullRequestReviewCommentPayload.jsonAdapter(moshi).fromJson(json);
            case PushEvent:
                return PushPayload.jsonAdapter(moshi).fromJson(json);
            case ReleaseEvent:
                return ReleasePayload.jsonAdapter(moshi).fromJson(json);
            case RepositoryEvent:
                return RepositoryPayload.jsonAdapter(moshi).fromJson(json);
            case StatusEvent:
                return StatusPayload.jsonAdapter(moshi).fromJson(json);
            case TeamAddEvent:
                return TeamAddPayload.jsonAdapter(moshi).fromJson(json);
            case WatchEvent:
                return WatchPayload.jsonAdapter(moshi).fromJson(json);
            default:
                return null;
        }
    }

    private void payloadToJson(GitHubEventType type, Moshi moshi, GitHubPayload payload, JsonWriter writer) throws IOException {
        switch (type) {
            case CommitCommentEvent:
                CommitCommentPayload.jsonAdapter(moshi).toJson(writer, (CommitCommentPayload) payload);
                break;
            case CreateEvent:
                CreatePayload.jsonAdapter(moshi).toJson(writer, (CreatePayload) payload);
                break;
            case DeleteEvent:
                DeletePayload.jsonAdapter(moshi).toJson(writer, (DeletePayload) payload);
                break;
            case DeploymentEvent:
                DeploymentPayload.jsonAdapter(moshi).toJson(writer, (DeploymentPayload) payload);
                break;
            case DeploymentStatusEvent:
                DeploymentStatusPayload.jsonAdapter(moshi).toJson(writer, (DeploymentStatusPayload) payload);
                break;
            case DownloadEvent:
                DownloadPayload.jsonAdapter(moshi).toJson(writer, (DownloadPayload) payload);
                break;
            case FollowEvent:
                FollowPayload.jsonAdapter(moshi).toJson(writer, (FollowPayload) payload);
                break;
            case ForkEvent:
                ForkPayload.jsonAdapter(moshi).toJson(writer, (ForkPayload) payload);
                break;
            case ForkApplyEvent:
                ForkApplyPayload.jsonAdapter(moshi).toJson(writer, (ForkApplyPayload) payload);
                break;
            case GistEvent:
                GistPayload.jsonAdapter(moshi).toJson(writer, (GistPayload) payload);
                break;
            case GollumEvent:
                GollumPayload.jsonAdapter(moshi).toJson(writer, (GollumPayload) payload);
                break;
            case IssueCommentEvent:
                IssueCommentPayload.jsonAdapter(moshi).toJson(writer, (IssueCommentPayload) payload);
                break;
            case IssuesEvent:
                IssuesPayload.jsonAdapter(moshi).toJson(writer, (IssuesPayload) payload);
                break;
            case MemberEvent:
                MemberPayload.jsonAdapter(moshi).toJson(writer, (MemberPayload) payload);
                break;
            case MembershipEvent:
                MembershipPayload.jsonAdapter(moshi).toJson(writer, (MembershipPayload) payload);
                break;
            case PageBuildEvent:
                PageBuildPayload.jsonAdapter(moshi).toJson(writer, (PageBuildPayload) payload);
                break;
            case PublicEvent:
                PublicPayload.jsonAdapter(moshi).toJson(writer, (PublicPayload) payload);
                break;
            case PullRequestEvent:
                PullRequestPayload.jsonAdapter(moshi).toJson(writer, (PullRequestPayload) payload);
                break;
            case PullRequestReviewCommentEvent:
                PullRequestReviewCommentPayload.jsonAdapter(moshi).toJson(writer, (PullRequestReviewCommentPayload) payload);
                break;
            case PushEvent:
                PushPayload.jsonAdapter(moshi).toJson(writer, (PushPayload) payload);
                break;
            case ReleaseEvent:
                ReleasePayload.jsonAdapter(moshi).toJson(writer, (ReleasePayload) payload);
                break;
            case RepositoryEvent:
                RepositoryPayload.jsonAdapter(moshi).toJson(writer, (RepositoryPayload) payload);
                break;
            case StatusEvent:
                StatusPayload.jsonAdapter(moshi).toJson(writer, (StatusPayload) payload);
                break;
            case TeamAddEvent:
                TeamAddPayload.jsonAdapter(moshi).toJson(writer, (TeamAddPayload) payload);
                break;
            case WatchEvent:
                WatchPayload.jsonAdapter(moshi).toJson(writer, (WatchPayload) payload);
                break;
        }
    }
}
