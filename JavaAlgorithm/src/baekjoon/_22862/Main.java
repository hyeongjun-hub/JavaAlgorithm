package baekjoon._22862;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n,k;
    static int[]arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++ ) {

            arr[i]=Integer.parseInt(st.nextToken());
        }

        int p=0; //짝
        int q=0; //홀
        int answer;

        int e =0; // 끝 포인터

        //슬라이딩 윈도우 -> 윈도우 크기만큼 end 길이을 늘려주면서 연산을 한다
        for(int i=0; i<n; i++) {

            if(arr[i]%2==0) {
                p++;
            }else {
                q++;
            }

            if(q==k) { // 홀수가 k개가 될때까지 홀수 짝수의 개수와 e의 위치를 옮겨준다
                e=i;
                break;
            }
        }

        answer = p;


        for(int s=0; s<n; s++) { // s는 start pointer

            while(q<=k) {  // 삭제한 홀수의 개수가 k개 이하일 때 까지

                if(q==k){answer=Math.max(answer, p);} //삭제한 홀수개수가 k개일때 answer 갱신

                e++; // 끝 pointer 이동

                if(e>=n) {
                    e--;
                    break;
                } //배열의 끝부분을 넘어서게 되면 while문을 빠져나간다

                if(arr[e]%2==0) { //짝수일 경우
                    p++;
                } else { //홀수일 경우
                    q++;
                }

            }

            if(arr[s]%2==0){
                p--; // 다음 시작점으로 옮기기 전에 현재 시작점에 있는 수가 홀수인지 짝수인지 판별하고 빼준다
            } else {
                q--;
            }

        }

        System.out.println(answer);
    }
}
