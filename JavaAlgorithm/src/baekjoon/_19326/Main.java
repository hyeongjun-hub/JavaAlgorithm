package baekjoon._19326;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int maxSum;
    static int sr, sc, sDir; // shark r, c, dir
    static Fish[][] map = new Fish[4][4];
    static boolean[][] dead = new boolean[4][4];
    static int[][] dir = {{0, 0}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}};

    public static void input() {
        FastReader fr = new FastReader();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int num = fr.nextInt();
                int dir = fr.nextInt();
                map[i][j] = new Fish(num, dir);
            }
        }
        sDir = map[0][0].dir;
        // depth 1 시작
        shark(1, map[0][0].num);
        System.out.println(maxSum);
    }

    public static void shark(int depth, int sum) {
        System.out.println("depth = " + depth);
        Fish[][] tempMap = new Fish[map.length][map.length];
        for(int i = 0; i < map.length; i++) {
            System.arraycopy(map[i], 0, tempMap[i], 0, map.length);
        }

        // 물고기로 인한 맵 변화
        fish(depth);


        int curR = sr;
        int curC = sc;
//        int pastDir = sDir;
        for (int i = 1; i <= 3; i++) {
            // 갈 수 있는지 확인
            int newSharkR = curR + dir[sDir][0] * i;
            int newSharkC = curC + dir[sDir][1] * i;
            int curDir = sDir;
            if((newSharkR < 0 || newSharkR >= 4 || newSharkC < 0 || newSharkC >= 4)) continue;
            if(dead[newSharkR][newSharkC]) continue; // 비어있으면 불가능
            // 갈 수 있으면
            // 상어로 인한 맵 변화
            dead[sr][sc] = true;
            int pastSharkR = sr;
            int pastSharkC = sc;
            sr = newSharkR;
            sc = newSharkC;
            sDir = map[newSharkR][newSharkC].dir;
            sum += map[sr][sc].num;
            if(maxSum < sum) maxSum = sum;

            // 재귀
            shark(depth + 1, sum);

            // 상어로 인한 맵 초기화
            sr = pastSharkR;
            sc = pastSharkC;
            sDir = curDir;
            sum -= map[sr][sc].num;
            dead[sr][sc] = false;
        }

        // 물고기로 인한 맵 되돌리기
        // 맵 상태, 물고기 정보 되돌리기
        for(int j = 0; j < map.length; j++) System.arraycopy(tempMap[j], 0, map[j], 0, map.length);
    }

    public static void fish(int depth) {
        // fish 이동 (map 변화)
        int index = 1;
        while (index <= 16) {
            point:
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (map[i][j].num != index){ continue;}
                    if (dead[i][j]){ index++; break point;}
                    if (i == sr && j == sc) { index++; break point;}
                    if (map[i][j].num == 0) {index++; break point;}


                    Fish fish = map[i][j];
                    int fishDir = fish.dir;

                    int wantR = i + dir[fishDir][0];
                    int wantC = j + dir[fishDir][1];
                    int change = 0;

                    while ((wantR < 0 || wantR >= 4 || wantC < 0 || wantC >= 4) || (wantR == sr && wantC == sc)) {
                        // 가능할 때 까지
                        fishDir += 1;
                        if (fishDir == 9) fishDir = 1;
                        wantR = i + dir[fishDir][0];
                        wantC = j + dir[fishDir][1];
                        change++;
                        if(change == 8) break point;
                    }

                    map[i][j].dir = fishDir;


                    // 위치 교환
                    // 빈 공간일 때
                    if(dead[wantR][wantC]) {
                        dead[i][j] = true;
                        dead[wantR][wantC] = false;
                    }
                    Fish temp = map[i][j];
                    map[i][j] = map[wantR][wantC];
                    map[wantR][wantC] = temp;
                    index++;
                    break point;
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if(dead[i][j])sb.append("E");
                    else if(i==sr && j==sc)sb.append("S");
                    else sb.append(map[i][j].num);
                    sb.append(" ");
                }
                sb.append("\n");
            }
            System.out.println(index);
            System.out.println(sb);
        }
    }


    public static void main(String[] args) {
        input();
    }

    static class Fish{
        int num;
        int dir;

        public Fish(int num, int dir) {
            this.num = num;
            this.dir = dir;
        }
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){ br = new BufferedReader(new InputStreamReader(System.in));}

        String next(){
            while(st == null || !st.hasMoreTokens()){
                try{
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        Double nextDouble() { return Double.parseDouble(next()); }

        String nextLine(){
            String str = "";
            try{
                str = br.readLine();
            } catch(IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
}
