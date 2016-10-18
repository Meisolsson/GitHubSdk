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
public abstract class Team implements Parcelable {

    @Nullable
    public abstract String url();

    @Nullable
    public abstract String name();

    @Nullable
    public abstract String slug();

    @Nullable
    public abstract String description();

    @Nullable
    public abstract String privacy();

    @Nullable
    public abstract String permission();

    @Nullable
    public abstract User organization();

    @Nullable
    public abstract Integer id();

    @Json(name = "members_count")
    @Nullable
    public abstract Integer membersCount();

    @Json(name = "repos_count")
    @Nullable
    public abstract Integer reposCount();

    public static JsonAdapter<Team> jsonAdapter(Moshi moshi) {
        return new AutoValue_Team.MoshiJsonAdapter(moshi);
    }

    public static Builder builder() {
        return new AutoValue_Team.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder url(String url);

        public abstract Builder name(String name);

        public abstract Builder slug(String slug);

        public abstract Builder description(String description);

        public abstract Builder privacy(String privacy);

        public abstract Builder permission(String permission);

        public abstract Builder organization(User organization);

        public abstract Builder id(Integer id);

        public abstract Builder membersCount(Integer membersCount);

        public abstract Builder reposCount(Integer reposCount);

        public abstract Team build();
    }
}