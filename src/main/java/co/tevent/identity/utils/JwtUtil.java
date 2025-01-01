package co.tevent.identity.utils;

import io.jsonwebtoken.Jwts;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

@Log4j2
@Component
public class JwtUtil {

    @Value("${security.jwt.secret-key}")
    private String secretKey;

    @Value("${security.jwt.expiration-time}")
    private long expirationTime;

    private static SecretKey key;

//    @PostConstruct
    public void initJwt() {
        try {
            byte[] decodedKey = Base64.getDecoder().decode(secretKey);
            key = new SecretKeySpec(decodedKey, 0, decodedKey.length, "HmacSHA256");
        } catch (IllegalArgumentException e) {
            throw new IllegalStateException("Failed to decode the secret key, ensure it's Base64 encoded", e);
        } catch (Exception e) {
            throw new IllegalStateException("Failed to initialize JWT", e);
        }
    }

    /**
     * Build token using email and additional claims
     * @param email, contain String email login
     * @param claims, contain Map from additional data used
     * @return String
     */
    public String buildToken(String email, Map<String, Object> claims) {
        return Jwts.builder()
                .setSubject(email)
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(key)
                .compact();
    }
}
