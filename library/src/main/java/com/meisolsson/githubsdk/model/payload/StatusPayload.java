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

package com.meisolsson.githubsdk.model.payload;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.meisolsson.githubsdk.model.Branch;
import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.util.List;

@AutoValue
public abstract class StatusPayload extends GitHubPayload<StatusPayload.Builder> implements Parcelable {

    @Nullable
    public abstract String sha();

    @Nullable
    public abstract String state();

    @Nullable
    public abstract String description();

    @Nullable
    public abstract List<Branch> branches();

    @Json(name = "target_url")
    @Nullable
    public abstract String targetUrl();

    public abstract Builder toBuilder();

    public static JsonAdapter<StatusPayload> jsonAdapter(Moshi moshi) {
        return new AutoValue_StatusPayload.MoshiJsonAdapter(moshi);
    }

    public static StatusPayload createFromParcel(Parcel in) {
        return AutoValue_StatusPayload.CREATOR.createFromParcel(in);
    }

    public static Builder builder() {
        return new AutoValue_StatusPayload.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder extends GitHubPayload.Builder<StatusPayload, Builder> {
        public abstract Builder sha(String sha);

        public abstract Builder state(String state);

        public abstract Builder description(String description);

        public abstract Builder branches(List<Branch> branches);

        public abstract Builder targetUrl(String targetUrl);

        public abstract StatusPayload build();
    }
}
