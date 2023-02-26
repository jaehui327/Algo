import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	static class Horse {
		int x;
		int y;
		boolean done;

		Horse(int x, int y, boolean done) {
			this.x = x;
			this.y = y;
			this.done = done;
		}
	}

	static int max;
	static int[] selected, dices;
	static boolean[] done;
	static Horse[] horses;
	static int[][] map = { 
			{ 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40 }, 
			{ 10, 13, 16, 19, 25, 30, 35, 40 }, 
			{ 20, 22, 24, 25, 30, 35, 40 },
			{ 30, 28, 27, 26, 25, 30, 35, 40 }
			};
	
	private static void permutation(int idx) {
		if (idx == 10) {
			game();
			return;
		}
		for (int i = 0; i < 4; i++) {
			selected[idx] = i;
			permutation(idx + 1);
		}
	}

	private static void game() {
		int score = 0;
		for (int i = 0; i < 4; i++) {
			horses[i] = new Horse(0, 0, false);
		}
		
		for (int i = 0; i < 10; i++) {
			if (score + 40 * (10 - i) <= max) return;
			if (horses[selected[i]].done) 
				return;
			Horse horse = nextPosition(horses[selected[i]], dices[i]);
			if (!isMovable(horse, selected[i])) 
				return;
			
			horses[selected[i]].x = horse.x;
			horses[selected[i]].y = horse.y;
			if (!horses[selected[i]].done) score += map[horses[selected[i]].y][horses[selected[i]].x];
		}
		max = Math.max(max, score);
	}

	private static Horse nextPosition(Horse h, int dice) {
		if (h.y == 0 && h.x + dice < map[h.y].length && map[h.y][h.x + dice] % 10 == 0 && map[h.y][h.x + dice] <= 30) return new Horse(0, map[h.y][h.x + dice] / 10, h.done);
		return new Horse(h.x + dice, h.y, h.done);
	}

	private static boolean isMovable(Horse horse, int idx) {
		if (horse.x >= map[horse.y].length) {
			horses[idx].done = true;
			return true;
		}
		for (int i = 0; i < 4; i++) {
			if (horses[i].done || (horses[i].x == 0 && horses[i].y == 0)) continue;
			if (horse.x == horses[i].x && horse.y == horses[i].y) return false;
			if (map[horses[i].y][horses[i].x] == map[horse.y][horse.x]) {
				if (map[horse.y][horse.x] == 25 || map[horse.y][horse.x] == 35 || map[horse.y][horse.x] == 40) return false;
				if (map[horse.y][horse.x] == 30 && horse.x != 0 && horses[i].x != 0) return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		selected = new int[10];
		dices = new int[10];
		horses = new Horse[4];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 10; i++) {
			dices[i] = Integer.parseInt(st.nextToken());
		}

		permutation(0);

		System.out.println(max);
		br.close();
	}

}
