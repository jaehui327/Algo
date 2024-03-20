import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        ArrayList<Reservation> reservation = new ArrayList<>();
        for (int i = 0; i < book_time.length; i++) {
            int start = Integer.parseInt(book_time[i][0].replace(":", ""));
            int end = Integer.parseInt(book_time[i][1].replace(":", ""));
            int endHour = end / 100;
            end = end - endHour * 100 + 10 > 59 ? end + 10 - 60 + 100 : end + 10;
            reservation.add(new Reservation(start, end));
        }
        Collections.sort(reservation);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < reservation.size(); i++) {
            if (!pq.isEmpty() && pq.peek() <= reservation.get(i).start) pq.poll();
            pq.offer(reservation.get(i).end);
        }
        
        
        return pq.size();
    }
    
    static class Reservation implements Comparable<Reservation> {
        int start;
        int end;
        
        public Reservation(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        public int compareTo(Reservation o) {
            return this.start - o.start;
        }
    }
}