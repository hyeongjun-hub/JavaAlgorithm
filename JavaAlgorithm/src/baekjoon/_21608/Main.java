package baekjoon._21608;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int N, ans;
    static HashMap<Integer, int[]> like = new HashMap();
    static int[][] map;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        map = new int[N][N];
        for (int i = 0; i < N*N; i++) {
            int[] cur = new int[4];
            int index = fr.nextInt();
            for (int j = 0; j < 4; j++) {
                cur[j] = fr.nextInt();
            }
            like.put(index, cur);
            place(index, cur);
        }
    }

    private static void place(int index, int[] cur) {
        // 1. 비어있는 칸 중 좋아하는 학생 번호가 몇 개 인접한지 +100
        // 2. 비어있는 칸 중 인접한 빈 칸이 몇개인지 +1
        int[][] temp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                temp[i][j] = -1;
                if(map[i][j] > 0) continue;
                // 비어있는 칸중 인접한 좋아하는 학생번호와 빈 칸 개수확인
                int blank = 0; // 비어있는 칸
                int like = 0;
                for (int k = 0; k < 4; k++) {
                    // 인접한 좌표
                    int newR = i + dir[k][0];
                    int newC = j + dir[k][1];
                    if (newR < 0 || newC < 0 || newR >= N || newC >= N) continue;
                    for (int l = 0; l < 4; l++) {
                        if (map[newR][newC] == cur[l]) {
                            like += 100;
                        }
                    }
                    if (map[newR][newC] == 0) {
                        blank++;
                    }
                }
                if(blank > temp[i][j]) temp[i][j] = blank;
                if(like > temp[i][j]) temp[i][j] = like + blank;
            }
        }
        // 3. 순회하면서 제일 적당한 곳 찾기
        int max = -1;
        int bestR = 0; int bestC = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (temp[i][j] > max) {
                    max = temp[i][j];
                    bestR = i;
                    bestC = j;
                }
            }
        }
        if (max == -1) {
            point:
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 0) {
                        bestR = i;
                        bestC = j;
                        break point;
                    }
                }
            }
        }
        map[bestR][bestC] = index;
    }

    public static void main(String[] args) {
        input();

//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                sb.append(map[i][j]);
//            }
//            sb.append("\n");
//        }
//        System.out.println(sb);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int people = 0;
                for (int k = 0; k < 4; k++) {
                    // 인접한 좌표
                    int newR = i + dir[k][0];
                    int newC = j + dir[k][1];
                    if (newR < 0 || newC < 0 || newR >= N || newC >= N) continue;
                    for (int l = 0; l < 4; l++) {
                        if (map[newR][newC] == like.get(map[i][j])[l]) {
                            people++;
                        }
                    }
                }
                if(people == 1) ans += 1;
                else if(people == 2) ans+=10;
                else if(people == 3) ans+=100;
                else if(people == 4) ans+=1000;
            }
        }
        System.out.println(ans);
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
