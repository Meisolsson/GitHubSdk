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
public abstract class Reaction implements Parcelable {
    public static final String CONTENT_PLUS_ONE = "+1";
    public static final String CONTENT_MINUS_ONE = "-1";
    public static final String CONTENT_LAUGH = "laugh";
    public static final String CONTENT_CONFUSED = "confused";
    public static final String CONTENT_HEART = "heart";
    public static final String CONTENT_HOORAY = "hooray";
    public static final String CONTENT_ROCKET = "rocket";
    public static final String CONTENT_EYES = "eyes";

    @Nullable
    public abstract Long id();

    @Nullable
    public abstract User user();

    @Nullable
    public abstract String content();

    @Json(name = "created_at")
    @Nullable
    @FormattedTime
    public abstract Date createdAt();

    public abstract Builder toBuilder();

    public static JsonAdapter<Reaction> jsonAdapter(Moshi moshi) {
        return new AutoValue_Reaction.MoshiJsonAdapter(moshi);
    }

    public static Builder builder() {
        return new AutoValue_Reaction.Builder();
    }


    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder id(Long id);

        public abstract Builder user(User user);

        public abstract Builder content(String content);

        public abstract Builder createdAt(Date updatedAt);

        public abstract Reaction build();
    }
}
