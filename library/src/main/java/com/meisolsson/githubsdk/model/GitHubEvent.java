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

package com.meisolsson.githubsdk.model;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.meisolsson.githubsdk.core.FormattedTime;
import com.meisolsson.githubsdk.core.GitHubPayloadTypeAdapter;
import com.meisolsson.githubsdk.model.payload.GitHubPayload;
import com.google.auto.value.AutoValue;
import com.ryanharter.auto.value.parcel.ParcelAdapter;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.util.Date;

@AutoValue
public abstract class GitHubEvent implements Parcelable {
    @AutoValue
    public abstract static class RepoIdentifier implements Parcelable {
        @Nullable
        public abstract Long id();

        @Nullable
        public abstract String url();

        @Json(name = "name")
        @Nullable
        public abstract String repoWithUserName();

        public static JsonAdapter<RepoIdentifier> jsonAdapter(Moshi moshi) {
            return new AutoValue_GitHubEvent_RepoIdentifier.MoshiJsonAdapter(moshi);
        }

        public static Builder builder() {
            return new AutoValue_GitHubEvent_RepoIdentifier.Builder();
        }

        @AutoValue.Builder
        public abstract static class Builder {
            public abstract Builder id(Long id);

            public abstract Builder url(String url);

            public abstract Builder repoWithUserName(String repoWithUserName);

            public abstract RepoIdentifier build();
        }
    }

    @Nullable
    public abstract GitHubEventType type();

    @Nullable
    public abstract String id();

    @ParcelAdapter(GitHubPayloadTypeAdapter.class)
    @Nullable
    public abstract GitHubPayload payload();

    @Nullable
    public abstract RepoIdentifier repo();

    @Nullable
    public abstract User actor();

    @Nullable
    public abstract User org();

    @Json(name = "public")
    @Nullable
    public abstract Boolean isPublic();

    @Json(name = "created_at")
    @Nullable
    @FormattedTime
    public abstract Date createdAt();

    public abstract Builder toBuilder();

    public static JsonAdapter<GitHubEvent> jsonAdapter(Moshi moshi) {
        return new AutoValue_GitHubEvent.MoshiJsonAdapter(moshi);
    }

    public static Builder builder() {
        return new AutoValue_GitHubEvent.Builder();
    }


    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder type(GitHubEventType type);

        public abstract Builder id(String id);

        public abstract Builder payload(GitHubPayload payload);

        public abstract Builder repo(RepoIdentifier repo);

        public abstract Builder actor(User actor);

        public abstract Builder org(User org);

        public abstract Builder isPublic(Boolean newPublic);

        public abstract Builder createdAt(Date createdAt);

        public abstract GitHubEvent build();
    }
}
