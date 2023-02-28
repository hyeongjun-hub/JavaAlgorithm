package baekjoon._1027;//package baekjoon._1027;
//
//import com.sun.security.jgss.GSSUtil;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Main {
//
//    static int N, ans;
//    static double[] input;
//
//    public static void input() {
//        FastReader fr = new FastReader();
//        N = fr.nextInt();
//        input = new double[N];
//        for (int i = 0; i < N; i++) {
//            input[i] = fr.nextInt();
//        }
//
//        for (int i = 0; i < N; i++) {
//            pro(i);
//        }
//    }
//
//    public static void pro(int mid) {
//        int max = 0;
//        double leftAngle = -2;
//        double rightAngle = 2;
//
//        // 좌측
//        int x = -1;
//        for (int i = mid - 1; i >= 0; i--) {
//            double curAng = Math.atan((input[mid] - input[i]) / x) * (180.0 / Math.PI);
//            System.out.println(i + " "  + curAng);
//            if (leftAngle < curAng) {
//                max++;
//                leftAngle = curAng;
//            }
//            x--;
//        }
//
//        // 우측
//        x = 1;
//        for (int i = mid + 1; i < N; i++) {
//            double curAng = Math.atan((input[i] - input[mid]) / x) * (180.0 / Math.PI);
//            System.out.println(i + " "  + curAng);
//            if (curAng < rightAngle) {
//                max++;
//                rightAngle = curAng;
//            }
//            x++;
//        }
//
//        if(max > ans) ans = max;
//
//    }
//
//    public static void main(String[] args) {
//        input();
//        System.out.println(ans);
//    }
//
//    static class FastReader {
//        BufferedReader br;
//        StringTokenizer st;
//
//        public FastReader(){ br = new BufferedReader(new InputStreamReader(System.in));}
//
//        String next(){
//            while(st == null || !st.hasMoreTokens()){
//                try{
//                    st = new StringTokenizer(br.readLine());
//                } catch (IOException e){
//                    e.printStackTrace();
//                }
//            }
//            return st.nextToken();
//        }
//
//        int nextInt() { return Integer.parseInt(next()); }
//
//        long nextLong() { return Long.parseLong(next()); }
//
//        Double nextDouble() { return Double.parseDouble(next()); }
//
//        String nextLine(){
//            String str = "";
//            try{
//                str = br.readLine();
//            } catch(IOException e){
//                e.printStackTrace();
//            }
//            return str;
//        }
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    //(ay-by)/(ax-bx) ? (ay-cy)/(ax-cx)
    //(ay-by)(ax-cx) ? (ay-cy)(ax-bx)
    // -axby + cxby -cxay + axcy + bxay -bxcy
    //(axcy + bxay + cxby) - (axby+bxcy+cxay)

    static int N;
    static long[] map;
    static int[] cache;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        map = new long[N];
        cache = new int[N];

        for(int i=0; i<N; i++){
            map[i] = Long.parseLong(st.nextToken());
        }

        right();

        for (int a : cache){
            answer = Math.max(a, answer);
        }
        System.out.println(answer);
    }

    public static void right(){

        boolean cont;
        for(int i=0; i<N-1; i++){
            for(int j=i+1; j<N; j++){
                cont = true;
                for(int k=i+1; k<j; k++){
                    if(check(i,j,k) <= 0){
                        cont = false;
                        break;
                    }
                }
                if(cont){
                    cache[i]++;
                    cache[j]++;
                }
            }
        }
    }

    //음수면 기울기 커짐
    static long check(int a, int b, int c){
        return  (long)a*map[c] + (long)b*map[a] + (long)c*map[b] - ((long)a*map[b] + (long)b*map[c] + (long)c*map[a]);
    }
}