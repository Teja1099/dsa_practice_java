package Leetcode;

//1061. Lexicographically Smallest Equivalent String
public class LexicographicallySmallestEquivalentString {
    int parser[] = new int[26];
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        for(int i = 0;  i < 26; i++) {
            parser[i] = i;
        }
        for(int i = 0; i < s1.length(); i++ ) {
            union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < baseStr.length(); i++ ) {
            int key = baseStr.charAt(i) - 'a';
            int c  = find(key);
            sb.append((char)(c+'a'));
        }
        return sb.toString();
    }
    public  int find(int x) {
        if(parser[x] != x) {
            parser[x] = find(parser[x]);
        }
        return parser[x];
    }

    public  void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if(px == py) return;
        if(px > py) {
            parser[px] = py;
        }
        else {
            parser[py] = px;
        }
    }
}
