package com.swordHostDemo.utls;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @date: 2022/12/29 20:25
 * @description:
 */
public class base64DeCode {
    public static String base64Decodes(String str) {
        String base64decodedByte = null;
        byte[] base64decodedBytes = Base64.getDecoder().decode(str);
        base64decodedByte = new String(base64decodedBytes, StandardCharsets.UTF_8);
        return base64decodedByte;
    }
    
}
