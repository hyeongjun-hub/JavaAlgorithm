//StringBuilder + StringTokenizer

package baekjoon._10952;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int firstNum = Integer.parseInt(st.nextToken());
            int secondNum = Integer.parseInt(st.nextToken());
            if (firstNum == 0 && secondNum == 0) {
                break;
            }
            sb.append(firstNum + secondNum).append("\n");
        }
        System.out.println(sb);


    }
}
