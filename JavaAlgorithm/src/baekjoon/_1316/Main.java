package baekjoon._1316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        int repeat = fr.nextInt();
        int result = 0;
        for (int i = 0; i < repeat; i++) {
            String word = fr.nextLine();
            result += findGroupWord(word);
        }
        System.out.println(result);
    }

    public static int findGroupWord(String word) {
        ArrayList<Character> alphabet = new ArrayList<>();
        char[] charList = word.toCharArray();
        alphabet.add(charList[0]);
        for(int i=1; i<charList.length; i++){
            if(charList[i-1] == charList[i]) continue;
            if (alphabet.contains(charList[i])) return 0;
            alphabet.add(charList[i]);
        }
        return 1;
    }
}
