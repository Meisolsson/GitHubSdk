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

package com.meisolsson.githubsdk.model.git;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.meisolsson.githubsdk.model.VerificationResult;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.util.List;

@AutoValue
public abstract class GitCommit implements Parcelable {

    @Nullable
    public abstract String sha();

    @Nullable
    public abstract String url();

    @Nullable
    public abstract String message();

    @Nullable
    public abstract GitUser author();

    @Nullable
    public abstract GitUser committer();

    @Nullable
    public abstract GitTree tree();

    @Nullable
    public abstract Boolean distinct();

    @Nullable
    public abstract List<GitCommit> parents();

    @Json(name = "comment_count")
    @Nullable
    public abstract Integer commentCount();

    @Nullable
    public abstract VerificationResult verification();

    public abstract Builder toBuilder();

    public static JsonAdapter<GitCommit> jsonAdapter(Moshi moshi) {
        return new AutoValue_GitCommit.MoshiJsonAdapter(moshi);
    }

    public static Builder builder() {
        return new AutoValue_GitCommit.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder sha(String sha);

        public abstract Builder url(String url);

        public abstract Builder message(String message);

        public abstract Builder author(GitUser author);

        public abstract Builder committer(GitUser committer);

        public abstract Builder tree(GitTree tree);

        public abstract Builder distinct(Boolean distinct);

        public abstract Builder parents(@Nullable List<GitCommit> parents);

        public abstract Builder commentCount(Integer commentCount);

        public abstract Builder verification(VerificationResult verification);

        public abstract GitCommit build();
    }
}
