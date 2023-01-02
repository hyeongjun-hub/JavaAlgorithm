package baekjoon._2170;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static ArrayList<Point> list = new ArrayList<>();

    static class Point{
        int x; int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void input() {
        FastReader fr = new FastReader();
        N = fr.nextInt();
        for (int i = 0; i < N; i++) {
            int x = fr.nextInt();
            int y = fr.nextInt();
            list.add(new Point(x, y));
        }
    }

    public static void main(String[] args) {
        input();
        list.sort((o1, o2) -> {
            if (o1.x > o2.x) {
                return 1;
            } else if (o1.x == o2.x) {
                if (o1.y > o2.y) {
                    return 1;
                }
            }
            return -1;
        });

        int s = list.get(0).x;
        int e = list.get(0).y;
        int sum = e - s;

        for (int i = 1; i < list.size(); i++) {
            int ns = list.get(i).x;
            int ne = list.get(i).y;

            if (s <= ns && ne < e) {
                continue;
            } else if (ns < e) {
                sum += -(e - ns) + ne - ns;
            } else {
                sum += ne - ns;
            }
            s = ns;
            e = ne;
        }

        System.out.println(sum);
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
