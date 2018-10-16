package com.learn.CodingTest;

import java.util.Scanner;

/**
 * Created by Intellij Idea 2018.5
 * Company :SEU
 * Author  :yonggandewo12
 * GitHub  :https://github.com/yonggandewo12
 */
public class test51 {
    public static int solve(Room[] rooms) {
        int res = 0;
        int startIndex = 0;
        int maxScore = Integer.MIN_VALUE;
        for (int i = 0; i < rooms.length; i++) {
            if (maxScore < rooms[i].score) {
                maxScore = rooms[i].score;
                startIndex = i + 1;
            }
        }
        int n= 0;
        int next = 0;
        res += maxScore;
        int cur = maxScore;
        while (n < rooms.length) {
            if (cur < 0) {
                cur = 0;
            }
            next = rooms[startIndex - 1].id;
            cur += rooms[next - 1].score;
            startIndex = next;
            if (cur > res) {
                res = cur;
            }
            n++;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());
        Room[] rooms = new Room[n];
        for (int i = 0; i < n; i++) {
            String[] str = s.nextLine().split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            rooms[i] = new Room(x, y);
        }
        System.out.println(solve(rooms));
    }
    static class Room{
        public int score;
        public int id;

        public Room(int score, int id) {
            this.id = id;
            this.score = score;
        }
    }
}
