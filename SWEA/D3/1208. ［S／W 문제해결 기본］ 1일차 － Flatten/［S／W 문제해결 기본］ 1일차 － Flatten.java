import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer box = new StringTokenizer(br.readLine(), " ");
			int[] boxes = new int[100];
			for(int i = 0; i < 100; i++) {
				boxes[i] = Integer.parseInt(box.nextToken());
			}
			Arrays.sort(boxes);
			
			
			for(int i = 0; i < N; i++) {
				boxes[0] += 1;
				boxes[99] -= 1;
				if(boxes[0] == boxes[99] || boxes[0] == boxes[99] + 1) break;
				Arrays.sort(boxes);
			}
			
			// print
			sb.append("#");
			sb.append(t);
			sb.append(" ");
			sb.append(boxes[99]-boxes[0]);
			sb.append("\n");
			
		}
		
		br.close();
		System.out.println(sb);
	}
}