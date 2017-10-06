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

import com.squareup.moshi.Json;

public enum IssueEventType {
    @Json(name = "assigned") Assigned,
    @Json(name = "closed") Closed,
    @Json(name = "commented") Commented,
    @Json(name = "committed") Committed,
    /*TODO Is this working correctly? This is used by the issue timeline api which is not
        yet stable. When it' stable this needs to be tested*/
    @Json(name = "cross-referenced") CrossReferenced,
    @Json(name = "demilestoned") Demilestoned,
    @Json(name = "head_ref_deleted") HeadRefDeleted,
    @Json(name = "head_ref_restored") HeadRefRestored,
    @Json(name = "labeled") Labeled,
    @Json(name = "locked") Locked,
    @Json(name = "mentioned") Mentioned,
    @Json(name = "merged") Merged,
    @Json(name = "milestoned") Milestoned,
    @Json(name = "referenced") Referenced,
    @Json(name = "renamed") Renamed,
    @Json(name = "reopened") Reopened,
    @Json(name = "subscribed") Subscribed,
    @Json(name = "unassigned") Unassigned,
    @Json(name = "unlabeled") Unlabeled,
    @Json(name = "unlocked") Unlocked,
    @Json(name = "unsubscribed") Unsubscribed
}