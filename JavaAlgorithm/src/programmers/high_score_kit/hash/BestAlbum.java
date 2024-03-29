package programmers.high_score_kit.hash;

import java.util.*;

/*
문제 설명
스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.

속한 노래가 많이 재생된 장르를 먼저 수록합니다.
장르 내에서 많이 재생된 노래를 먼저 수록합니다.
장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 Solution 함수를 완성하세요.

제한사항
genres[i]는 고유번호가 i인 노래의 장르입니다.
plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
장르 종류는 100개 미만입니다.
장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
모든 장르는 재생된 횟수가 다릅니다.
 */
public class BestAlbum {
    class Album implements Comparable<Album> {
        int index;
        String genre;
        int play;

        public Album(int index, String genre, int play) {
            this.index = index;
            this.genre = genre;
            this.play = play;
        }

        @Override
        public int compareTo(Album o) {
            if (o.play == this.play) {
                return this.index - o.index;
            } else {
                return o.play - this.play;
            }
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        // 전체를 담은 list 생성
        List<Album> allList = new ArrayList<>();
        for (int i = 0; i < genres.length; i++) {
            allList.add(new Album(i, genres[i], plays[i]));
        }

        // hashmap 에 장르별 저장
        HashMap<String, Integer> unsortedGenreList = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            unsortedGenreList.put(genres[i], unsortedGenreList.getOrDefault(genres[i], 0) + plays[i]);
        }

        // 높은 순으로 entry set(key, value) 가져와 (장르) 새로운 Map 생성
        LinkedHashMap<String, Integer> sortedGenreList = new LinkedHashMap<>();
        unsortedGenreList.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> sortedGenreList.put(x.getKey(), x.getValue()));

        ArrayList<Album> result = new ArrayList<>();
        for(String genre : sortedGenreList.keySet()){
            // 장르마다 리스트를 생성
            ArrayList<Album> list = new ArrayList<>();
            for(int i=0; i<genres.length; i++){
                if(genres[i].equals(genre)){
                    list.add(new Album(i, genre, plays[i]));
                }
            }
            // 정의한 comparable로 리스트 재정렬
            Collections.sort(list);
            result.add(list.get(0)); // 1개는 무조건 수록
            if(list.size()!=1){ // 더 수록할 곡이 있으면 수록 (총 두개)
                result.add(list.get(1));
            }
        }

        // print result
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i).index;
        }
        return answer;
    }

    public static void main(String[] args) {
        BestAlbum bestAlbum = new BestAlbum();
        int[] solution = bestAlbum.solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
        for (int i = 0; i < solution.length; i++) {
            System.out.println("Solution = " + solution[i]);
        }
    }
}
