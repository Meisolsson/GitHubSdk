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

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

@AutoValue
public abstract class GitHubFile implements Parcelable {

    @Nullable
    public abstract String filename();

    @Nullable
    public abstract String status();

    @Nullable
    public abstract String patch();

    @Nullable
    public abstract String sha();

    @Nullable
    public abstract Integer additions();

    @Nullable
    public abstract Integer deletions();

    @Nullable
    public abstract Integer changes();

    @Json(name = "raw_url")
    @Nullable
    public abstract String rawUrl();

    @Json(name = "blob_url")
    @Nullable
    public abstract String blobUrl();

    public abstract Builder toBuilder();

    public static JsonAdapter<GitHubFile> jsonAdapter(Moshi moshi) {
        return new AutoValue_GitHubFile.MoshiJsonAdapter(moshi);
    }

    public static Builder builder() {
        return new AutoValue_GitHubFile.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder filename(String filename);

        public abstract Builder status(String status);

        public abstract Builder patch(String patch);

        public abstract Builder sha(String sha);

        public abstract Builder additions(Integer additions);

        public abstract Builder deletions(Integer deletions);

        public abstract Builder changes(Integer changes);

        public abstract Builder rawUrl(String rawUrl);

        public abstract Builder blobUrl(String blobUrl);

        public abstract GitHubFile build();
    }
}