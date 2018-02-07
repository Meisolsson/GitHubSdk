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

package com.meisolsson.githubsdk.model.request.git;

import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.meisolsson.githubsdk.model.git.GitUser;
import com.google.auto.value.AutoValue;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.util.List;

@AutoValue
public abstract class CreateGitCommit implements Parcelable {

    @NonNull
    public abstract String message();

    @NonNull
    public abstract String tree();

    @NonNull
    public abstract List<String> parents(); //SHA of parents

    @Nullable
    public abstract GitUser committer();

    @Nullable
    public abstract GitUser author();

    public static JsonAdapter<CreateGitCommit> jsonAdapter(Moshi moshi) {
        return new AutoValue_CreateGitCommit.MoshiJsonAdapter(moshi);
    }

    public static Builder builder() {
        return new AutoValue_CreateGitCommit.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder message(@NonNull String message);

        public abstract Builder tree(@NonNull String tree);

        public abstract Builder parents(@NonNull List<String> parents);

        public abstract Builder committer(@Nullable GitUser committer);

        public abstract Builder author(@Nullable GitUser author);

        public abstract CreateGitCommit build();
    }
}
