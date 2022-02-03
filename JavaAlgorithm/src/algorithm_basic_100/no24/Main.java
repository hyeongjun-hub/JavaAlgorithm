// 평균을 넘는 수의 비율 구하기
// 입력 : [숫자개수, 수, 수, .. ]
// 출력 : 평균을 넘는 수의 비율

package algorithm_basic_100.no24;

import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        int[] inputs = {7, 29, 39, 10, 40, 40, 54, 77};
        int sum = 0;

        for (int i = 1; i < inputs.length; i++) {
            sum += inputs[i];
        }

        double avg = (double) sum / inputs[0];

        int cnt = 0;

        for(int i=1; i<inputs.length; i++){
            if (inputs[i] > avg) {
                cnt++;
            }
        }

        double beforeResult = cnt / (double) inputs[0] * 100;
        System.out.println("beforeResult = " + beforeResult);

        // 소숫점 자릿수 건들이기

        DecimalFormat df = new DecimalFormat("0.00");
        String result = df.format(beforeResult);

        System.out.println("result = " + result);

    }
}
