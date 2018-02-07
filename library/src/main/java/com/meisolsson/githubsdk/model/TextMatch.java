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

package com.meisolsson.githubsdk.model;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.util.List;

@AutoValue
public abstract class TextMatch implements Parcelable {
    @AutoValue
    public static abstract class MatchItem implements Parcelable {
        @Nullable
        public abstract List<Integer> indices();

        @Nullable
        public abstract String text();

        public int getStartPos() {
            List<Integer> indices = indices();
            return indices != null && !indices.isEmpty() ? indices.get(0) : -1;
        }

        public int getEndPos() {
            List<Integer> indices = indices();
            return indices != null && indices.size() >= 2 ? indices.get(1) : -1;
        }

        public static JsonAdapter<MatchItem> jsonAdapter(Moshi moshi) {
            return new AutoValue_TextMatch_MatchItem.MoshiJsonAdapter(moshi);
        }
    }

    @Json(name = "object_url")
    @Nullable
    public abstract String objectUrl();

    @Json(name = "object_type")
    @Nullable
    public abstract String objectType();

    @Nullable
    public abstract String property();

    @Nullable
    public abstract String fragment();

    @Nullable
    public abstract List<MatchItem> matches();

    public static JsonAdapter<TextMatch> jsonAdapter(Moshi moshi) {
        return new AutoValue_TextMatch.MoshiJsonAdapter(moshi);
    }
}
