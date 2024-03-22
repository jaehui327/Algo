import java.util.*;

class Solution {
    
    static String[] words = { "A", "E", "I", "O", "U"};
    static ArrayList<String> list;
    
    public int solution(String word) {
        list = new ArrayList<>();
        for (int k = 1; k <= 5; k++) {
            generate(0, k, new String[k]);
        }
        Collections.sort(list);
        return list.indexOf(word) + 1;
    }
    
    public void generate(int idx, int k, String[] s) {
        if (idx == k) {
            list.add(String.join("", s));
            return;
        }
        
        for (int i = 0; i < 5; i++) {
            s[idx] = words[i];
            generate(idx + 1, k, s);
        }
    }
}