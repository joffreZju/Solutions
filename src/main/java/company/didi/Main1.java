package company.didi;

import java.util.*;

public class Main1 {
    public static int editDistance(char[] word1, char[] word2) {
        int len1 = word1.length, len2 = word2.length;
        int dp[][] = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i * 3;
        }
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = i * 3;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1[i - 1] == word2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    boolean flag = isOneGroup(word1[i - 1], word2[j - 1]);
                    dp[i][j] = Math.min((flag ? 1 : 2) + dp[i - 1][j - 1],
                            3 + Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[len1][len2];
    }
    
    private static boolean isOneGroup(char i, char j) {
        return (g1.contains(i) && g1.contains(j)) || (g2.contains(i) && g2.contains(j));
    }
    
    private static class Word {
        int dis;
        int index;
        String content;
        
        public Word(int dis, int index, String content) {
            this.dis = dis;
            this.index = index;
            this.content = content;
        }
    }
    
    private static Set<Character> g1 = new HashSet<>(), g2 = new HashSet<>();
    
    public static void main(String[] args) {
        String s1 = "qwertasdfgzxcv", s2 = "yuiophjklbnm";
        for (char c : s1.toCharArray()) g1.add(c);
        for (char c : s2.toCharArray()) g2.add(c);
        
        List<Word> words = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        char[] origin = in.next().toLowerCase().toCharArray();
        while (in.hasNext()) {
            String cur = in.next();
            int dis = editDistance(origin, cur.toLowerCase().toCharArray());
            words.add(new Word(dis, words.size(), cur));
        }
        
        words.sort((a, b) -> a.dis != b.dis ? a.dis - b.dis : a.index - b.index);
        for (int i = 0; i < Math.min(3, words.size()); i++) {
            if (i != 0) System.out.print(" ");
            System.out.print(words.get(i).content);
        }
    }
}
