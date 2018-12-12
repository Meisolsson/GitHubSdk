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
    public enum Method {
        @Json(name = "merge") Merge,
        @Json(name = "squash") Squash,
        @Json(name = "rebase") Rebase
    }

    @Json(name = "commit_title")
    @Nullable
    public abstract String commitTitle();

    @Json(name = "commit_message")
    @Nullable
    public abstract String commitMessage();

    @Nullable
    public abstract String sha();

    @Json(name = "merge_method")
    @Nullable
    public abstract Method method();

    public static JsonAdapter<MergeRequest> jsonAdapter(Moshi moshi) {
        return new AutoValue_MergeRequest.MoshiJsonAdapter(moshi);
    }

    public static Builder builder() {
        return new AutoValue_MergeRequest.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder commitTitle(String commitTitle);

        public abstract Builder commitMessage(String commitMessage);

        public abstract Builder sha(String sha);

        public abstract Builder method(Method method);

        public abstract MergeRequest build();
    }
}
