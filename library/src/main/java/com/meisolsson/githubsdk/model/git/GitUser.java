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

package com.meisolsson.githubsdk.model.git;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.meisolsson.githubsdk.core.FormattedTime;
import com.google.auto.value.AutoValue;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.util.Date;

@AutoValue
public abstract class GitUser implements Parcelable {

    @Nullable
    public abstract String name();

    @Nullable
    public abstract String email();

    @Nullable
    @FormattedTime
    public abstract Date date();

    public abstract Builder toBuilder();

    public static JsonAdapter<GitUser> jsonAdapter(Moshi moshi) {
        return new AutoValue_GitUser.MoshiJsonAdapter(moshi);
    }

    public static Builder builder() {
        return new AutoValue_GitUser.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder name(String name);

        public abstract Builder email(String email);

        public abstract Builder date(Date date);

        public abstract GitUser build();
    }
}