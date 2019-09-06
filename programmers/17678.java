import java.util.*;

class Bus {
    String time;
    List<Bus> customers;

    Bus(String time) {
        this.time = time;
    }
}

class Solution {
    List<Bus> busList = new LinkedList<>();

    void initBusList(int n, int t) {
        int min = 0, hour = 9;
        String minStr = "", hourStr = "";
        for (int i = 0; i < n; i++) {
            min += i * t;
            if (min >= 60) {
                hour = 9 + min / 60;
                min = min % 60;
            }

            if (min < 10) minStr = "0" + String.valueOf(min);
            else minStr = String.valueOf(min);

            if (hour < 10) hourStr = "0" + String.valueOf(hour);
            else hourStr = String.valueOf(hour);

            busList.add(new Bus(hourStr + ":" + minStr));
        }
    }

    void addCustomer(String[] timetable, int n, int m) {
        boolean[] check = new boolean[timetable.length];

        int curBus = 0;
        while (curBus < n) {
            int cnt = 0;
            for (int i = 0; i < timetable.length; i++) {
                if (timetable[i].compareTo(busList.get(curBus).time) > 0) {
                    continue;
                }
                if (check[i]) continue;
                if (cnt >= m) break;
                check[i] = true;
                Bus b = busList.get(curBus);

                if (b.customers == null) {
                    List<Bus> list = new LinkedList<>();
                    list.add(new Bus(timetable[i]));
                    b.customers = list;
                }
                else {
                    b.customers.add(new Bus(timetable[i]));
                }
                cnt++;
            }
            curBus++;
        }

    }

    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";

        Arrays.sort(timetable);

        initBusList(n, t);
        if (busList.get(busList.size() - 1).time.compareTo(timetable[0]) < 0) {
            // 버스 오는 시간보다 사람들이 더 늦게 올 때
            return busList.get(busList.size() - 1).time;
        }

        addCustomer(timetable, n, m);

        List<Bus> consTime = new LinkedList<>();

        for (Bus bus : busList) {
            if (bus.customers == null) { // 받을 손님 없지만 버스가 올 때
                consTime.add(new Bus(bus.time));
                continue;
            }
            int cusLen = bus.customers.size() - 1;
            if (cusLen + 1 == m) { // isFull
                String lastTime = bus.customers.get(cusLen).time;
                String minTmp = lastTime.substring(3, 5);
                String hourTmp = lastTime.substring(0, 2);

                if (minTmp.equals("00")) {
                    minTmp = "59";
                    hourTmp = String.valueOf(Integer.parseInt(hourTmp) - 1);
                    if (hourTmp.length() < 2) hourTmp = "0" + hourTmp;
                }
                else {
                    minTmp = String.valueOf(Integer.parseInt(minTmp) - 1);
                    if (minTmp.length() < 2) minTmp = "0" + minTmp;
                }
                consTime.add(new Bus(hourTmp + ":" + minTmp));
            }
            else { // !isFull
                consTime.add(new Bus(bus.time));
            }
        }

        answer = ((LinkedList<Bus>) consTime).getLast().time;

        return answer;
    }
}