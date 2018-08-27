package com.learn;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class JumpFloor {
    //跳台阶问题
    private static int count = 0;
    public static void jump(int i, int target) {
        if (i == target) {
            count += 1;
            return;
        } else if (i>target) {
            return;
        }
        jump(i + 1, target);
        jump(i + 2, target);
    }

    public static void main(String[] args) {
        jump(0,2);
        System.out.println(count);
    }
}
