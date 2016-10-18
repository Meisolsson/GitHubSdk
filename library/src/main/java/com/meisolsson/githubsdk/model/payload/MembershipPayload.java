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

package com.meisolsson.githubsdk.model.payload;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.meisolsson.githubsdk.model.Team;
import com.meisolsson.githubsdk.model.User;
import com.google.auto.value.AutoValue;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

@AutoValue
public abstract class MembershipPayload extends GitHubPayload<MembershipPayload.Builder> implements Parcelable {

    @Nullable
    public abstract String action();

    @Nullable
    public abstract String scope();

    @Nullable
    public abstract User member();

    @Nullable
    public abstract Team team();

    public abstract Builder toBuilder();

    public static JsonAdapter<MembershipPayload> jsonAdapter(Moshi moshi) {
        return new AutoValue_MembershipPayload.MoshiJsonAdapter(moshi);
    }

    public static MembershipPayload createFromParcel(Parcel in) {
        return AutoValue_MembershipPayload.CREATOR.createFromParcel(in);
    }

    public static Builder builder() {
        return new AutoValue_MembershipPayload.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder extends GitHubPayload.Builder<MembershipPayload, Builder> {
        public abstract Builder action(String action);

        public abstract Builder scope(String scope);

        public abstract Builder member(User member);

        public abstract Builder team(Team team);

        public abstract MembershipPayload build();
    }
}
