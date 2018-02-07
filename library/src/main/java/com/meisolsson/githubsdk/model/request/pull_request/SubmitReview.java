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
public abstract class SubmitReview implements Parcelable {
    public enum Event {
        @Json(name = "APPROVE") Approve,
        @Json(name = "REQUEST_CHANGES") RequestChanges,
        @Json(name = "COMMENT") Comment
    }

    @Nullable
    public abstract String body();

    @NonNull
    public abstract Event event();

    public static JsonAdapter<SubmitReview> jsonAdapter(Moshi moshi) {
        return new AutoValue_SubmitReview.MoshiJsonAdapter(moshi);
    }

    public static Builder builder() {
        return new AutoValue_SubmitReview.Builder();
    }


    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder body(@Nullable String body);

        public abstract Builder event(@NonNull Event event);

        public abstract SubmitReview build();
    }
}
