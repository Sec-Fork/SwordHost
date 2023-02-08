package com.swordHostDemo.utls;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @date: 2023/1/4 22:03
 * @description:
 */
public class URLEnCode {
    public static String encodeCharSetUTF8 = "UTF-8";

    /**
     * 编码
     *
     * @param str    准备编码的字符串
     * @return 完成编码的字符串
     */
    public static String getURLEncoderString(String str) {
        String result = null;
        try {
            System.out.println("EncodeCharSet "+encodeCharSetUTF8);
            result = URLEncoder.encode(str, encodeCharSetUTF8).replace("+", "%20");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }




}
