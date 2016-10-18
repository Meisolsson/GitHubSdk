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
public abstract class ReviewComment implements Parcelable {

    @Nullable
    public abstract String url();

    @Nullable
    public abstract String body();

    @Nullable
    public abstract Integer id();

    @Nullable
    public abstract Integer position();

    @Nullable
    public abstract Integer line();

    @Nullable
    public abstract User user();

    @Json(name = "html_url")
    @Nullable
    public abstract String htmlUrl();

    @Json(name = "created_at")
    @Nullable
    @FormattedTime
    public abstract Date createdAt();

    @Json(name = "updated_at")
    @Nullable
    @FormattedTime
    public abstract Date updatedAt();

    @Nullable
    public abstract String path();

    @Json(name = "commit_id")
    @Nullable
    public abstract String commitId();

    @Json(name = "diff_hunk")
    @Nullable
    public abstract String diffChunk();

    @Json(name = "original_commit_id")
    @Nullable
    public abstract String originalCommitId();

    @Json(name = "original_position")
    @Nullable
    public abstract Integer originalPosition();

    public static JsonAdapter<ReviewComment> jsonAdapter(Moshi moshi) {
        return new AutoValue_ReviewComment.MoshiJsonAdapter(moshi);
    }
}
