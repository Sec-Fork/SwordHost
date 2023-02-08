package com.swordHostDemo.utls;

/**
 * @date: 2023/1/13 21:58
 * @description:
 */
public class unicodeDeCode {
    public static String unicodeToString1(String str) {
        int start = 0;
        int end = 0;
        StringBuilder buffer = new StringBuilder();
        while (start > -1) {
            end = str.indexOf("\\u", start + 2);
            String charStr = "";
            if (end == -1) {
                charStr = str.substring(start + 2);
            } else {
                charStr = str.substring(start + 2, end);
            }
            char letter = (char) Integer.parseInt(charStr, 16); // 16进制parse整形字符串。
            buffer.append(letter);
            start = end;
        }
        return buffer.toString();
    }
}

