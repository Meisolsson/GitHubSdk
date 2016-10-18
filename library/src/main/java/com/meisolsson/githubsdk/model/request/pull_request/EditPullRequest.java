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
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

@AutoValue
public abstract class EditPullRequest implements Parcelable {

    @Nullable
    public abstract String title();

    @Nullable
    public abstract String body();

    @Nullable
    public abstract String state();

    @Nullable
    public abstract String base();

    public static JsonAdapter<EditPullRequest> jsonAdapter(Moshi moshi) {
        return new AutoValue_EditPullRequest.MoshiJsonAdapter(moshi);
    }

    public static Builder builder() {
        return new AutoValue_EditPullRequest.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder title(String title);

        public abstract Builder body(String body);

        public abstract Builder state(String state);

        public abstract Builder base(String base);

        public abstract EditPullRequest build();
    }
}
