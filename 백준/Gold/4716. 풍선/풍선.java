import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Team implements Comparable<Team> {
		int balloons;
		int a;
		int b;
		
		Team(int balloons, int a, int b) {
			this.balloons = balloons;
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Team o) {
			return Math.abs(o.a - o.b) - Math.abs(this.a - this.b);
		}
	}

	static int N, A, B;
	static PriorityQueue<Team> teams;
	
	private static int solution() {
		int distance = 0;
		
		while(!teams.isEmpty()) {
			Team team = teams.poll();
			if (team.a < team.b) {
				if (A >= team.balloons) {
					distance += team.balloons * team.a;
					A -= team.balloons;
				} else {
					int rest = team.balloons - A;
					distance += A * team.a + rest * team.b;
					A = 0;
					B -= rest;
				}
			} else {
				if (B >= team.balloons) {
					distance += team.balloons * team.b;
					B -= team.balloons;
				} else {
					int rest = team.balloons - B;
					distance += B * team.b + rest * team.a;
					B = 0;
					A -= rest;
				}
			}
		}
		
		return distance;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			if (N + A + B == 0) break;
			
			teams = new PriorityQueue<Team>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int balloons = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				teams.offer(new Team(balloons, a, b));
			}
			
			sb.append(solution()).append("\n");
		}

		System.out.println(sb.toString());
		br.close();
	}

}
