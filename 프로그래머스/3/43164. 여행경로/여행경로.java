import java.util.*;

class Solution {
    
    static boolean[] visited; // 방문 체크
    static ArrayList<String> answer; // 여행 경로
    
    public String[] solution(String[][] tickets) {
        return travel(getMap(tickets));
    }
    
    public HashMap<String, ArrayList<String>> getMap(String[][] tickets) {
        // key: 출발지 (String), value: 도착지 (ArrayList<String>)
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (int i = 0; i < tickets.length; i++) {
            if (map.containsKey(tickets[i][0])) {
                map.get(tickets[i][0]).add(tickets[i][1]);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(tickets[i][1]);
                map.put(tickets[i][0], list);
            }
        }
        // 알파벳 순서 정렬
        for (Map.Entry<String, ArrayList<String>> entry: map.entrySet()) 
            Collections.sort(entry.getValue());
        return map;
    }
    
    public String[] travel(HashMap<String, ArrayList<String>> map) {
        Stack<String> stack = new Stack<>();
        stack.push("ICN"); // 항상 ICN에서 시작
        ArrayList<String> route = new ArrayList<>(); // 여행 경로
        
        while(!stack.isEmpty()) {
            String cur = stack.peek();
            if (!map.containsKey(cur) || map.get(cur).isEmpty()) { // 티켓 다 소진한 경우
                route.add(stack.pop()); // 경로 저장
            } else {
                stack.push(map.get(cur).remove(0)); // 알파벳 순서가 앞서는 티켓 먼저 소진
            }
        }
        
        Collections.reverse(route); // 역순 정렬
        return route.toArray(new String[route.size()]);
    }
}