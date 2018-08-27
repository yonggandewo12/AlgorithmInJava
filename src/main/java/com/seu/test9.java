package com.seu;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */

import java.util.*;

/**
 * 丢失的三个数
 * 现在有一个数组，其值为从1到10000的连续增长的数字。出于某次偶然操作，导致这个数组中丢失了某三个元素，同时顺序被打乱，现在需要你用最快的方法找出丢失的这三个元素，并且将这三个元素根据从小到大重新拼接为一个新数字，计算其除以7的余数
 */
public class test9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s= scanner.nextLine();
            String [] str=s.split(" ");
            int [] arr= new int[str.length];
            for(int i=0;i<str.length;i++){//输入的当行字符串转为整数
                arr[i]=Integer.parseInt(str[i]);
            }
            Arrays.sort(arr);//排序
            List<Integer> list = new ArrayList<>();//存储三个数
            for(int i=0;i<arr.length;i++){
                for(int j=i+1;j<arr.length;i++){
                    if(arr[j]==arr[i]+2){//找到了丢失的数，保存
                        list.add(arr[i]+1);
                    }else {
                        break;
                    }
                }
            }
            Collections.sort(list);//丢失的数排序
            StringBuilder sb = new StringBuilder();
            for(Integer i:list){
                sb.append(i);
            }
            System.out.println(Long.parseLong(sb.toString())%7);
        }
    }
}
