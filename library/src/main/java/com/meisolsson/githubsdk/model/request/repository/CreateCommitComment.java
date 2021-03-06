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

package com.meisolsson.githubsdk.model.request.repository;

import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

@AutoValue
public abstract class CreateCommitComment implements Parcelable {

    @NonNull
    public abstract String body();

    @Nullable
    public abstract String path();

    @Nullable
    public abstract Integer position();

    public static JsonAdapter<CreateCommitComment> jsonAdapter(Moshi moshi) {
        return new AutoValue_CreateCommitComment.MoshiJsonAdapter(moshi);
    }

    public static Builder builder() {
        return new AutoValue_CreateCommitComment.Builder();
    }


    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder body(@NonNull String body);

        public abstract Builder path(@Nullable String path);

        public abstract Builder position(@Nullable Integer position);

        public abstract CreateCommitComment build();
    }
}
