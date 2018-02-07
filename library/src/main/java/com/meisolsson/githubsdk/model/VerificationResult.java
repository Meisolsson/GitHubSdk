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

@AutoValue
public abstract class VerificationResult implements Parcelable {
    public enum Reason {
        @Json(name = "bad_email") BadEmail,
        @Json(name = "expired_key") ExpiredKey,
        @Json(name = "gpgverify_error") GpgVerifyError,
        @Json(name = "gpgverify_unavailable") GpgVerifyUnavailable,
        @Json(name = "invalid") Invalid,
        @Json(name = "malformed_signature") MalformedSignature,
        @Json(name = "no_user") NoUser,
        @Json(name = "not_signing_key") NotSigningKey,
        @Json(name = "unknown_key") UnknownKey,
        @Json(name = "unknown_signature_type") UnknownSignatureType,
        @Json(name = "unsigned") Unsigned,
        @Json(name = "unverified_email") UnverifiedEmail,
        @Json(name = "valid") Valid
    }

    @Nullable
    public abstract Boolean verified();

    @Nullable
    public abstract Reason reason();

    @Nullable
    public abstract String signature();

    @Nullable
    public abstract String payload();

    public static JsonAdapter<VerificationResult> jsonAdapter(Moshi moshi) {
        return new AutoValue_VerificationResult.MoshiJsonAdapter(moshi);
    }
}
