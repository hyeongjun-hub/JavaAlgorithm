package programmers_kakao.주차요금계산;

import java.util.*;

class Solution {

    HashMap<String, Queue<Integer>> map = new HashMap<>();

    public int[] solution(int[] fees, String[] records) {
        // 맵에 queue 넣기
        for (String record : records) {
            String[] split = record.split(" ");
            int time = Integer.parseInt(split[0].substring(0, 2)) * 60 + Integer.parseInt(split[0].substring(3, 5));

            if (!map.containsKey(split[1])) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(time);
                map.put(split[1], queue);
            } else {
                Queue<Integer> queue = map.get(split[1]);
                queue.add(time);
                map.replace(split[1], queue);
            }
        }

        int[] answer = new int[map.size()];
        double baseTime = fees[0];
        double baseFee = fees[1];
        double rateMin = fees[2];
        double rateFee = fees[3];

        // queue 시간 계산
        for (Map.Entry<String, Queue<Integer>> stringQueueEntry : map.entrySet()) {
            Queue<Integer> queue = stringQueueEntry.getValue();
            int time = 0;
            double finalFee = 0;
            while (queue.size() >= 2) {
                int in = queue.poll();
                int out = queue.poll();
                time += out - in;
            }
            if (queue.size() == 1) {
                int in = queue.poll();
                int out = 60 * 23 + 59;
                time += out - in;
            }

            // 주차비 계산
            if (time <= baseTime) {
                finalFee = baseFee;
            } else {
                finalFee = baseFee + Math.ceil((time - baseTime) / rateMin) * rateFee;
            }
            queue.add((int)finalFee);
            map.replace(stringQueueEntry.getKey(), queue);
        }

        List<String> keyList = new ArrayList<>(map.keySet());
        keyList.sort(String::compareTo);
        int i=0;
        for (String key : keyList) {
            answer[i] = map.get(key).poll();
            i++;
        }

        return answer;
    }

}