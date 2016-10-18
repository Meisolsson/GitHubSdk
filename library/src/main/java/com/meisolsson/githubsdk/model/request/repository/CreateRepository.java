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

package com.meisolsson.githubsdk.model.request.repository;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

@AutoValue
public abstract class CreateRepository implements Parcelable {

    @Nullable
    public abstract String name();

    @Nullable
    public abstract String description();

    @Nullable
    public abstract String homepage();

    @Json(name = "private")
    @Nullable
    public abstract Boolean isPrivate();

    @Json(name = "has_issues")
    @Nullable
    public abstract Boolean hasIssues();

    @Json(name = "has_wiki")
    @Nullable
    public abstract Boolean hasWiki();

    @Json(name = "has_downloads")
    @Nullable
    public abstract Boolean hasDownloads();

    @Json(name = "team_id")
    @Nullable
    public abstract Integer teamId();

    @Json(name = "auto_init")
    @Nullable
    public abstract Boolean autoInit();

    @Json(name = "gitignore_template")
    @Nullable
    public abstract String gitignoreTemplate();

    @Json(name = "license_template")
    @Nullable
    public abstract String licenseTemplate();

    public static JsonAdapter<CreateRepository> jsonAdapter(Moshi moshi) {
        return new AutoValue_CreateRepository.MoshiJsonAdapter(moshi);
    }

    public static Builder builder() {
        return new AutoValue_CreateRepository.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder name(String name);

        public abstract Builder description(String description);

        public abstract Builder homepage(String homepage);

        public abstract Builder isPrivate(Boolean _private);

        public abstract Builder hasIssues(Boolean hasIssues);

        public abstract Builder hasWiki(Boolean hasWiki);

        public abstract Builder hasDownloads(Boolean hasDownloads);

        public abstract Builder teamId(Integer teamId);

        public abstract Builder autoInit(Boolean autoInit);

        public abstract Builder gitignoreTemplate(String gitignoreTemplate);

        public abstract Builder licenseTemplate(String licenseTemplate);

        public abstract CreateRepository build();
    }
}
