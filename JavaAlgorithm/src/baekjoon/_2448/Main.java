package baekjoon._2448;

import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        String map[] = new String[n];
        map[0] = "  *  ";
        map[1] = " * * ";
        map[2] = "*****";

        for (int k = 1; 3 * (int)Math.pow(2, k) <= n; k++) {
            makeBigStar(k, map);
        }

        for (int i = 0; i < n; i++) {
            System.out.println(map[i]);
        }
    }

    private static void makeBigStar(int k, String map[]) {
        int height = 3 * (int)Math.pow(2, k);
        int middle = height / 2;

        for (int i = middle; i < height; i++) {
            map[i] = map[i - middle] + " " + map[i - middle];
        }

        //이전 배열에 빈 공간 추가
        String space = "";
        while (space.length() < middle) {
            space += " ";
        }
        for (int i = 0; i < middle; ++i) {
            map[i] = space + map[i] + space;
        }
    }
}