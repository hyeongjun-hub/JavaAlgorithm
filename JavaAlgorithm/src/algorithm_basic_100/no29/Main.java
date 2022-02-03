// 음계(백준 2920)
//1부터 8까지 차례대로 입력되면 ascending, 8부터 1까지 차례대로입력되면 descending, 둘다 아니라면 mixed를 출력하시오.
//
//예제 입력: 1 2 3 4 5 6 7 8
//출력 ascending
//예제 입력: 8 7 6 5 4 3 2 1
//출력 descending
//예제 입력: 8 1 7 2 6 3 5 4
//출력 mixed

package algorithm_basic_100.no29;

import java.util.Scanner;

public class Main {

    static boolean descend(int[] inputs){
        if(inputs[0] != 1){
            return false;
        }
        for (int i = 1; i < inputs.length-1; i++) {
            if(inputs[i+1] - inputs[i] != 1){
                return false;
            }
        }
        return true;
    }

    static boolean ascend(int[] inputs){
        if(inputs[0] != 1){
            return false;
        }
        for (int i = 1; i < inputs.length-1; i++) {
            if(inputs[i] - inputs[i+1] != 1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input[] = new int[8];

        for(int i=0; i<input.length; i++){
            input[i] = sc.nextInt();
        }

        if(descend(input)){
            System.out.println("descending");
        } else if(ascend(input)){
            System.out.println("ascending");
        } else{
            System.out.println("mixed");
        }


    }
}
