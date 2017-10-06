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
import java.util.List;

@AutoValue
public abstract class IssueEvent implements Parcelable {
    @AutoValue
    public static abstract class DismissedReview implements Parcelable {
        @Json(name = "review_id")
        @Nullable
        public abstract Integer reviewId();

        @Nullable
        public abstract ReviewEventState state();

        @Json(name = "dismissal_message")
        @Nullable
        public abstract String dismissalMessage();

        public static JsonAdapter<DismissedReview> jsonAdapter(Moshi moshi) {
            return new AutoValue_IssueEvent_DismissedReview.MoshiJsonAdapter(moshi);
        }
    }

    @Nullable
    public abstract String url();

    @Nullable
    public abstract Label label();

    @Nullable
    public abstract Long id();

    @Json(name = "commit_url")
    @Nullable
    public abstract String commitUrl();

    @Json(name = "created_at")
    @Nullable
    @FormattedTime
    public abstract Date createdAt();

    @Json(name = "commit_id")
    @Nullable
    public abstract String commitId();

    @Nullable
    public abstract IssueEventType event();

    @Nullable
    public abstract Milestone milestone();

    @Nullable
    public abstract Rename rename();

    @Nullable
    public abstract User assignee();

    @Nullable
    public abstract User assigner();

    @Nullable
    public abstract User actor();

    @Json(name = "review_requester")
    @Nullable
    public abstract User reviewRequester();

    @Json(name = "requested_reviewer")
    @Nullable
    public abstract User requestedReviewer();

    @Json(name = "requested_reviewers")
    @Nullable
    public abstract List<User> requestedReviewers();

    @Json(name = "dismissed_review")
    @Nullable
    public abstract DismissedReview dismissedReview();

    // TODO: All of the below belong to the timeline API and need to be re-checked
    //       once that API is out of preview.

    public enum ReviewEventState {
        @Json(name = "approved") Approved,
        @Json(name = "changes_requested") ChangesRequested,
        @Json(name = "commented") Commented,
        @Json(name = "dismissed") Dismissed,
        @Json(name = "pending") Pending
    }

    @AutoValue
    public static abstract class GitTreeReference implements Parcelable {
        @Nullable
        public abstract String sha();

        @Nullable
        public abstract String url();

        public static JsonAdapter<GitTreeReference> jsonAdapter(Moshi moshi) {
            return new AutoValue_IssueEvent_GitTreeReference.MoshiJsonAdapter(moshi);
        }

    }

    @AutoValue
    public static abstract class CrossReferenceSource implements Parcelable {
        // TODO: convert to enum
        @Nullable
        public abstract String type();

        @Nullable
        public abstract Issue issue();

        public static JsonAdapter<CrossReferenceSource> jsonAdapter(Moshi moshi) {
            return new AutoValue_IssueEvent_CrossReferenceSource.MoshiJsonAdapter(moshi);
        }
    }

    @Json(name = "state")
    @Nullable
    public abstract ReviewEventState reviewState();

    @Json(name = "submitted_at")
    @Nullable
    @FormattedTime
    public abstract Date submittedAt();

    @Json(name = "author_association")
    @Nullable
    public abstract AuthorAssociation authorAssociation();

    @Nullable
    public abstract User author();

    @Nullable
    public abstract User committer();

    @Nullable
    public abstract String message();

    @Nullable
    public abstract String sha();

    @Nullable
    public abstract GitTreeReference tree();

    @Nullable
    public abstract List<GitTreeReference> parents();

    @Nullable
    public abstract VerificationResult verification();

    @Nullable
    public abstract CrossReferenceSource source();

    public static JsonAdapter<IssueEvent> jsonAdapter(Moshi moshi) {
        return new AutoValue_IssueEvent.MoshiJsonAdapter(moshi);
    }
}
