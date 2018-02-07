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
import com.squareup.moshi.Json;

import java.util.Date;

public abstract class GitHubCommentBase implements Parcelable {

    @Nullable
    public abstract Long id();

    @Nullable
    public abstract String body();

    @Nullable
    @Json(name = "body_html")
    @FormattedHtml
    public abstract String bodyHtml();

    @Nullable
    public abstract User user();

    @Nullable
    public abstract String url();

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

    @Json(name = "author_association")
    @Nullable
    public abstract AuthorAssociation authorAssociation();

    @Nullable
    public abstract Reactions reactions();

    protected abstract static class Builder<B extends Builder<B>> {
        public abstract B id(Long id);

        public abstract B body(String body);

        public abstract B bodyHtml(String bodyHtml);

        public abstract B url(String url);

        public abstract B htmlUrl(String htmlUrl);

        public abstract B user(User user);

        public abstract B createdAt(Date createdAt);

        public abstract B updatedAt(Date updatedAt);

        public abstract B authorAssociation(AuthorAssociation authorAssociation);

        public abstract B reactions(Reactions reactions);
    }
}
