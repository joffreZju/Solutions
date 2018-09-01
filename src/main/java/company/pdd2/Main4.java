package company.pdd2;

import java.util.*;

public class Main4 {
    private static String ans = null;

    public static Boolean search(int i, ArrayList<Character>[] posChars, StringBuilder sb, HashSet<String> exist) {
        if (sb.length() == posChars.length) {
            if (exist.contains(sb.toString())) {
                return false;
            }
            ans = sb.toString();
            return true;
        }
        if (i >= posChars.length) return false;

        for (int j = 0; j < posChars[i].size(); j++) {
            sb.append(posChars[i].get(j));
            if (search(i + 1, posChars, sb, exist)) {
                return true;
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        return false;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int L = in.nextInt();
        in.nextLine();

        HashSet<String> exist = new HashSet<>();
        ArrayList<Character>[] posChars = new ArrayList[L];
        for (int i = 0; i < L; ++i) {
            posChars[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; ++i) {
            String w = in.nextLine();
            for (int j = 0; j < L; j++) {
                if (!posChars[j].contains(w.charAt(j))) posChars[j].add(w.charAt(j));
            }
            exist.add(w);
        }
        for (int i = 0; i < L; ++i) {
            Collections.sort(posChars[i]);
        }

        if (search(0, posChars, new StringBuilder(), exist)) {
            System.out.println(ans);
        } else {
            System.out.print("-");
        }
    }
}
