package com.learn.CodingTest;

import java.util.*;
import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test7 {
    //招商2   括号配对问题
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<String> result = new ArrayList<>();
        printHelper(n, n, "", result);

        Collections.sort(result);
        for (int i = 0; i < result.size(); i++) {
            if (i < result.size() - 1) {
                System.out.print(result.get(i) + ",");
            } else {
                System.out.print(result.get(i));
            }
        }
    }

    private static void printHelper(int left, int right
            , String out, List<String> result) {

        if (left < 0 || right < 0 || left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            result.add(out);
            return;
        }

        printHelper(left - 1, right, out + "(", result);
        printHelper(left, right - 1, out + ")", result);

    }
}
