import java.util.*;

class Solution {
    
    static class Point {
        int x;
        int y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static List<Integer> days;
    static boolean[][] visited;
    static int[] dx = { 1, 0, -1, 0 }, dy = { 0, 1, 0, -1 };
    
    public void bfs(char[][] map, int x, int y) {
        visited[y][x] = true;
        int cnt = map[y][x] - '0';
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        
        while(!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                
                if (nx < 0 || nx >= map[0].length || ny < 0 || ny >= map.length) continue;
                if (map[ny][nx] == 'X' || visited[ny][nx]) continue;
                cnt += map[ny][nx] - '0';
                visited[ny][nx] = true;
                queue.offer(new Point(nx, ny));
            }
        }
        days.add(cnt);
    }
    
    public int[] solution(String[] maps) {
        char[][] map = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        days = new ArrayList<>();
        
        for (int i = 0; i < maps.length; i++) {
            map[i] = maps[i].toCharArray();
        }
        
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 'X' || visited[i][j]) continue;
                bfs(map, j, i);
            }
        }
        
        if (days.isEmpty()) return new int[] {-1};
        Collections.sort(days);
        return days.stream().mapToInt(i -> i).toArray();
    }
}