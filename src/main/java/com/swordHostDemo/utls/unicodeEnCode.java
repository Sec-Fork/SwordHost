package com.swordHostDemo.utls;

/**
 * @date: 2023/1/13 21:57
 * @description:
 */
public class unicodeEnCode {


    public static String stringToUnicode(String str) {
        char[] utfBytes = str.toCharArray();
        StringBuilder unicodeBytes = new StringBuilder();
        for (char utfByte : utfBytes) {
            String hexB = Integer.toHexString(utfByte);
            if (hexB.length() <= 2) {
                hexB = "00" + hexB;
            }
            unicodeBytes.append("\\u").append(hexB);
        }
        return unicodeBytes.toString();
    }

}
