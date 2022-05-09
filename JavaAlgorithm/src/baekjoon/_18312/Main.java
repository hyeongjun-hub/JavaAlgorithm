package baekjoon._18312;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
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

    static int N, K;

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        K = fr.nextInt();
    }

    public static void main(String[] args) {
        input();
        int count = 0;
        for(int hour=0;hour<=N;hour++) {
            for(int min=0;min<60;min++) {
                for(int sec=0;sec<60;sec++) {
                    // 시간을 문자열로 표현, 시,분,초가 10 미만일 경우 앞에 0을 붙인다.
                    String time=((hour<10)?"0"+hour:""+hour)+
                            ((min<10)?"0"+min:""+min)+
                            ((sec<10)?"0"+sec:""+sec);

                    // 시간에 k가 포함되어 있다면 count
                    if(time.contains(""+K))
                        count++;
                }
            }
        }
        System.out.println(count);
    }
}
