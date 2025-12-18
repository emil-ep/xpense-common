package org.xperia.util;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class TimeUtil {

    public static Long getHourlyTimestamp(long currentTimeMillis){

        Instant instant = Instant.ofEpochMilli(currentTimeMillis);
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of("UTC"));
        ZonedDateTime startOfHour = zonedDateTime.truncatedTo(ChronoUnit.HOURS);
        return startOfHour.toInstant().toEpochMilli();
    }
}
