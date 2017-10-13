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

import java.util.List;

@AutoValue
public abstract class CreateReview implements Parcelable {
    public enum Event {
        @Json(name = "APPROVE") Approve,
        @Json(name = "REQUEST_CHANGES") RequestChanges,
        @Json(name = "COMMENT") Comment
    }

    @AutoValue
    public abstract static class DraftComment implements Parcelable {
        @NonNull
        public abstract String body();

        @NonNull
        public abstract String path();

        @NonNull
        public abstract Integer position();

        public static JsonAdapter<DraftComment> jsonAdapter(Moshi moshi) {
            return new AutoValue_CreateReview_DraftComment.MoshiJsonAdapter(moshi);
        }

        public static Builder builder() {
            return new AutoValue_CreateReview_DraftComment.Builder();
        }

        @AutoValue.Builder
        public abstract static class Builder {
            public abstract Builder body(@NonNull String body);

            public abstract Builder path(@NonNull String path);

            public abstract Builder position(@NonNull Integer position);

            public abstract DraftComment build();
        }
    }

    @NonNull
    public abstract String body();

    @Json(name = "commit_id")
    @Nullable
    public abstract String commitId();

    @Nullable
    public abstract Event event();

    @Nullable
    public abstract List<DraftComment> comments();

    public static JsonAdapter<CreateReview> jsonAdapter(Moshi moshi) {
        return new AutoValue_CreateReview.MoshiJsonAdapter(moshi);
    }

    public static Builder builder() {
        return new AutoValue_CreateReview.Builder();
    }


    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder body(@NonNull String body);

        public abstract Builder commitId(@Nullable String commitId);

        public abstract Builder event(@Nullable Event event);

        public abstract Builder comments(@Nullable List<DraftComment> comments);

        public abstract CreateReview build();
    }
}
