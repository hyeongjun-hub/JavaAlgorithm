package baekjoon._1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        Double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> deque = new LinkedList<>();
        FastReader fr = new FastReader();
        int repeat = fr.nextInt();
        int count = 0;
        for (int i = 1; i <= repeat; i++)
            deque.addLast(i);
        int findNum = fr.nextInt();
        for (int i = 0; i < findNum; i++) {
            int target = fr.nextInt();
            if (target == deque.peekFirst()) {
                deque.poll();
            } else { //왼쪽으로 가야함
                if(leftGo(deque, target)){
                    while(target != deque.peekFirst()){
                        deque.addLast(deque.pollFirst());
                        count++;
                    }
                    deque.poll();
                }
                else {
                    while (target != deque.peekFirst()) {
                        deque.addFirst(deque.pollLast());
                        count++;
                    }
                    deque.poll();
                }
            }
        }
        System.out.println(count);
    }

    public static boolean leftGo(LinkedList<Integer> deque, int target){
        int index = 0;
        while(deque.get(index) != target) {
            index++;
        }
        return index < (deque.size() % 2 == 0 ? deque.size()/2 : deque.size()/2 + 1);
    }
}
