package co.tevent.identity.utils;

import co.tevent.identity.common.Constants;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class DateUtil {
    public static Timestamp tokenExpired(int minutes, ZoneId zone){
        LocalDateTime now = LocalDateTime.now(zone);
        LocalDateTime expirationTime = now.plusMinutes(minutes);
        return Timestamp.valueOf(expirationTime);
    }

    public static Timestamp currentTimeJakarta(){
        LocalDateTime now = LocalDateTime.now(Constants.ASIA_JAKARTA);
        return Timestamp.valueOf(now);
    }
}
