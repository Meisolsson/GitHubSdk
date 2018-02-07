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

package com.meisolsson.githubsdk.model.request.organization;

import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.util.List;

@AutoValue
public abstract class CreateTeam implements Parcelable {

    @NonNull
    public abstract String name();

    @Nullable
    public abstract String description();

    @Json(name = "repo_names")
    @Nullable
    public abstract List<String> repoNames();

    @Nullable
    public abstract String privacy();

    public static JsonAdapter<CreateTeam> jsonAdapter(Moshi moshi) {
        return new AutoValue_CreateTeam.MoshiJsonAdapter(moshi);
    }

    public static Builder builder() {
        return new AutoValue_CreateTeam.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder name(@NonNull String name);

        public abstract Builder description(@Nullable String description);

        public abstract Builder repoNames(@Nullable List<String> repoNames);

        public abstract Builder privacy(@Nullable String privacy);

        public abstract CreateTeam build();
    }
}
