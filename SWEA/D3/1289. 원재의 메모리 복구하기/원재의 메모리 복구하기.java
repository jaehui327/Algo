import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T;
		T = Integer.parseInt(in.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++) {
			char[] memory = in.readLine().toCharArray();
			int bit = '0';
			int answer = 0;
			
			for(int i = 0; i < memory.length; i++) {
				if(bit!=memory[i]) {
					bit = memory[i];
					answer += 1;
				}
			}
			sb.append("#"+test_case+" "+answer+"\n");
		}
		System.out.println(sb);
	}
    
}
