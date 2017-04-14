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

package com.meisolsson.githubsdk.model.request.issue;

import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.meisolsson.githubsdk.model.IssueState;
import com.google.auto.value.AutoValue;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.util.List;

@AutoValue
public abstract class IssueRequest implements Parcelable {

    @Nullable
    public abstract IssueState state();

    @Nullable
    public abstract String title();

    @Nullable
    public abstract String body();

    @Nullable
    public abstract Integer milestone();

    @NonNull
    public abstract List<String> labels();

    @NonNull
    public abstract List<String> assignees();

    public static JsonAdapter<IssueRequest> jsonAdapter(Moshi moshi) {
        return new AutoValue_IssueRequest.MoshiJsonAdapter(moshi);
    }

    public static Builder builder() {
        return new AutoValue_IssueRequest.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder state(IssueState state);

        public abstract Builder title(String title);

        public abstract Builder body(String body);

        public abstract Builder milestone(Integer milestone);

        public abstract Builder labels(@NonNull List<String> labels);

        public abstract Builder assignees(@NonNull List<String> assignees);

        public abstract IssueRequest build();
    }
}
