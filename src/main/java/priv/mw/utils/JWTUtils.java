package priv.mw.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.RSAKeyProvider;
import priv.mw.exception.TokenExpiredException;

import java.time.*;
import java.time.temporal.TemporalAmount;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

public class JWTUtils {

    private static String key = "nduiabfuba13432njkbhj2v31nkxja97893543FASDFASE";
    private static int aliveDay = 1;

    public static boolean checkToken(String token) throws TokenExpiredException {
        try{
            String string = JWT.decode(token).getPayload();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public static String generateToken(HashMap<String, Object> map){
        LocalDate localDate = LocalDate.now();
        localDate.plusDays(aliveDay);

        Algorithm algorithm = Algorithm.HMAC256(key);
        String token = JWT.create()
                .withPayload(map)
                .withJWTId(UUID.randomUUID().toString())
                .withExpiresAt(Date.from(localDate.atStartOfDay(ZoneOffset.ofHours(8)).toInstant()))
                .sign(algorithm);
        return token;
    }
}
