package baekjoon._7785;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        FastReader fr = new FastReader();
        int repeat = fr.nextInt();
        for (int i = 0; i < repeat; i++) {
            String name = fr.next();
            String action = fr.next();
            if (action.equals("enter")) {
                set.add(name);
            }else {
                set.remove(name);
            }
        }
        List<String> people = new ArrayList<>(set);
        people.sort(Collections.reverseOrder());
        for(String person: people) sb.append(person).append("\n");
        System.out.println(sb);
    }
}
