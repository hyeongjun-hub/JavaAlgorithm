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

        notSosu = new boolean[Max]; // true??? ?????? ?????? false??? ?????????
        sosuSum = new boolean[Max]; // true??? ?????? ?????? ?????? ??????
        sosuMult = new boolean[Max]; // true??? ?????? ??????

        nums = new int[K];
        visited = new boolean[10];
        answer = 0;
        eratos();
        makeSum();
        makeMult();

        perm(0, 0); // ??????
        System.out.println(answer);
    }

    // ???????????????????????? ???
    private static void eratos() {
        notSosu[0] = true;
        notSosu[1] = true;
        for (int i = 2; i < Max; i++) {
            if (notSosu[i]) {
                continue;
            } else {
                for (int j = i + i; j < Max; j += i) {
                    notSosu[j] = true; // ????????? ??????
                }
            }
        }
    }

    // ?????? ?????? ??? ?????? ???
    private static void makeSum() {
        outer:
        for (int i = 2; i < Max; i++) {
            if (notSosu[i]) continue; // ????????? ????????? i ?????? ??????

            for (int j = i + 1; j < Max; j++) { // ????????? ???????????? +1 ?????? ??????
                if (notSosu[j]) continue; // ????????? ????????? j ?????? ??????
                if (i + j >= Max) continue outer; // ?????? ????????? ?????? ?????? x
                sosuSum[i + j] = true; // ?????? ??????
            }
        }
    }

    // ??? ?????? ???
    private static void makeMult() {
        outer:
        for (int i = 2; i < Max; i++) {
            if (notSosu[i]) continue; // ????????? ????????? i ?????? ??????

            for (int j = i; j < Max; j++) { // ????????? ????????? i??????
                if (notSosu[j]) continue;  // ????????? ????????? j ?????? ??????

                // ????????? ?????? .. long ???????????? ????????????.
                // ?????? ?????? K = 5 ??? ??? 46349*46349=2148229801 => int?????? ??????

                long num = (long) i * (long) j;
                if (num >= Max) continue outer;

                sosuMult[i * j] = true; // ??? ??????
            }
        }
    }

    // ??????
    private static void perm(int cnt, int num) {
        if (cnt == K) { // ?????? ??? ??????
            // ????????????
            if (sosuSum[num]) { // ?????? 1
                while ((num % M) == 0) { // num??? M?????? ?????? ??? ?????? ????????? ?????????
                    num /= M;
                }
                if (sosuMult[num]) { // ?????? 2
                    answer++;
                }
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (cnt == K - 1 && i == 0) continue; // ?????? ??? ????????? 0??? ??? ??? ??????.

            if (visited[i]) continue; // ???????????? ?????? ?????????
            visited[i] = true; // ????????????
            nums[cnt] = i;
            perm(cnt + 1, num + i * (int)Math.pow(10,cnt)); // ?????????, ???????????? ??????
            visited[i] = false;
        }
    }
}
