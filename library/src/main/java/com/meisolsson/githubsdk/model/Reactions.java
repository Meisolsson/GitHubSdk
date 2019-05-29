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

import com.meisolsson.githubsdk.core.FormattedTime;
import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.util.Date;

@AutoValue
public abstract class Reactions implements Parcelable {
    public int totalCount() {
        return plusOne() + minusOne() + laugh() + hooray() + confused() + heart();
    }

    @Json(name = "+1")
    public abstract Integer plusOne();

    @Json(name = "-1")
    public abstract Integer minusOne();

    public abstract Integer laugh();

    public abstract Integer hooray();

    public abstract Integer confused();

    public abstract Integer heart();

    public abstract Integer rocket();

    public abstract Integer eyes();

    public abstract Builder toBuilder();

    public static JsonAdapter<Reactions> jsonAdapter(Moshi moshi) {
        return new AutoValue_Reactions.MoshiJsonAdapter(moshi);
    }

    public static Builder builder() {
        return new AutoValue_Reactions.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder plusOne(Integer plusOne);

        public abstract Builder minusOne(Integer minusOne);

        public abstract Builder laugh(Integer laugh);

        public abstract Builder hooray(Integer hooray);

        public abstract Builder confused(Integer confused);

        public abstract Builder heart(Integer heart);

        public abstract Builder rocket(Integer rocket);

        public abstract Builder eyes(Integer eyes);

        public abstract Reactions build();
    }
}
