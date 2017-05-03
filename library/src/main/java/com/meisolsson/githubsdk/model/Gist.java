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
import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.util.Date;
import java.util.List;
import java.util.Map;

@AutoValue
public abstract class Gist implements Parcelable {

    @Nullable
    public abstract String url();

    @Nullable
    public abstract String id();

    @Nullable
    public abstract String description();

    @Nullable
    public abstract User owner();

    @Nullable
    public abstract User user();

    @Nullable
    public abstract Map<String, GistFile> files();

    @Nullable
    public abstract List<Gist> forks();

    @Nullable
    public abstract List<GistRevision> history();

    @Nullable
    public abstract Boolean truncated();

    @Nullable
    public abstract Integer comments();

    @Json(name = "public")
    @Nullable
    public abstract Boolean isPublic();

    @Json(name = "html_url")
    @Nullable
    public abstract String htmlUrl();

    @Json(name = "created_at")
    @Nullable
    @FormattedTime
    public abstract Date createdAt();

    @Json(name = "updated_at")
    @Nullable
    @FormattedTime
    public abstract Date updatedAt();

    public abstract Builder toBuilder();

    public static JsonAdapter<Gist> jsonAdapter(Moshi moshi) {
        return new AutoValue_Gist.MoshiJsonAdapter(moshi);
    }

    public static Builder builder() {
        return new AutoValue_Gist.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder url(String url);

        public abstract Builder id(String id);

        public abstract Builder description(String description);

        public abstract Builder owner(User owner);

        public abstract Builder user(User user);

        public abstract Builder files(Map<String, GistFile> files);

        public abstract Builder forks(@Nullable List<Gist> forks);

        public abstract Builder history(@Nullable List<GistRevision> history);

        public abstract Builder truncated(Boolean truncated);

        public abstract Builder comments(Integer comments);

        public abstract Builder isPublic(Boolean newPublic);

        public abstract Builder htmlUrl(String htmlUrl);

        public abstract Builder createdAt(Date createdAt);

        public abstract Builder updatedAt(Date updatedAt);

        public abstract Gist build();
    }
}