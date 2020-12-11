//
//Given a non-empty string s, you may delete at most one character. Judge whethe
//r you can make it a palindrome.
// 
//
// Example 1: 
// 
//Input: "aba"
//Output: True
// 
// 
//
// Example 2: 
// 
//Input: "abca"
//Output: True
//Explanation: You could delete the character 'c'.
// 
// 
//
// Note: 
// 
// The string will only contain lowercase characters a-z.
//The maximum length of the string is 50000. 
// 
// Related Topics 字符串 
// 👍 293 👎 0

package leetcode.editor.cn;
//Java：Valid Palindrome II
public class P680ValidPalindromeIi{
    public static void main(String[] args) {
        Solution solution = new P680ValidPalindromeIi().new Solution();
        String a = "cbbcc";
        System.out.println(solution.validPalindrome(a));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validPalindrome(String s) {
            int i = 0;
            int j = s.length() - 1;
            int chanceLast = 1;
            while (i < j) {
                if (s.charAt(i) == s.charAt(j)) {
                    i ++;
                    j --;
                } else {
                    int a = i;
                    int b = j - 1;
                    chanceLast --;
                    if (chanceLast < 0) {
                        return false;
                    }
                    int chanceInner = chanceLast;
                    while (a < b) {
                        if (s.charAt(a) == s.charAt(b)) {
                            a ++;
                            b --;
                        } else {
                            chanceInner --;
                            break;
                        }
                    }
                    if (chanceInner >= 0) {
                        return true;
                    }
                    i ++;
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}