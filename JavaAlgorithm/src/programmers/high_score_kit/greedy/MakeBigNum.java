package programmers.high_score_kit.greedy;

public class MakeBigNum {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int max;
        for (int i = 0; i < number.length() - k; i++) {
            max = 0;
            for (int j = index; j <= k + i; j++) {
                if (max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    index = j + 1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }
}

/*
[입출력 예]의 3번 예제로 예를 들면

'4177252841' 를 0번 index부터 탐색을 시작하여 총 6자리의 return 값을 만들어야 하기 때문에 뒤에서 6번째에 위치한 '41772' 까지 탐색을 진행한다.

그리고 StringBuilder에 가장 큰 수를 append한다.

그러면 이제 앞으로 5자리를 이어 붙히면 되고, 이제 탐색할 시작 index는 가장 큰 수였던 3번인덱스 다음인 4번인덱스 부터 순회한다.

'7252841' 문자열을 탐색하는것이다.

그러면 앞의 규칙에 따라 뒤에서 5번째에 위치한 '725' 까지 탐색을 진행하고 가장큰수를 append한다.

그 다음은 '252841' 문자열을 뒤에서 4번째인 '252' 까지,

그 다음은 '2841' 문자열을 뒤에서 3번째인 '28' 까지,

그 다음은 '41' 문자열을 뒤에서 2번째인 '4' 까지,

그 다음은 '1' 문자열을 뒤에서 1번째인 '1' 까지,

모든 범위가 끝나게되면 현재까지 진행했던 가장큰수를 이어붙인 '775841'가 만들어질것이고

return 해주면 된다.


 */