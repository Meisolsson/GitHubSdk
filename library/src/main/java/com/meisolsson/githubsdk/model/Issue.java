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
public abstract class Issue implements Parcelable {

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
    public abstract Integer id();

    @Nullable
    public abstract Integer comments();

    @Nullable
    public abstract Integer number();

    @Nullable
    public abstract Boolean locked();

    @Nullable
    public abstract IssueState state();

    @Nullable
    public abstract User user();

    @Nullable
    public abstract User assignee();

    @Nullable
    public abstract List<User> assignees();

    @Nullable
    public abstract List<Label> labels();

    @Nullable
    public abstract Milestone milestone();

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

    @Nullable
    public abstract Repository repository();

    public abstract Builder toBuilder();

    public static JsonAdapter<Issue> jsonAdapter(Moshi moshi) {
        return new AutoValue_Issue.MoshiJsonAdapter(moshi);
    }

    public static Builder builder() {
        return new AutoValue_Issue.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder url(String url);

        public abstract Builder body(String body);

        public abstract Builder bodyHtml(String bodyHtml);

        public abstract Builder title(String title);

        public abstract Builder id(Integer id);

        public abstract Builder comments(Integer comments);

        public abstract Builder number(Integer number);

        public abstract Builder locked(Boolean locked);

        public abstract Builder state(IssueState state);

        public abstract Builder user(User user);

        public abstract Builder assignee(User assignee);

        public abstract Builder labels(List<Label> labels);

        public abstract Builder milestone(Milestone milestone);

        public abstract Builder htmlUrl(String htmlUrl);

        public abstract Builder pullRequest(PullRequest pullRequest);

        public abstract Builder closedAt(Date closedAt);

        public abstract Builder createdAt(Date createdAt);

        public abstract Builder updatedAt(Date updatedAt);

        public abstract Builder closedBy(User closedBy);

        public abstract Builder repository(Repository repository);

        public abstract Builder assignees(List<User> assignees);

        public abstract Issue build();
    }
}