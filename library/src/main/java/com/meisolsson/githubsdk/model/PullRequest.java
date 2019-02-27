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
        @Json(name = "draft") Draft,
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

    public abstract Builder toBuilder();

    public static Builder builder() {
        return new AutoValue_PullRequest.Builder();
    }

    public static JsonAdapter<PullRequest> jsonAdapter(Moshi moshi) {
        return new AutoValue_PullRequest.MoshiJsonAdapter(moshi);
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder url(String url);

        public abstract Builder body(String body);

        public abstract Builder bodyHtml(String bodyHtml);

        public abstract Builder title(String title);

        public abstract Builder id(Long id);

        public abstract Builder comments(Integer comments);

        public abstract Builder number(Integer number);

        public abstract Builder additions(Integer additions);

        public abstract Builder commits(Integer commits);

        public abstract Builder deletions(Integer deletions);

        public abstract Builder locked(Boolean locked);

        public abstract Builder mergeable(Boolean mergeable);

        public abstract Builder merged(Boolean merged);

        public abstract Builder mergeableState(MergeableState mergeableState);

        public abstract Builder state(IssueState state);

        public abstract Builder user(User user);

        public abstract Builder assignee(User assignee);

        public abstract Builder labels(List<Label> labels);

        public abstract Builder milestone(Milestone milestone);

        public abstract Builder base(PullRequestMarker base);

        public abstract Builder head(PullRequestMarker head);

        public abstract Builder htmlUrl(String htmlUrl);

        public abstract Builder closedAt(Date closedAt);

        public abstract Builder createdAt(Date createdAt);

        public abstract Builder updatedAt(Date updatedAt);

        public abstract Builder closedBy(User closedBy);

        public abstract Builder changedFiles(Integer changedFiles);

        public abstract Builder diffUrl(String diffUrl);

        public abstract Builder patchUrl(String patchUrl);

        public abstract Builder mergeCommitSha(String mergeCommitSha);

        public abstract Builder mergedAt(Date mergedAt);

        public abstract Builder mergedBy(User mergedBy);

        public abstract PullRequest build();
    }
}
