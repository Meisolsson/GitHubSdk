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

package com.meisolsson.githubsdk.model.request.pull_request;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

@AutoValue
public abstract class MergeRequest implements Parcelable {

    @Json(name = "commit_message")
    @Nullable
    public abstract String commitMessage();

    @Nullable
    public abstract String sha();

    @Nullable
    public abstract String base();

    @Nullable
    public abstract String head();

    public static JsonAdapter<MergeRequest> jsonAdapter(Moshi moshi) {
        return new AutoValue_MergeRequest.MoshiJsonAdapter(moshi);
    }

    public static Builder builder() {
        return new AutoValue_MergeRequest.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder commitMessage(String commitMessage);

        public abstract Builder sha(String sha);

        public abstract Builder base(String base);

        public abstract Builder head(String head);

        public abstract MergeRequest build();
    }
}
