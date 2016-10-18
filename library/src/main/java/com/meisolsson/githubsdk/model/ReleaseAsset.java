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
public abstract class ReleaseAsset implements Parcelable {

    @Nullable
    public abstract String url();

    @Nullable
    public abstract String name();

    @Nullable
    public abstract String label();

    @Nullable
    public abstract String state();

    @Nullable
    public abstract Integer id();

    @Nullable
    public abstract Integer size();

    @Nullable
    public abstract User uploader();

    @Json(name = "browser_download_url")
    @Nullable
    public abstract String browserDownloadUrl();

    @Json(name = "content_type")
    @Nullable
    public abstract String contentType();

    @Json(name = "download_count")
    @Nullable
    public abstract Integer downloadCount();

    @Json(name = "created_at")
    @Nullable
    @FormattedTime
    public abstract Date createdAt();

    @Json(name = "updated_at")
    @Nullable
    @FormattedTime
    public abstract Date updatedAt();

    public static JsonAdapter<ReleaseAsset> jsonAdapter(Moshi moshi) {
        return new AutoValue_ReleaseAsset.MoshiJsonAdapter(moshi);
    }
}