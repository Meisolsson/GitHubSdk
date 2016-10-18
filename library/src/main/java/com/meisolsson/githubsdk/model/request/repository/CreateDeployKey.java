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
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

@AutoValue
public abstract class CreateDeployKey implements Parcelable {

    @Nullable
    public abstract String title();

    @Nullable
    public abstract String key();

    @Json(name = "read_only")
    public abstract Boolean readOnly();

    public static JsonAdapter<CreateDeployKey> jsonAdapter(Moshi moshi) {
        return new AutoValue_CreateDeployKey.MoshiJsonAdapter(moshi);
    }

    public static Builder builder() {
        return new AutoValue_CreateDeployKey.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder title(String title);

        public abstract Builder key(String key);

        public abstract Builder readOnly(Boolean readOnly);

        public abstract CreateDeployKey build();
    }
}
