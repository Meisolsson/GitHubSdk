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

package com.meisolsson.githubsdk.core;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;

import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

public class FormattedTimeAdapter {

    @FromJson
    @FormattedTime
    Date fromJson(String time){
        DateTimeFormatter format = ISODateTimeFormat.dateTimeParser();
        DateTime t = format.withZoneUTC().parseDateTime(time);
        return t.toDate();
    }

    @ToJson
    String toJson(@FormattedTime Date date){
        DateTimeFormatter format = ISODateTimeFormat.dateTime();
        return format.print(date.getTime());
    }
}
