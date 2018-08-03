package com.meisolsson.githubsdk.core;

import org.joda.time.format.ISODateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

public class DateQuery {
  private final Date date;

  public DateQuery(Date date) {
    this.date = date;
  }

  @Override public String toString() {
    DateTimeFormatter format = ISODateTimeFormat.dateTime();
    return format.print(date.getTime());
  }
}
