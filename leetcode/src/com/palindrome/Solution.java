public class Solution {
    static int EVEN = 1;
    static int ODD = 2;

    public  String longestPalindrome(String s) {
        int size = s.length();
        int max = size - 2;
        String longestPalindrome = "";
        
        if(size == 1) {
            return s;
        } else if(size == 2) {
            if(s.charAt(0) == s.charAt(1)){
                return s;
            } else {
                return "";
            }
        }
        
        for(int i = 0; i < max; i++){
            String tmp = new String();
            if(s.charAt(i) == s.charAt(i+1)){
                tmp = getPalindrome(s, i, EVEN);
            }
            
            if (s.charAt(i+1) == s.charAt(i+2)) {
                String tmp1 = getPalindrome(s, i+1, EVEN);
                if(tmp1.length() > tmp.length()) {
                    tmp = tmp1;
                }
            }

            if (s.charAt(i) == s.charAt(i+2)) {
                String tmp1 = getPalindrome(s, i+1, ODD);
                if(tmp1.length() > tmp.length()) {
                    tmp = tmp1;
                }
            }

            if (tmp.length() > longestPalindrome.length()){
                longestPalindrome = new String(tmp);
            }
        }
        
        return longestPalindrome;
    }
    
    public  String getPalindrome(String s, int center, int type) {
        int c1, c2;
        int size = s.length();
        
        if(type == EVEN) {
            c1 = center;
            c2 = center + 1;
        } else {
            c1 = center - 1;
            c2 = center + 1;
        }
        
        while(c1 >= 0 && c2 < size && s.charAt(c1) == s.charAt(c2)) {
            c1--;
            c2++;
        }
        
        String sub = new String(s.substring(++c1, c2));
        
        return sub;
    }
}