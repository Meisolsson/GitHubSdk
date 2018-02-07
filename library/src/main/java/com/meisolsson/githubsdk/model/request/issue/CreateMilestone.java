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

import com.meisolsson.githubsdk.core.FormattedTime;
import com.meisolsson.githubsdk.model.IssueState;
import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.util.Date;

@AutoValue
public abstract class CreateMilestone implements Parcelable {

    @Json(name = "due_on")
    @Nullable
    @FormattedTime
    public abstract Date dueOn();

    @NonNull
    public abstract String title();

    @Nullable
    public abstract String description();

    @Nullable
    public abstract IssueState state();

    public static JsonAdapter<CreateMilestone> jsonAdapter(Moshi moshi) {
        return new AutoValue_CreateMilestone.MoshiJsonAdapter(moshi);
    }

    public static Builder builder() {
        return new AutoValue_CreateMilestone.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder dueOn(@Nullable Date dueOn);

        public abstract Builder title(@NonNull String title);

        public abstract Builder description(@Nullable String description);

        public abstract Builder state(@Nullable IssueState state);

        public abstract CreateMilestone build();
    }
}
