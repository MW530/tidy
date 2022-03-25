package priv.mw.utils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class DateTimeUtils {
    public static long localDateTime2timeStamp(LocalDateTime localDateTime){
        System.out.println(localDateTime.toEpochSecond(ZoneOffset.of("+8")));
        return localDateTime.toEpochSecond(ZoneOffset.of("+8"));
    }
}
