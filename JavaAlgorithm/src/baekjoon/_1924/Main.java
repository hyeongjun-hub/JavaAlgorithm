package baekjoon._1924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

enum Day {
    MON, TUE, WED, THU, FRI, SAT, SUN
}

public class Main {

    static int month;
    static int day;

    public static void input() {
        FastReader fr = new FastReader();
        //전의 모든 달의 날짜 수를 세기 위해 바로 전 달의 숫자를 받음
        month = fr.nextInt() - 1;
        day = fr.nextInt();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while(st == null || !st.hasMoreTokens()){
                try{
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }

        Double nextDouble(){
            return Double.parseDouble(next());
        }

        String nextLine(){
            String str = "";
            try{
                str = br.readLine();
            } catch(IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }

    static int makeAllDay(int allDay){
        for(int i=1; i<=month; i++){
            switch (i) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                    allDay += 31;
                    break;
                case 2:
                    allDay += 28;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    allDay += 30;
                    break;
                default:
                    break;
            }
        }
        allDay += day;
        return allDay;
    }

    static void makeResult(int allDay){
        int figureOut = allDay % 7;
        switch (figureOut) {
            case 1:
                System.out.println(Day.MON);
                break;
            case 2:
                System.out.println(Day.TUE);
                break;
            case 3:
                System.out.println(Day.WED);
                break;
            case 4:
                System.out.println(Day.THU);
                break;
            case 5:
                System.out.println(Day.FRI);
                break;
            case 6:
                System.out.println(Day.SAT);
                break;
            default:
                System.out.println(Day.SUN);
                break;
        }
    }

    public static void main(String[] args) {
        input();
        int allDay = 0;
        allDay = makeAllDay(allDay);
        makeResult(allDay);
    }
}
