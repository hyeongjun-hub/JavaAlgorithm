package summer_coding;

public class First {
    public int solution(int[][] atmos) {
        int answer = 0;
        int useDay = 0;
        for (int[] day : atmos) {
            if (useDay == 2) {
                useDay = 0;
            } else if (useDay == 1) {
                if (day[0] >= 151 && day[1] >= 76) {
                    useDay = 0;
                }
                else {
                    useDay++;
                }
            } else { // 마스크를 안쓰고있을 때
                if (day[0] >= 151 && day[1] >= 76) {
                    useDay = 0;
                    answer++;
                } else if (day[0] >= 81 || day[1] >= 36) {
                    useDay++;
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        First first = new First();
        int solution = first.solution(new int[][]{{80, 35}, {70, 38}, {100, 41}, {75, 30}, {160, 80}, {77, 29}, {181, 68}, {151, 76}});
        System.out.println("solution = " + solution);
    }
}
