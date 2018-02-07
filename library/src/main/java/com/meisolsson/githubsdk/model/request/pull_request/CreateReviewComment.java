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

package com.meisolsson.githubsdk.model.request.pull_request;

import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

@AutoValue
public abstract class CreateReviewComment implements Parcelable {

    @NonNull
    public abstract String body();

    @Json(name = "commit_id")
    @Nullable
    public abstract String commitId();

    @Nullable
    public abstract String path();

    @Nullable
    public abstract Integer position();

    @Json(name = "in_reply_to")
    @Nullable
    public abstract Long inReplyTo();

    public static JsonAdapter<CreateReviewComment> jsonAdapter(Moshi moshi) {
        return new AutoValue_CreateReviewComment.MoshiJsonAdapter(moshi);
    }

    public static Builder builder() {
        return new AutoValue_CreateReviewComment.Builder();
    }


    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder body(@NonNull String body);

        public abstract Builder commitId(@Nullable String commitId);

        public abstract Builder path(@Nullable String path);

        public abstract Builder position(@Nullable Integer position);

        public abstract Builder inReplyTo(@Nullable Long inReplyTo);

        public abstract CreateReviewComment build();
    }
}
