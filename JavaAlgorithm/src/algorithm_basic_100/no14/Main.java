package algorithm_basic_100.no14;

public class Main {
    public static void main(String[] args) {
        int n = 123523452;
        String nString = n + "";
        char[] nCharArray = nString.toCharArray();
        int[] numArray = new int[10];

//        for(char nChar : nCharArray){
//            int nInt = nChar - '0';
//            numArray[nInt]++;
//        }

        while(n > 0){
            numArray[n % 10]++;
            n /= 10;
        }

        for(int i=0; i<numArray.length; i++){
            System.out.println(i + ": " + numArray[i]);
        }


    }
}
