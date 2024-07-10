/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.io.*;
import java.util.*;

public class Main {
    
    static Stack<Character> stack;
	static char[] ppap = { 'P', 'P', 'A', 'P' };
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		stack = new Stack<Character>();
		
		for (int i = 0; i < s.length(); i++) {
		    stack.push(s.charAt(i));
		    if (stack.size() < 4) continue;
		    if (!isPPAP()) continue;
		    setPPAP();
		}
		
		if (stack.size() == 1 && stack.pop() == 'P') System.out.println("PPAP");
		else System.out.println("NP");
		br.close();
	}
	
	public static boolean isPPAP() {
	    int stackIdx = stack.size() - 4;
	    int ppapIdx = 0;
	    for (int i = 0; i < 4; i++) {
	        if (stack.get(stackIdx) != ppap[ppapIdx]) return false;
	        stackIdx++; ppapIdx++;
	    }
	    return true;
	}
	
	public static void setPPAP() {
	    for (int i = 0; i < 4; i++) stack.pop();
	    stack.push('P');
	}
}