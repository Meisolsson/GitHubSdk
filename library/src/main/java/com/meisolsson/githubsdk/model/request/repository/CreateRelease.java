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
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

@AutoValue
public abstract class CreateRelease implements Parcelable {

    @Json(name = "tag_name")
    @NonNull
    public abstract String tagName();

    @Json(name = "target_commitish")
    @Nullable
    public abstract String targetCommitish();

    @Nullable
    public abstract String name();

    @Nullable
    public abstract String body();

    @Nullable
    public abstract Boolean draft();

    @Nullable
    public abstract Boolean prerelease();

    public static JsonAdapter<CreateRelease> jsonAdapter(Moshi moshi) {
        return new AutoValue_CreateRelease.MoshiJsonAdapter(moshi);
    }

    public static Builder builder() {
        return new AutoValue_CreateRelease.Builder();
    }


    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder tagName(@NonNull String tagName);

        public abstract Builder targetCommitish(@Nullable String targetCommitish);

        public abstract Builder name(@Nullable String name);

        public abstract Builder body(@Nullable String body);

        public abstract Builder draft(@Nullable Boolean draft);

        public abstract Builder prerelease(@Nullable Boolean prerelease);

        public abstract CreateRelease build();
    }
}
