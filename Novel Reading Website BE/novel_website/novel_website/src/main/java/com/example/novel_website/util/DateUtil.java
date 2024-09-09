package com.example.novel_website.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;

public class DateUtil {
    private static final ZoneId DEFAULT_ZONE_ID = ZoneId.of("UTC");
  
    // Fixed date as LocalDate (assuming UTC)
    private static final LocalDate FIXED_DATE = LocalDate.of(1970, 1, 1);
  
    // Note that week starts with Monday
    public static LocalDate startOfWeek() {
      return LocalDate.now(DEFAULT_ZONE_ID).with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
    }
  
    public static LocalDate startOfMonth() {
      return LocalDate.now(DEFAULT_ZONE_ID).with(TemporalAdjusters.firstDayOfMonth());
    }
  
    // public static Date toDate(final LocalDateTime localDateTime) {
    //   // Consider using a converter like OffsetDateTime.toInstant() instead of Date.from
    //   // depending on your specific needs.
    //   return Date.from(localDateTime.atZone(DEFAULT_ZONE_ID).toInstant());
    // }
  
    public static LocalDate calculateDateRange(String datetime) {
      switch (datetime.toLowerCase()) {
        case "week":
          return startOfWeek();
        case "month":
          return startOfMonth();
        case "alltime":
          return FIXED_DATE;
        default:
          return null;
      }
    }
  }
  
