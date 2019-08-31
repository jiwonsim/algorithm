import java.util.*;

class Record {
    String act, id;

    Record(String act, String id) {
        this.act = act;
        this.id = id;
    }
}

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};

        List<Record> list = new ArrayList<>();
        HashMap<String, String> name = new HashMap<>();

        for (int i = 0; i < record.length;  i++) {
            String[] cmd = record[i].split(" ");

            if (!cmd[0].equals("Change")) list.add(new Record(cmd[0], cmd[1]));
            if (!cmd[0].equals("Leave")) name.put(cmd[1], cmd[2]);
        }

        answer = new String[list.size()];

        int idx = 0;
        for (Record ele : list) {
            String cmd = ele.act.equals("Enter") ? "들어왔습니다." : "나갔습니다.";
            answer[idx++] = name.get(ele.id) + "님이 " + cmd;
        }

        return answer;
    }
}