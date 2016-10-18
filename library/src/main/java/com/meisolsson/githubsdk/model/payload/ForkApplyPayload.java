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
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

@AutoValue
public abstract class ForkApplyPayload extends GitHubPayload {

    @Nullable
    public abstract String head();

    @Nullable
    public abstract String before();

    @Nullable
    public abstract String after();

    public abstract Builder toBuilder();

    public static JsonAdapter<ForkApplyPayload> jsonAdapter(Moshi moshi) {
        return new AutoValue_ForkApplyPayload.MoshiJsonAdapter(moshi);
    }

    public static ForkApplyPayload createFromParcel(Parcel in) {
        return AutoValue_ForkApplyPayload.CREATOR.createFromParcel(in);
    }

    public static Builder builder() {
        return new AutoValue_ForkApplyPayload.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder extends GitHubPayload.Builder<ForkApplyPayload, Builder> {
        public abstract Builder head(String head);

        public abstract Builder before(String before);

        public abstract Builder after(String after);

        public abstract ForkApplyPayload build();
    }
}
