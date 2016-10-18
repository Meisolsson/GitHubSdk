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

package com.meisolsson.githubsdk.model.request.gist;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.meisolsson.githubsdk.model.GistFile;
import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.util.Map;

@AutoValue
public abstract class CreateGist implements Parcelable {

    @Nullable
    public abstract Map<String, GistFile> files();

    @Nullable
    public abstract String description();

    /**
     * Won't be used when editing the Gist
     */
    @Json(name = "public")
    public abstract Boolean isPublic();

    public static JsonAdapter<CreateGist> jsonAdapter(Moshi moshi) {
        return new AutoValue_CreateGist.MoshiJsonAdapter(moshi);
    }

    public static Builder builder() {
        return new AutoValue_CreateGist.Builder();
    }


    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder files(Map<String, GistFile> files);

        public abstract Builder description(String description);

        public abstract Builder isPublic(Boolean newPublic);

        public abstract CreateGist build();
    }
}
