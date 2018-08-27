package com.seu;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
/*
 * 首先将电话号码中的每个数字加上8取个位，然后使用对应的大写字母代替 （"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"），
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 电话号码分身
 */
public class XiaoMiTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] arr = new String[n];
        in.nextLine();  //先调用一次nextLine(),将该行剩下的内容抛弃
        for(int i=0;i<n;i++)
            arr[i] = in.nextLine();
        getResult(n,arr);
        in.close();
    }

    public static void getResult(int n,String[] arr){
        for(int i=0;i<n;i++){
            List<String> numberC = new ArrayList<String>(arr[i].length());
            for(int j=0;j<arr[i].length();j++)
                numberC.add(arr[i].charAt(j)+"");
            getNumber(numberC);
            numberC = null;
        }
    }

    public static void getNumber(List<String> numberC){
        StringBuilder sb = new StringBuilder();
        if(numberC.size()>=4&&numberC.contains("Z")){  //字母Z为0独占
            sb.append("2");  //2+8 =10,取个位0，是最小的那个数字
            numberC.remove("Z");
            numberC.remove("E");
            numberC.remove("R");
            numberC.remove("O");
        }
        if(numberC.size()>=3&&numberC.contains("W")){  //字母W为2独占
            sb.append("4");  //4+8 =12,取个位2，是最小的那个数字
            numberC.remove("T");
            numberC.remove("W");
            numberC.remove("O");
        }
        if(numberC.size()>=4&&numberC.contains("U")){  //字母U为4独占
            sb.append("6");  //6+8 =14,取个位4，是最小的那个数字
            numberC.remove("F");
            numberC.remove("O");
            numberC.remove("U");
            numberC.remove("R");
        }
        if(numberC.size()>=3&&numberC.contains("X")){  //字母X为6独占
            sb.append("8");  //8+8 =16,取个位6，是最小的那个数字
            numberC.remove("S");
            numberC.remove("I");
            numberC.remove("X");
        }
        if(numberC.size()>=5&&numberC.contains("G")){  //字母G为8独占
            sb.append("0");  //0+8 =8,取个位8，是最小的那个数字
            numberC.remove("E");
            numberC.remove("I");
            numberC.remove("G");
            numberC.remove("H");
            numberC.remove("T");
        }
        if(numberC.size()>=3&&numberC.contains("O")){  //字母O为1排除0,2,4,6,8后独占
            sb.append("3");  //3+8 =11,取个位1，是最小的那个数字
            numberC.remove("O");
            numberC.remove("N");
            numberC.remove("E");
        }
        if(numberC.size()>=5&&numberC.contains("H")){  //字母H为3排除0,2,4,6,8后独占
            sb.append("5");  //3+8 =11,取个位1，是最小的那个数字
            numberC.remove("T");
            numberC.remove("H");
            numberC.remove("R");
            numberC.remove("E");
            numberC.remove("E");
        }
        if(numberC.size()>=4&&numberC.contains("F")){  //字母F为5排除0,2,4,6,8后独占
            sb.append("7");  //7+8 =15,取个位5，是最小的那个数字
            numberC.remove("F");
            numberC.remove("I");
            numberC.remove("V");
            numberC.remove("E");
        }
        if(numberC.size()>=5&&numberC.contains("S")){  //字母F为7排除0,2,4,6,8后独占
            sb.append("9");  //9+8 =17,取个位7，是最小的那个数字
            numberC.remove("S");
            numberC.remove("E");
            numberC.remove("V");
            numberC.remove("E");
            numberC.remove("N");
        }
        if(numberC.size()>=4&&numberC.contains("I")){  //字母F为7排除0,2,4,6,8后独占
            sb.append("1");  //1+8 =9,取个位9，是最小的那个数字
            numberC.remove("N");
            numberC.remove("I");
            numberC.remove("N");
            numberC.remove("E");
        }
        String strN = sb.toString();
        char[] cr = strN.toCharArray();
        Arrays.sort(cr);
        String result = String.valueOf(cr);
        System.out.println(result);
    }
}