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
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

@AutoValue
public abstract class CreatePullRequest implements Parcelable {

    @NonNull
    public abstract String title();

    @NonNull
    public abstract String head();

    @NonNull
    public abstract String base();

    @Nullable
    public abstract String body();

    public static JsonAdapter<CreatePullRequest> jsonAdapter(Moshi moshi) {
        return new AutoValue_CreatePullRequest.MoshiJsonAdapter(moshi);
    }

    public static Builder builder() {
        return new AutoValue_CreatePullRequest.Builder();
    }


    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder title(@NonNull String title);

        public abstract Builder head(@NonNull String head);

        public abstract Builder base(@NonNull String base);

        public abstract Builder body(@Nullable String body);

        public abstract CreatePullRequest build();
    }
}
