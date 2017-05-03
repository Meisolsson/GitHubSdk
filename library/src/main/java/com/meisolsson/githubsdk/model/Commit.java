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
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.meisolsson.githubsdk.model.git.GitCommit;
import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.util.List;

@AutoValue
public abstract class Commit implements Parcelable {

    @Nullable
    public abstract String url();

    @Nullable
    public abstract String ref();

    @Nullable
    public abstract Repository repo();

    @Nullable
    public abstract String sha();

    @Nullable
    public abstract Boolean distinct();

    @Nullable
    public abstract GitCommit commit();

    @Nullable
    public abstract User author();

    @Nullable
    public abstract User committer();

    @Nullable
    public abstract List<Commit> parents();

    @Nullable
    public abstract GitHubStats stats();

    @Nullable
    public abstract List<GitHubFile> files();

    @Json(name = "html_url")
    @Nullable
    public abstract String htmlUrl();

    public abstract Builder toBuilder();

    public static JsonAdapter<Commit> jsonAdapter(Moshi moshi) {
        return new AutoValue_Commit.MoshiJsonAdapter(moshi);
    }

    public static Builder builder() {
        return new AutoValue_Commit.Builder();
    }


    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder url(String url);

        public abstract Builder ref(String ref);

        public abstract Builder repo(Repository repo);

        public abstract Builder sha(String sha);

        public abstract Builder distinct(Boolean distinct);

        public abstract Builder commit(GitCommit commit);

        public abstract Builder author(User author);

        public abstract Builder committer(User committer);

        public abstract Builder parents(@Nullable List<Commit> parents);

        public abstract Builder stats(GitHubStats stats);

        public abstract Builder files(@NonNull List<GitHubFile> files);

        public abstract Builder htmlUrl(String htmlUrl);

        public abstract Commit build();
    }
}