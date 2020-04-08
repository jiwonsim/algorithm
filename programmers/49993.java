import java.util.*;

class Solution {

    boolean enableSkillTree(String skill, String skillTree) {
        // skill 명과 순서를 저장할 사전 dic
        HashMap<Character, Integer> dic = new HashMap<>();
        for (int i = 0; i < skill.length(); i++) {
            dic.put(skill.charAt(i), i);
        }

        // 이전 skill을 배웠는지 검사하기 위한 boolean 배열
        boolean[] visited = new boolean[skill.length()];

        for (int i = 0; i < skillTree.length(); i++) {
            char cur = skillTree.charAt(i);
            // skill이 아니면 패스
            if (!dic.containsKey(cur)) continue;
            // skill에 포함되면 순서에 맞게 배웠는지 체크
            int order = dic.get(cur);
            for (int j = 0; j < order; j++) {
                if (!visited[j]) return false;
            }
            // 맞게 배웠으면 visited[] 체크
            visited[order] = true;
        }

        return true;
    }

    public int solution(String skill, String[] skillTrees) {
        int answer = 0;

        for (int i = 0; i < skillTrees.length; i++) {
            if (enableSkillTree(skill, skillTrees[i])) answer++;
        }

        return answer;
    }
}