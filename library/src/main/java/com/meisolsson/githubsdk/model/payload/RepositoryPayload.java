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

import com.meisolsson.githubsdk.model.Repository;
import com.google.auto.value.AutoValue;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

@AutoValue
public abstract class RepositoryPayload extends GitHubPayload<RepositoryPayload.Builder> implements Parcelable {

    @Nullable
    public abstract String action();

    @Nullable
    public abstract Repository repository();

    public abstract Builder toBuilder();

    public static JsonAdapter<RepositoryPayload> jsonAdapter(Moshi moshi) {
        return new AutoValue_RepositoryPayload.MoshiJsonAdapter(moshi);
    }

    public static RepositoryPayload createFromParcel(Parcel in) {
        return AutoValue_RepositoryPayload.CREATOR.createFromParcel(in);
    }

    public static Builder builder() {
        return new AutoValue_RepositoryPayload.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder extends GitHubPayload.Builder<RepositoryPayload, Builder> {
        public abstract Builder action(String action);

        public abstract Builder repository(Repository repository);

        public abstract RepositoryPayload build();
    }
}
