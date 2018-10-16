package com.learn.CodingTest;

import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test46 {
    /**
     * 牛牛喜欢字符串,但是他讨厌丑陋的字符串。
     * 对于牛牛来说,一个字符串的丑陋值是字符串中相同连续字符对的个数。
     * 比如字符串“ABABAABBB”的丑陋值是3,因为有一对"AA"和两对重叠的"BB"。
     * 现在给出一个字符串,字符串中包含字符'A'、'B'和'?'。
     * 牛牛现在可以把字符串中的问号改为'A'或者'B'。
     * 牛牛现在想让字符串的丑陋值最小,希望你能帮帮他。
     * @param str
     * @return
     */
    public static int solve(String str) {
        int res = 0;
        char[] c = str.toCharArray();
        for (int i = 1; i < str.length(); i++) {
            if (c[i] == '?') {
                if (c[i - 1] == 'A') {
                    c[i] = 'B';
                } else if (c[i-1]=='B') {
                    c[i] = 'A';
                }else{
                    if (i + 1 < str.length()) {
                        c[i] = c[i + 1] == 'B' ? 'A' : 'B';
                    }
                }
            }
            if (c[i] == c[i - 1] && c[i] != '?') {
                res++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println(solve(s.nextLine()));
    }
}
