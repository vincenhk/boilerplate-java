package co.tevent.identity.utils;

import java.util.Base64;
import java.util.UUID;

public class UuidUtil {
    public static String createUUID(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public static String uuidBase64(){
        UUID uuid = UUID.randomUUID();
        byte[] uuidByte = uuid.toString().getBytes();
        String hashUuid = Base64.getEncoder().encodeToString(uuidByte);
        return hashUuid.substring(0,16);
     }
}
