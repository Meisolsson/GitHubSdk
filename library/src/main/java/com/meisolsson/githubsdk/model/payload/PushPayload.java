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

import com.meisolsson.githubsdk.model.git.GitCommit;
import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.util.List;

@AutoValue
public abstract class PushPayload extends GitHubPayload<PushPayload.Builder> implements Parcelable {

    @Nullable
    public abstract String ref();

    @Nullable
    public abstract String head();

    @Nullable
    public abstract String before();

    @Nullable
    public abstract Integer size();

    @Nullable
    public abstract List<GitCommit> commits();

    @Json(name = "distinct_size")
    @Nullable
    public abstract Integer distinctSize();

    public abstract Builder toBuilder();

    public static JsonAdapter<PushPayload> jsonAdapter(Moshi moshi) {
        return new AutoValue_PushPayload.MoshiJsonAdapter(moshi);
    }

    public static PushPayload createFromParcel(Parcel in) {
        return AutoValue_PushPayload.CREATOR.createFromParcel(in);
    }

    public static Builder builder() {
        return new AutoValue_PushPayload.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder extends GitHubPayload.Builder<PushPayload, Builder> {
        public abstract Builder ref(String ref);

        public abstract Builder head(String head);

        public abstract Builder before(String before);

        public abstract Builder size(Integer size);

        public abstract Builder commits(List<GitCommit> commits);

        public abstract Builder distinctSize(Integer distinctSize);

        public abstract PushPayload build();
    }
}
