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

@AutoValue
public abstract class Milestone implements Parcelable {

    @Nullable
    public abstract String url();

    @Nullable
    public abstract String title();

    @Nullable
    public abstract String state();

    @Nullable
    public abstract String description();

    @Nullable
    public abstract Integer id();

    @Nullable
    public abstract Integer number();

    @Nullable
    public abstract User creator();

    @Json(name = "html_url")
    @Nullable
    public abstract String htmlUrl();

    @Json(name = "open_issues")
    @Nullable
    public abstract Integer openIssues();

    @Json(name = "closed_issues")
    @Nullable
    public abstract Integer closedIssues();

    @Json(name = "created_at")
    @Nullable
    @FormattedTime
    public abstract Date createdAt();

    @Json(name = "updated_at")
    @Nullable
    @FormattedTime
    public abstract Date updatedAt();

    @Json(name = "closed_at")
    @Nullable
    @FormattedTime
    public abstract Date closedAt();

    @Json(name = "due_on")
    @Nullable
    public abstract String dueOn();

    public static JsonAdapter<Milestone> jsonAdapter(Moshi moshi) {
        return new AutoValue_Milestone.MoshiJsonAdapter(moshi);
    }

    public static Builder builder() {
        return new AutoValue_Milestone.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder url(String url);

        public abstract Builder title(String title);

        public abstract Builder state(String state);

        public abstract Builder description(String description);

        public abstract Builder id(Integer id);

        public abstract Builder number(Integer number);

        public abstract Builder creator(User creator);

        public abstract Builder htmlUrl(String htmlUrl);

        public abstract Builder openIssues(Integer openIssues);

        public abstract Builder closedIssues(Integer closedIssues);

        public abstract Builder createdAt(Date createdAt);

        public abstract Builder updatedAt(Date updatedAt);

        public abstract Builder closedAt(Date closedAt);

        public abstract Builder dueOn(String dueOn);

        public abstract Milestone build();
    }
}