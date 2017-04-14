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
public abstract class Release implements Parcelable {

    @Nullable
    public abstract String url();

    @Nullable
    public abstract String name();

    @Nullable
    public abstract String body();

    @Nullable
    public abstract Integer id();

    @Nullable
    public abstract Boolean draft();

    @Nullable
    public abstract Boolean prerelease();

    @Nullable
    public abstract User author();

    @NonNull
    public abstract List<ReleaseAsset> assets();

    @Json(name = "html_url")
    @Nullable
    public abstract String htmlUrl();

    @Json(name = "assets_url")
    @Nullable
    public abstract String assetsUrl();

    @Json(name = "upload_url")
    @Nullable
    public abstract String uploadUrl();

    @Json(name = "tarball_url")
    @Nullable
    public abstract String tarballUrl();

    @Json(name = "zipball_url")
    @Nullable
    public abstract String zipballUrl();

    @Json(name = "tag_name")
    @Nullable
    public abstract String tagName();

    @Json(name = "target_commitish")
    @Nullable
    public abstract String targetCommitish();

    @Json(name = "created_at")
    @Nullable
    @FormattedTime
    public abstract Date createdAt();

    @Json(name = "published_at")
    @Nullable
    @FormattedTime
    public abstract Date publishedAt();

    public static JsonAdapter<Release> jsonAdapter(Moshi moshi) {
        return new AutoValue_Release.MoshiJsonAdapter(moshi);
    }
}