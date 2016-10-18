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

import com.google.auto.value.AutoValue;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

@AutoValue
public abstract class GitBlob implements Parcelable {

    @Nullable
    public abstract String content();

    @Nullable
    public abstract String encoding();

    @Nullable
    public abstract String url();

    @Nullable
    public abstract String sha();

    @Nullable
    public abstract Integer size();

    public static JsonAdapter<GitBlob> jsonAdapter(Moshi moshi) {
        return new AutoValue_GitBlob.MoshiJsonAdapter(moshi);
    }

    public static Builder builder() {
        return new AutoValue_GitBlob.Builder();
    }


    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder content(String content);

        public abstract Builder encoding(String encoding);

        public abstract Builder url(String url);

        public abstract Builder sha(String sha);

        public abstract Builder size(Integer size);

        public abstract GitBlob build();
    }
}
