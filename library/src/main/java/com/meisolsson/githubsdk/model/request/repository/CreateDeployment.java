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

import java.util.List;

@AutoValue
public abstract class CreateDeployment implements Parcelable {

    @Nullable
    public abstract String ref();

    @Nullable
    public abstract String task();

    @Json(name = "auto_merge")
    @Nullable
    public abstract Boolean autoMerge();

    @Json(name = "required_contexts")
    @NonNull
    public abstract List<String> requiredContexts();

    @Nullable
    public abstract String payload();

    @Nullable
    public abstract String environment();

    @Nullable
    public abstract String description();

    public static JsonAdapter<CreateDeployment> jsonAdapter(Moshi moshi) {
        return new AutoValue_CreateDeployment.MoshiJsonAdapter(moshi);
    }

    public static Builder builder() {
        return new AutoValue_CreateDeployment.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder ref(String ref);

        public abstract Builder task(String task);

        public abstract Builder autoMerge(Boolean autoMerge);

        public abstract Builder requiredContexts(@NonNull List<String> requiredContexts);

        public abstract Builder payload(String payload);

        public abstract Builder environment(String environment);

        public abstract Builder description(String description);

        public abstract CreateDeployment build();
    }
}
