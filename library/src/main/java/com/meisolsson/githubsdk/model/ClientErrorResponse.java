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
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.meisolsson.githubsdk.core.FormattedTime;
import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.util.Date;
import java.util.List;

@AutoValue
public abstract class ClientErrorResponse implements Parcelable {
    @AutoValue
    public abstract static class BlockReason implements Parcelable {
        @Nullable
        public abstract String reason();

        @Json(name = "created_at")
        @FormattedTime
        @Nullable
        public abstract Date createdAt();

        @Json(name = "html_url")
        @Nullable
        public abstract String htmlUrl();

        public static JsonAdapter<BlockReason> jsonAdapter(Moshi moshi) {
            return new AutoValue_ClientErrorResponse_BlockReason.MoshiJsonAdapter(moshi);
        }
    }

    @AutoValue
    public abstract static class FieldError implements Parcelable {
        public enum Reason {
            @Json(name = "missing") MissingResource,
            @Json(name = "missing_field") MissingField,
            @Json(name = "invalid") Invalid,
            @Json(name = "already_exists") AlreadyExists,
            @Json(name = "too_large") TooLarge,
            @Json(name = "custom") Custom
        }

        @NonNull
        public abstract String resource();

        @NonNull
        public abstract String field();

        @Json(name = "code")
        @NonNull
        public abstract Reason reason();

        @Nullable
        public abstract String message();

        public static JsonAdapter<FieldError> jsonAdapter(Moshi moshi) {
            return new AutoValue_ClientErrorResponse_FieldError.MoshiJsonAdapter(moshi);
        }
    }

    @Nullable
    public abstract String message();

    @Json(name = "block")
    @Nullable
    public abstract BlockReason blockReason();

    @Nullable
    public abstract List<FieldError> errors();

    @Json(name = "documentation_url")
    @Nullable
    public abstract String documentationUrl();

    public static JsonAdapter<ClientErrorResponse> jsonAdapter(Moshi moshi) {
        return new AutoValue_ClientErrorResponse.MoshiJsonAdapter(moshi);
    }
}
