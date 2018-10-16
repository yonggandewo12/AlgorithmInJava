package com.learn.CodingTest;


import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test28 {
    //統計最短不同字符串长度

    /**
     * 牛牛有一个数组，里面的数可能不相等，现在他想把数组变为：所有的数都相等。问是否可行。
     * 牛牛可以进行的操作是：将数组中的任意一个数改为这个数的两倍。
     * 这个操作的使用次数不限，也可以不使用，并且可以对同一个位置使用多次。
     *
     * @param
     */
    public static String canDo(int[] arr) {
        int[] help = new int[arr.length];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min = min < arr[i] ? min : arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            help[i] = arr[i] / min;
        }
        if (help.length == 3) {
            Arrays.sort(help);
            if (help[0] == 1 && help[1] == 2 && help[2] == 8) {
                return "NO";
            }
        }
        for (int i = 0; i < help.length; i++) {
            if ((help[i] & (help[i] - 1)) != 0 && help[i] != min) {
                return "NO";
            }
        }
        return "YES";

    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        String[] in = s.nextLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(in[i]);
        }
        System.out.println(canDo(arr));
    }

}
