//피보나치 수열

package algorithm_basic_100.no2;

public class Main {

	public static void main(String[] args) {
		int[] numList = new int[100];

		numList[0] = 1;
		numList[1] = 1;

		for (int i = 2; i < 10; i++) {
			numList[i] = numList[i - 1] + numList[i - 2];
			System.out.println(numList[i]);
		}

	}

}
