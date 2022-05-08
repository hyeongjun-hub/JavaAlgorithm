package summer_coding;

import java.util.*;

public class Second {
    public String[] solution(String[] rooms, int target) {

        HashMap<String, ArrayList<Integer>> all = new HashMap<>();

        for (String roomStr : rooms) {
            String beforeNum = roomStr.replaceAll("[^0-9]", "");
            int roomNum = Integer.parseInt(beforeNum);
            String names = roomStr.replaceAll("[^,a-zA-Z]", "");

            StringTokenizer st = new StringTokenizer(names, ", ");
            while (st.hasMoreTokens()) {
                String person = st.nextToken();
                ArrayList<Integer> havingRooms = all.getOrDefault(person, new ArrayList<>());
                havingRooms.add(roomNum);
                all.put(person, havingRooms);
            }
        }

        ArrayList<Employee> answerList = new ArrayList<>();
        for (String key : all.keySet()) {
            int distanceMin = 9999;
            for (int where : all.get(key)) {
                if(where == target){
                    all.remove(where);
                }
                distanceMin = Math.min(distanceMin, Math.abs(where - target));
            }
            Employee employee = new Employee(key, all.get(key), distanceMin);
            answerList.add(employee);
        }

        Collections.sort(answerList);

        ArrayList<String> result = new ArrayList<>();

        for (Employee a : answerList) {
            if(a.distance!=0) result.add(a.name);
        }
        String[] answer = result.toArray(new String[result.size()]);
        return answer;
    }

    public static void main(String[] args) {
        Second second = new Second();
        String[] solution = second.solution(new String[]{"[403]James", "[404]Azad,Louis,Andy", "[101]Azad,Guard"}, 403);
//        String[] solution = second.solution(new String[]{"[1234]No,Body,In,Here", "[5678]Guard"}, 1234);
        System.out.println(Arrays.toString(solution));
    }
}

class Employee implements Comparable<Employee> {
    String name;
    ArrayList<Integer> have;
    int distance;

    public Employee(String name, ArrayList<Integer> have, int distance) {
        this.name = name;
        this.have = have;
        this.distance = distance;
    }

    @Override
    public int compareTo(Employee o) {
        if (o.have.size() != this.have.size()) {
            return this.have.size() - o.have.size();
        } else {
            if (o.distance != this.distance) {
                return this.distance - o.distance;
            } else {
                return this.name.compareTo(o.name);
            }
        }
    }
}
