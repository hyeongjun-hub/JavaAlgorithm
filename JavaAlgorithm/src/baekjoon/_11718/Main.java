package baekjoon._11718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str;
        while ((str= bf.readLine()) != null) {
            sb.append(str).append("\n");

        }
        System.out.println(sb);

    }
}
