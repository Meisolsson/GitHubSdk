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

import com.meisolsson.githubsdk.core.FormattedHtml;
import com.meisolsson.githubsdk.core.FormattedTime;
import com.meisolsson.githubsdk.model.User;
import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.util.Date;

@AutoValue
public abstract class GitComment implements Parcelable {

    @Nullable
    public abstract String url();

    @Nullable
    public abstract String body();

    @Nullable
    @Json(name = "body_html")
    @FormattedHtml
    public abstract String bodyHtml();

    @Nullable
    public abstract Integer id();

    @Nullable
    public abstract Integer position();

    @Nullable
    public abstract Integer line();

    @Nullable
    public abstract User user();

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

    @Nullable
    public abstract String path();

    @Json(name = "commit_id")
    @Nullable
    public abstract String commitId();

    public abstract Builder toBuilder();

    public static JsonAdapter<GitComment> jsonAdapter(Moshi moshi) {
        return new AutoValue_GitComment.MoshiJsonAdapter(moshi);
    }

    public static Builder builder() {
        return new AutoValue_GitComment.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder url(String url);

        public abstract Builder body(String body);

        public abstract Builder bodyHtml(String bodyHtml);

        public abstract Builder id(Integer id);

        public abstract Builder position(Integer position);

        public abstract Builder line(Integer line);

        public abstract Builder user(User user);

        public abstract Builder htmlUrl(String htmlUrl);

        public abstract Builder createdAt(Date createdAt);

        public abstract Builder updatedAt(Date updatedAt);

        public abstract Builder path(String path);

        public abstract Builder commitId(String commitId);

        public abstract GitComment build();
    }
}
