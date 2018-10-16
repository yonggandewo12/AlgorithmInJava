package com.learn.CodingTest;

import java.util.*;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test41 {
    /**
     * 牛牛变得黑化了,想要摧毁掉地球。但他忘记了开启地球毁灭器的密码。
     * 牛牛手里有一个字符串S,牛牛还记得从S中去掉一个字符就恰好是正确的密码,
     * 请你帮牛牛求出他最多需要尝试多少次密码。
     * 如样例所示S = "ABA",3个可能的密码是"BA", "AA", "AB".
     * 当S = "A", 牛牛唯一可以尝试的密码是一个空的密码,所以输出1.
     * @param str
     * @return
     */
    public static int solve(String str) {
        if (str.length() == 0 || str == null) {
            return 0;
        }
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i - 1)) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println(solve(s.nextLine()));
    }
}
