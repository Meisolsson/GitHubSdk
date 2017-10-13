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

@AutoValue
public abstract class CreateGitTag implements Parcelable {

    @Nullable
    public abstract String tag();

    @Nullable
    public abstract String message();

    @Nullable
    public abstract String object(); //SHA of the object

    @Nullable
    public abstract String type();

    @Nullable
    public abstract GitUser tagger();

    public static JsonAdapter<CreateGitTag> jsonAdapter(Moshi moshi) {
        return new AutoValue_CreateGitTag.MoshiJsonAdapter(moshi);
    }

    public static Builder builder() {
        return new AutoValue_CreateGitTag.Builder();
    }


    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder tag(String tag);

        public abstract Builder message(String message);

        public abstract Builder object(String object);

        public abstract Builder type(String type);

        public abstract Builder tagger(GitUser tagger);

        public abstract CreateGitTag build();
    }
}
