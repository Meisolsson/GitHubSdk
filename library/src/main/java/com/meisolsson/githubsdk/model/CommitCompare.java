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
public abstract class CommitCompare implements Parcelable {

    @Nullable
    public abstract String url();

    @Json(name = "base_commit")
    @Nullable
    public abstract Commit baseCommit();

    @Json(name = "merge_base_commit")
    @Nullable
    public abstract Commit mergeBaseCommit();

    @Nullable
    public abstract String status();

    @Json(name = "ahead_by")
    @Nullable
    public abstract Integer aheadBy();

    @Json(name = "behind_by")
    @Nullable
    public abstract Integer behindBy();

    @Json(name = "total_commits")
    @Nullable
    public abstract Integer totalCommits();

    @Nullable
    public abstract List<Commit> commits();

    @Nullable
    public abstract List<GitHubFile> files();

    public static JsonAdapter<CommitCompare> jsonAdapter(Moshi moshi){
        return new AutoValue_CommitCompare.MoshiJsonAdapter(moshi);
    }

}
