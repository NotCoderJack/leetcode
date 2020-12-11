//Given two strings s and t, return the minimum window in s which will contain a
//ll the characters in t. If there is no such window in s that covers all characte
//rs in t, return the empty string "". 
//
// Note that If there is such a window, it is guaranteed that there will always 
//be only one unique minimum window in s. 
//
// 
// Example 1: 
// Input: s = "ADOBECODEBANC", t = "ABC"
//Output: "BANC"
// Example 2: 
// Input: s = "a", t = "a"
//Output: "a"
// 
// 
// Constraints: 
//
// 
// 1 <= s.length, t.length <= 105 
// s and t consist of English letters. 
// 
//
// 
//Follow up: Could you find an algorithm that runs in O(n) time? Related Topics 
//哈希表 双指针 字符串 Sliding Window 
// 👍 845 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

//Java：Minimum Window Substring
public class P76MinimumWindowSubstring{
    public static void main(String[] args) {
        Solution solution = new P76MinimumWindowSubstring().new Solution();
        String a = "acbbaca";
        String b = "aba";
        System.out.println(solution.minWindow(a, b));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            if (t.length() == 0 || s.length() == 0 || s.length() < t.length() || s == null || t == null) {
                return "";
            }
            int[] window = new int[128];
            int[] needs = new int[128];
            int count = 0;

            // map t
            for (int i = 0; i < t.length(); i ++) {
                char letter = t.charAt(i);
                needs[letter]++;
            }

            // loop grow/shrink minimum window
            int slow = 0;
            int minLen = s.length() + 1;
            String res = "";
            for (int fast = 0; fast < s.length(); fast ++) {
                char current = s.charAt(fast);
                window[current] ++;
                if (needs[current] > 0 && needs[current] >= window[current]) {
                    count ++;
                }
                // 已找到包含的子串，寻找更小的
                while (count == t.length()) {
                    char currentSlow = s.charAt(slow);
                    if (needs[currentSlow] > 0 && needs[currentSlow] >= window[currentSlow]) {
                        count--;
                    }
                    if (fast - slow + 1 < minLen) {
                        minLen = fast - slow + 1;
                        res = s.substring(slow, fast + 1);
                    }
                    window[currentSlow] --;
                    slow++;
                }

            }
            return  res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}