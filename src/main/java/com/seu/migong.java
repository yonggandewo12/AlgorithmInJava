package com.seu;

import java.util.Scanner;
/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class migong {
    public static void main(String[] args) {
        while(true) {
            Scanner scanner = new Scanner(System.in);
            String in1 = scanner.nextLine();
            //迷宫大小
            int m = Integer.parseInt(in1.split(" ")[0]);
            int n = Integer.parseInt(in1.split(" ")[1]);
            String in2 = scanner.nextLine();
            if (0 == in2.hashCode() || " ".equals(in2)) {
                //0是什么都不做直接回车时对应的hash值
                System.out.println("Incorrect command format.");
                return;
            }
            int[][] number = InputFormate(m, n, in2);
            if (number == null) {
                return;
            }
            if (validate(m, n, number)) {
                //校验通过，执行后续
                System.out.println(InputToResultString(m,n,number));
            } else {
            }
        }
    }

    private static String InputToResultString(int m,int n,int[][] num) {
        int[][] result = new int[m+m+1][n+n+1];
        //初始化
        for (int i=0;i<result.length;i++) {
            for (int j=0;j<result[i].length;j++) {
                result[i][j]=0;
            }
        }
        //step1  num素组下标替换
        for (int i=0;i<num.length;i++) {
            for (int j=0;j<num[i].length;j++) {
                num[i][j]=num[i][j]+num[i][j]+1;
            }
        }
        //打通的道路标记
        for (int i=0;i<num.length;i++) {
            if (num[i][0]==num[i][2]) {
                result[num[i][0]][(num[i][1]+num[i][3])/2]=1;
                result[num[i][0]][num[i][1]]=1;
                result[num[i][0]][num[i][3]]=1;
            }
            if (num[i][1]==num[i][3]) {
                result[(num[i][0]+num[i][2])/2][num[i][1]]=1;
                result[num[i][1]][num[i][0]]=1;
                result[num[i][1]][num[i][2]]=1;
            }
        }
        StringBuffer sb = new StringBuffer("");
        //结果
        for (int i=0;i<result.length;i++){
            for(int j=0;j<result[i].length;j++){
                if (result[i][j]==1){
                    sb.append("[R]"+" ");
                }else{
                    sb.append("[W]"+" ");
                }
            }
            sb.append("\r\n");
        }
        return sb.toString();
    }

    /**
     * 输入迷宫数据格式化
     * @param in
     * @return
     */
    private static int[][] InputFormate(int m,int n,String in) {
        String[] str = in.split(";");
        //将数据信息转化为二维数组
        int[][] num = new int[str.length][4];
        try{
            for (int i = 0; i < str.length; i++) {
                String[] str2 = str[i].split(" ");
                num[i][0] = Integer.parseInt((str2[0].split(","))[0]);
                num[i][1] = Integer.parseInt((str2[0].split(","))[1]);
                num[i][2] = Integer.parseInt((str2[1].split(","))[0]);
                num[i][3] = Integer.parseInt((str2[1].split(","))[1]);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
            return null;
        }
        return num;
    }

    private static boolean validate(int m,int n,int[][] num) {
            boolean isTrue = true;
            String log;
            for (int i=0;i<num.length;i++) {
                for (int j=0;j<num[i].length;j++) {
                    if (!(num[i][j]>=0)) {
                        log = "Invalid number format.";
                        isTrue = false;
                        System.out.println(log);
                        return isTrue;
                    }
                    if (j==0||(j==2)) {
                        //二重校验  矩阵范围校验
                        if (!(num[i][j]>=0&&(num[i][j]<=m-1))) {
                            log = "Number out of range.";
                            isTrue = false;
                            System.out.println(log);
                            System.exit(0);
                        }
                    }
                    if (j==1||(j==3)) {
                        //二重校验  矩阵范围校验
                        if (!(num[i][j]>=0&&(num[i][j]<=n-1))) {
                            log = "Number out of range.";
                            isTrue = false;
                            System.out.println(log);
                            System.exit(0);
                        }
                    }
                }
                //通路判断
                if ((num[i][0] == num[i][2])) {
                    if (Math.abs(num[i][1] - num[i][3]) == 1) {
                    } else {
                        log = "Maze format error.";
                        isTrue = false;
                        System.out.println(log);
                        return isTrue;
                    }
                } else if ((num[i][1] == num[i][3])) {
                    if (Math.abs(num[i][0] - num[i][2]) == 1) {
                    } else {
                        log = "Maze format error.";
                        isTrue = false;
                        System.out.println(log);
                        return isTrue;
                    }
                } else {
                    log = "Maze format error.";
                    System.out.println(log);
                    isTrue = false;
                    return isTrue;
                }
            }
        return isTrue;
    }
}
