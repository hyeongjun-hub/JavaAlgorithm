package baekjoon._15651;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// N = 3, M = 4 이면
// _ _ _
// 4 * 4 * 4
// backtracking 사용

// 시간복잡도
// O(N^M) = O(7^7) ~= 82만
// 1초에 1억번 연산이 가능하므로 충분

// 공간복잡도
// O(M)


public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] selected;
    //이때까지 나온 결과를 저장하는 배열

    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M + 1];
    }

    // 재귀 함수
    static void rec_func(int k){
        if(k == M + 1){ // 다 골랐으므로 출력
            for(int i = 1; i <= M; i++){
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        }else{
            for(int cand = 1; cand <= N; cand++){
                selected[k] = cand;
                // k+1 번지부터 ~ M-1 번지까지 모두 탐색하는 일이 남음
                rec_func(k + 1);
                // 재귀함수를 호출하고 또 호출하여 결국 출력(stringBuilder에 추가)할 수 있음
                // 의례상 0으로 지움
                selected[k] = 0;
            }
        }
    }

    // 함수를 더 모듈화하기 위해 main 함수에 긴 코드를 넣지않음
    public static void main(String[] args) {
        input();
        rec_func(1);
        System.out.println(sb);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

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

        int nextInt(){
            return Integer.parseInt(next());
        }

        Double nextDouble(){
            return Double.parseDouble(next());
        }

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
