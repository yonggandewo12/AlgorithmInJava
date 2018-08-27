package com.learn;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class TheMinAbsoluteValue {
    //对于升序排列的数组，求其绝对值最小数
    private static int res = 0;
    //二分法查找
    public static void findMinAbsoluteValue(int[] arr, int l, int r) {
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] == 0) {
                res = 0;
                return;
            } else if (arr[mid] > 0) {
                if (mid - 1 >= l && arr[mid - 1] > 0) {
                    findMinAbsoluteValue(arr, l, mid - 1);
                }
                if (mid - 1 >= l && arr[mid - 1] <= 0) {
                    res = -arr[mid - 1] > arr[mid] ? arr[mid] : arr[mid - 1];
                    return;
                }
            }else{
                if (mid + 1 <= r && arr[mid + 1] <= 0) {
                    findMinAbsoluteValue(arr, mid + 1, r);
                }
                if (mid + 1 <= r && arr[mid + 1] > 0) {
                    res = -arr[mid] > arr[mid + 1] ? arr[mid + 1] : arr[mid];
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {-2, -1,0, 2, 3, 5};
        findMinAbsoluteValue(arr, 0, arr.length - 1);
        System.out.println(res);
    }
}
