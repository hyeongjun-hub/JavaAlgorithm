package baekjoon._12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int maxCount = Integer.parseInt(input[0]);
        int maxWeight = Integer.parseInt(input[1]);

        //무게, 가치
        int[][] item = new int[maxCount + 1][2];

        //데이터 넣어주기
        for (int i = 1; i <= maxCount; i++) {
            input = br.readLine().split(" ");
            item[i][0] = Integer.parseInt(input[0]);
            item[i][1] = Integer.parseInt(input[1]);
        }

        int[][] dp = new int[maxCount + 1][maxWeight + 1];

        //무게를 점차 늘려감
        for (int nowWeight = 1; nowWeight <= maxWeight; nowWeight++) {
            //해당 무게에 맞는 최대 가치 찾기
            for (int nowItem = 1; nowItem <= maxCount; nowItem++) {
                //기본적으로 앞에 있는 데이터 넣어주기
                dp[nowItem][nowWeight] = dp[nowItem - 1][nowWeight];

                //만약 넣고자 하는 아이템이 무게에 맞는다면?
                if (nowWeight - item[nowItem][0] >= 0) {
                    //넣고자 하는 가치 + (현재 넣을 수 있는 무게 - 넣고자 하는 아이템 무게)를 하고 남은 무게를 가진 아이템의 가치
                    dp[nowItem][nowWeight] = Math.max(dp[nowItem - 1][nowWeight], item[nowItem][1] + dp[nowItem - 1][nowWeight - item[nowItem][0]]);
                }
            }
        }
        System.out.println(dp[maxCount][maxWeight]);
    }
}