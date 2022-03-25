package priv.mw.utils;

import org.apache.shiro.crypto.hash.Sha512Hash;
import priv.mw.domain.User;

import java.time.LocalDateTime;
import java.time.ZoneOffset;



public class EncodeUtils {
    private static int iterations = 1024;

    public static String getEncodePass(User user, LocalDateTime registerTime, int iterations){
        String storedPassword = new Sha512Hash(user.getPassword(), String.valueOf(DateTimeUtils.localDateTime2timeStamp(registerTime)), iterations).toString();
        return storedPassword;
    }

    public static String getEncodePass(User user, LocalDateTime registerTime){
        String storedPassword = new Sha512Hash(user.getPassword(), String.valueOf(DateTimeUtils.localDateTime2timeStamp(registerTime)), iterations).toString();
        return storedPassword;
    }
}
