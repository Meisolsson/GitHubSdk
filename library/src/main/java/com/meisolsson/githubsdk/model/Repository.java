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
public abstract class Repository implements Parcelable {

    @Nullable
    public abstract String name();

    @Nullable
    public abstract String description();

    @Nullable
    public abstract String url();

    @Nullable
    public abstract String homepage();

    @Nullable
    public abstract String language();

    @Nullable
    public abstract Integer size();

    @Nullable
    public abstract Long id();

    @Json(name = "fork")
    @Nullable
    public abstract Boolean isFork();

    @Nullable
    public abstract User owner();

    @Nullable
    public abstract User organization();

    @Nullable
    public abstract Repository parent();

    @Nullable
    public abstract Repository source();

    @Nullable
    public abstract Permissions permissions();

    @Json(name = "full_name")
    @Nullable
    public abstract String fullName();

    @Json(name = "private")
    @Nullable
    public abstract Boolean isPrivate();

    @Json(name = "html_url")
    @Nullable
    public abstract String htmlUrl();

    @Json(name = "mirror_url")
    @Nullable
    public abstract String mirrorUrl();

    @Json(name = "forks_count")
    @Nullable
    public abstract Integer forksCount();

    @Json(name = "stargazers_count")
    @Nullable
    public abstract Integer stargazersCount();

    @Json(name = "watchers_count")
    @Nullable
    public abstract Integer watchersCount();

    @Json(name = "default_branch")
    @Nullable
    public abstract String defaultBranch();

    @Json(name = "open_issues_count")
    @Nullable
    public abstract Integer openIssuesCount();

    @Json(name = "has_issues")
    @Nullable
    public abstract Boolean hasIssues();

    @Json(name = "has_wiki")
    @Nullable
    public abstract Boolean hasWiki();

    @Json(name = "has_pages")
    @Nullable
    public abstract Boolean hasPages();

    @Json(name = "has_downloads")
    @Nullable
    public abstract Boolean hasDownloads();

    @Json(name = "pushed_at")
    @Nullable
    @FormattedTime
    public abstract Date pushedAt();

    @Json(name = "created_at")
    @Nullable
    @FormattedTime
    public abstract Date createdAt();

    @Json(name = "updated_at")
    @Nullable
    @FormattedTime
    public abstract Date updatedAt();

    @Json(name = "subscribers_count")
    @Nullable
    public abstract Integer subscribersCount();

    public abstract Builder toBuilder();

    public static JsonAdapter<Repository> jsonAdapter(Moshi moshi) {
        return new AutoValue_Repository.MoshiJsonAdapter(moshi);
    }

    public static Builder builder() {
        return new AutoValue_Repository.Builder();
    }


    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder name(String name);

        public abstract Builder description(String description);

        public abstract Builder url(String url);

        public abstract Builder homepage(String homepage);

        public abstract Builder language(String language);

        public abstract Builder size(Integer size);

        public abstract Builder id(Long id);

        public abstract Builder isFork(Boolean newFork);

        public abstract Builder owner(User owner);

        public abstract Builder organization(User organization);

        public abstract Builder parent(Repository parent);

        public abstract Builder source(Repository source);

        public abstract Builder permissions(Permissions permissions);

        public abstract Builder fullName(String fullName);

        public abstract Builder isPrivate(Boolean newPrivate);

        public abstract Builder htmlUrl(String htmlUrl);

        public abstract Builder mirrorUrl(String mirrorUrl);

        public abstract Builder forksCount(Integer forksCount);

        public abstract Builder stargazersCount(Integer stargazersCount);

        public abstract Builder watchersCount(Integer watchersCount);

        public abstract Builder defaultBranch(String defaultBranch);

        public abstract Builder openIssuesCount(Integer openIssuesCount);

        public abstract Builder hasIssues(Boolean hasIssues);

        public abstract Builder hasWiki(Boolean hasWiki);

        public abstract Builder hasPages(Boolean hasPages);

        public abstract Builder hasDownloads(Boolean hasDownloads);

        public abstract Builder pushedAt(Date pushedAt);

        public abstract Builder createdAt(Date createdAt);

        public abstract Builder updatedAt(Date updatedAt);

        public abstract Builder subscribersCount(Integer subscribersCount);

        public abstract Repository build();
    }
}