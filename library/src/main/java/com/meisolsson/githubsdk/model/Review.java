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
public abstract class Review implements Parcelable {
    @Nullable
    public abstract Long id();

    @Nullable
    public abstract User user();

    @Nullable
    public abstract ReviewState state();

    @Nullable
    public abstract String body();

    @Json(name = "body_html")
    @Nullable
    public abstract String bodyHtml();

    @Json(name = "commit_id")
    @Nullable
    public abstract String commitId();

    @Json(name = "html_url")
    @Nullable
    public abstract String htmlUrl();

    @Json(name = "pull_request_url")
    @Nullable
    public abstract String pullRequestUrl();

    @Json(name = "submitted_at")
    @Nullable
    @FormattedTime
    public abstract Date submittedAt();

    public static JsonAdapter<Review> jsonAdapter(Moshi moshi) {
        return new AutoValue_Review.MoshiJsonAdapter(moshi);
    }
}
