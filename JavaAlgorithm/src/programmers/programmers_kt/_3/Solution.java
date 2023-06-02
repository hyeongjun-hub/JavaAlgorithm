package programmers.programmers_kt._3;

import java.util.ArrayList;

class Solution {

    static class Service{
        int index;
        int data;
        ArrayList<Integer> service;
    }

    public int[] solution(int n, String[] plans, String[] clients) {
        int[] answer = new int[clients.length];
        Service[] services = new Service[plans.length];
        ArrayList<Integer> allService = new ArrayList<>();
        for (int i = 0; i < plans.length; i++) {
            services[i] = new Service();
            String[] split = plans[i].split("\\s+");
            services[i].index = i+1;
            services[i].data = Integer.parseInt(split[0]);
            ArrayList<Integer> newService = new ArrayList<>(allService);
            for(int j=1; j<split.length; j++){
                newService.add(Integer.parseInt(split[j]));
                allService.add(Integer.parseInt(split[j]));
            }
            services[i].service = newService;
        }

        for (int j=0; j< clients.length; j++) {
            String[] split = clients[j].split("\\s+");
            int data = Integer.parseInt(split[0]);
            for (Service service : services) {
                if (data <= service.data) {
                    boolean check = true;
                    for(int i=1; i< split.length; i++){
                        if (!service.service.contains(Integer.parseInt(split[i]))) {
                            check = false;
                            break;
                        }
                    }
                    if(check){
                        answer[j] = service.index;
                        break;
                    }
                }
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(5, new String[]{"100 1 3", "500 4", "2000 5"}, new String[]{"300 3 5", "1500 1", "100 1 3", "50 1 2"});
    }
}
