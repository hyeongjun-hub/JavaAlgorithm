package baekjoon._22943;

import java.util.Scanner;

public class Main {
//    static class FastReader {
//        BufferedReader br;
//        StringTokenizer st;
//
//        public FastReader(){
//            br = new BufferedReader(new InputStreamReader(System.in));
//        }
//
//        String next(){
//            while(st == null || !st.hasMoreTokens()){
//                try{
//                    st = new StringTokenizer(br.readLine());
//                } catch (IOException e){
//                    e.printStackTrace();
//                }
//            }
//            return st.nextToken();
//        }
//
//        int nextInt(){
//            return Integer.parseInt(next());
//        }
//
//        Double nextDouble(){
//            return Double.parseDouble(next());
//        }
//
//        String nextLine(){
//            String str = "";
//            try{
//                str = br.readLine();
//            } catch(IOException e){
//                e.printStackTrace();
//            }
//            return str;
//        }
//    }
//
//    static int K, M;
//
//    public static void input() {
//        FastReader fr = new FastReader();
//        K = fr.nextInt();
//        M = fr.nextInt();
//    }
//
//    public static boolean isPrime(int num) {
//        if(num == 1) return false;
//        for (int i = 2; i <= Math.sqrt(num); i++) {
//            if (num % i == 0) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public static boolean firstCondition(int num) {
//        for (int i = 2; i <= num/2; i++) {
//            if (isPrime(i) && isPrime(num - i) && (i != num - i)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public static boolean secondCondition(int num) {
//        while (num % M == 0) {
//            num /= M;
//        }
//        for (int i = 2; i <= Math.sqrt(num); i++) {
//            if (num % i == 0) {
//                if (isPrime(i) && isPrime(num / i)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    public static void main(String[] args) {
//        input();
//        int limit = 9;
//        while (K > 1) {
//            K--;
//            limit += 9 * Math.pow(10, K);
//        }
//        int num = 1;
//        int answer = 0;
//        while (num <= limit) {
//            if(firstCondition(num)){
//                if(secondCondition(num)) answer++;
//            }
//            num++;
//        }
//        System.out.println(answer);
//    }

    static int K, M;
    static int[] nums;
    static boolean[] visited, notSosu, sosuSum, sosuMult;
    static int answer;
    static int Max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        M = sc.nextInt();
        Max = (int) Math.pow(10, K);

        notSosu = new boolean[Max]; // true면 소수 아님 false면 소수임
        sosuSum = new boolean[Max]; // true면 서로 다른 소수 합임
        sosuMult = new boolean[Max]; // true면 소수 곱임

        nums = new int[K];
        visited = new boolean[10];
        answer = 0;
        eratos();
        makeSum();
        makeMult();

        perm(0, 0); // 순열
        System.out.println(answer);
    }

    // 에라토스테네스의 체
    private static void eratos() {
        notSosu[0] = true;
        notSosu[1] = true;
        for (int i = 2; i < Max; i++) {
            if (notSosu[i]) {
                continue;
            } else {
                for (int j = i + i; j < Max; j += i) {
                    notSosu[j] = true; // 배수를 제외
                }
            }
        }
    }

    // 서로 다른 두 소수 합
    private static void makeSum() {
        outer:
        for (int i = 2; i < Max; i++) {
            if (notSosu[i]) continue; // 소수가 아니면 i 다시 찾기

            for (int j = i + 1; j < Max; j++) { // 같으면 안되므로 +1 부터 시작
                if (notSosu[j]) continue; // 소수가 아니면 j 다시 찾기
                if (i + j >= Max) continue outer; // 합이 넘으면 찾는 이유 x
                sosuSum[i + j] = true; // 합을 저장
            }
        }
    }

    // 두 소수 곱
    private static void makeMult() {
        outer:
        for (int i = 2; i < Max; i++) {
            if (notSosu[i]) continue; // 소수가 아니면 i 다시 찾기

            for (int j = i; j < Max; j++) { // 같아도 되므로 i부터
                if (notSosu[j]) continue;  // 소수가 아니면 j 다시 찾기

                // 이부분 조심 .. long 타입으로 해야한다.
                // 예를 들어 K = 5 일 때 46349*46349=2148229801 => int이면 음수

                long num = (long) i * (long) j;
                if (num >= Max) continue outer;

                sosuMult[i * j] = true; // 곱 저장
            }
        }
    }

    // 순열
    private static void perm(int cnt, int num) {
        if (cnt == K) { // 숫자 다 모임
            // 기저조건
            if (sosuSum[num]) { // 조건 1
                while ((num % M) == 0) { // num을 M으로 나눌 수 있을 때까지 나누기
                    num /= M;
                }
                if (sosuMult[num]) { // 조건 2
                    answer++;
                }
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (cnt == K - 1 && i == 0) continue; // 수의 맨 앞에는 0이 올 수 없다.

            if (visited[i]) continue; // 중복이면 다시 고르기
            visited[i] = true; // 중복체크
            nums[cnt] = i;
            perm(cnt + 1, num + i * (int)Math.pow(10,cnt)); // 자릿수, 갖고있는 숫자
            visited[i] = false;
        }
    }
}
