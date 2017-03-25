package com.meisolsson.githubsdk.model.request;

import com.google.auto.value.AutoValue;
import com.meisolsson.githubsdk.core.FormattedTime;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonQualifier;
import com.squareup.moshi.Moshi;

import java.util.Date;

/**
 * Created by savio on 2017-03-25.
 */

@AutoValue
public abstract class NotificationReadRequest {

    @Json(name = "last_read_at")
    @FormattedTime
    public abstract Date lastReadAt();

    public static JsonAdapter<NotificationReadRequest> jsonAdapter(Moshi moshi){
        return new AutoValue_NotificationReadRequest.MoshiJsonAdapter(moshi);
    }

    public static NotificationReadRequest.Builder builder() {
        return new AutoValue_NotificationReadRequest.Builder()
                .lastReadAt(new Date());
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract NotificationReadRequest.Builder lastReadAt(Date lastReadAt);

        public abstract NotificationReadRequest build();
    }
}
