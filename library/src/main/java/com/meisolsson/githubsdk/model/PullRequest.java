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

import com.meisolsson.githubsdk.core.FormattedHtml;
import com.meisolsson.githubsdk.core.FormattedTime;
import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.util.Date;
import java.util.List;

@AutoValue
public abstract class PullRequest implements Parcelable {
    public enum MergeableState {
        @Json(name = "behind") Behind,
        @Json(name = "blocked") Blocked,
        @Json(name = "clean") Clean,
        @Json(name = "dirty") Dirty,
        @Json(name = "unknown") Unknown,
        @Json(name = "unstable") Unstable
    }

    @Nullable
    public abstract String url();

    @Nullable
    public abstract String body();

    @Nullable
    @Json(name = "body_html")
    @FormattedHtml
    public abstract String bodyHtml();

    @Nullable
    public abstract String title();

    @Nullable
    public abstract Long id();

    @Nullable
    public abstract Integer comments();

    @Nullable
    public abstract Integer number();

    @Nullable
    public abstract Integer additions();

    @Nullable
    public abstract Integer commits();

    @Nullable
    public abstract Integer deletions();

    @Nullable
    public abstract Boolean locked();

    @Nullable
    public abstract Boolean mergeable();

    @Nullable
    public abstract Boolean merged();

    @Json(name = "mergeable_state")
    @Nullable
    public abstract MergeableState mergeableState();

    @Nullable
    public abstract IssueState state();

    @Nullable
    public abstract User user();

    @Nullable
    public abstract User assignee();

    @Nullable
    public abstract List<Label> labels();

    @Nullable
    public abstract Milestone milestone();

    @Nullable
    public abstract PullRequestMarker base();

    @Nullable
    public abstract PullRequestMarker head();

    @Json(name = "html_url")
    @Nullable
    public abstract String htmlUrl();

    @Json(name = "pull_request")
    @Nullable
    public abstract PullRequest pullRequest();

    @Json(name = "closed_at")
    @Nullable
    @FormattedTime
    public abstract Date closedAt();

    @Json(name = "created_at")
    @Nullable
    @FormattedTime
    public abstract Date createdAt();

    @Json(name = "updated_at")
    @Nullable
    @FormattedTime
    public abstract Date updatedAt();

    @Json(name = "closed_by")
    @Nullable
    public abstract User closedBy();

    @Json(name = "changed_files")
    @Nullable
    public abstract Integer changedFiles();

    @Json(name = "diff_url")
    @Nullable
    public abstract String diffUrl();

    @Json(name = "patch_url")
    @Nullable
    public abstract String patchUrl();

    @Json(name = "merge_commit_sha")
    @Nullable
    public abstract String mergeCommitSha();

    @Json(name = "merged_at")
    @Nullable
    @FormattedTime
    public abstract Date mergedAt();

    @Json(name = "merged_by")
    @Nullable
    public abstract User mergedBy();

    public static JsonAdapter<PullRequest> jsonAdapter(Moshi moshi) {
        return new AutoValue_PullRequest.MoshiJsonAdapter(moshi);
    }
}
