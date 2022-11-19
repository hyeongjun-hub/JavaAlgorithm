package programmers.high_score_kit.dynamic_programming;

import java.util.Arrays;

public class WayToSchool {
    // 순회하면서 오른쪽 아래로 모두 갈 수 있으면 *2를 한다
    // 불가능

    // 1. m, n 크기의 이차원 배열을 만든다. (street[][])
    // 2. 웅덩이 배열(puddles[][]) 크기만큼 반복문을 돌며, 해당 street 배열의 위치의 값을 -1로 초기화한다.
    // 3. 시작점(0, 0)의 크기를 1로 초기화한다.
    // 4. 이중 반복문을 돈다.
    //      첫 번째 반복문은 n까지(i), 두번째 반복문은 m까지(j)
    // 5. street[i][j]의 값이 -1이라면(웅덩이) 값을 0으로 바꿔주고 (나중에 계산을 위해) 4번으로 돌아간다.
    // 6. i의 값이 0이 아니라면 (맨 위가 아니라면) 위쪽 값을 street[i][j]에 더해준다.
    // 7. j의 값이 0이 아니라면 (맨 왼쪽이 아니라면) 왼쪽 값을 street[i][j]에 더해준다.
    // 8. 4번으로 돌아간다.
    // 9. street[m - 1][n - 1]을 리턴한다.
    //      m과 n은 크기를 의미하기 때문에 위치는 -1을 해주어야한다.

    public int solution(int m, int n, int[][] puddles) {
        int[][] street = new int[n][m];

        // 웅덩이는 -1
        for (int[] puddle : puddles) {
            street[puddle[1] - 1][puddle[0] - 1] = -1;
        }

        street[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (street[i][j] == -1) {
                    street[i][j] = 0;
                    continue;
                }

                if (i != 0) {
                    street[i][j] += street[i - 1][j] % 1000000007;
                }
                if (j != 0) {
                    street[i][j] += street[i][j - 1] % 1000000007;
                }
            }

        }
        return street[n - 1][m - 1] % 1000000007;
    }

    public static void main(String[] args) {
        WayToSchool wayToSchool = new WayToSchool();
        int solution = wayToSchool.solution(4, 3, new int[][]{{2, 2}});
        System.out.println("Solution = " + solution);
    }
}
