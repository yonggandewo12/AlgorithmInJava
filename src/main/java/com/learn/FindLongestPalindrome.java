package com.learn;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class FindLongestPalindrome {
    //最长回文子序列问题

    /**
     * 提取最长回文子串
     * @param s
     * @return
     */
    public static String getPalindrome(String s) {
        char[] ch = s.toCharArray();
        String str = "";
        String re = "";
        for (int i = 0; i < ch.length; i++) {
            re = getEvery(ch, i, i); // 当以一个字符为中轴也就是回文串为奇数时
            if (re.length() > str.length()) {
                str = re;
            }
            re = getEvery(ch, i, i + 1); // 当以当前和他后一个字符为轴心，也就是回文串为偶数时
            if (re.length() > str.length()) {
                str = re;
            }
        }
        return str;
    }
    /**
     * 判断一个字符数组从某一个或两个点开始向两端拓展，是否是回文串，是则返回该子串
     *
     * @param ch
     * @param i
     * @param j
     * @return
     */
    public static String getEvery(char[] ch, int i, int j) {
        int length = ch.length;
        while (i >= 0 && j <= length - 1 && ch[i] == ch[j]) {
            i--;
            j++;
        }
        return String.valueOf(ch).substring(i + 1, j);// 不可以用ch.toString()，这个方法返回的不是字符数组对应的字符串，而是一个内存地址，
        // 且此处无论是前面边界退出还是两端值不等退出都应该将ij的值回退，所以sub这两端。
    }

    /**
     * 是否是回文串
     * @param text
     * @return
     */
    public static boolean isPalindrome(String text) {
        int length = text.length();
        for (int i = 0; i < length / 2; i++) {
            if (text.toCharArray()[i] != text.toCharArray()[length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 计算回文序列总个数
     * @param str
     * @return
     */
    public static int sumOfPalindrome(String str)
    {
        int length = str.length();
        int[][] count = new int[length][length];  //系统自动初始化为0

        for (int left = length - 1; left >= 0; left--)
        {
            count[left][left] = 1;

            for (int right = left + 1; right < length; right++)
            {
                if (str.charAt(left) == str.charAt(right))
                {
                    count[left][right] = count[left][right - 1] + count[left + 1][right] + 1;
                }
                else
                {
                    count[left][right] = count[left][right - 1] + count[left + 1][right] - count[left + 1][right - 1];
                }
            }
        }
        return count[0][length - 1];
    }

    /**
     * 添加最少的字符串，使得原串是回文字符串   (动态规划法)
     * @param c
     * @return 添加字符数目
     */
    public static int getDP(char[] c) {
        int[][] dp = new int[c.length][c.length];
        for (int j = 1; j < c.length; j++) {
            dp[j - 1][j] = c[j - 1] == c[j] ? 0 : 1;
            for (int i = j - 2; i > -1; i--) {
                if (c[i] == c[j]) {
                    dp[i][j] = dp[i + 1][j - 1];
                }else{
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[0][c.length - 1];
    }

    /**
     * 把一个字符串最少切割几次，使得得到的子串全部都是回文串
     * @param str
     * @return 最少切割次数
     */
    public static int minCut(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        char[] c = str.toCharArray();
        int len = c.length;
        int[] dp = new int[len + 1];
        dp[len] = -1;
        boolean[][] p = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = i; j < len; j++) {
                if (c[i] == c[j] && (j - i < 2 || p[i + 1][j - 1])) {
                    p[i][j] = true;
                    dp[i] = Math.min(dp[i], dp[j + 1] + 1);
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        String str = "abcddcc";
        System.out.println(getPalindrome(str));
        System.out.println(sumOfPalindrome(str));
        System.out.println(isPalindrome(str));
    }
}
