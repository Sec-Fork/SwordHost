package com.swordHostDemo.utls;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @date: 2023/1/4 22:02
 * @description:
 */
public class URLDeCode {

    public static String encodeCharSetUTF8 = "UTF-8";

    /**
     * 解码
     *
     * @param str    已经编码的字符串
     * @return 完成解码的字符串
     */
    public static String getURLDecoderString(String str) {
        String result = null;
        try {
            System.out.println("DecodeCharSet "+encodeCharSetUTF8);
            result = URLDecoder.decode(str, encodeCharSetUTF8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

//    public static void main(String[] args) {
//        String str = "https://baike.baidu.com/item/136156";
//
//
//        String result = URLEnCode.getURLEncoderString(str);
//        System.out.println("编码之后的字符串：" + result);
//        result = getURLDecoderString(str);
//        System.out.println("解码之后的字符串：" + result);
//    }
}
