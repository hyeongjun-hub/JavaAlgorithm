// split method

package baekjoon._10953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        while(T > 0){
            String[] strings = bf.readLine().split(",");
            int a = Integer.parseInt(strings[0]);
            int b = Integer.parseInt(strings[1]);
            System.out.println(a+b);
            T--;
        }
    }
}
