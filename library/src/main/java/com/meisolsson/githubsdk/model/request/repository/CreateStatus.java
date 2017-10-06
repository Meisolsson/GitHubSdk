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
import com.meisolsson.githubsdk.model.StatusState;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

@AutoValue
public abstract class CreateStatus implements Parcelable {

    @Nullable
    public abstract StatusState state();

    @Json(name = "target_url")
    @Nullable
    public abstract String targetUrl();

    @Nullable
    public abstract String context();

    @Nullable
    public abstract String description();

    public static JsonAdapter<CreateStatus> jsonAdapter(Moshi moshi) {
        return new AutoValue_CreateStatus.MoshiJsonAdapter(moshi);
    }

    public static Builder builder() {
        return new AutoValue_CreateStatus.Builder();
    }


    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder state(StatusState state);

        public abstract Builder targetUrl(String targetUrl);

        public abstract Builder context(String context);

        public abstract Builder description(String description);

        public abstract CreateStatus build();
    }
}
