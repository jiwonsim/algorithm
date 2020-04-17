import java.util.*;

class Music implements Comparable<Music> {
    int index;
    int plays;

    Music(int index, int plays) {
        this.index = index;
        this.plays = plays;
    }

    @Override
    public int compareTo(Music target) {
        if (target.plays == this.plays) return this.index - target.index;
        return target.plays - this.plays;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {

        // 누적 재생 수를 저장하는 맵
        HashMap<String, Integer> playingGenre = new HashMap<>();
        // 장르별 노래를 저장하는 맵
        HashMap<String, ArrayList<Music>> albums = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];

            // 누적 재생 수 저장
            if (playingGenre.get(genre) == null) {
                playingGenre.put(genre, plays[i]);
            }
            else {
                playingGenre.put(genre, playingGenre.get(genre) + plays[i]);
            }

            // 장르별 노래를 저장
            ArrayList<Music> musicList;
            if (albums.get(genre) == null) {
                musicList = new ArrayList<Music>();
            }
            else {
                musicList = albums.get(genre);
            }

            musicList.add(new Music(i, plays[i]));
            Collections.sort(musicList); // 재생 수 별로 정렬하고 저장

            albums.put(genre, musicList);
        }

        // 누적 재생 수대로 장르 정렬
        List<String> genreList = sortingPlayingGenre(playingGenre);

        return makeAlbum(genreList, albums);
    }

    int[] makeAlbum(List<String> genreList, HashMap<String, ArrayList<Music>> albums) {
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        for (String genre : genreList) {
            ArrayList<Music> musicList = albums.get(genre);
            int count = 0;
            for (Music music : musicList) {
                // 장르별 두 곡만 담도록 제한
                if (count >= 2) break;
                resultList.add(music.index);
                count++;
            }
        }

        return convertList2Array(resultList);
    }

    int[] convertList2Array(ArrayList<Integer> list) {
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    List<String> sortingPlayingGenre(HashMap<String, Integer> map) {
        List<String> keySetList = new ArrayList<>(map.keySet());
        Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1)))); // 내림차순 정렬
        return keySetList;
    }
}