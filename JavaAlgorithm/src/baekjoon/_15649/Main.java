package baekjoon._15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 15651과 유사한 문제, 하지만 중복을 허용하지 않음 (조건이 존재)
// N=4, M=3
// _ _ _
// 4 * 3 * 2

// 시간복잡도
// O(NPM) = O(8P8) = 40320
// 1억보다 충분히 작기 때문에 구현할 가치 ok

// 공간복잡도
// O(M)


public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] selected;
    static boolean[] used;
    // selected : 출력하기
    // used : index 가 현재 쓰였는지 안쓰였는지 저장해 놓는 boolean 배열

    static void input(){
        FastReader fr = new FastReader();
        N = fr.nextInt();
        M = fr.nextInt();
        selected = new int[M + 1];
        used = new boolean[N + 1];
    }

    static void rec_func(int k){
        if(k == M + 1){
            for(int i = 1; i <= M; i++){
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        }else{
            for(int cand = 1; cand <= N; cand++){
                if(used[cand]) continue;
                // k 번째에 cand가 올 수 있으면
                selected[k] = cand;    used[cand] = true;
                rec_func(k+1);
                selected[k] = 0;    used[cand] = false;
            }
        }
    }


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
