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
public abstract class User implements Parcelable {

    @Nullable
    public abstract String login();

    @Nullable
    public abstract String url();

    @Nullable
    public abstract String bio();

    @Nullable
    public abstract String description();

    @Nullable
    public abstract String name();

    @Nullable
    public abstract String company();

    @Nullable
    public abstract String blog();

    @Nullable
    public abstract String location();

    @Nullable
    public abstract String email();

    @Nullable
    public abstract Integer id();

    @Nullable
    public abstract Integer followers();

    @Nullable
    public abstract Integer following();

    @Nullable
    public abstract Boolean hireable();

    @Nullable
    public abstract UserType type();

    @Json(name = "avatar_url")
    @Nullable
    public abstract String avatarUrl();

    @Json(name = "public_repos")
    @Nullable
    public abstract Integer publicRepos();

    @Json(name = "public_gists")
    @Nullable
    public abstract Integer publicGists();

    @Json(name = "html_url")
    @Nullable
    public abstract String htmlUrl();

    @Json(name = "created_at")
    @Nullable
    @FormattedTime
    public abstract Date createdAt();

    @Json(name = "gravatar_id")
    @Nullable
    public abstract String gravatarId();

    @Json(name = "site_admin")
    @Nullable
    public abstract Boolean siteAdmin();

    @Json(name = "updated_at")
    @Nullable
    @FormattedTime
    public abstract Date updatedAt();

    @Nullable
    public abstract Integer contributions();

    public abstract Builder toBuilder();

    public static JsonAdapter<User> jsonAdapter(Moshi moshi) {
        return new AutoValue_User.MoshiJsonAdapter(moshi);
    }

    public static Builder builder() {
        return new AutoValue_User.Builder();
    }


    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder login(String login);

        public abstract Builder url(String url);

        public abstract Builder bio(String bio);

        public abstract Builder description(String description);

        public abstract Builder name(String name);

        public abstract Builder company(String company);

        public abstract Builder blog(String blog);

        public abstract Builder location(String location);

        public abstract Builder email(String email);

        public abstract Builder id(Integer id);

        public abstract Builder followers(Integer followers);

        public abstract Builder following(Integer following);

        public abstract Builder hireable(Boolean hireable);

        public abstract Builder type(UserType type);

        public abstract Builder avatarUrl(String avatarUrl);

        public abstract Builder publicRepos(Integer publicRepos);

        public abstract Builder publicGists(Integer publicGists);

        public abstract Builder htmlUrl(String htmlUrl);

        public abstract Builder createdAt(Date createdAt);

        public abstract Builder gravatarId(String gravatarId);

        public abstract Builder siteAdmin(Boolean siteAdmin);

        public abstract Builder updatedAt(Date updatedAt);

        public abstract Builder contributions(Integer contributions);

        public abstract User build();
    }
}