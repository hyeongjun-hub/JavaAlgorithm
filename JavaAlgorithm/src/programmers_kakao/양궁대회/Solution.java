package programmers_kakao.양궁대회;

public class Solution {
    static int[] res = {-1};
    static int[] lion;
    static int max = Integer.MIN_VALUE;

    public int[] solution(int n, int[] info) {
        lion = new int[11];
        dfs(0, info, n);
        return res;
    }

    public static void dfs(int cnt, int[] apeach, int arrow) {
        if (cnt == arrow) {
            // 출력
            int apeachPoint = 0;
            int lionPoint = 0;
            for (int j = 0; j <= 10; j++) {
                if (apeach[j] != 0 || lion[j] != 0) {
                    if (apeach[j] < lion[j]) {
                        lionPoint += 10 - j;
                    } else {
                        apeachPoint += 10 - j;
                    }
                }
            }
            if (lionPoint > apeachPoint) {
                if (lionPoint - apeachPoint >= max) {
                    res = lion.clone();
                    max = lionPoint - apeachPoint;
                }
            }
            return;
        }
        for (int i = 0; i < 11 && lion[i] <= apeach[i]; i++) {
            // backtracking
            lion[i]++;
            dfs(cnt + 1, apeach, arrow);
            lion[i]--;
        }
    }
}
