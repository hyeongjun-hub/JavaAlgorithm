package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderEx1 {
    public static void main(String[] args) throws IOException {
        //콘솔에서 입력받을 경우
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String으로 리턴하므로 형변환
        int num = Integer.parseInt(br.readLine());

        //입출력이 끝나면 닫기
        br.close();

    }
}
