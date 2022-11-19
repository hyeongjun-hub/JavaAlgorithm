package programmers_skill_check_test.lv1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution {
    /*
     public int Solution(int[] d, int budget) {
        int answer = 0;
        int sum = 0;
        Arrays.sort(d);
        for(int i=0; i<d.length; i++) {
            if(sum + d[i] <= budget){
                sum += d[i];
                answer++;
            } else {
                break;
            }
        }

        return answer;
    }
     */

//    static class Profile {
//        int index;
//        String name;
//        int ans = 0;
//    }
//
//    public int[] Solution(String[] id_list, String[] report, int k) {
//        int[] answer = {};
//        HashMap<String, HashSet<String>> reported = new HashMap<>();
//        HashMap<String, Integer> ans = new HashMap<>();
//
//
//        for(int i=0; i< id_list.length; i++){
//            reported.put(id_list[i], new HashSet<>());
//            ans.put(id_list[i], 0);
//        }
//
//        for (String content : report) {
//            String owner = content.split("\\s+")[0];
//            String reportName = content.split("\\s+ ")[1];
//            HashSet<String> nowReport = reported.getOrDefault(owner, new HashSet<>());
//            nowReport.add(reportName);
//            reported.put(owner, nowReport);
//        }
//
//        for (Map.Entry<String, HashSet<String>> stringHashSetEntry : reported.entrySet()) {
//            if(stringHashSetEntry.getValue().size() >= 2){
//                for (String s : stringHashSetEntry.getValue()) {
//                    ans.put()
//                }
//            }
//        }
//
//        return answer;
//    }
}
